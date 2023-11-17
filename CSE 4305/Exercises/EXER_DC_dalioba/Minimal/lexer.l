/* Dalio, Brian A. */
/* dalioba         */
/* 2023-10-20      */

  //---- DEFINITIONS  --------------------------------------------

/* Ensure the lexer is reentrant -- avoid the original mess of
    global variables for everything. */
%option reentrant

/* We're a lexer for a bison-generated parser, so adjust our
    functional interface to match. */
%option bison-bridge

/* Establish the connection between bison and flex for tracking
    locations of tokens.  (Even with this, the locations are NOT
    tracked automatically.  We have to do that ourself.  See
    below for more details. */
%option bison-locations

/* Create the lexer exports header file with this name. */
%option header-file="lex.yy.h"

/* Our input is not from an interactive source. */
%option never-interactive
/* Don't generate the default rule. */
%option nodefault
/* We don't directly read the input. */
%option noinput
/* Don't include <unistd.h>. */
%option nounistd
/* We don't 'unput' a character back. */
%option nounput
/* Don't call yywrap() on EOF. */
%option noyywrap

/* These two options are doubled to get more detailed reports. */
/* Write performance report to stderr. */
%option perf-report perf-report
/* Write statistics summary to stderr. */
%option verbose verbose

/* Generate warning messages for goofs.  Why the heck isn't this
    the default? */
%option warn

/* Maintain current line number in yylineno. */
%option yylineno

%{
#include <stdio.h>

/* The expression structure, support functions, etc. defs. */
#include "expr.h"

/* Linkage to the bison-generated parser. */
#include "parser.tab.h"

/* Used not only by lexer action routines but also globally. */
void printLocation( YYLTYPE *loc, FILE *fp );

/* Some routines used only from lexer action routines. */
static int  _decodeRoman( char *txt, YYLTYPE *loc );
static void _updateYYLLOC( char *txt, YYLTYPE *loc, int lineno );

/* YY_USER_ACTION is automatically inserted at the beginning of
    every action routine.  All we use it for at this point is to
    help us do the tracking of token line and column locations.

    See the definition of the _updateYYLLOC() routine below for
    more details. */
#define YY_USER_ACTION _updateYYLLOC( yytext, yylloc, yylineno );
%}

/* Defined names ... */
BIT           [01]
DIGIT         [0-9]
EXPONENT      [eE][-+]?{DIGIT}+
HEXIT         [a-fA-F0-9]
OCTIT         [0-7]
ROMAN_DIGIT   [MDCLXVImdclxvi]

%% //---- RULES --------------------------------------------------

  /*-- Integer literals ----------------------------------------*/

0b{BIT}+  {
  // A string of binary digits -- an integer literal.
  yylval->expr = makeLitInteger( (int) strtol( yytext+2, NULL, 2 ) );
  return TOKEN_INTEGER;
}

0o{OCTIT}+  {
  // A string of octal digits -- an integer literal.
  yylval->expr = makeLitInteger( (int) strtol( yytext+2, NULL, 8 ) );
  return TOKEN_INTEGER;
}

0r{ROMAN_DIGIT}+ {
  // A string of Roman numeral digits -- an integer literal.
  yylval->expr = makeLitInteger( _decodeRoman( yytext, yylloc ) );

  return TOKEN_INTEGER;
}

0x{HEXIT}+  {
  // A string of hexadecimal digits -- an integer literal.
  yylval->expr = makeLitInteger( (int) strtol( yytext+2, NULL, 16 ) );
  return TOKEN_INTEGER;
}

{DIGIT}+  {
  // A string of decimal digits -- an integer literal.
  yylval->expr = makeLitInteger( (int) strtol( yytext, NULL, 10 ) );
  return TOKEN_INTEGER;
}

  /*-- Real literals -------------------------------------------*/

(({DIGIT}*(({DIGIT}\.)|(\.{DIGIT})){DIGIT}*){EXPONENT}?) {
  // The kind of real literal that has a decimal point in it
  //  somewhere;  either at the front, the back, or somewhere in
  //  the middle.  The exponent is optional since the DP indicates
  //  it's a real literal.
  yylval->expr = makeLitReal( atof( yytext ) );
  return TOKEN_REAL;
}

({DIGIT}+{EXPONENT})  {
  // The kind of real literal that does NOT have a DP.  For this
  //  style, the exponent is required.
  yylval->expr = makeLitReal( atof( yytext ) );
  return TOKEN_REAL;
}

  /*-- Identifier ----------------------------------------------*/

[_a-zA-Z][_a-zA-Z0-9]*  {
  // An ID.
  yylval->expr = makeId( yytext );
  return TOKEN_ID;
}

  /*-- Single character tokens ---------------------------------*/

[-=+*()]  { return yytext[0]; }

  /*-- Multi-character tokens ----------------------------------*/

"+="  { return TOKEN_PLUS_ASSIGN; }

  /*-- Ignorable comment ---------------------------------------*/

"//".*  {}

  /*-- Ignorable whitespace ------------------------------------*/

[ \f\n\r\t\v]+  {}

  /*-- Illegal character ---------------------------------------*/

.           {
  // Ignore the illegal character, but print a message.
  printLocation( yylloc, stdout );

  printf( ":  Illegal character '%s' ignored.\n", yytext );
}

%% //---- USER CODE ----------------------------------------------

//----------------------------------------------------------------
//-- Roman number decoding ---------------------------------------
//----------------------------------------------------------------
static int _romanCharToValue( char c )
{
  switch ( c ) {
    case 'M' : case 'm' : return 1000;
    case 'D' : case 'd' : return  500;
    case 'C' : case 'c' : return  100;
    case 'L' : case 'l' : return   50;
    case 'X' : case 'x' : return   10;
    case 'V' : case 'v' : return    5;
    case 'I' : case 'i' : return    1;
  }

  return -1;
}

static int _decodeRoman( char *txt, YYLTYPE *loc )
{
  char *start = txt;
  int total = 0;

  txt += 2;     // Skip over the "0r".

  while ( *txt ) {
    int dVal1 = _romanCharToValue( *txt );

    if ( dVal1 < 0 ) {
      printLocation( loc, stdout );
      printf( "Illegal character '%c' in Roman number literal %s.\n",
        *txt, start );

      return 0;
    }

    int dVal2 = _romanCharToValue( *(txt+1) );
    if ( dVal2 > dVal1 ) {
      total += dVal2 - dVal1;
      txt += 2;
    } else {
      total += dVal1;
      txt++;
    }
  }

  return total;
}

//----------------------------------------------------------------
void printLocation( YYLTYPE *loc, FILE *fp )
{
  if ( loc->first_line == loc->last_line ) {
    if ( loc->first_column == loc->last_column ) {
      fprintf( fp, "%d(%d)",
        loc->first_line, loc->first_column );
    } else {
      fprintf( fp, "%d(%d-%d)",
        loc->first_line,
        loc->first_column, loc->last_column );
    }
  } else {
    fprintf( fp, "%d(%d)-%d(%d)",
      loc->first_line, loc->first_column,
      loc->last_line, loc->last_column );
  }
}

/*----------------------------------------------------------------
  All the poop we need to track the location of a token:
    which line it's on, which column it starts in, and which
    column it ends in. */
static int yycolnoBegin;
static int yycolnoEnd;

// Defined here to have access to yycolnoBegin/End, but used by
//  the main routine to reset the column numbers on each new
//  string to be processed.
void resetColumnPosition()
{
  yycolnoBegin = yycolnoEnd = 0;
}

static void _updateYYLLOC( char *txt, YYLTYPE *loc, int lineno )
{
  // The first line of this token has to be the last line of the
  //  previous token.
  loc->first_line = loc->last_line;

  // The last line of this token is whatever line flex thinks we
  //  are on now.
  loc->last_line  = lineno;

  // The first column of this token has to be one past the last
  //  column of the previous token.
  yycolnoBegin = yycolnoEnd + 1;

  // We count the characters this token matched to determine its
  //  last column.  If the token includes a newline or a carriage
  //  return, we start over again at the left margin.
  // It would be truly unusual for a token pattern to allow an
  //  embedded newline character, but if one day some pattern
  //  DOES allow an embedded newline, this routine is READY!  :)
  for ( int i=0; txt[i] != '\0'; i++ ) {
    if ( txt[i] == '\n' || txt[i] == '\r' ) {
      yycolnoEnd = 0;
    } else {
      yycolnoEnd++;
    }
  }

  // Now that we know the begin / end column of the token, place
  //  this info in the yylloc location so flex / bison can see it.
  loc->first_column = yycolnoBegin;
  loc->last_column  = yycolnoEnd;

#if defined( DEBUG )
  // Useful info when debugging the scanner, but very noisy for
  //  any production use.
  printLocation( loc, stdout );
  printf( ": >%s<\n", txt );
#endif
}

//----------------------------------------------------------------

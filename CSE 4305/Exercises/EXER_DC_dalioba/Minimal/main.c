// Dalio, Brian A.
// dalioba
// 2023-10-20
//----------------------------------------------------------------
#include <ctype.h>
#include <math.h>
#include <readline/history.h>
#include <readline/readline.h>
#include <stdio.h>
#include <string.h>

#include "expr.h"
#include "symbolTable.h"

#include "parser.tab.h"
#include "lex.yy.h"

extern void resetColumnPosition();    // defined in lexer.l

// Some routines local to this file ...
static void _createDefaultSymbols();
static int  _getFlag( char *flagName );
static int  _parseString( const char *exprStr, Expr **expr );

//----------------------------------------------------------------
// The names of various calc configuration parameters.
#define SHOW_PARSE_TREE ("showParseTree")
#define SHOW_ROMAN_INTS ("showRomanInts")

//----------------------------------------------------------------
int main()
{
  char    *linePtr = NULL;
  ssize_t  start;

  Expr *expr;
  int   parseState;

  // Create the default symbol table entries, e.g., pi and e.
  _createDefaultSymbols();

  while ( 1 ) {
    // Prompt the user for some input, using the readline routine
    //  so we get the nice editing, etc. capabilities.  (Get rid
    //  of the previous line, if there was one first.)
    if ( linePtr ) free( linePtr );
    linePtr = readline( "> " );

    // If nothing returned, some error or maybe EOF.  Terminate
    //  the loop.
    if ( !linePtr ) break;

    // Get rid of any whitespace at the beginning of the input.
    for ( start=0; linePtr[start] && isspace( linePtr[start] ); start++ ) {}

    // If the string is empty, don't try to parse it or even add
    //  it to the history.  Just reiterate and get another line.
    if ( !linePtr[start] ) continue;

    // There's something to parse.  Add it to the history so we
    //  can get it back later.
    add_history( linePtr+start );

    // Parse the string!
    parseState = _parseString( linePtr+start, &expr );
    if ( parseState ) {
      // Didn't parse --
      //   Inform the user what happened.
      printf(
        "Unable to parse \"%s\".  Error is (%d) \"%s\".\n",
        linePtr,
        parseState,
        parseState == -1 ? "Unable to initialize lexical analyzer" :
        parseState ==  1 ? "Invalid input" :
        parseState ==  2 ? "Out of memory" : "Unknown error?" );
    } else {
      // Did parse.  Announce results ...
      printf( "\"%s\" ==>\n\n", linePtr );

      // Show the structure, if we're supposed to.
      if ( _getFlag( SHOW_PARSE_TREE ) ) {
        dumpExpr( expr, 0 );
        printf( "\n" );
      }

      // Evaluate the expression and show the result.  Show the
      //  result using Roman literal representation if requested.
      dumpExpr( evalExpr( expr ), _getFlag( SHOW_ROMAN_INTS ) );
      printf( "\n" );
    }
  }

  // Ensure we're at the beginning of a newline on exit.  Tidy.
  printf( "\n" );

  // Get rid of all of the expressions and symbols that were
  //  allocated so we're not a scummy memory leaker.
  freeAllExprs();
  freeAllSymbols();

  // If we have a line buffer, deallocate it.  Again, so we're
  //  not a scummy memory leaker.
  if ( linePtr != NULL ) free( linePtr );

  // All done!
  return 0;
}

//----------------------------------------------------------------
// Enters some "global" constants into the symbol table.
static void _createDefaultSymbols()
{
  // Some commonly used math constants
  createSymbol( "e",  sCONSTANT, makeLitReal( M_E ) );
  createSymbol( "pi", sCONSTANT, makeLitReal( M_PI ) );

  // Control for the calculator
  createSymbol( SHOW_PARSE_TREE, sVARIABLE, makeLitInteger( 0 ) );
  createSymbol( SHOW_ROMAN_INTS, sVARIABLE, makeLitInteger( 0 ) );
}

//----------------------------------------------------------------
// Gets a TRUE / FALSE value for a given name.  We're essentially
//  using the name as a flag.
// TRUE / FALSE is decidable for anumeric (int or real) value.
//  For other types or for a non-existent name, we assume its
//  value is FALSE, though we warn about that.
// If it just didn't exist, we create it and set it to 0.
static int _getFlag( char *flagName )
{
  Expr *flag = findSymbol( flagName );

  if ( flag ) {
    if ( flag->kind == eLIT_INTEGER ) {
      // Return flag's value as long as it's an integer.
      return flag->litInteger;

    } else if ( flag->kind == eLIT_REAL ) {
      // Hmm, flag isn't an integer.  If it's a real, just
      //  cast it to an integer and return that.
      return (int) flag->litReal;

    } else {
      // Hmm, flag isn't an integer or a real.  Pretend it
      //  doesn't exist and return FALSE.
      fprintf( stderr,
        "Flag '%s' has non-numeric type.  *Assuming* it is FALSE.\n",
        flagName );

      return 0;
    }

  } else {
    // Flag didn't exist -- assume its value would have been 0.
    fprintf( stderr,
      "Flag '%s' did not exist.  Setting it to FALSE (0).\n",
      flagName );

    createSymbol( flagName, sVARIABLE, makeLitInteger( 0 ) );

    return 0;
  }
}

//----------------------------------------------------------------
// Parses the given string as an expression and sets *expr to
//  point to an Expr structure representing the value, NULL in
//  case of error.
// Returns an int indicating the success status of the parse /
//  evaluation.
static int _parseString( const char *exprStr, Expr **expr )
{
  YY_BUFFER_STATE  bufferState;
  int              parseState;
  yyscan_t         scanner;

  // Initialize the Lexical Analyzer (the scanner).
  if ( yylex_init( &scanner ) ) {
    printf(
      "Unable to initialize the lexical analyzer.  Error is (%d) \"%s\".\n",
      errno, strerror( errno ) );

    // We have to signal to the caller that we didn't even
    //   get to the parser so there's no expression.
    *expr = NULL;

    return -1;
  }

  // Set the given string as the input for the scanner to scan.
  bufferState = yy_scan_string( exprStr, scanner );

  // Reset the line number, column position.
  yyset_lineno( 1, scanner );
  resetColumnPosition();

  // Using the established scanner as a source of tokens, parse
  //   the input.  The returned state tells us whether it was a
  //   success or not.
  parseState = yyparse( expr, scanner );

  // Now that the parse is over, dispose of the scanner info.
  yy_delete_buffer( bufferState, scanner );
  yylex_destroy( scanner );

  // Return the state we got back from parsing.
  return parseState;
}

//----------------------------------------------------------------

/* Dalio, Brian A. */
/* dalioba         */
/* 2023-10-20      */

   /*--- DEFINITIONS -------------------------------------------*/
%{
#include <stdio.h>

#include "expr.h"

#include "parser.tab.h"
#include "lex.yy.h"

extern void printLocation( YYLTYPE *loc, FILE *fp );    // defined in lexer.l

// The routine that gets called in case of a parse error.
void yyerror( YYLTYPE *, Expr **, void *, const char * );

%}

%code requires {
  typedef void *yyscan_t;
}

  /* Ensure we get a "pure" parser.  That is, a parser that does
      not use global variables.  Much cleaner though the interface
      to the lexer becomes a bit more complex.  This is essential
      for making a parser that works in a "real" program as
      opposed to a toy example. */
%define api.pure full

  /* Create the parser "header file".  That is, a header file
      that includes the token names, the location type, the
      value / attribute type, and so forth. */
%defines

  /* Ensures the generated parser will propagate locations.
      These locations are accessible via the '@n' notation. */
%locations

  /* Since we are "pure" (see above), we have to pass extra
      parameters to the lexer and the parser.  These parameters
      take the place of what would have been global variables. */
%lex-param   { yyscan_t scanner }
%parse-param { Expr **expr }
%parse-param { yyscan_t scanner }

  /* Value stack type   Encompasses not only all possible
      attributes that a token might require but also all types
      that a grammar non-terminal might return. */
%union {
  Expr *expr;
}

  /* Token names (and attribute type, where necessary) */
%token TOKEN_PLUS_ASSIGN

%token <expr>   TOKEN_INTEGER
%token <expr>   TOKEN_REAL

%token <expr>   TOKEN_ID

  /* Nonterminal types -- any non-terminal that returns a
      value has to be declared here along with its value type. */
%type <expr> expr

  /* Operator precedence / associativity
      The list goes from LOWEST to HIGHTEST precedence.  (Yeah,
      I know, that exactly the opposite of how precedence tables
      are depicted in book.  Go figure. :)
     Operators on the same line have the same precedence. */
%right     '='  TOKEN_PLUS_ASSIGN
%left      '+'
%left      '*'
%right     NEGATE

%% /*--- RULES -------------------------------------------------*/

start
  : expr                  { *expr = $1; }
  ;

  /* Binary operators */
expr
  : expr '+' expr  { $$ = oprBinary( eBOP_ADD,      $1, $3 ); }
  | expr '=' expr  { $$ = oprBinary( eBOP_ASSIGN,   $1, $3 ); }
  | expr '*' expr  { $$ = oprBinary( eBOP_MULTIPLY, $1, $3 ); }
  | expr TOKEN_PLUS_ASSIGN     expr  { $$ = oprBinary( eBOP_PLUS_ASSIGN,     $1, $3 ); }
  ;

  /* Unary operators */
expr
  : '-' expr  %prec NEGATE   { $$ = oprUnary( eUOP_NEGATE,  $2 ); }
  ;

  /* Fundamentals */
expr
  : TOKEN_INTEGER         { $$ = $1; }
  | TOKEN_REAL            { $$ = $1; }
  | TOKEN_ID              { $$ = $1; }
  ;

  /* Nesting */
expr
  : '(' expr ')'          { $$ = $2; }
  ;

%% /*--- USER CODE ---------------------------------------------*/
// The yyerror routine is called by the parser engine whenever
//  it fails in parsing the token stream.
// There's lots of stuff that COULD be done in here, the
//  discussion of which we'll put off for now.  (Frankly, error
//  reporting and recovery is messy. :)
// Since this is a "read-a-line, evaluate-a-line" tool, we print
//  a marker at the column the error was detected, the location
//  of the error, and the given message.

// How wide is the prompt.  Keeps the error marker in sync with
//  the typed string.
#define PROMPT_SIZE (2)

void yyerror( YYLTYPE *llocp, Expr **_expr, void *_scanner, const char *msg )
{
  /* Unused at present */ (void) _expr; (void) _scanner;

  // "- 1" because columns are counted from 1 yet indices are
  //  counted from 0.
  printf( "%*s^\n", PROMPT_SIZE + llocp->first_column - 1, " " );

  printLocation( llocp, stdout );

  printf( " %s\n", msg );
}

/*--------------------------------------------------------------*/

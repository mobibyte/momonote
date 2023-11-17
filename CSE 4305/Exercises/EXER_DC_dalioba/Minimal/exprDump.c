// Dalio, Brian A.
// dalioba
// 2023-10-20
//----------------------------------------------------------------
#include <limits.h>
#include <math.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "expr.h"

//----------------------------------------------------------------
// These names have to be in the same order as the enum _ExprKind
//  as defined in expr.h.
// We use this when dumping expressions to convert a numeric
//  ExprKind enum value into a human-understandable string.
static char *_exprKindStr[] = {
  "ADD", "ASSIGN", "MULTIPLY", "PLUS_ASSIGN",
  "ID",
  "INTEGER", "REAL",
  "NEGATE",
};

//----------------------------------------------------------------
// Prints the part of theInt that's at the level of tenLevel,
//  fiveLevel, and oneLevel.  For example, called with tenLevel
//  10000, fiveLevel 5000, oneLevel 1000, will print the
//  "thousands" of the number theInt.
// If there's nothing at this level, prints nothing.
// Returns theInt minus whatever was printed at this level.  For
//  example, called with the prevous levels, if theInt is 7893,
//  would print "IↃↃMM", which is 7000, and return 893.
// This will be a lot clearer if one looks at how this routine is
//  called below.
// *Assuems* the number is NOT > the tenLevel.
static int _printRomanRange(
  FILE *fp, int theInt,
  int tenLevel,  char *tenRep,
  int fiveLevel, char *fiveRep,
  int oneLevel,  char *oneRepStr )
{
  // Exactly equal to tenLevel?  If so, just print the tenRepStr
  //  and return 0 left to print.
  if ( theInt == tenLevel ) {
    fputs( tenRep, fp );
    return 0;
  }

  // Below tenLevel yet above or equal to nine times the oneLevel.
  //  (In other words, in the range [9, 10) for this level.)
  // Print the oneRepStr in front of the tenRepStr and return
  //  theInt - nine times the oneLevel.
  if ( theInt >= 9*oneLevel ) {
    fprintf( fp, "%c%s", oneRepStr[0], tenRep );
    return theInt - 9*oneLevel;
  }

  // Below 9*oneLevel yet above or equal to the fiveLevel.
  //  Print the fiveLevel, subtract the fiveLevel from theInt,
  //  and keep going.  (There could still be value at this level.
  //  For example, 70 is a fiveLevel plus two oneLevels.)
  if ( theInt >= fiveLevel ) {
    fputs( fiveRep, fp );
    theInt -= fiveLevel;
  }

  // Below fiveLevel yet above or equal to 4*oneLevel.  Print
  //  4*oneLevel and return theInt - 4*oneLevel.
  if ( theInt >= 4*oneLevel ) {
    // Super special case: we must emit IIII for 4 instead of IV.
    //  Romans were perhaps reluctant to write IV as that is the
    //  first two letters of the deity "IVPITER".
    if ( theInt == 4 ) {
      fprintf( fp, "%.*s", theInt, oneRepStr );

    } else {
      // Not units so OK to express 4 as one letter of oneRepStr
      //  in front of fiveRep.
      fprintf( fp, "%c%s", oneRepStr[0], fiveRep );
    }

    return theInt - 4*oneLevel;
  }

  // OK, down to the simplest case, a number in the range [1,4).
  // All we do is write the requisite number of oneRepStr chars,
  //  subtract that value from theInt, and return that.
  int tmp = theInt / oneLevel;
  fprintf( fp, "%.*s", tmp, oneRepStr );
  theInt -= tmp*oneLevel;

  return theInt;
}

static void tryToPrintAsRomanNumeral( FILE *fp, int theInt )
{
  // Silly little routine that tries to print the given integer as
  //  a Roman numeral.

  // Works only for numbers in the range 1 .. 9,999.  If theInt is
  //  out of that range, the number is printed in normal decimal
  //  form.

  // The main reason for the 9,999 upper limit is that there isn't
  //  an easy way to write much larger numbers.  Even 5,000 (as
  //  IↃↃ) and 10,000 (as CCIↃↃ) are already unwieldy.  It's no
  //  wonder the Romans didn't invent the calculus.  Ha, ha!
  if ( theInt < 1 || theInt > 9999 ) {
    // Bzzt!  Out of range.  Just print it in decimal.
    fprintf( fp, "%d", theInt );

  } else {
    // OK, it's in range.  We start with the Roman numeral mark.
    fprintf( fp, "0r" );

    // The number is 1 .. 10000.
    // Print, in order, the thousands, then the hundreds, then
    //  the tens, then the units.
    theInt = _printRomanRange( fp, theInt, 10000, "CCIↃↃ", 5000, "IↃↃ", 1000, "MMMM" );
    theInt = _printRomanRange( fp, theInt,  1000, "M",      500, "D",     100, "CCCC" );
    theInt = _printRomanRange( fp, theInt,   100, "C",       50, "L",      10, "XXXX" );
    (void)   _printRomanRange( fp, theInt,    10, "X",        5, "V",       1, "IIII" );
  }
}

// Dump the given Expr node (hierarchically).
static void _dumpExprInternal( Expr *e, int showRomanInts, int indent, FILE *fp )
{
  switch ( e->kind ) {
    //--------------------------------------
    // Binary operators
    case eBOP_ADD :
    case eBOP_ASSIGN :
    case eBOP_MULTIPLY :
    case eBOP_PLUS_ASSIGN :
      fprintf( fp, "%*c(BOP %s\n",
        indent, ' ', _exprKindStr[ e->kind ] );

      _dumpExprInternal( e->left,  showRomanInts, indent+1, fp );
      _dumpExprInternal( e->right, showRomanInts, indent+1, fp );

      fprintf( fp, "%*c)\n",
        indent, ' ' );

      break;

    //--------------------------------------
    // Unary operators
    case eUOP_NEGATE :
      fprintf( fp, "%*c(UOP %s\n",
        indent, ' ', _exprKindStr[ e->kind ] );

      _dumpExprInternal( e->left, showRomanInts, indent+1, fp );

      fprintf( fp, "%*c)\n",
        indent, ' ' );

      break;

    //--------------------------------------
    // Name
    case eID :
      fprintf( fp, "%*c(ID \"%s\")\n",
        indent, ' ', e->id );

      break;

    //--------------------------------------
    // Literals
    case eLIT_INTEGER :
      fprintf( fp, "%*c(LITERAL %s ",
        indent, ' ', _exprKindStr[ e->kind ] );

      if ( showRomanInts ) {
        tryToPrintAsRomanNumeral( fp, e->litInteger );
      } else {
        fprintf( fp, "%d", e->litInteger );
      }

      fprintf( fp, ")\n" );

      break;

    case eLIT_REAL :
      fprintf( fp, "%*c(LITERAL %s %.16e)\n",
        indent, ' ', _exprKindStr[ e->kind ], e->litReal );

      break;

    //--------------------------------------
    // Don't you hate it when something like this happens?
    default :
      fprintf( stderr, "Unknown expression kind %d.\n", e->kind );

      break;
  }
}

void dumpExpr( Expr *e, int showRomanInts )
{
  // Dump the give expr structure to stdout, showing Roman
  //  numeral format as requested.
  _dumpExprInternal( e, showRomanInts, 1, stdout );
}

//----------------------------------------------------------------

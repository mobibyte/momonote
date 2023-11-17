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
#include "symbolTable.h"

static Expr *_evalBOPIntInt( ExprKind opr, int left, int right );
static Expr *_evalBOPRealReal( ExprKind opr, double left, double right );

//----------------------------------------------------------------
static void _assignToVar( char *var, Expr *value )
{
  SymbolCreateStatus s = createSymbol( var, sVARIABLE, value );

  // Did we succeed in this assign?  If not, let the user
  //  know what happened.
  switch ( s ) {
    case sOK : break;

    case sALREADY :
      printf( "\"%s\" is a constant and cannot be assigned.\n", var );
      break;

    case sBADALLOC :
      printf( "Unable to allocate \"%s\" as a variable.\n", var );
      break;

    default :
      printf( "Unknown error %d when assigning to \"%s\"?.\n",
        s, var );
      break;
  }
}

// Evaluate an Expr node, including any hierarchical nodes.
Expr *evalExpr( Expr *e )
{
  switch ( e->kind ) {
    //--------------------------------------
    // Binary operator  -- Assignments
    case eBOP_ASSIGN :
    case eBOP_PLUS_ASSIGN :
    {
      // Left side of any assign must be an ID.
      if ( e->left->kind != eID ) {
        printf( "Left side of assignment is not an ID.\n" );
        return zeroIntLit;
      }

      // Evaluate the right hand side to get the other operand.
      Expr *right = evalExpr( e->right );
      Expr *result;

      // Now that we have the evaluated RHS operand, do the
      //  appropriate operation with the value of the LHS ID and
      //  that RHS value.
      switch ( e->kind ) {
        case eBOP_ASSIGN :
          // For a simple assign, there is no operation with the
          //  RHS.  The assigned value is just the evaluated RHS.
          result = right;
          break;

        case eBOP_PLUS_ASSIGN :
          result = evalExpr( oprBinary( eBOP_ADD, e->left, right ) );
          break;

        default :
          printf( "Unknown assignment operator kind %d.\n", e->kind );
          return zeroIntLit;
      }

      // Ensure the LHS ID actually exists as a variable and give
      //  it the computed value.
      _assignToVar( e->left->id, result );

      return result;
    }

    // Binary operators -- Normal
    case eBOP_ADD :
    case eBOP_MULTIPLY :
    {
      // All of these work the same for now:  Evaluate the left
      //  and right operands and return the computed value.
      Expr *left   = evalExpr( e->left );
      Expr *right  = evalExpr( e->right );
      Expr *result;

      // We have to careful about types.  For now, if the two
      //  operands are the same type, the result will be that
      //  type.  If they are different types, the result will be
      //  a REAL value.
      // The only exceptions are the equality operators, which
      //  always return an INTEGER result (TRUE (1), FALSE (0))
      //  even when used on REALs.
      if ( left->kind == right->kind ) {
        if ( left->kind == eLIT_INTEGER ) {
          result = _evalBOPIntInt( e->kind, left->litInteger, right->litInteger );
        } else {
          result = _evalBOPRealReal( e->kind, left->litReal, right->litReal );
        }
      } else {
        result = _evalBOPRealReal( e->kind, ENSURE_REAL( left ), ENSURE_REAL( right ) );
      }

      return result;
    }

    //--------------------------------------
    // Unary operators
    case eUOP_NEGATE :
    {
      // Just evaluate the operand and do the operation
      //    according to the type of the operand.
      Expr *operand = evalExpr( e->left );
      Expr *result  = allocExpr();

      if ( operand->kind == eLIT_INTEGER ) {
        switch (e->kind) {
          case eUOP_NEGATE : result->litInteger = -operand->litInteger; break;

          default :
            printf( "Unknown unary operator kind %d.\n", e->kind );
            return zeroIntLit;
        }
      } else {
        result->kind = eLIT_REAL;
        switch (e->kind) {
          case eUOP_NEGATE : result->litReal = -operand->litReal; break;

          default :
            printf( "Unknown unary operator kind %d.\n", e->kind );
            return zeroIntLit;
        }
      }

      return result;
    }

    //--------------------------------------
    // Name
    case eID : {
      // When evaluating an ID, check to see if it exists.
      // If so, return its entry from the symbol table.
      // If not, complain and return the zero int literal.
      Expr *v = findSymbol( e->id );

      if ( v == NULL ) {
        printf( "Unknown identifier \"%s\".  (Assuming it's 0.)\n", e->id );

        // Create this name as a var with the value 0 so we don't
        //  get the "unknown id" error again.
        _assignToVar( e->id, zeroIntLit );

        return zeroIntLit;

      } else {
        return v;
      }
    }

    //--------------------------------------
    // Literals
    case eLIT_INTEGER :
    case eLIT_REAL :
      // Literals evaluate to themselves.
      return e;

    //--------------------------------------
    // Don't you hate it when something like this happens?
    default :
      printf( "Unknown expression kind %d.\n", e->kind );

      return zeroIntLit;
  }
}

//----------------------------------------------------------------
// Evaluate BOP, both sides integer.
static Expr *_evalBOPIntInt( ExprKind opr, int iLeft, int iRight )
{
  Expr *result = allocExpr();

  switch ( opr ) {
    case eBOP_ADD :
      result->litInteger = iLeft + iRight;
      break;

    case eBOP_MULTIPLY :
      result->litInteger = iLeft * iRight; break;

    default :
      // How is this even possible?
      printf( "evalBOPIntInt: Unknown expression kind %d.\n", opr );
      break;
  }

  return result;
}

// Evaluate BOP, both sides real.
static Expr *_evalBOPRealReal( ExprKind opr, double rLeft, double rRight )
{
  Expr *result  = allocExpr();

  result->kind = eLIT_REAL;

  switch ( opr ) {
    case eBOP_ADD :
      result->litReal = rLeft + rRight; break;

    case eBOP_MULTIPLY :
      result->litReal = rLeft * rRight; break;

    default :
      // How is this even possible?
      printf( "_evalBOPRealReal: Unknown expression kind %d.\n", opr );
      break;
  }

  return result;
}

//----------------------------------------------------------------

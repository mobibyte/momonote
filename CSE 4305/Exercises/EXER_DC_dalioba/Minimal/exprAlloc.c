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
// Some standard literals ...
Expr *zeroIntLit;    // Literal Integer 0.
Expr *oneIntLit;     // Literal Integer 1.
Expr *zeroRealLit;   // Literal Real 0.0.

//----------------------------------------------------------------
// We keep a linked list of every Expr node that gets allocated
//   so they are easy to clean up later.
static Expr *_exprList;

// Allocate an Expr node -- by default we make it a literal
//    integer 0.
// Return NULL if the allocation fails.
Expr *allocExpr()
{
  // Get a zeroed-out expression structure.
  Expr *e = (Expr *) calloc( 1, sizeof( Expr ) );

  // Oops, couldn't allocate!
  if ( e == NULL ) return NULL;

  // Make the newly allocated expr struct a literal integer 0.
  //  (Remember, all fields are zero since we used calloc().)
  e->kind = eLIT_INTEGER;

  // If nothing is on the expr list yet, that means we have to
  //  create the standard literals.
  int needInit = _exprList == NULL;

  // Stick this newly created literal on the list of all expr
  //  structs.
  e->next   = _exprList;
  _exprList = e;

  // If we needed to create the standard literals, do so now.
  if ( needInit ) {
    zeroIntLit  = makeLitInteger( 0 );
    oneIntLit   = makeLitInteger( 1 );
    zeroRealLit = makeLitReal( 0.0 );
  }

  // Success!  Return the literal we just created.
  return e;
}

// Free all Expr nodes that have been allocated so far.
void freeAllExprs()
{
  Expr *e    = _exprList;
  Expr *next = NULL;

  // As long as there's an expr struct on the expr struct list,
  //  free it.  We go down the list freeing them one after
  //  another, remembering the pointer to the next one as we go.
  while ( e ) {
    next = e->next;

    if ( e->kind == eID ) free( e->id );
    free( e );

    e = next;
  }

  // List is empty now ...
  _exprList = NULL;
}

//----------------------------------------------------------------
// Build an ID reference Expr node for the given name.
//   Return NULL if the allocation fails.
Expr *makeId( char *name )
{
  // Get an expr struct.
  Expr *e = allocExpr();

  // Allocation failure -- return NULL.
  if ( e == NULL ) return NULL;

  // Set the kind of this literal to be real.
  e->kind = eID;

  // Set the name of the ID to be what we were given.
  e->id = strdup( name );

  return e;
}


// Build an integer literal Expr node with the given value.
//   Return NULL if the allocation fails.
Expr *makeLitInteger( int value )
{
  // Get an expr struct.
  Expr *e = allocExpr();

  // Allocation failure -- return NULL.
  if ( e == NULL ) return NULL;

  // Set the kind of this literal to be integer.
  e->kind = eLIT_INTEGER;

  // Set the value of the literal to be what we were given.
  e->litInteger = value;

  return e;
}

// Build a real literal Expr node with the given value.
//   Return NULL if the allocation fails.
Expr *makeLitReal( double value )
{
  // Get an expr struct.
  Expr *e = allocExpr();

  // Allocation failure -- return NULL.
  if ( e == NULL ) return NULL;

  // Set the kind of this literal to be real.
  e->kind = eLIT_REAL;

  // Set the value of the literal to be what we were given.
  e->litReal = value;

  return e;
}

//----------------------------------------------------------------
// Build a binary operator Expr node with the given left and
//   right operands.
//   Return NULL if the allocation fails.
Expr *oprBinary( ExprKind kind, Expr *left, Expr *right )
{
  Expr *e = allocExpr();

  if ( e == NULL ) return NULL;

  e->kind  = kind;

  e->left  = left;
  e->right = right;

  return e;
}

// Build a unary operator Expr node with the given operand.
//   Return NULL if the allocation fails.
Expr *oprUnary( ExprKind kind, Expr *operand )
{
  Expr *e = allocExpr();

  if ( e == NULL ) return NULL;

  e->kind  = kind;

  e->left  = operand;

  return e;
}

//----------------------------------------------------------------

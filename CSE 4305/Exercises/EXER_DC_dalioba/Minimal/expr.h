// Dalio, Brian A.
// dalioba
// 2023-10-20
//----------------------------------------------------------------
#if !defined( __EXPR_H__ )
#define __EXPR_H__

#include <stdio.h>

//----------------------------------------------------------------
typedef enum _ExprKind
{
  // If this enum list changes, ensure suitable changes are also
  //  made to _exprKindStr[] in exprDump.c.

  // Binary operators -- will have other exprs as operands.
  eBOP_ADD,
  eBOP_ASSIGN,
  eBOP_MULTIPLY,
  eBOP_PLUS_ASSIGN,

  // Leaf node -- an ID.
  eID,

  // Leaf nodes -- integer, real literals.
  eLIT_INTEGER,
  eLIT_REAL,

  // Unary operators -- will have another expr as operand.
  eUOP_NEGATE,
} ExprKind;

typedef struct _Expr
{
  // Just a link so expr nodes can be kept in a list.
  struct _Expr *next;

  // What kind of expr is this?  From the ExprKind enum above.
  ExprKind kind;

  // Attribute information for a leaf expr node.
  int     litInteger;
  double  litReal;
  char   *id;

  // Sub-expr structs for hierarchical expressions.
  struct _Expr *left;
  struct _Expr *right;
} Expr;

// Get the value of a numeric literal expr as a real.  (Chaos
//  results if the given expr is NOT a numeric literal! :)
#define ENSURE_REAL(e) ( (e)->kind == eLIT_REAL ? (e)->litReal : (double) (e)->litInteger )

//-- exprDump.c --------------------------------------------------
extern void dumpExpr( Expr *e, int showRomanInts );

//-- exprAlloc.c -------------------------------------------------
extern Expr *zeroIntLit;
extern Expr *oneIntLit;
extern Expr *zeroRealLit;

extern Expr *allocExpr();
extern void  freeAllExprs();

extern Expr *makeLitInteger( int value );
extern Expr *makeLitReal( double value );
extern Expr *makeId( char *id );
extern Expr *oprBinary( ExprKind kind, Expr *left, Expr *right );
extern Expr *oprUnary( ExprKind kind, Expr *operand );

//-- exprEval.c --------------------------------------------------
extern Expr *evalExpr( Expr *e );

//----------------------------------------------------------------
#endif

// Dalio, Brian A.
// dalioba
// 2023-10-20

#if !defined( __SYMBOL_TABLE_H__ )
#define __SYMBOL_TABLE_H__

//----------------------------------------------------------------
typedef enum _SymbolKind
{
  sCONSTANT,
  sVARIABLE
} SymbolKind;

typedef enum _SymbolCreateStatus
{
  sOK,
  sALREADY,
  sBADALLOC
} SymbolCreateStatus;

typedef struct _Symbol
{
  struct _Symbol *next;

  SymbolKind kind;

  char *id;
  void *contents;
} Symbol;

//----------------------------------------------------------------
void  freeAllSymbols();

SymbolCreateStatus createSymbol( char *id, SymbolKind kind, void *contents );
void *findSymbol( char *id );

//----------------------------------------------------------------
#endif

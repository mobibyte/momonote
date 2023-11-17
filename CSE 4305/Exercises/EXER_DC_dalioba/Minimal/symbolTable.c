// Dalio, Brian A.
// dalioba
// 2023-10-20

//----------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "symbolTable.h"

static Symbol *_getSymbolEntry( char *id );

//----------------------------------------------------------------
// We keep a linked list of every Symbol node that gets allocated
//   so they are easy to clean up later.
static Symbol *_symbolList;

// Allocate a Symbol node -- by default we make it a constant with
//  NULL contents and no name.
// Return NULL if the allocation fails.
static Symbol *_allocSymbol()
{
  // Get a zeroed-out symbol structure.
  Symbol *s = (Symbol *) calloc( 1, sizeof( Symbol ) );

  // Oops, couldn't allocate!
  if ( s == NULL ) return NULL;

  // Make the newly allocated symbol struct a constant with NULL
  //  contents and no name.
  //  (Remember, all fields are zero since we used calloc().)
  s->kind = sCONSTANT;

  // Stick this newly created symbol on the fron of the list of
  //  all symbol structs.
  s->next     = _symbolList;
  _symbolList = s;

  // Success!  Return the symbol we just created.
  return s;
}

// Free all Symbol nodes that have been allocated so far.
void freeAllSymbols()
{
  Symbol *s    = _symbolList;
  Symbol *next = NULL;

  // As long as there's a symbol struct on the symbol struct list,
  //  free it.  We go down the list freeing them one after
  //  another, remembering the pointer to the next one as we go.
  //  We also free the name (s->id) that we allocated when the
  //  symbol was created (as long as it exists).
  //  We do NOTHING with the contents (if any) because that
  //  belongs to the creator of the symbol.
  while ( s ) {
    next = s->next;

    if ( s->id ) free( s->id );
    free( s );

    s = next;
  }

  // List is empty now ...
  _symbolList = NULL;
}

//----------------------------------------------------------------
// Create a symbol with the given name, kind, and contents.
// If the name already exists, its contents are updated to the
//  new contents as long as the new kind is the same as the old
//  kind.  (Thus it is OK to update a "constant" as long as it
//  remains a "constant" but we don't, e.g., change a constant
//  to a variable or vice-versa.)
// If the name doesn't exist, create a new symbol entry for it.
// Returns sOK if all works out OK.
//         sALREADY if name already exists with a different kind.
//         sBADALLOC if a new symbol entry can't be allocated.
SymbolCreateStatus createSymbol( char *id, SymbolKind kind, void *contents )
{
  Symbol *s = _getSymbolEntry( id );

  if ( s ) {
    if ( kind == s->kind ) {
      s->contents = contents;
      return sOK;
    } else {
      return sALREADY;
    }
  }

  s = _allocSymbol();
  if ( s == NULL ) return sBADALLOC;

  s->kind     = kind;
  s->id       = strdup( id );
  s->contents = contents;

  return sOK;
}

//----------------------------------------------------------------
// Returns the contents of the given name, if it exists.  If it
//  doesn't exist, returns NULL instead.
// Note that it's not possible to distinguish a name that does not
//  exist from a name that has NULL as its contents.
void *findSymbol( char *id )
{
  Symbol *s = _getSymbolEntry( id );

  if ( s == NULL ) return NULL;
  else             return s->contents;
}

//----------------------------------------------------------------
// Returns the symbol entry structure for the given name if it
//  exists.  NULL if it doesn't.
static Symbol *_getSymbolEntry( char *id )
{
  for ( Symbol *s = _symbolList; s; s = s->next ) {
    if ( strcmp( id, s->id ) == 0 ) {
      return s;
    }
  }

  return NULL;
}

//----------------------------------------------------------------

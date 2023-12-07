// Vester, Diego A.
// dxg9342
// 2023-12-01
//----------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>

//----------------------------------------------------------------
#define SIZE 128

int main()
{
  // Allocate some memory.
  char *lost = (char *) malloc( SIZE );

  // Show that it really got allocated.
  printf( "malloc( %d ) returned %p\n",
    SIZE, lost );

  // Make use of the allocated memory.
  int sum = 0;
  for ( int i=0; i<SIZE; i++ ) {
    sum += lost[i];
  }

  // Meaningless result -- the memory wasn't initialized with any
  //  particular values so this is garbage.
  // BUT, if we do not actually *use* the memory in a way that
  //  does not get optimized away, the leak doesn't get reported.
  //  (Why should this be so?)
  printf ( "sum was %d.\n", sum );

  // Brag about our complete lack of programming integrity!
  //  We're so naughty!  Ha!
  printf( "Stand back!  I'm about to commit a memory leak!\n" );

  // Now, commit the leak!  We *try* to exit with status code 0
  //  for SUCCESS, but leak detection should notice that we didn't
  //  free the allocated memory and abort.
  return 0;
}

//----------------------------------------------------------------

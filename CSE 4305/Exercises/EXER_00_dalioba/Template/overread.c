// Dalio, Brian A.
// dalioba
// 2023-08-01
//----------------------------------------------------------------
#include <stdio.h>
#include <stdlib.h>

//----------------------------------------------------------------
#define SIZE 128

int main()
{
  // Allocate some memory.
  char *overread = (char *) malloc( SIZE );

  // Show that it really got allocated.
  printf( "malloc( %d ) returned %p\n",
    SIZE, overread );

  // Brag about our complete lack of programming integrity!
  //  We're so naughty!  Ha!
  printf( "Stand back!  I'm about to commit a memory overread!\n" );

  // Oh great lords of program design, please forgive me for this
  //  gross breach of proper technique!
  printf( "one past is 0x%02x\n",
    overread[SIZE] );

  //-- We shouldn't reach here! ----------------------------------
  // The address sanitizer should have noticed the overrun in the
  //  above statement and aborted the execution.
  //--------------------------------------------------------------
  printf( "got past the overread?  WTF?\n" );

  // Free the allocated memory, so we don't cause a memory leak.
  free( overread);

  // Exit with status code 0 for SUCCESS.  (Boy, are we deluded!)
  return 0;
}

//----------------------------------------------------------------

#-----------------------------------------------------------------
#-- Prerequisites ------------------------------------------------
#-----------------------------------------------------------------

* Ensure you have flex 2.6.4 installed.

  $ apt-cache policy flex
  flex:
    Installed: 2.6.4-6.2
    Candidate: 2.6.4-6.2
    Version table:
   *** 2.6.4-6.2 500
          500 http://archive.ubuntu.com/ubuntu focal/main amd64 Packages
          100 /var/lib/dpkg/status
  $ flex --version
  flex 2.6.4
  $

* Read the flex handout on Canvas, "flex Notes, v1.1.pdf" in
    Modules > Handouts.

* Finish Exercises 00, 01, and 02a.

#-----------------------------------------------------------------
#-- What to do ... -----------------------------------------------
#-----------------------------------------------------------------
* (Simple) Roman numerals.  The goal is to write a rule that
    recognizes a Roman numeral up to 3999 and returns its value as
    a tok_INT_LIT.

  For those of you who don't remember Roman numerals (seeing as
    how often they come up has somewhat declined in the past two
    thousand years :), here's a table of equivalences,

      M         1000
      D          500
      C          100
      L           50
      X           10
      V            5
      I            1

  We combine characters from largest to smallest to make numbers.
    For example,

      MM        2000
      DCCXXII    722
      LVII        57
      XXV         25
      VI           6
      III          3

  Notice how the letters for larger values are to the left of
    letters for smaller values.  The only exception to this rule
    is when making the 4 or 9 values.  Here are the forms for
    those values,

      CM         900
      CD         400
      XC          90
      XL          40
      IX           9
      IV           4

  These forms mean "subtract the value of the smaller letter on
    the left from the larger letter on the right".  Being able to
    do this means we never have more than three of the same
    letter in a row.  So, 44 is XLIV, not XXXXIIII.  99 is XCIX,
    not LXXXXVIIII or XXXXXXXXXIIIIIIIII.

  There can be only one subtracting letter to the left.  For
    example, IIX for 8 is not allowed.  Once you have done a
    subtraction, you can't use the subtracting letter on the
    right.  So, you can't write 600 as CDCC.  It would be DC.
    You can't make 1990 as XM as that's not a 4 or 9 value.  It
    would be MCMXC.

  -- Rules summary --

    > Letters go from largest to smallest, except when making a 4 or 9 value.

    > Use the subtracting forms (smaller value on left) only for the 4 or 9 values.

    > Don't match a symbol if it's already been used in a subtraction.

    > Don't match more than three (3) of any symbol in a row.

* Similar to the other integer literal formats, we'll begin a
    Roman numeral with 0r as the prefix.  Following that will be a
    series of M, D, C, L, X, V, and I characters making up the
    numeral.

  The file Exercises/roman.txt has examples of numbers ranging
    from 1 to 3999.  There's also an entry in that file for
    zero, even though the Romans didn't have a numeral for zero.
    We'll just recognize 0r with no following characters as zero.

* The key to writing the RE that matches legal Roman numerals is
    to start small and build it up piece by piece.  Do this RE in
    four stages, Units, Tens, Hundreds, Thousands.  (We'll add
    the leading "0r" at the end of this derivation.)

      (Before we go any further, remember that in flex one can
       use the form R{n,m} to match n through m copies of the RE
       R.  This is on page 15 of the flex handout.  Geez! :)

  First, write a RE that recognizes the Roman numerals for 0
    through 9.  Here they are,

    0   <epsilon>
    1   I
    2   II
    3   III
    4   IV
    5   V
    6   VI
    7   VII
    8   VIII
    9   IX

  Consider the problem in stages.

    0   <epsilon>
    1   I
    2   II
    3   III

  What's a RE for the forms for 0 through 3?  This shouldn't be
    too difficult as it's just recognizing zero through three I
    characters.  My RE for this is exactly six characters.

    5   V
    6   VI
    7   VII
    8   VIII

  What's the RE for the forms for 5 through 8?  Mine is exactly
    seven characters.  (Really, if you did 0 .. 3, how hard can
    5 .. 8 be?)

  Now write an RE that recognizes BOTH of these forms, 0 .. 3 and
    5 .. 8, in one RE.   My RE is exactly eight characters.  (I
    added one character to the 5 .. 8 RE).

    4   IV

  Add recognition of IV.  I added three characters.

    9   IX

  Add recognition of IX.  I added three more characters.

  You now have an RE that recognizes 0 .. 9.  Mine is 14
    characters.

* Once you have a RE that recognizes 0 .. 9, it's pretty easy to
    write the RE that recognizes 10, 20, 30, ... 90, right?

    10    X
    20    XX
    30    XXX
    40    XL
    50    L
    60    LX
    70    LXX
    80    LXXX
    90    XC

  After all, it's the SAME RE except with different letters.
    (Geez!  :)

* Now do 100, 200, 300, ... 900.

* Now do the thousands.  We said up to 3999, so at most we want
    three Ms on the front.  My RE for that is 6 characters.

* Now combine these four REs in order from left to right,
    thousands down to units.  Remember each section is optional,
    so use ()? on the ones with toplevel alternations.  My
    combination of these four is 57 characters.

* Stick 0r on the front.  I did this by putting "0r" on the
    front, getting to a final RE 61 characters long.

* Easy, isn't it, when you do it in steps?

#---------------------------------------
* OK, that's the RE.  What about the processing?  Well, you have
    to turn whatever characters were matched into an integer.
    Unfortunately, the strtol() routine doesn't understand Roman
    numerals.  (The writers probably didn't go to a classical
    high school.  Ha! :)  That's OK, we can write it ourselves.
    It's not at all hard.

* The Source/lexer.l file has a spot (line 92) for you to put
    your RE.

* The processing part is already written for you, only six LOC.
    All YOU have to do is write the xlateRoman( char *, int )
    function which is called by the processing part.  Look down a
    bit to line 249 and you'll see where xlateRoman() is defined.
    There's a TODO comment describing what needs to be done.

* Use findRomanValue() to convert a character to a value.  (That
    routine is already written for you.)  If the character is
    illegal, findRomanValue() returns -1.  If this happens,
    return -1 as the value from xlateRoman() so an error message
    gets printed by the processing routine.

* xlateRoman() is not complex.  The body of my implementation is
    only 18 LOC and that includes putting close braces } on their
    own lines.

#---------------------------------------
* Now what?  Well, enhance this implementation by recognizing
    minuscule letters (LOWER case) as well as majuscule letters
    (UPPER case) for M D C L X V I.  The Romans don't seem to
    have used minuscule letters for numbers (at least I'm unaware
    of any such inscriptions), but what the hell, let's go for
    it.  :)

* This is pretty easy as all you have to do is,

    (1) Replace each letter Q in your RE with [qQ]

    (2) Add entries for each q to the initialization of rvals[].
          Be careful that you leave the entry for '\0' as the
          last entry as that's the marker for the end of the
          table.

#-----------------------------------------------------------------

#-----------------------------------------------------------------
#-- Prerequisites ------------------------------------------------
#-----------------------------------------------------------------

* Ensure you have flex 2.6.4 (at least) installed.

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

* Ensure that you have bison 3.5.1 (at least) installed.

  $ apt-cache policy bison
  bison:
    Installed: 2:3.5.1+dfsg-1
    Candidate: 2:3.5.1+dfsg-1
    Version table:
   *** 2:3.5.1+dfsg-1 500
          500 http://archive.ubuntu.com/ubuntu focal/main amd64 Packages
          100 /var/lib/dpkg/status
  $ bison --version
  bison (GNU Bison) 3.5.1
  Written by Robert Corbett and Richard Stallman.

  Copyright (C) 2020 Free Software Foundation, Inc.
  This is free software; see the source for copying conditions.  There is NO
  warranty; not even for MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  $

* You don't *need* xsltproc installed, but it does make a much
    nicer looking report if you do.

  $ apt-cache policy xsltproc
  xsltproc:
    Installed: 1.1.34-4ubuntu0.20.04.1
    Candidate: 1.1.34-4ubuntu0.20.04.1
    Version table:
   *** 1.1.34-4ubuntu0.20.04.1 500
          500 http://archive.ubuntu.com/ubuntu focal-updates/main amd64 Packages
          500 http://security.ubuntu.com/ubuntu focal-security/main amd64 Packages
          100 /var/lib/dpkg/status
       1.1.34-4 500
          500 http://archive.ubuntu.com/ubuntu focal/main amd64 Packages
  $ xsltproc --version
  Using libxml 20910, libxslt 10134 and libexslt 820
  xsltproc was compiled against libxml 20910, libxslt 10134 and libexslt 820
  libxslt 10134 was compiled against libxml 20910
  libexslt 820 was compiled against libxml 20910
  $

  If you choose not to install xsltproc, comment out or remove
    line 25 of the Makefile.  (That's the line invoking xsltproc.)

* Some systems have the readline library installed by default.
    If yours doesn't you will need to install it.

  $ apt-cache policy libreadline-dev
  libreadline-dev:
    Installed: 8.0-4
    Candidate: 8.0-4
    Version table:
   *** 8.0-4 500
          500 http://archive.ubuntu.com/ubuntu focal/main amd64 Packages
          100 /var/lib/dpkg/status
  $

#-----------------------------------------------------------------
#-- What to do ---------------------------------------------------
#-----------------------------------------------------------------

* Look in the Minimal/ directory.

* Type "make",

  $ make
  flex lexer.l
  %option yylineno entails a performance penalty ONLY on rules that can match newline characters
  flex version 2.6.4 usage statistics:
    scanner options: -pps--reentrant--bison-bridge--bison-locationsvB8 -Cem
    89/2000 NFA states
    37/1000 DFA states (156 words)
    13 rules
    Compressed tables always back-up
    1/40 start conditions
    52 epsilon states, 29 double epsilon states
    23/100 character classes needed 263/500 words of storage, 0 reused
    226 state/nextstate pairs created
    67/159 unique/duplicate transitions
    47/1000 base-def entries created
    126/2000 (peak 270) nxt-chk entries created
    80/2500 (peak 220) template nxt-chk entries created
    5 empty table entries
    15 protos created
    10 templates created, 16 uses
    22/256 equivalence classes created
    8/256 meta-equivalence classes created
    0 (3 saved) hash collisions, 33 DFAs equal
    0 sets of reallocations needed
    624 total table entries needed
  bison -Werror=conflicts-sr -Werror=conflicts-rr --report=all --xml parser.y
  xsltproc /usr/share/bison/xslt/xml2xhtml.xsl parser.xml > parser.html
  rm -f parser.xml
  gcc -g -Wall -Wextra  -fsanitize=address lex.yy.c parser.tab.c exprAlloc.c exprDump.c exprEval.c symbolTable.c main.c -o calc -lm -lreadline
  $

* You will run into some problems if you don't have xsltproc
    installed or if your system installs bison in a weird place.

  If xsltproc isn't installed (or you don't care about tidy
    HTML reports), just remove or comment out line 25 of the
    Makefile.  (That's the line that invokes xsltproc.)

  If xsltproc is installed but complains, maybe bison's
    xml2xhtml.xsl file is installed in a different spot.  On
    UNIXy systems, this file is in the /usr/share/bison/xslt/
    directory.  Maybe your install put it somewhere else.  Look
    around for it and change line 25 of the Makefile to refer to
    the correct location.

* You might also have some trouble with the readline library.
    Some systems have it installed automatically.  Others don't.
    If the build fails with a missing library for this, check
    if libreadline is there.  (See note above in Prerequisites.)

* Once it's all built correctly, run the desk calculator.  Use
    ^D to exit.  For example,

  $ ./calc
  > 1 + 1    // The classic first test of a calculator
  "1 + 1    // The classic first test of a calculator" ==>

   (LITERAL INTEGER 2)

  > 1 + 2 * 3   // Precedence test
  "1 + 2 * 3   // Precedence test" ==>

   (LITERAL INTEGER 7)

  > 10 + 9 + 1  // Associativity test
  "10 + 9 + 1  // Associativity test" ==>

   (LITERAL INTEGER 20)

  > -----3  // Unary operator test
  "-----3  // Unary operator test" ==>

   (LITERAL INTEGER -3)

  > a = 1  // Assignment to var
  "a = 1  // Assignment to var" ==>

   (LITERAL INTEGER 1)

  > a += 23  // Add assign to var
  "a += 23  // Add assign to var" ==>

   (LITERAL INTEGER 24)

  > showParseTree = 1  // Show parse tree before evaluating
  "showParseTree = 1  // Show parse tree before evaluating" ==>

   (LITERAL INTEGER 1)

  > 10 + 9 + 1  // Associativity test with parse tree
  "10 + 9 + 1  // Associativity test with parse tree" ==>

   (BOP ADD
    (BOP ADD
     (LITERAL INTEGER 10)
     (LITERAL INTEGER 9)
    )
    (LITERAL INTEGER 1)
   )

   (LITERAL INTEGER 20)

  > 1 + 2 * 3   // Precedence test with parse tree
  "1 + 2 * 3   // Precedence test with parse tree" ==>

   (BOP ADD
    (LITERAL INTEGER 1)
    (BOP MULTIPLY
     (LITERAL INTEGER 2)
     (LITERAL INTEGER 3)
    )
   )

   (LITERAL INTEGER 7)

  > -----3  // Unary operator test with parse tree
  "-----3  // Unary operator test with parse tree" ==>

   (UOP NEGATE
    (UOP NEGATE
     (UOP NEGATE
      (UOP NEGATE
       (UOP NEGATE
        (LITERAL INTEGER 3)
       )
      )
     )
    )
   )

   (LITERAL INTEGER -3)

  > a = 1  // Assignment to var with parse tree
  "a = 1  // Assignment to var with parse tree" ==>

   (BOP ASSIGN
    (ID "a")
    (LITERAL INTEGER 1)
   )

   (LITERAL INTEGER 1)

  > a += 23  // Add assign to var with parse tree
  "a += 23  // Add assign to var with parse tree" ==>

   (BOP PLUS_ASSIGN
    (ID "a")
    (LITERAL INTEGER 23)
   )

   (LITERAL INTEGER 24)

  >
  $

* As calc is using readline to get input from the tty, you can
    use up and down arrow to scroll through the history of lines
    you've entered.  On a line you can use left and right arrow
    to move around inside the line.  Use backspace and delete to
    remove stuff you don't want and type new characters wherever
    you will.  Hit enter anywhere in the line to submit it.
    (readline has zillions of other commands if you care.  RTFM!)

* Pretty cool, eh?  calc even ignores // comments.  Slick!  :)

* You'll notice that the only operators that are implemented
    are addition (binary +), multiplication (binary *),
    assign (binary =), plus-assign (binary +=), and
    negate (unary -).

* Take a look at the various internals and see if you can pick
    out what would be necessary to support say subtraction
    (binary -).

  This isn't all that difficult if you think about it the
    correct way.  Take a look at EVERY spot in ANY file where
    something was done to support addition (binary +) and see if
    you can figure out what the equivalent support would be for
    subtraction.

  OK, OK, here's a hint list:

    expr.h      :
      one line added

    exprDump.c  :
      one line changed
      another line added

    exprEval.c  :
      one line added
      another two lines added
      yet another two lines added

    parser.y    :
      one line changed
      one line added

  No other files had to be changed at all!  Eight lines added and
    two lines (slightly) changed.  Wow!  No big deal, right?
    By the way, the reference solution calls the subtract
    operation eBOP_SUBTRACT.

* Now try for division (binary /).  Division (eBOP_DIVIDE)
    requires similar changes in the same files that subtraction
    did.  (It's "similar" instead of "exactly the same" because
    in some places different numbers of lines were
    added / changed.)

    Division also requires one line to be (slightly) changed
    in lexer.l.  (Subtraction didn't require the lexer to be
    changed because - was already used for the negate operator.)

    Turns out there's also one other thing that we have to do to
    support division properly that was not required for addition,
    subtraction, or multiplication.  Think hard for a moment.  :)
    What does one have to be careful about with division that
    doesn't come up with addition, subtraction, or multiplication?

    The total ends up being three lines (slightly) changed and
    28 (!) lines added.  It's a bit more than in the subtraction
    case because of that difference about division just mentioned.

* Don't panic if this all seems a bit obscure or if you have some
    troubles.  It's only hard the first time.  :)  Once you
    understand what's necessary to enhance the calculator with
    one binary operator, you'll be able to add any number of
    additional binary operators with little difficulty.  Really!

* We'll be reviewing this in detail in class.  However, the more
    familiar you are with the code beforehand, the easier it will
    be to get the maximum benefit from the discussion.

* By the way, if you're winning with subtraction and division,
    think about what other operations might be fun to add.  Once
    one has +, -, *, and /, what about ^ for exponentiation?
    How about % for modulus?  Think about what % means for integer
    operands versus real operands.  Once that's done, how about
    % as a postfix operator meaning percent?  What about other
    assign operators such as -=, *=, and /=?  Etc., etc. ...

    Go for it!  :)
#-----------------------------------------------------------------

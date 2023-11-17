#-----------------------------------------------------------------
#-- Prerequisites ------------------------------------------------
#-----------------------------------------------------------------

* Ensure you have *at least* flex 2.6.4 installed.

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

* Glance at the flex handout on Canvas, "flex Notes, v1.0.pdf" in
    Modules > Handouts.

#-----------------------------------------------------------------
#-- First steps --------------------------------------------------
#-----------------------------------------------------------------

* Look in the Source/ directory.

* Type "make",

  $ make
  flex --outfile=lexer.c lexer.l
  %option yylineno entails a performance penalty ONLY on rules that can match newline characters
  flex version 2.6.4 usage statistics:
    scanner options: -ppsvB8 -Cem -olexer.c
    27/2000 NFA states
    14/1000 DFA states (50 words)
    6 rules
    Compressed tables always back-up
    1/40 start conditions
    19 epsilon states, 10 double epsilon states
    9/100 character classes needed 135/500 words of storage, 0 reused
    28 state/nextstate pairs created
    23/5 unique/duplicate transitions
    17/1000 base-def entries created
    22/2000 (peak 21) nxt-chk entries created
    9/2500 (peak 21) template nxt-chk entries created
    0 empty table entries
    3 protos created
    3 templates created, 5 uses
    7/256 equivalence classes created
    3/256 meta-equivalence classes created
    0 (0 saved) hash collisions, 12 DFAs equal
    0 sets of reallocations needed
    341 total table entries needed
  gcc -g -Wall -Wextra -fsanitize=address -c lexer.c
  gcc -fsanitize=address -o lexer lexer.o
  rm lexer.c
  $

* Run the lexer on its internal test string,

  $ ./lexer
  Tokens for
  fred _ 15 1234.345 "bob" Maddog87

  (1:1-4) ID 'fred'
  (1:6) ID '_'
  (1:8-9) INTEGER_LITERAL 15
  (1:11-14) INTEGER_LITERAL 1234
  (1:15) Illegal character '.' (0x2e)
  (1:16-18) INTEGER_LITERAL 345
  (1:20) Illegal character '"' (0x22)
  (1:21-23) ID 'bob'
  (1:24) Illegal character '"' (0x22)
  (1:26-33) ID 'Maddog87'
  $

  Pretty neat, eh?  This text is in Results/string-results.txt.

* Now run the lexer on the supplied tryMe.txt file,

  $ ./lexer tryMe.txt
  639 bytes read from 'tryMe.txt'.
  Tokens for
    auto      break     case      char      const     continue
    default   do        double    else      enum      extern
    float     for       goto      if        inline    int
    long      register  restrict  return    short     signed
    sizeof    static    struct    switch    typedef   typeof
    union     unsigned  void      volatile  while

  .
  .  (lots of messages edited out here)
  .

  (27:19) Illegal character '"' (0x22)
  (27:20) Illegal character ',' (0x2c)
  (27:22) ID 'i'
  (28:3) Illegal character '}' (0x7d)
  $

  Even though we're supplying keywords, many are reported as IDs
  because the lexer hasn't been told they are keywords yet.

  Many illegal characters are reported because we haven't told the
  lexer that they are operators, punctuation, etc. yet.

* The complete text is Results/original-results.txt.

#-----------------------------------------------------------------
#-- Next steps ---------------------------------------------------
#-----------------------------------------------------------------

* Using your superior intellect, augment the lexer.l file so that
    when you make and run it on tryMe.txt, THERE ARE NO ILLEGAL
    CHARACTERS REPORTED and all keywords are properly scanned!
    (That is, all token categories represented by constructs in
    the text file have suitable rules to recognize them.)

* Results/final-results.txt is the output text you want to
    generate.

* We're going to do this in stages, each one pretty simple in
    itself, yet by the time we're done we'll have a pretty darn
    good and useful lexical analyzer.

#-- [1] Comments -----------------------
* The absolute easiest thing to do first is to recognize and
    discard // comments.

#-- [2] Other keywords -----------------
* Next, do the rest of the keywords.  The tok_... consts for the
    keywords are all already declared for you in the enum starting
    at line 44.  To recognize them, (1) add the appropriate
    entries in keywords[] using the tok_AUTO entry as an example,
    then (2) add the appropriate case labels to the switch
    statement again using the tok_AUTO entry as an example.

#-- [3] Other 1-char punctuation -------
* Now do the rest of the single-character punctuation marks.
    '(' and ')' are already properly processed.  Caarefully add
    the []{}:;, characters to the rule and the corresponding case
    labels to the switch statement. (Ensure that you escape with
    the \ character any troublesome entries!)

#-- [4] 1-char operators ---------------
* The single-character operators are similar to the punctuation
    marks.  Carefully add the -+*/^!<>= characters to the rule.
    To get the different message for the operators, you'll have
    to make a separate entry in the switch statement.  It's pretty
    much the same as the one for the punctuation marks, but the
    message says "Operator" instead of "Punctuation".

#-- [5] Multi-char operators -----------
* The multi-character operators >= <= == and <> are a little
    trickier because they are each two characters long.  You'll
    see that there are tok_... consts declared for these in the
    enum.  We'll need a separate rule for each one.  The RE for
    the rule is the characters of the operator.  The action for
    the rule is to return the appropriate tok_... const.

    Add another entry to the switch statement with the four case
    labels for these operators.  The message printed is like the
    one for keywords except it says "Operator" instead of
    "Keyword".

    Add entries to keywords[] for these operators so we can look
    up their string forms using their tok_... const.

#-- [6] String literal -----------------
* Finally, do string literal.  Create a rule with a RE to
    recognize the form of a string literal: a quotation mark,
    then 0-or-more characters that are not a quotation mark nor
    a newline, then the closing quotation mark.  In the action,
    allocate space to hold the contents of the string and copy
    into that space the characters without the leading or trailing
    quotation marks.  (Use what we did for ID as an starting
    point.)

    Add another entry to the switch statement with the case label
    tok_STR_LIT and print a message.  Don't forget to free the
    yylval.strval so you don't leak memory!

#-- All done! --------------------------
* Pretty simple, eh?  Looking at my solution, I see,

    comments :
      1 one-line rule

    keywords :
      37 new entries in keywords[]
      37 new case labels

    single-char punctuation marks :
      7 new chars in the RE
      7 new case labels

    single-char operators :
      9 new chars in the RE
      9 case labels
      2 Lines of Code (LOC) in a new switch entry (a printf
          and a break! :)

    multi-char operators :
      4 one-line rules
      4 new entries in keywords[]
      4 case labels
      2 LOC in a new switch entry (another printf / break! :)

    string literal :
      1 RE to match a string literal
      3 LOC to allocate some space, copy the contents, and return
      1 case label
      3 LOC in a new switch entry (this time a printf / free /
          break! :)

#-----------------------------------------------------------------

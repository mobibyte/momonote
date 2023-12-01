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
    24/2000 NFA states
    13/1000 DFA states (45 words)
    5 rules
    Compressed tables always back-up
    1/40 start conditions
    17 epsilon states, 9 double epsilon states
    8/100 character classes needed 133/500 words of storage, 0 reused
    26 state/nextstate pairs created
    21/5 unique/duplicate transitions
    18/1000 base-def entries created
    19/2000 (peak 30) nxt-chk entries created
    25/2500 (peak 30) template nxt-chk entries created
    0 empty table entries
    5 protos created
    5 templates created, 9 uses
    6/256 equivalence classes created
    5/256 meta-equivalence classes created
    0 (0 saved) hash collisions, 11 DFAs equal
    0 sets of reallocations needed
    336 total table entries needed
  gcc -g -Wall -Wextra -fsanitize=address -c lexer.c
  gcc -fsanitize=address -o lexer lexer.o
  rm lexer.c
  $

* Run the lexer,

  $ ./lexer
  Tokens for "fred _ 15 1234.345 "bob" Maddog87":
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

* Dance for joy!  You've got a lexer working!

* By default, this lexer scans the builtin string,

    fred _ 15 1234.345 "bob" Maddog87

  However, it is smart enough to read the string to scan from a
  file.  Put some IDs, integer literals, and illegal characters
  in a text file and rerun ./lexer giving the name of the text
  file as an argument.  For example,

    $ ./lexer MyTextFile.txt

  The lexer will read the characters from that file and scan them.

#-----------------------------------------------------------------
#-- Next steps ---------------------------------------------------
#-----------------------------------------------------------------

* Make up a rule to deal with hex integer literals.  This is
    quite easy:

    * Make a definition for hex "digits".  It should look like the
        DIGIT definition on line 85, but allow a-f and A-F as
        well.  Name it HEXIT -- for hex "digit".

    * Make a rule for hex literals.  This will look like the one
        for decimal literals in lines 90-97 but will have a
        pattern that recognizes such things as 0xaBc or 0x123 or
        0xDeadBeef or ...

        Also, the strtol() call in the action routine should use
        16 for the base and it should start the conversion at
        yytext+2.  (Why?)

* As soon as that works, you are clearly omnipotent.  Make up
    another rule for binary integer literals.  These will start
    with 0b and have only 0 and 1 as possible "digits".

* With that done, do another rule to recognize octal integer
    literals.  These begin with 0o and have 0-7 as possible
    "digits".

* You should be getting bored with all of this success.  Now
    try to make a rule that recognizes FP literals.  You will have
    to:

    * Add tok_REAL_LIT to the enum at lines 44.47.

    * Add a realval field to the yylval union at lines 53-56.  Its
        type is double.

    * Make a rule whose pattern matches such things as 1.234 or
        .123 or 123. or ...  These are digit strings with EXACTLY
        one decimal point somewhere in the middle or at the front
        or at the end.

        Use atof() to convert the characters indicated by yytext
        into a double and assign it to yylval.realval.

     * Add a new case to the switch at lines 211-224 to print
        tok_REAL_LIT tokens.

* Once that simple real literal rule is working OK, see if you
    can add an OPTIONAL exponent to it.  An exponent is e or E
    followed by an optional sign + or - followed by one or more
    decimal digits.

    If you do this correctly, your FP literal rule should
    recognize character sequences such as 123.456 and 0.23E12 and
    567.e-234 and ...

    However, it should not match anything like . or .e or 1.e--12
    or ...

* If you're really ambitious, make a rule that recognizes string
    literals.  Call it tok_STR_LIT.  You don't need to add a new
    field to yylval as you can use strval as tok_ID does.  Use
    strdup() to make a copy of the string literal.  Add a new case
    to the switch to print tok_STR_LIT tokens.  Don't forget to
    free yylval.strval when you're done with it.

* Now before you start getting all arrogant, did you remember to
    NOT include the " characters at the beginning and end of the
    string literal when you did the strdup?  :)

#-----------------------------------------------------------------

# Dalio, Brian A.
# dalioba
# 2023-10-20
#-----------------------------------------------------------------
FILES  = lex.yy.c parser.tab.c exprAlloc.c exprDump.c exprEval.c symbolTable.c main.c

CC     = gcc

SANFLAGS = -fsanitize=address

CFLAGS = -g -Wall -Wextra  $(SANFLAGS)
LDFLAGS = $(SANFLAGS)
LDLIBS  = -lm -lreadline

#-----------------------------------------------------------------
calc : $(FILES)
	$(CC) $(CFLAGS) $(FILES) -o calc $(LDLIBS)

#-----------------------------------------------------------------
lex.yy.c : lexer.l
	flex lexer.l

parser.tab.c : parser.y lex.yy.c
	bison -Werror=conflicts-sr -Werror=conflicts-rr --report=all --xml parser.y
	xsltproc /usr/share/bison/xslt/xml2xhtml.xsl parser.xml > parser.html
	rm -f parser.xml

#-----------------------------------------------------------------
clean:
	rm -f *.o lex.yy.[ch] parser.tab.[ch] parser.output parser.xml parser.html calc

#-----------------------------------------------------------------

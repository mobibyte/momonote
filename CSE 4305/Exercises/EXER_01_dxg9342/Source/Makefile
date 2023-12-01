# Dalio, Brian A.
# dalioba
# 2023-09-08
#-----------------------------------------------------------------
PROJS  = lexer

#-----------------------------------------------------------------
CC       = gcc

SANFLAGS = -fsanitize=address

CFLAGS   = -g -Wall -Wextra $(SANFLAGS)
LDFLAGS  = $(SANFLAGS)
LDLIBS   = -lm

#-----------------------------------------------------------------
%.o : %.c
	$(CC) $(CFLAGS) -c $^

%.c : %.l
	flex --outfile=$*.c $^

lexer : lexer.o
	$(CC) $(LDFLAGS) -o lexer lexer.o

#-----------------------------------------------------------------
clean:
	rm -f *.o $(PROJS) lex.yy.[ch] lexer.tab.[ch]

#-----------------------------------------------------------------

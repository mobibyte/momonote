# Phases of Compilation

0. Character Stream  
V  
1. **__Scanner (lexical analysis)__**  
V  
Token stream  
V  
2. **__Parser (syntax analysis)__**  
V  
Parse tree  
V  
3. **__Semantic analysis and intermediate code generation__**  
V   
Abstract syntax tree or other intermediate form  
V  
4. **__Machine-independent code improvement__**  
V  
Modified intermediate form  
V  
5. **__Target code generation__**  
V  
Target language (e.g., assembler)  
V  
6. **__Machine-specific code improvement__**  
V  
Modified target language  

## Front end
1. Lexical analysis
2. Syntax analysis
3. Semantic analysis

## Back end
5. Target code generation
6. Machine-specific code improvement (optional)





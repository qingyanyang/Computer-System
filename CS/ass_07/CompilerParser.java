import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;

class CompilerParser {

    LinkedList<Token> tokens;
    // create iterator to point the index of token which is using
    int iterator;
    //initialization
    public CompilerParser(){
        iterator = 0;
        tokens = null;
    }
    /**
     * Constructor for the CompilerParser
     * @param tokens A linked list of tokens to be parsed
     */
    public CompilerParser(LinkedList<Token> tokens){
        this.tokens = tokens;
    }
    //check the identifier rule
    public boolean identifierRule(int iterator){
        if(iterator < tokens.size()){
            if(tokens.get(iterator).getType().equals("identifier")){
                //cannot start from number
                if(tokens.get(iterator).getValue().charAt(0) <= 57 && tokens.get(iterator).getValue().charAt(0) >= 48){
                    return false;
                }else{
                    return true;
                }
            }
        }
        return false;
    }
    //check the type rule
    public boolean typeRule(int iterator){
        if(iterator < tokens.size()){
            if(equal(iterator, "keyword", "int") || equal(iterator, "keyword", "char") || equal(iterator, "keyword", "boolean")) {
                return true;
            }
        }

        return false;
    }
    //check the integer constant rule
    public boolean integerConstantRule(int iterator){
        if(iterator < tokens.size()){
            if(tokens.get(iterator).getType().equals("integerConstant")){
                if(tokens.get(iterator).getValue().matches("^[0-9]*$") && Integer.parseInt(tokens.get(iterator).getValue()) <= 32767){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    //check the string constant rule
    public boolean stringConstantRule(int iterator){
        if(iterator < tokens.size()){
            if(tokens.get(iterator).getType().equals("stringConstant")){
                String s = tokens.get(iterator).getValue();
                if((s.charAt(0)=='"') && (s.charAt(s.length()-1)=='"') && (!s.substring(1,s.length()-1).contains("\n")&&!s.substring(1,s.length()-1).contains("\""))){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
    }
    //check the keyword constant rule
    public boolean keywordConstantRule(int iterator){
        if(iterator < tokens.size()){
            if(equal(iterator,"keyword","true") || equal(iterator,"keyword","false") || equal(iterator,"keyword","null") || equal(iterator,"keyword","this")){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    //check the symbol op rule
    public boolean OpRule(int iterator){
        if(iterator < tokens.size()){
            if(equal(iterator,"symbol","+") || equal(iterator,"symbol","-") || equal(iterator,"symbol","*") || equal(iterator,"symbol","/") || equal(iterator,"symbol","&") || equal(iterator,"symbol","|") || equal(iterator,"symbol","<") || equal(iterator,"symbol",">") || equal(iterator,"symbol","=")){
                return true;
            }
        }
        return false;
    }

    //check if the current token type and value by iterator equals to what we expect
    public boolean equal(int iterator, String type, String value){
        if(iterator < tokens.size()){
            if(tokens.get(iterator).getType().equals(type) && (tokens.get(iterator).getValue().equals(value))){
                return true;
            }
        }
        return false;
    }
    //get parse tree by specific iterator
    public ParseTree getParseTree(int iterator){
        if(iterator < tokens.size()){
            ParseTree parseTree = new ParseTree(tokens.get(iterator).getType(),tokens.get(iterator).getValue());
            return parseTree;
        }
        return null;
    }
    /**
     * Generates a parse tree for a single program
     */
    public ParseTree compileProgram() throws ParseException {
        if(!tokens.isEmpty()){
            //only if the tokens starts with class
            if(equal(0,"keyword","class")){
                return compileClass();
            }else{
                throw new ParseException("have not found class", iterator);
            }
        }
        return null;
    }

    /**
     * Generates a parse tree for a single class
     */
    public ParseTree compileClass() throws ParseException {
        ParseTree parseTree = new ParseTree("class", "");
        boolean mark = true;
        //if tokens cannot meet the rule of class, throw exception
        if(equal(iterator,"keyword","class")
                && identifierRule(iterator + 1)
                && equal(iterator + 2,"symbol","{")){
            parseTree.addChild(getParseTree(iterator));
            parseTree.addChild(getParseTree(iterator + 1));
            parseTree.addChild(getParseTree(iterator + 2));
            iterator = iterator + 3;
            //if there are keywords of class vardec, invokes it
            while(equal(iterator,"keyword","field") || equal(iterator,"keyword","static")){
                parseTree.addChild(compileClassVarDec());
            }
            //if there are keywords of Subroutine, invokes it
            while(equal(iterator,"keyword","constructor") || equal(iterator,"keyword","method") || equal(iterator,"keyword","function")){
                parseTree.addChild(compileSubroutine());
            }
            if(equal(iterator,"symbol","}")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                mark = false;
            }
        }
        if(mark){
            throw new ParseException("wrong class form", iterator);
        }

        return parseTree;
    }

    /**
     * Generates a parse tree for a static variable declaration or field declaration
     */
    public ParseTree compileClassVarDec() throws ParseException {
        boolean mark = true;
        ParseTree parseTree = new ParseTree("classVarDec", "");
        //if tokens cannot meet the rule of class, throw exception
        if(typeRule(iterator + 1) && identifierRule(iterator + 2)){
            parseTree.addChild(getParseTree(iterator));
            parseTree.addChild(getParseTree(iterator + 1));
            parseTree.addChild(getParseTree(iterator + 2));
            iterator = iterator + 3;
            //if there are more, keep adding, by identifing ","
            while(equal(iterator,"symbol",",")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                if(identifierRule(iterator)){
                    parseTree.addChild(getParseTree(iterator));
                    iterator++;
                }else{
                    throw new ParseException("wrong identifier rule", iterator);
                }
            }
            //check if it is ended with ";"
            if(equal(iterator,"symbol",";")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                mark = false;
            }
        }
        if(mark){
            throw new ParseException("wrong class var dec form", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for a method, function, or constructor
     */
    public ParseTree compileSubroutine() throws ParseException {
        boolean mark = true;
        ParseTree parseTree = new ParseTree("subroutine", "");
        //if tokens cannot meet the rule of Subroutine, throw exception
        if((equal(iterator + 1, "keyword", "void") || typeRule(iterator + 1) || identifierRule(iterator + 1)) && identifierRule(iterator + 2) && equal(iterator + 3, "symbol", "(")){
            parseTree.addChild(getParseTree(iterator));
            parseTree.addChild(getParseTree(iterator + 1));
            parseTree.addChild(getParseTree(iterator + 2));
            parseTree.addChild(getParseTree(iterator + 3));
            iterator = iterator + 4;
            //complie parameterlist
            parseTree.addChild(compileParameterList());
            //check if it is ended with ")"
            if(equal(iterator,"symbol", ")")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                parseTree.addChild(compileSubroutineBody());
                mark = false;
            }
        }
        if(mark){
            throw new ParseException("wrong subroutine form", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for a subroutine's parameters
     */
    public ParseTree compileParameterList() throws ParseException {
        boolean mark = true;
        ParseTree parseTree = new ParseTree("parameterList", "");
        //if tokens cannot meet the rule of ParameterList, throw exception
        if(equal(iterator,"symbol",")")){
            return parseTree;
        }else{
            if((typeRule(iterator) || identifierRule(iterator)) && identifierRule(iterator+1)){
                parseTree.addChild(getParseTree(iterator));
                parseTree.addChild(getParseTree(iterator + 1));
                iterator = iterator + 2;
                //if there are more, keep adding, by identifing ","
                while (equal(iterator,"symbol", ",")){
                    if((typeRule(iterator + 1) || identifierRule(iterator+1)) && identifierRule(iterator + 2)){
                        parseTree.addChild(getParseTree(iterator));
                        parseTree.addChild(getParseTree(iterator + 1));
                        parseTree.addChild(getParseTree(iterator + 2));
                        iterator = iterator + 3;
                    }else{
                        throw new ParseException("wrong parameter list form", iterator);
                    }
                }
                mark = false;
            }
        }
        if(mark){
            throw new ParseException("wrong parameter list form", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for a subroutine's body
     */
    public ParseTree compileSubroutineBody() throws ParseException {
        boolean mark = true;
        ParseTree parseTree = new ParseTree("subroutineBody", "");
        //if tokens cannot meet the rule of subroutineBody, throw exception
        if(equal(iterator,"symbol","{")){
            parseTree.addChild(getParseTree(iterator));
            iterator++;
            //if keyword of var dec is found, add to the parse tree, there could be more
            while(equal(iterator, "keyword","var")){
                parseTree.addChild(compileVarDec());
            }
            //add statements
            parseTree.addChild(compileStatements());
            //check if it is ended with "}"
            if(equal(iterator,"symbol","}")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                mark = false;
            }
        }
        if(mark){
            throw new ParseException("wrong subroutine body form", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for a variable declaration
     */
    public ParseTree compileVarDec() throws ParseException {
        boolean mark = true;
        ParseTree parseTree = new ParseTree("varDec", "");
        //if tokens cannot meet the rule of VarDec, throw exception
        if((typeRule(iterator + 1) || identifierRule(iterator + 1)) && identifierRule(iterator + 2)){
            parseTree.addChild(getParseTree(iterator));
            parseTree.addChild(getParseTree(iterator + 1));
            parseTree.addChild(getParseTree(iterator + 2));
            iterator = iterator + 3;
            //if there are more, keep adding, by identifing ","
            while(equal(iterator,"symbol",",")){
                if(identifierRule(iterator + 1)){
                    parseTree.addChild(getParseTree(iterator));
                    parseTree.addChild(getParseTree(iterator + 1));
                    iterator = iterator + 2;
                }else{
                    throw new ParseException("wrong vardec form", iterator);
                }
            }
            //check if it is ended with ";"
            if(equal(iterator,"symbol",";")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                mark = false;
            }
        }
        if(mark){
            throw new ParseException("wrong vardec form", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for a series of statements
     */
    public ParseTree compileStatements() throws ParseException {
        ParseTree parseTree = new ParseTree("statements", "");
        //only if meet the rule of statements, there could be more, keep checking and adding
        while(equal(iterator, "keyword","let") || equal(iterator, "keyword","do") || equal(iterator, "keyword","while") || equal(iterator, "keyword","if") || equal(iterator, "keyword","return")){
            if(equal(iterator,"keyword","let")){
                parseTree.addChild(compileLet());
            }
            if(equal(iterator,"keyword","do")){
                parseTree.addChild(compileDo());
            }
            if(equal(iterator,"keyword","while")){
                parseTree.addChild(compileWhile());
            }
            if(equal(iterator,"keyword","if")){
                parseTree.addChild(compileIf());
            }
            if(equal(iterator,"keyword","return")){
                parseTree.addChild(compileReturn());
            }
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for a let statement
     */
    public ParseTree compileLet() throws ParseException {
        boolean mark = true;
        ParseTree parseTree = new ParseTree("letStatement", "");
        //if tokens cannot meet the rule of Let statement, throw exception
        if(identifierRule(iterator + 1)){
            parseTree.addChild(getParseTree(iterator));
            parseTree.addChild(getParseTree(iterator + 1));
            iterator = iterator + 2;
            //check if there is an expression
            if(equal(iterator,"symbol","[")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                parseTree.addChild(compileExpression());
                //check if it is ended by "]"
                if(equal(iterator,"symbol","]")){
                    parseTree.addChild(getParseTree(iterator));
                    iterator++;
                }else{
                    throw new ParseException("have not found class", iterator);
                }
            }
            //check if the next token is "=", if not, throw exception
            if(equal(iterator,"symbol","=")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                parseTree.addChild(compileExpression());
                if(equal(iterator,"symbol",";")){
                    parseTree.addChild(getParseTree(iterator));
                    iterator++;
                    mark = false;
                }
            }
        }
        if(mark){
            throw new ParseException("have not found class", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for an if statement
     */
    public ParseTree compileIf() throws ParseException {
        boolean mark = true;
        ParseTree parseTree = new ParseTree("ifStatement", "");
        //if tokens cannot meet the rule of if statement, throw exception
        if(equal(iterator+1,"symbol","(")){
            parseTree.addChild(getParseTree(iterator));
            parseTree.addChild(getParseTree(iterator + 1));
            iterator = iterator + 2;
            parseTree.addChild(compileExpression());
            if(equal(iterator,"symbol",")") && equal(iterator+1,"symbol","{")){
                parseTree.addChild(getParseTree(iterator));
                parseTree.addChild(getParseTree(iterator + 1));
                iterator = iterator + 2;
                parseTree.addChild(compileStatements());
                if(equal(iterator,"symbol","}")){
                    parseTree.addChild(getParseTree(iterator));
                    iterator++;
                    mark = false;
                }
                //if there are else statements, adding
                if(equal(iterator,"keyword","else") && equal(iterator+1,"symbol","{")){
                    parseTree.addChild(getParseTree(iterator));
                    parseTree.addChild(getParseTree(iterator + 1));
                    iterator = iterator + 2;
                    parseTree.addChild(compileStatements());
                    if(equal(iterator,"symbol","}")){
                        parseTree.addChild(getParseTree(iterator));
                        iterator++;
                    }else{
                        throw new ParseException("have not found class", iterator);
                    }
                }
            }
        }
        if(mark){
            throw new ParseException("have not found class", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for a while statement
     */
    public ParseTree compileWhile() throws ParseException {
        boolean mark = true;
        ParseTree parseTree = new ParseTree("whileStatement", "");
        //if tokens cannot meet the rule of while statement, throw exception
        if(equal(iterator+1,"symbol","(")){
            parseTree.addChild(getParseTree(iterator));
            parseTree.addChild(getParseTree(iterator + 1));
            iterator = iterator + 2;
            parseTree.addChild(compileExpression());
            if(equal(iterator,"symbol",")") && equal(iterator+1,"symbol","{")){
                parseTree.addChild(getParseTree(iterator));
                parseTree.addChild(getParseTree(iterator + 1));
                iterator = iterator + 2;
                parseTree.addChild(compileStatements());
                if(equal(iterator,"symbol","}")){
                    parseTree.addChild(getParseTree(iterator));
                    iterator++;
                    mark = false;
                }
            }
        }
        if(mark){
            throw new ParseException("have not found class", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for a do statement
     */
    public ParseTree compileDo() throws ParseException {
        boolean mark = true;
        ParseTree parseTree = new ParseTree("doStatement", "");
        //if tokens cannot meet the rule of do statement, throw exception
        parseTree.addChild(getParseTree(iterator));
        iterator++;
        parseTree.addChild(compileExpression());
        if(equal(iterator,"symbol",";")){
            parseTree.addChild(getParseTree(iterator));
            iterator++;
        }else {
            throw new ParseException("have not found class", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for a return statement
     */
    public ParseTree compileReturn() throws ParseException {
        ParseTree parseTree = new ParseTree("returnStatement", "");
        //if tokens cannot meet the rule of return statement, throw exception
        if(equal(iterator + 1,"symbol",";")){
            parseTree.addChild(getParseTree(iterator));
            parseTree.addChild(getParseTree(iterator+1));
            iterator= iterator + 2;
            return parseTree;
        }else{
            parseTree.addChild(getParseTree(iterator));
            iterator++;
            parseTree.addChild(compileExpression());
            if(equal(iterator,"symbol",";")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
            }else{
                throw new ParseException("have not found class", iterator);
            }
        }
        return parseTree;
    }
    /**
     * Generates a parse tree for an expression
     */
    public ParseTree compileExpression() throws ParseException {
        ParseTree parseTree = new ParseTree("expression", "");
        if(equal(iterator,"keyword","skip")){
            parseTree.addChild(getParseTree(iterator));
            iterator++;
        }else{
            parseTree.addChild(compileTerm());
            while(OpRule(iterator)){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                parseTree.addChild(compileTerm());
            }
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for an expression term
     */
    public ParseTree compileTerm() throws ParseException {
        ParseTree parseTree = new ParseTree("term", "");
        if(tokens.get(iterator).getType().equals("integerConstant") || tokens.get(iterator).getType().equals("stringConstant") || keywordConstantRule(iterator)){
            parseTree.addChild(getParseTree(iterator));
            iterator++;
        }else if(identifierRule(iterator)){
            parseTree.addChild(getParseTree(iterator));
            iterator++;
            if(equal(iterator,"symbol","[")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                parseTree.addChild(compileExpression());
                if(equal(iterator,"symbol","]")){
                    parseTree.addChild(getParseTree(iterator));
                    iterator++;
                }else{
                    throw new ParseException("wrong term form", iterator);
                }
            }else if(equal(iterator,"symbol","(")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                parseTree.addChild(compileExpressionList());
                if(equal(iterator,"symbol",")")){
                    parseTree.addChild(getParseTree(iterator));
                    iterator++;
                }else{
                    throw new ParseException("wrong SubroutineCall form", iterator);
                }
            }else if(equal(iterator,"symbol",".") && identifierRule(iterator+1) && equal(iterator+2,"symbol","(")){
                parseTree.addChild(getParseTree(iterator));
                parseTree.addChild(getParseTree(iterator+1));
                parseTree.addChild(getParseTree(iterator+2));
                iterator=iterator+3;
                parseTree.addChild(compileExpressionList());
                if(equal(iterator,"symbol",")")){
                    parseTree.addChild(getParseTree(iterator));
                    iterator++;
                }else{
                    throw new ParseException("wrong SubroutineCall form", iterator);
                }
            }
        }else if(equal(iterator,"symbol","(")){
            parseTree.addChild(getParseTree(iterator));
            iterator++;
            parseTree.addChild(compileExpression());
            if(equal(iterator,"symbol",")")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
            }else{
                throw new ParseException("wrong term form", iterator);
            }
        }else if(equal(iterator,"symbol","-") || equal(iterator,"symbol","~")){
            parseTree.addChild(getParseTree(iterator));
            iterator++;
            parseTree.addChild(compileTerm());
        }else{
            throw new ParseException("wrong term form", iterator);
        }
        return parseTree;
    }

    /**
     * Generates a parse tree for an expression list
     */
    public ParseTree compileExpressionList() throws ParseException {
        ParseTree parseTree = new ParseTree("expressionList", "");
        if(equal(iterator,"symbol",")")){
            return parseTree;
        }else{
            parseTree.addChild(compileExpression());
            while(equal(iterator,"symbol",",")){
                parseTree.addChild(getParseTree(iterator));
                iterator++;
                parseTree.addChild(compileExpression());
            }
        }
        return parseTree;
    }

    public static void main(String[] args){
        /* Tokens for:
         *     class MyClass {
         *
         *     }
         */
        LinkedList<Token> tokens = new LinkedList<Token>();
        tokens.add(new Token("identifier","Main"));
        tokens.add(new Token("symbol","."));
        tokens.add(new Token("identifier","somefunctionName"));
        tokens.add(new Token("symbol","("));
        tokens.add(new Token("integerConstant","1"));
        tokens.add(new Token("symbol",","));
        tokens.add(new Token("stringConstant","Hello"));
        tokens.add(new Token("symbol",")"));
        //tokens.add(new Token("symbol","}"));

        CompilerParser parser = new CompilerParser(tokens);
        try {
            ParseTree result = parser.compileExpression();
            System.out.println(result);
        } catch (ParseException e) {
            System.out.println("Error Parsing!");
        }

    }

}


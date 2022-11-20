class Token extends ParseTree{

    /**
     * Token for parsing. Can be used as a terminal node in a ParseTree
     * @param type The type of token (see token types). Can be read using token.getType()
     * @param value The token's value. Can be read using token.getValue()
     */
    public Token(String type, String value){
        super(type, value);
    }

} 

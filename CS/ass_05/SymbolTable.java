import java.util.HashMap;

public class SymbolTable {
    //define a hash-map to hold symbol table data
    HashMap<String, Integer> symbolTable = new HashMap<>();
    /**
     * Constructor for the Symbol table
     */
    public SymbolTable() {
        // Your code here
        //initialize predefined symbol table
        symbolTable.put("R0",0);
        symbolTable.put("R1",1);
        symbolTable.put("R2",2);
        symbolTable.put("R3",3);
        symbolTable.put("R4",4);
        symbolTable.put("R5",5);
        symbolTable.put("R6",6);
        symbolTable.put("R7",7);
        symbolTable.put("R8",8);
        symbolTable.put("R9",9);
        symbolTable.put("R10",10);
        symbolTable.put("R11",11);
        symbolTable.put("R12",12);
        symbolTable.put("R13",13);
        symbolTable.put("R14",14);
        symbolTable.put("R15",15);
        symbolTable.put("SP",0);
        symbolTable.put("LCL",1);
        symbolTable.put("ARG",2);
        symbolTable.put("THIS",3);
        symbolTable.put("THAT",4);
        symbolTable.put("SCREEN",16384);
        symbolTable.put("KBD",24576);
    }

    /**
     * Adds a symbol to the symbol table
     * 
     * @param symbol The name of the symbol
     * @param value  The address for the symbol
     */
    public void addSymbol(String symbol, int value) {
        // Your code here
        //only if the symbol added is not found in existed list
        //add the pair to the symbol table
        if(!this.symbolTable.containsKey(symbol)){
            this.symbolTable.put(symbol,value);
        }
    }

    /**
     * Gets a symbol from the symbol table
     * 
     * @param symbol The name of the symbol
     * @return The address for the symbol or -1 if the symbol isn't in the table
     */
    public int getSymbol(String symbol) {
        // Your code here
        //get address though symbol
        if(this.symbolTable.containsKey(symbol)){
            Integer address = this.symbolTable.get(symbol);
            return address;
        }else{
            return -1;
        }
    }
//    public void printSymbol(){
//        System.out.println(this.symbolTable);
//    }
}
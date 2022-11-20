import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Instruction types */
enum InstructionType {
    A_INSTRUCTION, C_INSTRUCTION, L_INSTRUCTION, NULL
}

/** C-instruction destinations */
enum InstructionDest {
    A, D, M, AM, AD, MD, AMD, NULL
}

/** C-instruction jump conditions */
enum InstructionJump {
    JLT, JGT, JEQ, JLE, JGE, JNE, JMP, NULL
}

/** C-instruction computations/op-codes */
enum InstructionComp {
    CONST_0, CONST_1, CONST_NEG_1,
    A, M, D,
    NOT_A, NOT_M, NOT_D,
    NEG_A, NEG_M, NEG_D,
    A_ADD_1, M_ADD_1, D_ADD_1,
    A_SUB_1, M_SUB_1, D_SUB_1,
    D_ADD_A, D_ADD_M,
    D_SUB_A, D_SUB_M, A_SUB_D, M_SUB_D,
    D_AND_A, D_AND_M,
    D_OR_A, D_OR_M,
    NULL
}

public class Assembler {

    /**
     * Assembler first pass; populates symbol table with label locations.
     * 
     * @param instructions An array of the assembly language instructions.
     * @param symbolTable  The symbol table to populate.
     */
    public static void doFirstPass(String[] instructions, SymbolTable symbolTable) {
        // Your code here
        int len = instructions.length;
        int count = 0;
        //if it is L instruction, get symbol and put them into symbol table
        for(int i = 0; i < len; i++){
            if(parseInstructionType(instructions[i]) == InstructionType.L_INSTRUCTION){
                String label = parseSymbol(instructions[i]);
                symbolTable.addSymbol(label,i - count);
                count++;
            }
        }
    }

    /**
     * Translates a set of instructions to machine code.
     * 
     * @param instructions An array of the assembly language instructions to be
     *                     converted to machine code.
     * @param symbolTable  The symbol table to reference/update.
     * @return A String containing the generated machine code as strings of 16-bit
     *         binary instructions.
     */
    public static String doSecondPass(String[] instructions, SymbolTable symbolTable) {
        // record variables
        int len = instructions.length;
        int count = 0;
        String machineCode = "";
        String machineCodeCol = "";
        //start traverse
        for(int i = 0; i < len; i++){
            //A instruction
            //if it is lower case symbol, then it is user-defined variable
            if(parseInstructionType(instructions[i]) == InstructionType.A_INSTRUCTION){
                String symbol = parseSymbol(instructions[i]);
                if(symbol.matches("^[a-z]+$")){
                    symbolTable.addSymbol(symbol,16 + count);//the address starts from 16
                    count ++;
                }
                //parse it to binary code
                String instructionA = "0" + translateSymbol(symbol, symbolTable);
                machineCodeCol = instructionA;
                //L instruction
                //jump
            }else if(parseInstructionType(instructions[i]) == InstructionType.L_INSTRUCTION){
                continue;
                //C instruction
                //parse it to binary code
            }else if(parseInstructionType(instructions[i]) == InstructionType.C_INSTRUCTION){
                String instructionC = "111" + translateComp(parseInstructionComp(instructions[i])) +
                        translateDest(parseInstructionDest(instructions[i])) +
                        translateJump(parseInstructionJump(instructions[i]));
                machineCodeCol = instructionC;
            }
            //combine them together
            machineCode += ("\n" + machineCodeCol);
        }
        //translating into machine code
        return machineCode; // replace this
    }

    /**
     * Parses the type of the provided instruction
     * 
     * @param instruction The assembly language representation of an instruction.
     * @return The type of the instruction (A_INSTRUCTION, C_INSTRUCTION,
     *         L_INSTRUCTION, NULL)
     */
    public static InstructionType parseInstructionType(String instruction) {
        // Your code here
        //identify each instruction
        char head = instruction.charAt(0);
        if(head == '@')
            return InstructionType.A_INSTRUCTION;
        else if(head == '(')
            return InstructionType.L_INSTRUCTION;
        else if(instruction.isEmpty())
            return InstructionType.NULL;
        else
            return InstructionType.C_INSTRUCTION;
    }

    /**
     * Parses the destination of the provided C-instruction
     * 
     * @param instruction The assembly language representation of a C-instruction.
     * @return The destination of the instruction (A, D, M, AM, AD, MD, AMD, NULL)
     */
    public static InstructionDest parseInstructionDest(String instruction) {
        // Your code here
        //method to parse comp symbol of c instruction to enum constant
        if(instruction.contains("=")){
            String destination = instruction.substring(0,instruction.indexOf("="));
            switch(destination){
                case "A":
                    return InstructionDest.A;
                case "D":
                    return InstructionDest.D;
                case "M":
                    return InstructionDest.M;
                case "AM":
                    return InstructionDest.AM;
                case "AD":
                    return InstructionDest.AD;
                case "MD":
                    return InstructionDest.MD;
                case "AMD":
                    return InstructionDest.AMD;
                default:
                    return InstructionDest.NULL;
            }
        }else{
            return InstructionDest.NULL;
        }
    }

    /**
     * Parses the jump condition of the provided C-instruction
     * 
     * @param instruction The assembly language representation of a C-instruction.
     * @return The jump condition for the instruction (JLT, JGT, JEQ, JLE, JGE, JNE,
     *         JMP, NULL)
     */
    public static InstructionJump parseInstructionJump(String instruction) {
        // Your code here
        //method to parse comp symbol of c instruction to enum constant
        int len = instruction.length();
        if(instruction.contains(";")){
            String jump = instruction.substring(instruction.indexOf(";")+1, len);
            switch(jump){
                case "JLT":
                    return InstructionJump.JLT;
                case "JGT":
                    return InstructionJump.JGT;
                case "JEQ":
                    return InstructionJump.JEQ;
                case "JLE":
                    return InstructionJump.JLE;
                case "JGE":
                    return InstructionJump.JGE;
                case "JNE":
                    return InstructionJump.JNE;
                case "JMP":
                    return InstructionJump.JMP;
                default:
                    return InstructionJump.NULL;
            }
        }else{
            return InstructionJump.NULL;
        }
    }

    /**
     * Parses the computation/op-code of the provided C-instruction
     * 
     * @param instruction The assembly language representation of a C-instruction.
     * @return The computation/op-code of the instruction (CONST_0, ... ,D_ADD_A ,
     *         ... , NULL)
     */
    public static InstructionComp parseInstructionComp(String instruction) {
        // Your code here
        int len = instruction.length();
        String comp = "";
        //eg: D;JGT
        if(instruction.contains(";") && !instruction.contains("=")){
            comp = instruction.substring(0, instruction.indexOf(";"));
            //eg: D=M
        }else if(instruction.contains("=") && !instruction.contains(";")){
            comp = instruction.substring(instruction.indexOf("=")+1, len);
            //eg: D=M;JGT
        }else if(instruction.contains("=") && instruction.contains(";")) {
            comp = instruction.substring(instruction.indexOf("=") + 1, instruction.indexOf(";"));
            //eg: D
        }else if(!instruction.isEmpty() && !instruction.contains("=") && !instruction.contains(";")){
            comp = instruction;
        }
        return compEqual(comp);
    }
    //method to parse comp symbol of c instruction to enum constant
    public static InstructionComp compEqual(String comp) {
        switch(comp){
            case "0":
                return InstructionComp.CONST_0;
            case "1":
                return InstructionComp.CONST_1;
            case "-1":
                return InstructionComp.CONST_NEG_1;
            case "D":
                return InstructionComp.D;
            case "A":
                return InstructionComp.A;
            case "!D":
                return InstructionComp.NOT_D;
            case "!A":
                return InstructionComp.NOT_A;
            case "-D":
                return InstructionComp.NEG_D;
            case "-A":
                return InstructionComp.NEG_A;
            case "D+1":
                return InstructionComp.D_ADD_1;
            case "A+1":
                return InstructionComp.A_ADD_1;
            case "D-1":
                return InstructionComp.D_SUB_1;
            case "A-1":
                return InstructionComp.A_SUB_1;
            case "D+A":
                return InstructionComp.D_ADD_A;
            case "D-A":
                return InstructionComp.D_SUB_A;
            case "A-D":
                return InstructionComp.A_SUB_D;
            case "D&A":
                return InstructionComp.D_AND_A;
            case "D|A":
                return InstructionComp.D_OR_A;
            case "M":
                return InstructionComp.M;
            case "!M":
                return InstructionComp.NOT_M;
            case "-M":
                return InstructionComp.NEG_M;
            case "M+1":
                return InstructionComp.M_ADD_1;
            case "M-1":
                return InstructionComp.M_SUB_1;
            case "D+M":
                return InstructionComp.D_ADD_M;
            case "D-M":
                return InstructionComp.D_SUB_M;
            case "M-D":
                return InstructionComp.M_SUB_D;
            case "D&M":
                return InstructionComp.D_AND_M;
            case "D|M":
                return InstructionComp.D_OR_M;
        }
        return InstructionComp.NULL;
    }
    /**
     * Parses the symbol of the provided A/L-instruction
     * 
     * @param instruction The assembly language representation of a A/L-instruction.
     * @return A string containing either a label name (L-instruction),
     *         a variable name (A-instruction), or a constant integer value
     *         (A-instruction)
     */
    public static String parseSymbol(String instruction) {
        // Your code here
        //identify each instruction and get the instruction symbol
        String temp = "";
        if(parseInstructionType(instruction) == InstructionType.A_INSTRUCTION){
            temp = instruction.replace("@","");
        }else if(parseInstructionType(instruction) == InstructionType.L_INSTRUCTION){
            temp = instruction.substring(1, instruction.indexOf(")"));
        }
        return temp;
    }

    /**
     * Generates the binary bits of the dest part of a C-instruction
     * 
     * @param dest The destination of the instruction
     * @return A String containing the 3 binary dest bits that correspond to the
     *         given dest value.
     */
    public static String translateDest(InstructionDest dest) {
        // Your code here
        //parse symbol to binary code
        switch(dest){
            case M:
                return "001";
            case D:
                return "010";
            case MD:
                return "011";
            case A:
                return "100";
            case AM:
                return "101";
            case AD:
                return "110";
            case AMD:
                return "111";
            default:
                return "000";
        }
    }

    /**
     * Generates the binary bits of the jump part of a C-instruction
     * 
     * @param jump The jump condition for the instruction
     * @return A String containing the 3 binary jump bits that correspond to the
     *         given jump value.
     */
    public static String translateJump(InstructionJump jump) {
        // Your code here
        //parse symbol to binary code
        switch(jump){
            case JLT:
                return "100";
            case JGT:
                return "001";
            case JEQ:
                return "010";
            case JLE:
                return "110";
            case JGE:
                return "011";
            case JNE:
                return "101";
            case JMP:
                return "111";
            default:
                return "000";
        }
    }

    /**
     * Generates the binary bits of the computation/op-code part of a C-instruction
     * 
     * @param comp The computation/op-code for the instruction
     * @return A String containing the 7 binary computation/op-code bits that
     *         correspond to the given comp value.
     */
    public static String translateComp(InstructionComp comp) {
        // Your code here
        //parse symbol to binary code
        switch(comp){
            case CONST_0:
                return "0101010";
            case CONST_1:
                return "0111111";
            case CONST_NEG_1:
                return "0111010";
            case D:
                return "0001100";
            case A:
                return "0110000";
            case NOT_D:
                return "0001101";
            case NOT_A:
                return "0110001";
            case NEG_D:
                return "0001111";
            case NEG_A:
                return "0110011";
            case D_ADD_1:
                return "0011111";
            case A_ADD_1:
                return "0110111";
            case D_SUB_1:
                return "0001110";
            case A_SUB_1:
                return "0110010";
            case D_ADD_A:
                return "0000010";
            case D_SUB_A:
                return "0010011";
            case A_SUB_D:
                return "0000111";
            case D_AND_A:
                return "0000000";
            case D_OR_A:
                return "0010101";
            case M:
                return "1110000";
            case NOT_M:
                return "1110001";
            case NEG_M:
                return "1110011";
            case M_ADD_1:
                return "1110111";
            case M_SUB_1:
                return "1110010";
            case D_ADD_M:
                return "1000010";
            case D_SUB_M:
                return "1010011";
            case M_SUB_D:
                return "1000111";
            case D_AND_M:
                return "1000000";
            case D_OR_M:
                return "1010101";
            default:
                return "";
        }
    }

    /**
     * Generates the binary bits for an A-instruction, parsing the value, or looking
     * up the symbol name.
     * 
     * @param symbol      A string containing either a label name, a variable name,
     *                    or a constant integer value
     * @param symbolTable The symbol table for looking up label/variable names
     * @return A String containing the 15 binary bits that correspond to the given
     *         sybmol.
     */
    public static String translateSymbol(String symbol, SymbolTable symbolTable) {
        // Your code here
        int address = symbolTable.getSymbol(symbol);
        if(address!= -1){
            String origin =  transferToBinary(address);
            int len = origin.length();
            while(len < 15){
                origin = "0" + origin;
                len++;
            }
            //overflow
            return origin;
        }else if(symbol.matches("^\\d+$")){
            String origin =  transferToBinary(Integer.parseInt(symbol));
            int len = origin.length();
            while(len < 15){
                origin = "0" + origin;
                len++;
            }
            //overflow
            return origin;
        }
        return "000000000000000";
    }
    public static String transferToBinary(int decimal){
        int quotient = decimal;
        int reminder = 0;
        StringBuilder binary = new StringBuilder();
        while(quotient >= 2){
            reminder = quotient % 2;
            quotient = quotient / 2;
            binary.insert(0, reminder);
        }
        binary.insert(0, quotient);
        return binary.toString();
    }

    /** 
     * A quick-and-dirty driver when run standalone.
     * When testing your code, we encourage you to also write your own classes to check
     * individual functions as the autograder will do
     */
    public static void main(String[] args) {
        if(args.length > 0){
            SymbolTable symbolTable = new SymbolTable();
            //symbolTable.printSymbol();
            LinkedList<String> instructionList = new LinkedList<String>();
            // Open file
            try {
                // Read line-by-line
                Scanner sc = new Scanner(new File(args[0]));
                while (sc.hasNextLine()) {
                    String rawInstruciton = sc.nextLine();
                    //while(rawInstruciton == null){
                    //    rawInstruciton = sc.nextLine();
                    //}
                    String[] subInst = rawInstruciton.split("//", 2);
                    String code_no_comment = subInst[0].trim();
                    if (code_no_comment.isEmpty()) {
                        continue;
                    }
                    instructionList.add(code_no_comment.trim()); // String.trim() removes all leading and trailing
                    // whitespaces
                }
                // Close file
                sc.close();
            } catch (FileNotFoundException e) {
                System.err.println("File not found.");
            }
            // Convert to array
            String[] instructions = instructionList.toArray(new String[0]);
            // First pass
            doFirstPass(instructions, symbolTable);
            //symbolTable.printSymbol();
            // Second pass
            String code = doSecondPass(instructions, symbolTable);
            //symbolTable.printSymbol();
            // Print output
            System.out.println(code);

        }

    }

}
#include <string>

#include "VMTranslator.h"

using namespace std;

/**
 * VMTranslator constructor
 */
int VMTranslator::call_counter = 0;
int VMTranslator::pop_counter = 0;
int VMTranslator::eq_counter = 0;
int VMTranslator::gt_counter = 0;
int VMTranslator::lt_counter = 0;
int VMTranslator::return_counter = 0;
VMTranslator::VMTranslator() {
    // Your code here
}

/**
 * VMTranslator destructor
 */
VMTranslator::~VMTranslator() {
    // Your code here
}

/** Generate Hack Assembly code for a VM push operation */
string VMTranslator::vm_push(string segment, int offset){
    string symbol;
    string same_part = "@SP\nAM=M+1\nA=A-1\nM=D";
    string assembler_code;
    if(segment == "constant"){
        symbol = to_string(offset);
        assembler_code = "@" + symbol + "\nD=A\n" + same_part;
    }else if(segment == "static" || segment == "temp" || segment == "pointer"){
        if(segment == "static"){
            symbol = to_string(offset + 16);
        }else if(segment == "temp"){
            symbol = to_string(offset + 5);
        }else if(segment == "pointer"){
            if(offset == 0){
                symbol = "THIS";
            }else{
                symbol = "THAT";
            }
        }
        assembler_code = "@" + symbol + "\nD=M\n" + same_part;
    }else{
        if(segment == "local"){
            symbol = "LCL";
        }else if(segment == "argument"){
            symbol = "ARG";
        }else if(segment == "this"){
            symbol = "THIS";
        }else if(segment == "that"){
            symbol = "THAT";
        }
        if(offset >= 2){
            string front = "@" + to_string(offset) + "\nD=A";
            assembler_code = front + "\n@" + symbol + "\nA=M+D\nD=M\n" + same_part;
        }else if(offset == 1){
            assembler_code = "@" + symbol + "\nA=M+1\nD=M\n" + same_part;
        }else{
            assembler_code = "@" + symbol + "\nA=M\nD=M\n" + same_part;
        }
    }
    return assembler_code;
}

/** Generate Hack Assembly code for a VM pop operation */
string VMTranslator::vm_pop(string segment, int offset){

    string symbol = "";
    string same_part = "@SP\nAM=M-1\nD=M";
    string assembler_code;
    if(segment == "static" || segment == "temp" || segment == "pointer"){
        if(segment == "static"){
            symbol = to_string(offset + 16);
        }else if(segment == "temp"){
            symbol = to_string(offset + 5);
        }else if(segment == "pointer") {
            if (offset == 0) {
                symbol = "THIS";
            } else {
                symbol = "THAT";
            }
        }
        assembler_code = same_part +"\n" + "@" + symbol + "\nM=D";
    }else{
        if(segment == "local"){
            symbol = "LCL";
        }else if(segment == "argument"){
            symbol = "ARG";
        }else if(segment == "this"){
            symbol = "THIS";
        }else if(segment == "that"){
            symbol = "THAT";
        }
        if(offset >= 2){
            string front = "@" + to_string(offset) + "\nD=A\n@" + symbol + "\nD=M+D\n@temp_pop" + to_string(pop_counter) + "\nM=D";
            assembler_code = front + "\n" + same_part + "\n@temp_pop" + to_string(pop_counter) + "\nA=M\nM=D";
        }else if(offset == 1){
            assembler_code = same_part + "\n" + "@" + symbol + "\nA=M+1\nM=D";
        }else{
            assembler_code = same_part + "\n" + "@" + symbol + "\nA=M\nM=D";
        }
    }
    pop_counter++;
    return assembler_code;
}

/** Generate Hack Assembly code for a VM add operation */
string VMTranslator::vm_add(){
    string assembler_code = "@SP\nAM=M-1\nD=M\nA=A-1\nM=D+M";
    return assembler_code;
}

/** Generate Hack Assembly code for a VM sub operation */
string VMTranslator::vm_sub(){
    string assembler_code = "@SP\nAM=M-1\nD=M\nA=A-1\nM=M-D";
    return assembler_code;
}

/** Generate Hack Assembly code for a VM neg operation */
string VMTranslator::vm_neg(){
    string assembler_code = "@SP\nA=M-1\nM=-M";
    return assembler_code;
}

/** Generate Hack Assembly code for a VM eq operation */
string VMTranslator::vm_eq(){
    string assembler_code = "@SP\nAM=M-1\nD=M\nA=A-1\nD=D-M\n@TRUE_EQ" + to_string(eq_counter) + "\nD;JEQ\nD=0\n@FALSE_EQ" +
            to_string(eq_counter) + "\n0;JMP\n(TRUE_EQ"+ to_string(eq_counter) + ")\nD=-1\n(FALSE_EQ"+ to_string(eq_counter) + ")\n@SP\nA=M-1\nM=D";
    eq_counter++;
    return assembler_code;
}

/** Generate Hack Assembly code for a VM gt operation */
string VMTranslator::vm_gt(){
    string assembler_code = "@SP\nAM=M-1\nD=M\nA=A-1\nD=M-D\n@TRUE_GT" + to_string(gt_counter) + "\nD;JGT\nD=0\n@FALSE_GT" + to_string(gt_counter) + "\n0;JMP\n(TRUE_GT" + to_string(gt_counter) + ")\nD=-1\n(FALSE_GT" + to_string(gt_counter) + ")\n@SP\nA=M-1\nM=D";
    gt_counter++;
    return assembler_code;
}

/** Generate Hack Assembly code for a VM lt operation */
string VMTranslator::vm_lt(){
    string assembler_code = "@SP\nAM=M-1\nD=M\nA=A-1\nD=D-M\n@TRUE_LT" + to_string(lt_counter) + "\nD;JGT\nD=0\n@FALSE_LT" + to_string(lt_counter) + "\n0;JMP\n(TRUE_LT" + to_string(lt_counter) + ")\nD=-1\n(FALSE_LT" + to_string(lt_counter) + ")\n@SP\nA=M-1\nM=D";
    lt_counter++;
    return assembler_code;
}

/** Generate Hack Assembly code for a VM and operation */
string VMTranslator::vm_and(){
    string assembler_code = "@SP\nAM=M-1\nD=M\nA=A-1\nM=D&M";
    return assembler_code;
}

/** Generate Hack Assembly code for a VM or operation */
string VMTranslator::vm_or(){
    string assembler_code = "@SP\nAM=M-1\nD=M\nA=A-1\nM=D|M";
    return assembler_code;
}

/** Generate Hack Assembly code for a VM not operation */
string VMTranslator::vm_not(){
    string assembler_code = "@SP\nA=M-1\nM=!M";
    return assembler_code;
}

/** Generate Hack Assembly code for a VM label operation */
string VMTranslator::vm_label(string label){
    //transform(label.begin(), label.end(), label.begin(), ::toupper);
    string assembler_code = "(" + label + ")";
    return assembler_code;
}

/** Generate Hack Assembly code for a VM goto operation */
string VMTranslator::vm_goto(string label){
    //transform(label.begin(), label.end(), label.begin(), ::toupper);
    return "@"+label+"\n"+"0;JMP";
}

/** Generate Hack Assembly code for a VM if-goto operation */
string VMTranslator::vm_if(string label){
    //transform(label.begin(), label.end(), label.begin(), ::toupper);
    string assembler_code = "@SP\nAM=M-1\nD=M\n@" + label + "\nD;JNE";
    return assembler_code;//SOMETHING WRONG!!!
}

/** Generate Hack Assembly code for a VM function operation */
string VMTranslator::vm_function(string function_name, int n_vars){
    string assembler_code;
    for(int i = 0; i < n_vars; i++){
        assembler_code += ("\n" + vm_push("constant",0));
    }
    return vm_label(function_name) + assembler_code;//????????
}

/** Generate Hack Assembly code for a VM call operation */
string VMTranslator::vm_call(string function_name, int n_args){
    //transform(function_name.begin(), function_name.end(), function_name.begin(), ::toupper);
    string assembler_code;
    assembler_code += "@RETURN_ADDRESS_CALL"+ to_string(call_counter)+"\nD=A\n@SP\nAM=M+1\nA=A-1\nM=D\n";
    assembler_code += "@LCL\nD=M\n@SP\nAM=M+1\nA=A-1\nM=D\n";
    assembler_code += "@ARG\nD=M\n@SP\nAM=M+1\nA=A-1\nM=D\n";
    assembler_code += "@THIS\nD=M\n@SP\nAM=M+1\nA=A-1\nM=D\n";
    assembler_code += "@THAT\nD=M\n@SP\nAM=M+1\nA=A-1\nM=D\n";
    assembler_code += "@5\nD=A\n@SP\nD=M-D\n@" + to_string(n_args) + "\nD=D-A\n@ARG\nM=D\n";
    assembler_code += "@SP\nD=M\n@LCL\nM=D\n";
    assembler_code += "@"+function_name+"\n0;JMP\n";
    assembler_code += "(RETURN_ADDRESS_CALL" + to_string(call_counter) + ")";
    call_counter++;
    return assembler_code;//??????????
}

/** Generate Hack Assembly code for a VM return operation */
string VMTranslator::vm_return(){
    string assembler_code;
    assembler_code += "@LCL\nD=M\n@frame_return"+to_string(return_counter)+"\nM=D\n@5\nA=D-A\nD=M\n@retAddr_return"+to_string(return_counter)+"\nM=D\n";
    assembler_code += vm_pop("argument",0)+"\n";
    assembler_code += "@ARG\nD=M+1\n@SP\nM=D\n";
    assembler_code += "@frame_return"+to_string(return_counter)+"\nA=M-1\nD=M\n@THAT\nM=D\n";
    assembler_code += "@2\nD=A\n@frame_return"+to_string(return_counter)+"\nA=M-D\nD=M\n@THIS\nM=D\n";
    assembler_code += "@3\nD=A\n@frame_return"+to_string(return_counter)+"\nA=M-D\nD=M\n@ARG\nM=D\n";
    assembler_code += "@4\nD=A\n@frame_return"+to_string(return_counter)+"\nA=M-D\nD=M\n@LCL\nM=D\n";
    assembler_code += "@retAddr_return"+to_string(return_counter)+"\nA=M;JMP";//???????
    return_counter++;
    return assembler_code;
}
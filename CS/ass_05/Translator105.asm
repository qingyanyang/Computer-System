//C instructions test
//normal dest+comp+jump
@SP
A=D-A;JGT
D=M
@R2
A=M;JGE
@ARG
M=D;JLT
@SP
D=A;JEQ
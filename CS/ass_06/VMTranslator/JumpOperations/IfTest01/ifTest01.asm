@LCL
A=M+1
D=M
@SP
AM=M+1
A=A-1
M=D
@SP
AM=M-1
D=M
@NEXT
D;JNE
@LCL
A=M+1
D=M
@SP
AM=M+1
A=A-1
M=D
@END
0;JMP
(NEXT)
@LCL
A=M
D=M
@SP
AM=M+1
A=A-1
M=D
(END)
@SP
AM=M-1
D=M
@16
M=D

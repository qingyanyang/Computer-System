@5
D=A
@SP
AM=M+1
A=A-1
M=D
@5
D=A
@SP
AM=M+1
A=A-1
M=D
@SP
AM=M-1
D=M
A=A-1
D=D-M
@TRUE0
D;JEQ
D=0
@FALSE0
0;JMP
(TRUE0)
D=-1
(FALSE0)
@SP
A=M-1
M=D
@SP
AM=M-1
D=M
@16
M=D
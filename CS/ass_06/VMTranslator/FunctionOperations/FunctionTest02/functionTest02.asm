@17
D=M
@SP
AM=M+1
A=A-1
M=D
@RETURN_ADDRESS_CALL0
D=A
@SP
AM=M+1
A=A-1
M=D
@LCL
D=M
@SP
AM=M+1
A=A-1
M=D
@ARG
D=M
@SP
AM=M+1
A=A-1
M=D
@THIS
D=M
@SP
AM=M+1
A=A-1
M=D
@THAT
D=M
@SP
AM=M+1
A=A-1
M=D
@5
D=A
@SP
D=M-D
@1
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@FUNCTIONTEST02.FIB
0;JMP
(RETURN_ADDRESS_CALL0)
@SP
AM=M-1
D=M
@16
M=D
(END)
@END
0;JMP
(FUNCTIONTEST02.FIB)
@ARG
A=M
D=M
@SP
AM=M+1
A=A-1
M=D
@2
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
@TRUE_LT0
D;JGT
D=0
@FALSE_LT0
0;JMP
(TRUE_LT0)
D=-1
(FALSE_LT0)
@SP
A=M-1
M=D
@NEXT_IF0
D;JEQ
@STOP
0;JMP
(NEXT_IF0)
@ARG
A=M
D=M
@SP
AM=M+1
A=A-1
M=D
@1
D=A
@SP
AM=M+1
A=A-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@RETURN_ADDRESS_CALL1
D=A
@SP
AM=M+1
A=A-1
M=D
@LCL
D=M
@SP
AM=M+1
A=A-1
M=D
@ARG
D=M
@SP
AM=M+1
A=A-1
M=D
@THIS
D=M
@SP
AM=M+1
A=A-1
M=D
@THAT
D=M
@SP
AM=M+1
A=A-1
M=D
@5
D=A
@SP
D=M-D
@1
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@FUNCTIONTEST02.FIB
0;JMP
(RETURN_ADDRESS_CALL1)
@ARG
A=M
D=M
@SP
AM=M+1
A=A-1
M=D
@2
D=A
@SP
AM=M+1
A=A-1
M=D
@SP
AM=M-1
D=M
A=A-1
M=M-D
@RETURN_ADDRESS_CALL2
D=A
@SP
AM=M+1
A=A-1
M=D
@LCL
D=M
@SP
AM=M+1
A=A-1
M=D
@ARG
D=M
@SP
AM=M+1
A=A-1
M=D
@THIS
D=M
@SP
AM=M+1
A=A-1
M=D
@THAT
D=M
@SP
AM=M+1
A=A-1
M=D
@5
D=A
@SP
D=M-D
@1
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@FUNCTIONTEST02.FIB
0;JMP
(RETURN_ADDRESS_CALL2)
@SP
AM=M-1
D=M
A=A-1
M=D+M
@LCL
D=M
@frame_return0
M=D
@5
A=D-A
D=M
@retAddr_return0
M=D
@SP
AM=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M+1
@SP
M=D
@frame_return0
A=M-1
D=M
@THAT
M=D
@2
D=A
@frame_return0
A=M-D
D=M
@THIS
M=D
@3
D=A
@frame_return0
A=M-D
D=M
@ARG
M=D
@4
D=A
@frame_return0
A=M-D
D=M
@LCL
M=D
@retAddr_return0
A=M;JMP
(STOP)
@ARG
A=M
D=M
@SP
AM=M+1
A=A-1
M=D
@LCL
D=M
@frame_return1
M=D
@5
A=D-A
D=M
@retAddr_return1
M=D
@SP
AM=M-1
D=M
@ARG
A=M
M=D
@ARG
D=M+1
@SP
M=D
@frame_return1
A=M-1
D=M
@THAT
M=D
@2
D=A
@frame_return1
A=M-D
D=M
@THIS
M=D
@3
D=A
@frame_return1
A=M-D
D=M
@ARG
M=D
@4
D=A
@frame_return1
A=M-D
D=M
@LCL
M=D
@retAddr_return1
A=M;JMP
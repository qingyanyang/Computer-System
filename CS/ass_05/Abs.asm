// Calculates the absolute value of R1 and stores the result in R0.
// (R0, R1 refer to RAM[0], and RAM[1], respectively.)

// Put your code here.
//get a
@R1
D=M
//if a>=0 ram[R0]=a
@IF_TRUE
D;JGE
//else ram[R0]=-a
@R0
M=-D
@END
0;JMP
(IF_TRUE)
@R0
M=D
(END)
@END
0;JMP







// This file is based on part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: Mult.asm

// Multiplies R1 and R2 and stores the result in R0.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)

// Put your code here.
//abs(R1) as times for addition
@R1
D=M
//if a>=0 TEMP=a
@IF_TRUE
D;JGE
//else TEMP=-a
@temp
M=-D
@NEXT
0;JMP
(IF_TRUE)
@temp
M=D
//while(R1==0) jump out of loop
//otherwise sum = sum + R2
(NEXT)
@sum
M=0
(LOOP)
@temp
D=M
@NEXT2
D;JEQ
@R2
D=M
@sum
M=M+D
@temp
M=M-1
@LOOP
0;JMP
//if R1>=0, then sum is unchanged, else sum = -sum
(NEXT2)
@R1
D=M
@TRUE
D;JGE
@sum
D=M
@R0
M=-D
@END
0;JMP
(TRUE)
@sum
D=M
@R0
M=D
(END)
0;JMP
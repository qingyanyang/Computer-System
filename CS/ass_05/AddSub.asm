// Calculates R1 - R2 + R3 and stores the result in R0.
// (R0, R1, R2, R3 refer to RAM[0], RAM[1], RAM[2], and RAM[3], respectively.)

// Put your code here.
//get a
@R1
D=M
//get b
//get a-b into D register
@R2
D=D-M
//get c
//add c
@R3
D=D+M
//put result into RAM[R0]
@R0
M=D
(END)
@END
0;JMP

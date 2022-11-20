// Finds the largest element in the array of length R2 whose first element is at RAM[R1] and stores the result in R0.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)

// Put your code here.
//get address and the value of arr[0]
//put the first value to max
@R1
D=M
@comparedaddress
AM=D
D=M
@max
M=D
//while(len>0)
//if max < 0 && arr[comparedaddress] > 0
//max = arr[comparedaddress]
//if max > 0 && arr[comparedaddress] < 0
//max = max
//else
//if max - arr[comparedaddress] < 0
//max = arr[comparedaddress]
//comparedaddress++
//len--
@R2
D=M
@time
M=D-1
(LOOP)
@time
D=M
@NEXT
D;JEQ
@comparedaddress
AM=M+1
D=M
@MAX
D;JGT
@max
D=M
@TRUE
D;JGT
@JUDGE
0;JMP
(MAX)
@max
D=M
@SUC
D;JLT
(JUDGE)
@comparedaddress
A=M
D=M
@max
D=M-D
@TRUE
D;JGT
(SUC)
@comparedaddress
A=M
D=M
@max
M=D
(TRUE)
@time
M=M-1
@LOOP
0;JMP
//put max to ram[RO]
(NEXT)
@max
D=M
@R0
M=D
(END)
@END
0;JMP
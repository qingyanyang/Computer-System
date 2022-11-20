// Sorts the array of length R2 whose first element is at RAM[R1] in descending order in place. Sets R0 to True (-1) when complete.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)

// Put your code here.
//get the first arr address
@R1
D=M
@tempaddress
M=D
//get the length of arr
@R2
D=M
@i
M=D-1
//outside loop
(LOOP1)
@i
D=M
@FINAL//if i = 0, jump to the end
D;JEQ
@tempaddress
D=M
@maxaddress
M=D
@tempaddress2
M=D+1
@i
D=M
@j
M=D
//inside loop
//while(j>0)
//if RAM[maxAddress] < 0 && arr[tempAddress] > 0
//maxAddress = tempAddress
//if RAM[maxAddress] > 0 && arr[tempAddress] < 0
//maxAddress stay unchanged
//else
//if RAM[maxAddress] - arr[tempAddress] < 0
//maxAddress = tempAddress
(LOOP2)
@j
D=M
@NEXT
D;JEQ
@tempaddress2
A=M
D=M
@MAX
D;JGT
@maxaddress
A=M
D=M
@TRUE
D;JGT
@JUDGE
0;JMP
(MAX)
@maxaddress
A=M
D=M
@SWAP
D;JLT
(JUDGE)
@tempaddress2
A=M
D=M
@maxaddress
A=M
D=M-D
@TRUE
D;JGE
//max address changes
(SWAP)
@tempaddress2
D=M
@maxaddress
M=D
(TRUE)
@tempaddress2
M=M+1
@j
M=M-1
@LOOP2
0;JMP
//swap max address and temp arr address
(NEXT)
@maxaddress
A=M
D=M
@temp
M=D
@tempaddress
A=M
D=M
@maxaddress
A=M
M=D
@temp
D=M
@tempaddress
A=M
M=D
@tempaddress
M=M+1
@i
M=M-1
@LOOP1
0;JMP
//put value into ram[RO]
(FINAL)
@R0
M=-1
(END)
@END
0;JMP

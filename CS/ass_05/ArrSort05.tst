// Sample Test file for ArrSort.asm
// Follows the Test Scripting Language format described in 
// Appendix B of the book "The Elements of Computing Systems"

load ArrSort.asm,
output-file ArrSort05.out,
compare-to ArrSort05.cmp,
output-list RAM[0]%D2.6.2 RAM[1]%D2.6.2 RAM[2]%D2.6.2 RAM[2048]%D2.6.2 RAM[2049]%D2.6.2 RAM[2050]%D2.6.2 RAM[2051]%D2.6.2
RAM[2052]%D2.6.2 RAM[2053]%D2.6.2 RAM[2054]%D2.6.2 RAM[2055]%D2.6.2;

set PC 0,
set RAM[0]    0,  // Set R0
set RAM[1] 2048,  // Set R1
set RAM[2]    8,  // Set R2
set RAM[2048] -3,  // Set Arr[0]
set RAM[2049] -5,  // Set Arr[1]
set RAM[2050] 3,  // Set Arr[2]
set RAM[2051] 6,  // Set Arr[3]
set RAM[2052] 4,  // Set Arr[4]
set RAM[2053] -8,  // Set Arr[5]
set RAM[2054] -2,  // Set Arr[6]
set RAM[2055] -4;  // Set Arr[7]
repeat 1500 {
  ticktock;       // Run for 600 clock cycles
}
set RAM[1] 2048,  // Restore arguments in case program used them
set RAM[2] 8,
output;           // Output to file


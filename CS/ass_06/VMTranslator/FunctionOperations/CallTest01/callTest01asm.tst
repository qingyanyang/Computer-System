// Sample Test file for vm_callTest01.asm
// Follows the Test Scripting Language format described in 
// Appendix B of the book "The Elements of Computing Systems"

load callTest01.asm,
output-file callTest01.out,
compare-to callTest01.cmp,
output-list RAM[0]%D1.6.1 RAM[1]%D1.6.1 RAM[2]%D1.6.1 RAM[3]%D1.6.1 RAM[4]%D1.6.1 RAM[16]%D1.6.1 RAM[17]%D1.6.1 RAM[300]%D1.6.1 RAM[301]%D1.6.1 RAM[302]%D1.6.1 RAM[400]%D1.6.1 RAM[401]%D1.6.1 RAM[402]%D1.6.1;

set PC 0,
set RAM[0] 256,  // Set sp
set RAM[1] 300;  // Set local
set RAM[2] 400,  // Set argument
set RAM[3] 3000,  // Set this
set RAM[4] 3010,  // Set that
set RAM[16] 3,  // static 0
set RAM[17] 2,  // static 1
set RAM[18] 1,  // static 2
set RAM[300] 10,  // local 0
set RAM[301] 20,  // local 1
set RAM[302] 30,  // local 2
set RAM[400] 100,  // argument 0
set RAM[401] 200,  // argument 1
set RAM[402] 300;  // argument 2
repeat 300 {
  ticktock;    // Run for 300 clock cycles
}
output;        // Output to file


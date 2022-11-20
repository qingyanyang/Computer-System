// Sample Test file for vm_pushTest01.asm
// Follows the Test Scripting Language format described in 
// Appendix B of the book "The Elements of Computing Systems"

load pushTest01.asm,
output-file pushTest01.out,
compare-to pushTest01.cmp,
output-list RAM[256]%D1.6.1 RAM[257]%D1.6.1 RAM[258]%D1.6.1
RAM[259]%D1.6.1;

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
repeat 100 {
  ticktock;    // Run for 100 clock cycles
}
output;        // Output to file

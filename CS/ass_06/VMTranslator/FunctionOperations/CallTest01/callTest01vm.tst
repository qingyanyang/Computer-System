// Sample Test file for vm_callTest01.vm
// Follows the Test Scripting Language format described in 
// Appendix B of the book "The Elements of Computing Systems"

load callTest01.vm,
output-file callTest01.cmp,
output-list RAM[0]%D1.6.1 RAM[1]%D1.6.1 RAM[2]%D1.6.1 RAM[3]%D1.6.1 RAM[4]%D1.6.1 RAM[16]%D1.6.1 RAM[17]%D1.6.1 RAM[300]%D1.6.1 RAM[301]%D1.6.1 RAM[302]%D1.6.1 RAM[400]%D1.6.1 RAM[401]%D1.6.1 RAM[402]%D1.6.1;
            

set sp 256,        // stack pointer
set local 300,     // base address of the local segment
set argument 400,  // base address of the argument segment
set this 3000,     // base address of the this segment
set that 3010,     // base address of the that segment

set RAM[16] 3,  // static 0
set RAM[17] 2,  // static 1
set RAM[18] 1,  // static 2

set local[0] 10,  // local 0
set local[1] 20,  // local 1
set local[2] 30,  // local 2

set argument[0] 100,  // argument 0
set argument[1] 200,  // argument 1
set argument[2] 300;  // argument 2

repeat 50 {        // Change this number to cover the number of instructions in the VM test file
  vmstep;
}
output;

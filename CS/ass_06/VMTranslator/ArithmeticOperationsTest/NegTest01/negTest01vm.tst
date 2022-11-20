// Sample Test file for vm_negTest01.vm
// Follows the Test Scripting Language format described in 
// Appendix B of the book "The Elements of Computing Systems"

load negTest01.vm,
output-file negTest01.cmp,
output-list RAM[16]%D1.6.1;
            

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

repeat 3 {        // Change this number to cover the number of instructions in the VM test file
  vmstep;
}
output;

# MiniRV-SpinalHDL

Study repository with an implementation of a RISC-V processor subset, built using the **SpinalHDL** hardware description language.

## Instruction Set

The adopted instruction subset and datapath designs can be found in **Chapter 4** of [[1]](#1).

We consider a 64-bit architecture with the following instructions:
- **ld**, **sd** (load/store doubleword)
- **add**, **sub**, **and**, **or** (arithmetic-logical instructions)
- **beq** (conditional branch)

## SpinalHDL

The [SpinalHDL template](https://github.com/SpinalHDL/SpinalTemplateSbt) was used to bootstrap this repository.

```sh
// To generate Verilog code from SpinalHDL
sbt "runMain hw.MiniRVVerilog"

// To generate VHDL code from SpinalHDL
sbt "runMain hw.MiniRVVhdl"

// To run the testbench
sbt "runMain hw.MiniRVSim"
```

## References

<a id="1">[1]</a> Patterson, D. and Hennessy, J. Computer Organization and Design RISC-V edition: The Hardware/Software Interface. Elsevier, 2018.


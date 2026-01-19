# MiniRV-SpinalHDL

Study repository with an implementation of a RISC-V processor subset, built using the **SpinalHDL** hardware description language.

The adopted instruction subset and datapath designs can be found in **Chapter 4** of *Computer Organization and Design (RISC-V Edition)* by Patterson & Hennessy [[1]](#1).

The [SpinalHDL template](https://github.com/SpinalHDL/SpinalTemplateSbt) was used to bootstrap this repository.

```sh
// To generate Verilog code from SpinalHDL
sbt "runMain MiniRV.MiniRVVerilog"

// To generate VHDL code from SpinalHDL
sbt "runMain MiniRV.MiniRVVhdl"

// To run the testbench
sbt "runMain MiniRVSim"
```

## References

<a id="1">[1]</a> Patterson, D. and Hennessy, J. (2014) Computer Organization and Design RISC-V edition: The Hardware/Software Interface. Elsevier, 2018.


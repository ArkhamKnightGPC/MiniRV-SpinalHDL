package hw

import spinal.core._
import spinal.lib._

import scala.language.postfixOps

class MiniRV() extends Component {
  val io = new Bundle {
    val instructionMemoryBus: InstructionMemoryIO = master(InstructionMemoryIO())
    val registerFileBus: RegisterFileIO = master(RegisterFileIO())
  }

  //STAGE 1: Instruction Fetch
  val pc: UInt = Reg(UInt(32 bits)) init(0)
  io.instructionMemoryBus.address := pc
  val currentInstruction: UInt = io.instructionMemoryBus.instruction
  pc := pc + 4

  //STAGE 2: Instruction Decode
  val opcode: UInt = currentInstruction(6 downto 0)
  val Rtype: Bool = True
  io.registerFileBus.readReg1 := currentInstruction(19 downto 15)
  io.registerFileBus.readReg2 := currentInstruction(24 downto 20)
  io.registerFileBus.writeReg := currentInstruction(11 downto 7)
  io.registerFileBus.regWrite := Rtype
  io.registerFileBus.writeData := U(0, 64 bits)

  //STAGE 3: Execute

  //STAGE 4: Memory

  //STAGE 5: Write-back
}

// Generate Verilog
object MiniRVVerilog extends App {
  Config.spinal.generateVerilog(new MiniRV())
}

// Generate VHDL
object MiniRVVhdl extends App {
  Config.spinal.generateVhdl(new MiniRV())
}
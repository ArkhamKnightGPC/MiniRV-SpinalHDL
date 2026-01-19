package hw

import spinal.core._
import spinal.lib._

import scala.language.postfixOps

case class InstructionMemoryIO() extends Bundle with IMasterSlave {
  val address: UInt = UInt(32 bits)
  val instruction: UInt = UInt(32 bits)

  override def asMaster(): Unit = {
    out(address)
    in(instruction)
  }
}

class InstructionMemory extends Component {
  val io = new Bundle{
    val bus: InstructionMemoryIO = slave(InstructionMemoryIO())
  }

  private val mem = Mem(UInt(32 bits), wordCount = 1024)
  io.bus.instruction := mem.readAsync(
    address = io.bus.address
  )
}
package hw

import spinal.core._
import spinal.lib._

import scala.language.postfixOps

case class RegisterFileIO() extends Bundle with IMasterSlave {
  val readReg1: UInt = UInt (5 bits)
  val readReg2: UInt = UInt (5 bits)
  val writeReg: UInt = UInt (5 bits)
  val writeData: UInt = UInt (64 bits)
  val regWrite: Bool = Bool()
  val readData1: UInt = UInt (64 bits)
  val readData2: UInt = UInt (64 bits)

  override def asMaster(): Unit = {
    out(readReg1, readReg2, writeReg, writeData, regWrite)
    in(readData1, readData2)
  }
}

class RegisterFile extends Component {
  val io = new Bundle {
    val bus: RegisterFileIO = slave(RegisterFileIO())
  }

  //Register 0 is hardwired zero!
  private val registerFile = Mem(UInt(64 bits), wordCount = 32)

  io.bus.readData1 := (io.bus.readReg1 === 0) ? U(0, 64 bits) | registerFile.readAsync(
    address = io.bus.readReg1
  )
  io.bus.readData2 := (io.bus.readReg2 === 0) ? U(0, 64 bits) | registerFile.readAsync(
    address = io.bus.readReg2
  )

  registerFile.write(
    enable = io.bus.regWrite,
    address = io.bus.writeReg,
    data = io.bus.writeData
  )
}

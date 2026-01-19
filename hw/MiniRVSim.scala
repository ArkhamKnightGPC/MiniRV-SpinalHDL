package hw

import spinal.core._
import spinal.core.sim._

object MiniRVSim extends App {
  Config.sim.compile(new MiniRV()).doSim { dut =>
    // Fork a process to generate the reset and the clock on the dut
    dut.clockDomain.forkStimulus(period = 10)

  }
}

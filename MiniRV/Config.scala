package MiniRV

import spinal.core._
import spinal.core.sim._

object Config {
  def spinal = SpinalConfig(
    targetDirectory = "gen/",
    defaultConfigForClockDomains = ClockDomainConfig(
      resetActiveLevel = HIGH
    ),
    onlyStdLogicVectorAtTopLevelIo = false
  )

  def sim = SimConfig.withConfig(spinal).withFstWave
}

lazy val root = (project in file("."))
  .settings(
    name := "hw",
    Compile / scalaSource := baseDirectory.value,

    libraryDependencies ++= Seq(
      "com.github.spinalhdl" %% "spinalhdl-core" % "1.10.2",
      "com.github.spinalhdl" %% "spinalhdl-lib"  % "1.10.2",
      compilerPlugin("com.github.spinalhdl" %% "spinalhdl-idsl-plugin" % "1.10.2")
    )
  )

fork := true
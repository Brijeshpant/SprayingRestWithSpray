name := "SprayingRestWithSpray"

version := "1.0"

libraryDependencies ++= {
    val akkaV = "2.3.6"
    val sprayV = "1.3.2"
    Seq(
        "io.spray"            %%   "spray-can"     % sprayV,
        "io.spray"            %%   "spray-routing" % sprayV,
        "com.typesafe.akka"   %%  "akka-actor"    % akkaV
    )
}

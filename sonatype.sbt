// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "in.norbor"

// To sync with Maven central, you need to supply the following information:
publishMavenStyle := true

// License of your choice
licenses := Seq("MIT" -> url("https://raw.githubusercontent.com/nuboat/yoda-ommon/master/LICENSE"))
homepage := Some(url("https://github.com/nuboat/yoda-ommon"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/nuboat/yoda-common"),
    "scm:git@github.com:nuboat/yoda-ommon.git"
  )
)
developers := List(
  Developer(id = "nuboat"
    , name = "Peerapat Asoktummarungsri"
    , email = "nuboat@gmail.com"
    , url = url("https://github.com/nuboat"))
)

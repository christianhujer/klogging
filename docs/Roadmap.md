# Klogging Roadmap

In no particular order at this stage.

## Goals

- Nanosecond precision in logging timestamps
- Ease of use in API for developers
- Close but not too close in API to popular logging APIs

## Within the library

- Support platforms other than JVM.
- Extensive performance testing of event creation and dispatching.
- More string rendering options, e.g. with colouring of logger level.
- More built-in dispatching and rendering options, e.g. Logstash, syslog.
- Configuration from YAML and/or JSON files.
- [Message template](https://messagetemplates.org) processing for sinks other
  than Seq.

## Additions to the library

- Create a [Ktor](https://ktor.io/) plugin with options for automatically
  capturing and logging request and other context information.
- Create an [SLF4J](http://www.slf4j.org/) provider for Klogging.
- A repository of examples in Kotlin and Java
- A complete documentation and support website, using ideas from
  [The Documentation System](https://documentation.divio.com/).

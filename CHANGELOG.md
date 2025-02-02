# Klogging changes

## Version 0.5.7

- Workaround for issue `NoClassDefFoundError` thrown when using Spring Boot Starter
  (see [issue 188](https://github.com/klogging/klogging/issues/188))
- Send Splunk-formatted messages to any sink (not just an HEC endpoint)
- Support Hexagon microservices toolkit 3.4.3, requiring JDK 17
- Use Kotlin 1.9.20
- Build with Gradle 8.4

## Version 0.5.6

- Include sources in SLF4J provider and Hexagon logging adapter

## Version 0.5.5

- Logging adapter for [Hexagon microservices toolkit](https://hexagonkt.com/)

## Version 0.5.4

- Use Gradle `api()` for `kotlinx-coroutines` so it is available transitively to consuming applications

## Version 0.5.3

- Seq server configuration accepts `apiKey` and works with HTTPS endpoints
- Fixed direct sending to not use any coroutines
- Specify config file path in DSL

## Version 0.5.2

- `ItemExtractor` functions that can add items to any log events
- [#149](https://github.com/klogging/klogging/issues/149) SLF4J provider uses `ItemExtractor` function to include MDC
  items in all log events, including those from non-SLF4J loggers

## Version 0.5.1

- Send internal logger INFO messages after configuration is set

## Version 0.5.0

A number of bug fixes and improvements.

- [Console renderer with colouring of level strings](https://klogging.io/docs/configuration/built-ins#render_ansi)
- [Base context items](https://klogging.io/docs/configuration/context-items#base-context)
- [Mapping from other coroutine contexts, e.g. Project Reactor](https://klogging.io/docs/configuration/context-items#from-other-coroutine-context-elements)
- [Configuration from HOCON files](https://klogging.io/docs/configuration/hocon)
- [Direct, synchronous logging as well as asynchronous via coroutines](https://klogging.io/docs/concepts/direct-logging)
- [Stop on match for logger names in configuration](https://klogging.io/docs/configuration/dsl#short-circuit-matching-with-stoponmatch)
- [One-line renderer with ISO8601 timestamps](https://klogging.io/docs/configuration/built-ins#render_iso8601)
- [Env var for setting built-in renderer for a sink](https://klogging.io/docs/internals/environment-variables)
- [`toMaxLevel` function for defining loggers](https://klogging.io/docs/configuration/dsl#fromminlevel-tomaxlevel-atlevel-and-inlevelrange)


## Version 0.4.0

- New architecture with multiple coroutine channels for handling log events.
- Batching events to send to sink destinations.
- Configure with `sendTo` instead of `dispatchTo`.
- Sink for sending log events to Splunk servers.
- More comprehensive diagnostics using internal logger.
- Coloured, column-aligned output in console renderer.

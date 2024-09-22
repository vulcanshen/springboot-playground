```mermaid
flowchart TD
    ServletWebServerInitializedEvent --> ContextRefreshedEvent
    ContextRefreshedEvent --> ApplicationStartedEvent
    ApplicationStartedEvent --> AvailabilityChangeEvent_1
    AvailabilityChangeEvent_1 --> ApplicationReadyEvent
    ApplicationReadyEvent --> AvailabilityChangeEvent_2
```

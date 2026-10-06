package com.brandon.log_search.event;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record LogEvent(
        UUID id,
        Instant timestamp,
        String source,
        Severity severity,
        String message) {
    public LogEvent {
        Objects.requireNonNull(id, "id must not be null");
        Objects.requireNonNull(timestamp, "timestamp must not be null");
        Objects.requireNonNull(source, "source must not be null");
        Objects.requireNonNull(severity, "severity must not be null");
        Objects.requireNonNull(message, "message must not be null");

        if (source.isBlank()) {
            throw new IllegalArgumentException("source must not be blank");
        }

        if (message.isBlank()) {
            throw new IllegalArgumentException("message must not be blank");
        }
    }

    public static LogEvent create(Instant timestamp, String source,
                                  Severity severity, String message) {
        return new LogEvent(UUID.randomUUID(), timestamp, source, severity, message);
    }
}

package com.brandon.log_search.service;

import com.brandon.log_search.event.LogEvent;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LogEventService {
    private final ConcurrentHashMap<UUID, LogEvent> store;

    public LogEventService() {
        this.store = new ConcurrentHashMap<>();
    }

    public LogEvent save(LogEvent logEvent) {
        store.put(logEvent.id(), logEvent);
        return logEvent;
    }

    public Optional<LogEvent> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<LogEvent> findAll() {
        List<LogEvent> sorted = new ArrayList<>(store.values());
        sorted.sort(Comparator.comparing(LogEvent::timestamp).reversed());
        return List.copyOf(sorted);
    }
}

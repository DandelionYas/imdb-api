package com.imdb.api.services;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class AdminService {
    private final AtomicLong counter = new AtomicLong();

    /**
     * Uses AtomicLong to ensure mutual exclusion without the overhead of synchronization and locks
     * @return the current count of http requests since the last startup
     */
    public Long getRequestCount() {
        return counter.incrementAndGet();
    }
}

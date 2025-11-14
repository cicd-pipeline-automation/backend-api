package com.example.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HealthController {

    private final Instant startTime = Instant.now();

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name:backend-api}")
    private String appName;

    @GetMapping("/health")
    public Map<String, Object> health() {

        Map<String, Object> status = new LinkedHashMap<>();

        status.put("status", "UP");
        status.put("service", appName);
        status.put("port", serverPort);
        status.put("timestamp", Instant.now().toString());

        long uptimeSeconds = Instant.now().getEpochSecond() - startTime.getEpochSecond();
        status.put("uptime_seconds", uptimeSeconds);

        status.put("message", "Backend is running smoothly 🚀");

        return status;
    }
}

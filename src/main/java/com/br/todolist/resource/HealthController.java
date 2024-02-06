package com.br.todolist.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @Autowired
    private HealthIndicator healthIndicator;


    @GetMapping("/health")
    public ResponseEntity<Health> checkHealth() {
        Health health = healthIndicator.health();
        return ResponseEntity.ok(health);
    }

}

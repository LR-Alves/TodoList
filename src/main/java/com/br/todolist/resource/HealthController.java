package com.br.todolist.resource;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    private final Logger logger = LoggerFactory.getLogger(HealthController.class);


    @Autowired
    private HealthIndicator healthIndicator;


    @GetMapping("/health")
    public ResponseEntity<Health> checkHealth() {
        logger.info("validando endpoint /health");
        Health health = healthIndicator.health();

        return ResponseEntity.ok(health);
    }

}

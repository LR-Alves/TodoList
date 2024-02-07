package com.br.todolist.custom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class HealthIndicatorCustom implements HealthIndicator {

    @Override
    public Health health() {

        boolean isHealthy = checkHealth();

        if (isHealthy) {
            return Health.up().build();
        } else {
            return Health.down().withDetail("Reason", "Something went wrong").build();
        }
    }

    private boolean checkHealth() {

        return true;
    }
}

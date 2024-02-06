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
        // Implementa a lógica para verificar a saúde do seu aplicativo
        boolean isHealthy = checkHealth();

        if (isHealthy) {
            return Health.up().build();
        } else {
            return Health.down().withDetail("Reason", "Something went wrong").build();
        }
    }

    private boolean checkHealth() {
        // Aqui você pode adicionar a lógica para verificar a saúde do seu aplicativo
        // Por exemplo, verificando a conexão com um banco de dados, serviço externo, etc.
        // Por simplicidade, retornaremos sempre true neste exemplo
        return true;
    }
}

package net.blitzstein.microservices.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class BasicHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Basic health check failed", errorCode).build();
        }
        return Health.up().build();
    }

    // hard code everything is alright!
    // TODO: do something real
    private int check() {
        return 0;
    }

}

package net.blitzstein.microservices.domain;

/**
 * Created by jared on 1/25/17.
 */
public class Greeting {
    private String mainGreeting;

    public Greeting(String mainGreeting) {
        this.mainGreeting = mainGreeting;
    }

    public String getMainGreeting() {
        return mainGreeting;
    }
}

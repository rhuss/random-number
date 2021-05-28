package io.k8spatterns.examples;

import java.util.Random;
import java.util.UUID;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RandomGeneratorService {

    private UUID id;
    private Random random = new Random();

    public int getRandom() {
        return random.nextInt();
    }

    public UUID getUUID() {
        if (id == null) {
            id = UUID.randomUUID();
        }
        return id;
    }
}

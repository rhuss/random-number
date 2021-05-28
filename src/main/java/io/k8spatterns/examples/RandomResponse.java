package io.k8spatterns.examples;

import java.util.UUID;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class RandomResponse {

    private UUID id;
    private int random;
    private String version;

    RandomResponse(UUID id, int random, String version) {
        this.id = id;
        this.random = random;
        this.version = version;
    }

    public String getId() {
        return id.toString();
    }

    public int getRandom() {
        return random;
    }

    public String getVersion() {
        return version;
    }
}

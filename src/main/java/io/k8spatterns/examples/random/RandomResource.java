package io.k8spatterns.examples.random;


import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/")
public class RandomResource {

    @ConfigProperty(name = "quarkus.application.version")
    String version;

    @Inject
    RandomGeneratorService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RandomResponse random() {
        waitIfRequested();
        return new RandomResponse(service.getUUID(), service.getRandom(), version);
    }

    private void waitIfRequested() {
        String delay = System.getenv("DELAY");
        if (delay != null) {
            long delayMs = Long.parseLong(delay);
            try {
                Thread.sleep(delayMs);
            } catch (InterruptedException e) {
            }
        }

    }
}

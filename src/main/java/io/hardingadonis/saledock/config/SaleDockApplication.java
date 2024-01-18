package io.hardingadonis.saledock.config;

import jakarta.ws.rs.*;
import org.glassfish.jersey.server.*;

@ApplicationPath("api")
public class SaleDockApplication extends ResourceConfig {

    public SaleDockApplication() {
        packages("io.hardingadonis.saledock.api");
    }
}

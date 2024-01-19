package io.hardingadonis.saledock.api.v1;

import io.hardingadonis.saledock.model.*;
import io.hardingadonis.saledock.utils.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("v1/demo")
public class DemoAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct() {
        return Singleton.productDAO.getByID(1).get();
    }
}

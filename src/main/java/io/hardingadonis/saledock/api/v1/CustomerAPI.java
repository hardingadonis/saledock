package io.hardingadonis.saledock.api.v1;

import io.hardingadonis.saledock.utils.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("v1/customer")
public class CustomerAPI {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatistic(
            @QueryParam("duration") Integer duration
    ) {
        return Singleton.customerDAO.getTop10(duration);
    }
}

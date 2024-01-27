package io.hardingadonis.saledock.api.v1;

import io.hardingadonis.saledock.utils.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("v1/product")
public class ProductAPI {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getStatistic(@QueryParam("duration") Integer duration) {
    return Singleton.productDAO.getTop10(duration);
  }
}

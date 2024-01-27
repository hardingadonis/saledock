package io.hardingadonis.saledock.api.v1;

import io.hardingadonis.saledock.utils.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("v1/order")
public class OrderAPI {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String getStatistic(@QueryParam("by") String by,
                             @QueryParam("duration") Integer duration) {
    if (by.equals("sold")) {
      return Singleton.orderDAO.statisticBySold(duration);
    } else {
      return Singleton.orderDAO.statisticByStatus(duration);
    }
  }
}

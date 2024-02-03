package io.hardingadonis.saledock.dao;

import io.hardingadonis.saledock.model.*;

public interface IOrderDAO extends IDAO<Order>, IPagination<Order> {

    default Long countOrderInProcess() {
        return 0L;
    }

    public String statisticBySold(Integer duration);

    public String statisticByStatus(Integer duration);
}

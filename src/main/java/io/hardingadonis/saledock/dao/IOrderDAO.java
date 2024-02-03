package io.hardingadonis.saledock.dao;

import io.hardingadonis.saledock.model.*;

public interface IOrderDAO extends IDAO<Order>, IPagination<Order> {

    default Integer countOrderInProcess() {
        return 0;
    }

    public String statisticBySold(Integer duration);

    public String statisticByStatus(Integer duration);
}

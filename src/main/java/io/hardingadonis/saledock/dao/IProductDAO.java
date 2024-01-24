package io.hardingadonis.saledock.dao;

import io.hardingadonis.saledock.model.*;

public interface IProductDAO extends IDAO<Product> {

    public String getTop10(Integer duration);
}

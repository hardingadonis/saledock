package io.hardingadonis.saledock.dao;

import io.hardingadonis.saledock.model.*;

public interface ICustomerDAO extends IDAO<Customer> {

    public String getTop10(Integer duration);
}

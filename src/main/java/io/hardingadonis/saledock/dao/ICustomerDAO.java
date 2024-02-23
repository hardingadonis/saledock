package io.hardingadonis.saledock.dao;

import io.hardingadonis.saledock.model.*;
import java.util.*;

public interface ICustomerDAO extends IDAO<Customer>, IPagination<Customer> {
    
    public String getTop10(Integer duration);
    
    public Optional<Customer> getByName(String customerName);
}

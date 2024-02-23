package io.hardingadonis.saledock.dao;

import io.hardingadonis.saledock.model.*;
import java.util.*;

public interface IProductDAO extends IDAO<Product>, IPagination<Product> {

    public String getTop10(Integer duration);
    
    public Optional<Product> getByName(String productName);
}

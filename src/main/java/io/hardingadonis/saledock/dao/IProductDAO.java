package io.hardingadonis.saledock.dao;

import io.hardingadonis.saledock.model.*;
import java.util.Optional;

public interface IProductDAO extends IDAO<Product>, IPagination<Product> {

    public String getTop10(Integer duration); 
    
    public Optional<Product> getByCode(String code);
}

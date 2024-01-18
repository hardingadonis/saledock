package io.hardingadonis.saledock.dao;

import java.util.*;

public interface IDAO<T> {

    public void add(T obj);
    
    public Optional<T> getByID(Integer ID);
    
    public List<T> getAll();
    
    void update(T obj);
}

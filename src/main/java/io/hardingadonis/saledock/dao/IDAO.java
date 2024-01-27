package io.hardingadonis.saledock.dao;

import java.util.*;

public interface IDAO<T> {

  public T save(T obj);

  public Optional<T> getByID(Integer ID);

  public List<T> getAll();

  default Long count() { return 0L; }

  public boolean insert(T t);
}

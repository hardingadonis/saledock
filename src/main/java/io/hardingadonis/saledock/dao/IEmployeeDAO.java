package io.hardingadonis.saledock.dao;

import io.hardingadonis.saledock.model.*;
import java.util.Optional;

public interface IEmployeeDAO extends IDAO<Employee> {
  Optional<Employee> getByCode(String code);
}

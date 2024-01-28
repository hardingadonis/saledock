package io.hardingadonis.saledock.dao;

import io.hardingadonis.saledock.model.*;
import java.util.*;

public interface IEmployeeDAO extends IDAO<Employee> {

    public Optional<Employee> getByCode(String code);
}

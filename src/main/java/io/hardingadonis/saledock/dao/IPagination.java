package io.hardingadonis.saledock.dao;

import java.util.*;

public interface IPagination<T> {

    public List<T> pagination(Integer offset, Integer limit);

    public Integer totalPages(Integer limit);
}

package com.ronx.hr.dao;

/**
 * Created by Ron on 22.05.2015.
 */
public interface HumanResourcesDAO<T> {

    void create(T entity);
    void getEntityById(T entity, Long id);
    void update();
    void delete();
}

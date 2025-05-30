package com.mygdv.mc_account_service.util;

import java.util.List;

public interface ICrud<T> {

    List<T> getAll();

    T add(T t);

    T update(T t);

    T delete(T t);

    T getById(String id);

}
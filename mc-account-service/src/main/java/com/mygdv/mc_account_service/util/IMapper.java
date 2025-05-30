package com.mygdv.mc_account_service.util;

public interface IMapper<T> {

    T getDTO();

    void setData(T t);

}
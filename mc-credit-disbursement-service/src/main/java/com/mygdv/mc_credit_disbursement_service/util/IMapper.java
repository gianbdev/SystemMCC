package com.mygdv.mc_credit_disbursement_service.util;

public interface IMapper<T> {

    T getDTO();

    void setData(T t);

}
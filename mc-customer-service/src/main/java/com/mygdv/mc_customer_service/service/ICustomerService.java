package com.mygdv.mc_customer_service.service;

import com.mygdv.mc_customer_service.dto.CustomerDTO;
import com.mygdv.mc_customer_service.util.ICrud;

public interface ICustomerService extends ICrud<CustomerDTO> {

    CustomerDTO getByCu(String cu);

}
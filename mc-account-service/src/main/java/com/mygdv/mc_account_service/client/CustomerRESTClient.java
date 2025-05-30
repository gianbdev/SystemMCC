package com.mygdv.mc_account_service.client;

import com.mygdv.mc_account_service.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "${feign.clients.customer.name}", url = "${feign.clients.customer.url}")
public interface CustomerRESTClient {

    @PostMapping
    ResponseEntity<CustomerDTO> add(@RequestBody CustomerDTO customerDTO);

    @GetMapping("/cu/{cu}")
    ResponseEntity<CustomerDTO> getByCu(@PathVariable("cu") String cu);

}
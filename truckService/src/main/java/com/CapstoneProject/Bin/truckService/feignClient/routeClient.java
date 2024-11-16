package com.CapstoneProject.Bin.truckService.feignClient;


import com.CapstoneProject.Bin.truckService.dtos.Route;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "routeService" ,url="http://localhost:8085/api/routes")
public interface routeClient {
    @GetMapping("/{id}")
    public Route getRouteById(String id);
}

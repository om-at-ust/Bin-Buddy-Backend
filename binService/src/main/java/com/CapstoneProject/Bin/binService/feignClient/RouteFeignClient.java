package com.CapstoneProject.Bin.binService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "routeService", url = "XXXXXXXXXXXXXXXXXXXXX")
public interface RouteFeignClient {

}

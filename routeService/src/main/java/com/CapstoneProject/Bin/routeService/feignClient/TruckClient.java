package com.CapstoneProject.Bin.routeService.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "truckClient", url = "http://localhost:8083/api/trucks/")
public interface TruckClient {
    @PostMapping("/assignRoute")
    public ResponseEntity<String> assignRouteToTruck(@RequestBody String routeId);

}

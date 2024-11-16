package com.CapstoneProject.Bin.routeService.feignClient;

import com.CapstoneProject.Bin.routeService.dtos.Bin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="binService" ,url="http://localhost:8082/bins")
public interface BinFeignClient {
    @GetMapping("/full-overflowing")
    ResponseEntity<List<Bin>> getFullOrOverflowingBins();
}

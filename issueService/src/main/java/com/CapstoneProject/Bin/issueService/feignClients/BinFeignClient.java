package com.CapstoneProject.Bin.issueService.feignClients;

import com.CapstoneProject.Bin.issueService.dtos.Bin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="binService", url = "http://localhost:8082/bins")
public interface BinFeignClient {
    @GetMapping("/{id}")
    Bin getBinById(@PathVariable Long id);
}

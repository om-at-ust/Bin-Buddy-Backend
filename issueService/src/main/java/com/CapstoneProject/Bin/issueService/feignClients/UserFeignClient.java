package com.CapstoneProject.Bin.issueService.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="authenticationService", url = "http://localhost:8081/api/auth")
public interface UserFeignClient {
    public ResponseEntity<?> getUserByUserName(@PathVariable String userName);

}

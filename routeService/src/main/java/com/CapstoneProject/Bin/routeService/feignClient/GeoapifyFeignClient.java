package com.CapstoneProject.Bin.routeService.feignClient;




import com.CapstoneProject.Bin.routeService.entity.GeoapifyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "geoapifyClient", url = "https://api.geoapify.com/v1")
public interface GeoapifyFeignClient {

    @GetMapping("/routing")
    GeoapifyResponse getRoute(
            @RequestParam("waypoints") String waypoints,
            @RequestParam("mode") String mode,
            @RequestParam("apiKey") String apiKey
    );
}

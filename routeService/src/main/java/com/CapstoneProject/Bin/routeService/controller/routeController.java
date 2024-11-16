package com.CapstoneProject.Bin.routeService.controller;

import com.CapstoneProject.Bin.routeService.entity.GeoapifyResponse;
import com.CapstoneProject.Bin.routeService.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
public class routeController {
    @Autowired
    RouteService geoapifyService;

//    String waypoints = "50.96209827745463,4.414458883409225|50.429137079078345,5.00088081232559";
//    String mode = "drive";
//    String apiKey = "e40bf7725f014f46b46609ebb9112a9a";
    @GetMapping("/getRoute")
    public GeoapifyResponse getRoute() {
        return geoapifyService.fetchRoute();
    }

    @GetMapping("/{id}")
    public GeoapifyResponse getRouteById(@PathVariable String id) {
        return geoapifyService.getRouteById(id);
    }
    @GetMapping("/createRoute")
    public GeoapifyResponse createRoute() throws Exception {
        return geoapifyService.createRoute();
    }
    @DeleteMapping
    public ResponseEntity<String> deleteRoute(@RequestParam String id) {
        return geoapifyService.deleteRoute(id);
    }

}

package com.CapstoneProject.Bin.routeService.controller;

import com.CapstoneProject.Bin.routeService.entity.GeoapifyResponse;
import com.CapstoneProject.Bin.routeService.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
@CrossOrigin(origins = "http://localhost:5173")
public class routeController {
    @Autowired
    RouteService geoapifyService;


    @GetMapping("/{id}")
    public ResponseEntity<GeoapifyResponse> getRouteById(@PathVariable String id) {
        return new ResponseEntity<>(geoapifyService.getRouteById(id), HttpStatus.OK);
    }
    @GetMapping("/createRoute")
    public GeoapifyResponse createRoute() throws Exception {
        return geoapifyService.createRoute();
    }
    @DeleteMapping
    public ResponseEntity<String> deleteRoute(@RequestParam String id) {
        return geoapifyService.deleteRoute(id);
    }

    @GetMapping("/getAllRoutes")
    public ResponseEntity<?> getAllRoutes() {
        return new ResponseEntity<>(geoapifyService.getAllRoutes(), HttpStatus.OK);
    }
    @PostMapping("/setRouteStatusAssigned/{routeId}")
    public ResponseEntity<String> setRouteStatusAssigned(@PathVariable String routeId) {
        return new ResponseEntity<>(geoapifyService.setRouteStatusAssigned(routeId), HttpStatus.OK);
    }
}

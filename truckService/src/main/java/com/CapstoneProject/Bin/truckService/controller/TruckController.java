package com.CapstoneProject.Bin.truckService.controller;

import com.CapstoneProject.Bin.truckService.entity.Truck;
import com.CapstoneProject.Bin.truckService.entity.TruckStatusUpdateRequest;
import com.CapstoneProject.Bin.truckService.services.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trucks")
@CrossOrigin(origins = "http://localhost:5173")
public class TruckController {

    @Autowired
    private TruckService truckService;

    @GetMapping
    public List<Truck> getAllTrucks() {
        return truckService.getAllTrucks();
    }

    // Get available trucks
    @GetMapping("/available")
    public List<Truck> getAvailableTrucks() {
        return truckService.getAvailableTrucks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Truck> getTruckById(@PathVariable String id) {
        Truck truck = truckService.getTruckById(id);
        if (truck != null) {
            return ResponseEntity.ok(truck);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Truck> saveTruck(@RequestBody Truck truck) {
        Truck savedTruck = truckService.saveTruck(truck);
        return ResponseEntity.ok(savedTruck);
    }

    @PostMapping("/saveall")
    public ResponseEntity<List<Truck>> saveTrucks(@RequestBody List<Truck> trucks) {
        List<Truck> savedTrucks = truckService.saveAllTrucks(trucks);
        return ResponseEntity.ok(savedTrucks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Truck> updateTruck(@PathVariable String id, @RequestBody Truck truck) {
        truck.setId(id);
        Truck updatedTruck = truckService.updateTruck(truck);
        if (updatedTruck != null) {
            return ResponseEntity.ok(updatedTruck);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTruck(@PathVariable String id) {
        truckService.deleteTruck(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/status")
    public void updateTruckStatus(@RequestBody TruckStatusUpdateRequest statusUpdateRequest) {
        truckService.updateTruckStatus(statusUpdateRequest);
    }
    @PostMapping("/assignRoute")
    public ResponseEntity<String> assignRouteToTruck(@RequestParam String routeId) {
        try {
            String result = truckService.assignRouteToTruck(routeId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/route/{routeId}")
    public ResponseEntity<Truck> getTruckByRouteId(@PathVariable String routeId) {
        Truck truck = truckService.getTruckByRouteId(routeId);
        if (truck != null) {
            return ResponseEntity.ok(truck);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

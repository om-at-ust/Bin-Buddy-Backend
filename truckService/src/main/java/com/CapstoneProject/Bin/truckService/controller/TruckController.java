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
    public ResponseEntity<Truck> getTruckById(@PathVariable Long id) {
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
    public ResponseEntity<Truck> updateTruck(@PathVariable Long id, @RequestBody Truck truck) {
        truck.setId(id);
        Truck updatedTruck = truckService.updateTruck(truck);
        if (updatedTruck != null) {
            return ResponseEntity.ok(updatedTruck);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTruck(@PathVariable Long id) {
        truckService.deleteTruck(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/status")
    public void updateTruckStatus(@RequestBody TruckStatusUpdateRequest statusUpdateRequest) {
        truckService.updateTruckStatus(statusUpdateRequest);
    }
}

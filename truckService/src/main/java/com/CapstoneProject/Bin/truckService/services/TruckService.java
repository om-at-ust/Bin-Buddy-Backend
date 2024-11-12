package com.CapstoneProject.Bin.truckService.services;

import com.CapstoneProject.Bin.truckService.entity.Truck;
import com.CapstoneProject.Bin.truckService.entity.TruckStatus;
import com.CapstoneProject.Bin.truckService.entity.TruckStatusUpdateRequest;
import com.CapstoneProject.Bin.truckService.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TruckService {

    @Autowired
    private TruckRepository truckRepository;

      public List<Truck> getAllTrucks() {
        return truckRepository.findAll();
    }

    public List<Truck> getAvailableTrucks() {
        return truckRepository.findByStatus(TruckStatus.AVAILABLE);
    }

    public void updateTruckStatus(TruckStatusUpdateRequest request) {
        Truck truck = truckRepository.findById(request.getTruckId()).orElse(null);


        truck.setStatus(request.getNewStatus());
        truckRepository.save(truck);
    }

    public Truck getTruckById(Long id) {
        return truckRepository.findById(id).orElse(null);
    }

    public Truck saveTruck(Truck truck) {
        truck.setCreatedAt(LocalDateTime.now());
        return truckRepository.save(truck);
    }

    public List<Truck> saveAllTrucks(List<Truck> trucks){
        return truckRepository.saveAll(trucks);
    }

    public void deleteTruck(Long id) {
        truckRepository.deleteById(id);
    }

    public Truck updateTruck(Truck truck) {
        return truckRepository.save(truck);
    }

    // Change truck status (e.g., set to ON_ROUTE)
    public Truck updateTruckStatus(Long id, TruckStatus status) {
        Truck truck = getTruckById(id);
        truck.setStatus(status);
        return truckRepository.save(truck);
    }
}
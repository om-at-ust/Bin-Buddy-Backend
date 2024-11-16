package com.CapstoneProject.Bin.truckService.repository;

import com.CapstoneProject.Bin.truckService.entity.Truck;
import com.CapstoneProject.Bin.truckService.entity.TruckStatus;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TruckRepository extends MongoRepository<Truck, Long>{
    List<Truck> findByStatus(TruckStatus status);
//    Truck findByUserId(Long userId);

    Truck findByAssignedRouteId(String routeId);

}

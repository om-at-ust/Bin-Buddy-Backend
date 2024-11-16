package com.CapstoneProject.Bin.truckService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "trucks")
public class Truck {

    @Id
    private Long id;

    private Long userId;

    private String truckNumber;

    private int pickupCapacity;
    private String currentLocation;


    private TruckStatus status = TruckStatus.AVAILABLE;

    private LocalDateTime createdAt = LocalDateTime.now();

    // Start coordinates
    private double startLatitude;
    private double startLongitude;

    // End coordinates
    private double endLatitude;
    private double endLongitude;


     // TODO : Store the assigned route
       private String assignedRouteId;



}

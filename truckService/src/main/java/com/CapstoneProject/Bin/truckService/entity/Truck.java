package com.CapstoneProject.Bin.truckService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


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


    public Truck() {
    }

    public Truck(Long id, Long userId, String truckNumber, int pickupCapacity, String currentLocation, TruckStatus status, LocalDateTime createdAt, double startLatitude, double startLongitude, double endLatitude, double endLongitude) {
        this.id = id;
        this.userId = userId;
        this.truckNumber = truckNumber;
        this.pickupCapacity = pickupCapacity;
        this.currentLocation = currentLocation;
        this.status = status;
        this.createdAt = createdAt;
        this.startLatitude = startLatitude;
        this.startLongitude = startLongitude;
        this.endLatitude = endLatitude;
        this.endLongitude = endLongitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public int getPickupCapacity() {
        return pickupCapacity;
    }

    public void setPickupCapacity(int pickupCapacity) {
        this.pickupCapacity = pickupCapacity;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public TruckStatus getStatus() {
        return status;
    }

    public void setStatus(TruckStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }
}

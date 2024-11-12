package com.CapstoneProject.Bin.issueService.dtos;

import java.time.LocalDateTime;
import java.util.Date;

public class Bin {
    private Long id;

    private String location;
    private Double latitude;
    private Double longitude;

    private int wasteAmount;


    private BinStatus status;

    private int fillLevel;

    private LocalDateTime createdAt = LocalDateTime.now();
    private Date lastCollectionDate;
    private Date nextCollectionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getWasteAmount() {
        return wasteAmount;
    }

    public void setWasteAmount(int wasteAmount) {
        this.wasteAmount = wasteAmount;
    }

    public BinStatus getStatus() {
        return status;
    }

    public void setStatus(BinStatus status) {
        this.status = status;
    }

    public int getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(int fillLevel) {
        this.fillLevel = fillLevel;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Date getLastCollectionDate() {
        return lastCollectionDate;
    }

    public void setLastCollectionDate(Date lastCollectionDate) {
        this.lastCollectionDate = lastCollectionDate;
    }

    public Date getNextCollectionDate() {
        return nextCollectionDate;
    }

    public void setNextCollectionDate(Date nextCollectionDate) {
        this.nextCollectionDate = nextCollectionDate;
    }

    public Bin() {
    }

    public Bin(Long id, String location, Double latitude, Double longitude, int wasteAmount, BinStatus status, int fillLevel, LocalDateTime createdAt, Date lastCollectionDate, Date nextCollectionDate) {
        this.id = id;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.wasteAmount = wasteAmount;
        this.status = status;
        this.fillLevel = fillLevel;
        this.createdAt = createdAt;
        this.lastCollectionDate = lastCollectionDate;
        this.nextCollectionDate = nextCollectionDate;
    }

}

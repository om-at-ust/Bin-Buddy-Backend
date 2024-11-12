package com.CapstoneProject.Bin.issueService.dtos;

public class BinDTO1 {
    Long id;
    Double latitude;
    Double longitude;
    int fillLevel;


    public BinDTO1() {
    }

    public BinDTO1(Long id, Double latitude, int fillLevel, Double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.fillLevel = fillLevel;
        this.longitude = longitude;
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

    public int getFillLevel() {
        return fillLevel;
    }

    public void setFillLevel(int fillLevel) {
        this.fillLevel = fillLevel;
    }
}

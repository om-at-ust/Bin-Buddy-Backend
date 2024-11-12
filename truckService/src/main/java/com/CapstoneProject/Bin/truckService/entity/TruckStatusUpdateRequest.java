package com.CapstoneProject.Bin.truckService.entity;

public class TruckStatusUpdateRequest {
    private Long truckId;
    private TruckStatus newStatus;

    public TruckStatusUpdateRequest(Long truckId, TruckStatus newStatus) {
        this.truckId = truckId;
        this.newStatus = newStatus;
    }

    public TruckStatusUpdateRequest() {
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public TruckStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(TruckStatus newStatus) {
        this.newStatus = newStatus;
    }
}

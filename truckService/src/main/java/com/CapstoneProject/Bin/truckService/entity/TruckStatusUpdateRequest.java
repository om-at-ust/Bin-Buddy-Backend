package com.CapstoneProject.Bin.truckService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TruckStatusUpdateRequest {
    private String truckId;
    private TruckStatus newStatus;

}

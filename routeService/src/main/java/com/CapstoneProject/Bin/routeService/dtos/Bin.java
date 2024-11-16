package com.CapstoneProject.Bin.routeService.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}

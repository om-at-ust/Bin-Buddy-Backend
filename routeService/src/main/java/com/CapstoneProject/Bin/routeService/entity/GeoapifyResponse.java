package com.CapstoneProject.Bin.routeService.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "routes")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoapifyResponse {
    @Id
    private String id;
    private Boolean isAssigned = false;

    private List<Feature> features;
    private Properties properties;
    private String type;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Feature {
        private String type;
        private FeatureProperties properties;
        private Geometry geometry;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FeatureProperties {
        private String mode;
        private List<FeatureWaypoint> waypoints;  // Using FeatureWaypoint
        private String units;
        private double distance;
        private String distance_units;
        private double time;
        private List<Leg> legs;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FeatureWaypoint {  // Waypoint for Feature
        private List<Double> location;
        @JsonProperty("original_index")
        private int originalIndex;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PropertiesWaypoint {  // New Waypoint for root Properties
        private double lat;
        private double lon;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Leg {
        private double distance;
        private double time;
        private List<Step> steps;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Step {
        private int from_index;
        private int to_index;
        private double distance;
        private double time;
        private Instruction instruction;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Instruction {
        private String text;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Geometry {
        private String type;
        private List<List<double[]>> coordinates;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Properties {
        private String mode;
        private List<PropertiesWaypoint> waypoints;  // Using PropertiesWaypoint
        private String units;
    }
}
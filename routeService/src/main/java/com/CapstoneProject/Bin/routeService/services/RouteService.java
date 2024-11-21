package com.CapstoneProject.Bin.routeService.services;



import com.CapstoneProject.Bin.routeService.dtos.Bin;
import com.CapstoneProject.Bin.routeService.entity.GeoapifyResponse;
import com.CapstoneProject.Bin.routeService.feignClient.BinFeignClient;
import com.CapstoneProject.Bin.routeService.feignClient.GeoapifyFeignClient;
import com.CapstoneProject.Bin.routeService.feignClient.TruckClient;
import com.CapstoneProject.Bin.routeService.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteService {

    @Autowired
    GeoapifyFeignClient geoapifyFeignClient;
    @Autowired
    RouteRepository routeRepository;
    @Autowired
    BinFeignClient binFeignClient;
    @Autowired
    TruckClient truckClient;


    String sourceLat = "8.524139";
    String sourceLon = "76.936638";
    String destinationLat = "8.4248574";
    String destinationLon = "76.9490328";
//    String waypoints = sourceLat + "," + sourceLon + "|" + destinationLat + "," + destinationLon;
    String mode = "drive";
    String apiKey = "e40bf7725f014f46b46609ebb9112a9a";



//    public GeoapifyResponse fetchRoute() {
//        GeoapifyResponse res = geoapifyFeignClient.getRoute(waypoints, mode, apiKey);
//        routeRepository.save(res);
//        return res;
//    }
    public List<GeoapifyResponse> getAllRoutes(){
        List<GeoapifyResponse> routes = routeRepository.findAll();
        if(routes.size() == 0 || routes == null) return null;
        System.out.println(routes);
        return routes;
    }

   public GeoapifyResponse createRoute() throws Exception {
        List<Bin> bins = binFeignClient.getFullOrOverflowingBins().getBody();
        if(bins.size() == 0 || bins == null) throw new Exception("No bins found");
        StringBuilder waypointsBuilder = new StringBuilder();
        waypointsBuilder.append(sourceLat).append("%2c").append(sourceLon);
        for (Bin bin : bins) {
            waypointsBuilder.append("%7c").append(bin.getLatitude()).append("%2c").append(bin.getLongitude());
        }
        waypointsBuilder.append("%7c").append(destinationLat).append("%2c").append(destinationLon);
        String waypoints = waypointsBuilder.toString();

        return routeRepository.save(geoapifyFeignClient.getRoute(waypoints, mode, apiKey));
   }

   public String assignRouteToTruck (){
        List<GeoapifyResponse> routes = routeRepository.findAllByIsAssignedTrue();
        if(routes.size() == 0 || routes == null) return "No routes found";
        GeoapifyResponse route = routes.get(0);
        truckClient.assignRouteToTruck(route.getId());
        route.setIsAssigned(true);
        routeRepository.save(route);
        return "Route assigned to truck";
   }

    public GeoapifyResponse getRouteById(String id) {
        return routeRepository.findById(id).orElseThrow(() -> new RuntimeException("Route not found with id: " + id));
    }


    public ResponseEntity<String> deleteRoute(String id) {
        routeRepository.deleteById(id);
        return ResponseEntity.ok("Route deleted");
   }

   public String setRouteStatusAssigned(String routeId) {
        GeoapifyResponse route = routeRepository.findById(routeId).orElse(null);
        if(route == null) return "Route not found";
        route.setIsAssigned(true);
        routeRepository.save(route);
        return "Route status updated";
   }

}

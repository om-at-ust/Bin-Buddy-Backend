package com.CapstoneProject.Bin.routeService.repository;

import com.CapstoneProject.Bin.routeService.entity.GeoapifyResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends MongoRepository<GeoapifyResponse, String>{
    List<GeoapifyResponse> findAllByIsAssignedTrue();
}

package com.CapstoneProject.Bin.binService.repository;

import com.CapstoneProject.Bin.binService.entity.Bin;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BinRepository extends MongoRepository<Bin, Long>{
    List<Bin> findByStatusIn(List<String> statuses);
}

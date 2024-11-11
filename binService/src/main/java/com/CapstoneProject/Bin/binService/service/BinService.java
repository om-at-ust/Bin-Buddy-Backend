package com.CapstoneProject.Bin.binService.service;

import com.CapstoneProject.Bin.binService.entity.Bin;
import com.CapstoneProject.Bin.binService.feignClient.RouteFeignClient;
import com.CapstoneProject.Bin.binService.repository.BinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BinService {
    @Autowired
    private BinRepository binRepository;
    @Autowired
    private RouteFeignClient routeFeignClient;
    public BinService(BinRepository binRepository, RouteFeignClient routeFeignClient) {
        this.binRepository = binRepository;
        this.routeFeignClient = routeFeignClient;
    }




    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }

    public List<Bin> saveAllBins(List<Bin> bins){
        return binRepository.saveAll(bins);
    }

    public Bin getBinById(Long id) {
        return binRepository.findById(id).orElse(null);
    }

    public Bin saveBin(Bin bin) {
        return binRepository.save(bin);
    }

    public void deleteBin(Long id) {
        binRepository.deleteById(id);
    }

    // Fetch bins with both FULL and OVERFLOW statuses
    public List<Bin> getFullAndOverflowingBins() {
        return binRepository.findByStatusIn(Arrays.asList("FULL", "OVERFLOWING"));
    }

    public Bin updateBins(Bin bin , Long id) {
        Optional<Bin> optionalBin = binRepository.findById(id);
        if(optionalBin.isPresent()) {
            Bin foundedbin = optionalBin.get();
            foundedbin.setLocation(bin.getLocation());
            foundedbin.setLatitude(bin.getLatitude());
            foundedbin.setLongitude(bin.getLongitude());
            foundedbin.setWasteAmount(bin.getWasteAmount());
            foundedbin.setStatus(bin.getStatus());
            foundedbin.setFillLevel(bin.getFillLevel());
            return  binRepository.save(foundedbin);
        }
        throw  new RuntimeException("Bin with id " + id + "not found");
    }
}

package com.CapstoneProject.Bin.binService.service;

import com.CapstoneProject.Bin.binService.entity.Bin;
import com.CapstoneProject.Bin.binService.entity.BinStatus;
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

    public Bin getBinById(String id) {
        return binRepository.findById(id).orElse(null);
    }

    public Bin saveBin(Bin bin) {
        return binRepository.save(bin);
    }

    public void deleteBin(String id) {
        binRepository.deleteById(id);
    }

    // Fetch bins with both FULL and OVERFLOW statuses
    public List<Bin> getFullAndOverflowingBins() {
        return binRepository.findByStatusIn(Arrays.asList("FULL", "OVERFLOWING"));
    }

    public Bin updateBins(Bin bin , String id) {
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



    private static final int MIN_FILL_LEVEL = 0;
    private static final int MAX_FILL_LEVEL = 100;
    public Bin updateBinStatus(String id, int fillLevel) {
        Bin bin = getBinById(id);
        if (bin != null) {
            bin.setFillLevel(fillLevel);
            if (fillLevel == MIN_FILL_LEVEL) {
                bin.setStatus(BinStatus.EMPTY);
            } else if (fillLevel < 50) {
                bin.setStatus(BinStatus.HALF_FULL);
            } else if (fillLevel < 75) {
                bin.setStatus(BinStatus.QUARTERLY_FULL);
            } else if (fillLevel < MAX_FILL_LEVEL) {
                bin.setStatus(BinStatus.FULL);
            } else {
                bin.setStatus(BinStatus.OVERFLOWING);
            }
            return binRepository.save(bin);
        }
        return null;
    }

    //TODO : assign the filled bins to the scheduled Job list
    // TODO: <to be done after route microservice>
}

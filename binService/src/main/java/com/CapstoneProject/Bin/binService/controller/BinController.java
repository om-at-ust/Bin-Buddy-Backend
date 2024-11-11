package com.CapstoneProject.Bin.binService.controller;

import com.CapstoneProject.Bin.binService.entity.Bin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/bins")
@CrossOrigin(origins = "http://localhost:4200")
public class BinController {

    private final BinService binService;
    public BinController(BinService binService) {
        this.binService = binService;
    }

    @GetMapping
    public List<Bin> getAllBins() {
        return binService.getAllBins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bin> getBinById(@PathVariable Long id) {
        Bin bin = binService.getBinById(id);
        if (bin != null) {
            return ResponseEntity.ok(bin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Bin> saveBin(@RequestBody Bin bin) {
        Bin savedBin = binService.saveBin(bin);
        return ResponseEntity.ok(savedBin);
    }

    @PostMapping("/saveall")
    public ResponseEntity<List<Bin>> saveallBin(@RequestBody List<Bin> bins) {
        List<Bin> savedBins = binService.saveAllBins(bins);
        return ResponseEntity.ok(savedBins);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bin> updateBin(@RequestBody Bin bin , @PathVariable Long id) {
        return ResponseEntity.ok(binService.updateBins(bin,id));
    }

    //    bin/{id}?fillLevel=X
    @PutMapping("/{id}")
    public ResponseEntity<Bin> updateBinStatus(@PathVariable Long id, @RequestParam int fillLevel) {
        Bin updatedBin = binService.updateBinStatus(id, fillLevel);
        if (updatedBin != null) {
            return ResponseEntity.ok(updatedBin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBin(@PathVariable Long id) {
        binService.deleteBin(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/update-fill-level")
    public ResponseEntity<Bin> updateFillLevel(@PathVariable Long id, @RequestParam int fillLevel) {
        Bin updatedBin = binService.updateBinStatus(id, fillLevel);
        if (updatedBin != null) {
            return ResponseEntity.ok(updatedBin);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/full-overflowing")
    public ResponseEntity<List<Bin>> getFullOrOverflowingBins(){
        List<Bin> fullAndOverflowingBins = binService.getFullAndOverflowingBins();
        if (fullAndOverflowingBins != null) {
            return ResponseEntity.ok(fullAndOverflowingBins);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
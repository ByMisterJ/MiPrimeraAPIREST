package com.example.miprimeraapirest.controller;

import com.example.miprimeraapirest.model.Driver;
import com.example.miprimeraapirest.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverRestController {
    private final DriverService driverService;

    @Autowired
    public DriverRestController(DriverService service){
        this.driverService = service;
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getAll() {
        return ResponseEntity.ok(driverService.getAllDrivers());
    }

    @GetMapping("/drivers/{code}")
    public ResponseEntity<Driver> getByCode(@PathVariable String code) {
        return driverService.getDriverByCode(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /*
    POST http://localhost:8080/api/drivers/
     */

    @PostMapping("/drivers")
    public ResponseEntity<Driver> create(@RequestBody Driver driver) {
        if (driver.getDriverId() != null) {
            return ResponseEntity.badRequest().build();
        }
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    /*
    PUT http://localhost:8080/api/drivers/
     */

    @PutMapping("/drivers")
    public ResponseEntity<Driver> update(@RequestBody Driver driver) {
        this.driverService.saveDriver(driver);
        return ResponseEntity.ok(driver);
    }

    /*
    DELETE http://localhost:8080/api/drivers/alo
     */

    @DeleteMapping("/drivers/{code}")
    public ResponseEntity<Driver> delete(@PathVariable String code) {
        this.driverService.deleteDriverByCode(code);
        return ResponseEntity.noContent().build();
    }


}

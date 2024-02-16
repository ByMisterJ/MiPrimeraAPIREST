package com.example.miprimeraapirest.service;

import com.example.miprimeraapirest.model.Driver;

import java.util.List;
import java.util.Optional;

public interface DriverService {
    List<Driver> getAllDrivers();
    Optional<Driver> getDriverByCode(String code);

    void deleteDriverByCode(String code);

    void saveDriver(Driver driver);
}

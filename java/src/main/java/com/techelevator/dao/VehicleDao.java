package com.techelevator.dao;

import com.techelevator.model.Vehicle;

import java.util.List;

public interface VehicleDao {

    List<Vehicle> getVehicles();


    Vehicle getVehicleById(int vehicleId);

    Vehicle getVehicleByMake(String make);

    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    Vehicle deleteVehicleById(int vehicleId);




}

package com.techelevator.dao;

import com.techelevator.model.Vehicle;

import java.util.List;

public interface VehicleDao {

    List<Vehicle> getVehicles();
    List<Vehicle> getVehiclesByUserId(int userId);


    Vehicle getVehicleByVehicleId(int vehicleId);

    List<Vehicle> getVehiclesByMake(String make);

    List<Vehicle> getVehiclesByModel(String model);

    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    Vehicle deleteVehicleById(int vehicleId);




}

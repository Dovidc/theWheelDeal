package com.techelevator.dao;

import com.techelevator.model.Vehicle;

public interface VehicleDao {

    Vehicle getVehicleById(int vehicleId);

    Vehicle getVehicleByMake(String make);
    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle);
    Vehicle deleteVehicleById(int vehicleId);




}

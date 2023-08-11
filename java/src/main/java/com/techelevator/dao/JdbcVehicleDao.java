package com.techelevator.dao;

import com.techelevator.model.Vehicle;
import com.techelevator.security.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVehicleDao implements VehicleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Vehicle> getVehicles() {
        List<Vehicle> returnedVehicles = new ArrayList<>();
        String sql = "Select * from vehicle;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                Vehicle vehicle = mapRowToVehicle(rowSet);
                returnedVehicles.add(vehicle);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return returnedVehicles;
    }//completed

    @Override
    public List<Vehicle> getVehiclesByUserId (int userId) {
        List<Vehicle> returnedVehicles = new ArrayList<>();
        String sql = "select vehicle.vehicle_id, make, model, year, color, plate_number, mileage from vehicle\n" +
                "join users_vehicle on users_vehicle.vehicle_id = vehicle.vehicle_id\n" +
                "where users_vehicle.user_id = ?;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);
            while (rowSet.next()) {
                Vehicle vehicle = mapRowToVehicle(rowSet);
                returnedVehicles.add(vehicle);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }

        return returnedVehicles;
    }// completed

    @Override
    public Vehicle getVehicleByVehicleId(int vehicleId) {
        Vehicle vehicle = new Vehicle();
        String sql = "select * from vehicle where vehicle_id = ?;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, vehicleId);
            if (rowSet.next()) {
                vehicle = mapRowToVehicle(rowSet);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database", e);
        }

        return vehicle;
    }//completed

    @Override
    public List<Vehicle> getVehiclesByMake(String make) {
        List<Vehicle> returnedVehicles = new ArrayList<>();
        String sql = "select vehicle.vehicle_id, make, model, year, color, plate_number, mileage from vehicle\n" +
                "where make = ?;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, make);
            while (rowSet.next()) {
                Vehicle vehicle = mapRowToVehicle(rowSet);
                returnedVehicles.add(vehicle);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database", e);
        }

        return returnedVehicles;
    }//completed

    @Override
    public List<Vehicle> getVehiclesByModel(String model) {
        List<Vehicle> returnedVehicles = new ArrayList<>();
        String sql = "select vehicle.vehicle_id, make, model, year, color, plate_number, mileage from vehicle\n" +
                "where model = ?;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, model);
            while (rowSet.next()) {
                Vehicle vehicle = mapRowToVehicle(rowSet);
                returnedVehicles.add(vehicle);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database", e);
        }

        return returnedVehicles;
    }//completed

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {

    }
    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {

    }
    @Override
    public Vehicle deleteVehicleById(int vehicleId) {

    }

    public Vehicle mapRowToVehicle (SqlRowSet rowSet) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVehicleId(rowSet.getInt("vehicle_id"));
        newVehicle.setMake(rowSet.getString("make"));
        newVehicle.setModel(rowSet.getString("model"));
        newVehicle.setYear(rowSet.getString("year"));
        newVehicle.setColor(rowSet.getString("color"));
        newVehicle.setPlateNumber(rowSet.getString("plate_number"));
        newVehicle.setMileage(rowSet.getInt("mileage"));
        return newVehicle;
    }


}

package com.techelevator.dao;

import com.techelevator.model.Service;
import com.techelevator.security.exception.DaoException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcServiceDao implements ServiceDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcServiceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Service> getServices() {
        List<Service> returnedServices = new ArrayList<>();
        String sql = "select service_id, service_description, " +
                "service_category, service_price, service_time" +
                "from service;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while(rowSet.next()) {
                Service service = mapRowToService(rowSet);
                returnedServices.add(service);
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database", e);
        }

        return returnedServices;
    }//completed

    @Override
    public List<String> getServiceCategories() {
        List<String> serviceCategories = new ArrayList<>();
        String sql = "select service_description from service;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                String category = rowSet.getString("service_description");
                serviceCategories.add(category);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        }

        return serviceCategories;
    }//completed

    @Override
    public Service getServiceById(int serviceId) {
        Service returnedService = new Service();
        String sql = "select service_id, service_description, service_category, service_price, service_time\n" +
                "from service where service_id = ?;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, serviceId);
            if (rowSet.next()) {
                Service service = mapRowToService(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Cannot connect to server or database.", e);
        }

        return returnedService;
    }//completed

    @Override
    public Service createService(Service service) {

    }

    @Override
    public Service updateService(Service service) {

    }




    public Service mapRowToService (SqlRowSet rowSet) {
        Service service = new Service();
        service.setServiceID(rowSet.getInt("service_id"));
        service.setServiceDescription(rowSet.getString("service_description"));
        service.setCategory(rowSet.getString("service_category"));
        service.setPrice(rowSet.getDouble("service_price"));
        service.setServiceTime(rowSet.getDouble("service_time"));
        return service;
    }
}

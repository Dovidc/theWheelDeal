package com.techelevator.dao;

import com.techelevator.model.*;
import com.techelevator.security.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcWorkOrderDao implements WorkOrderDao {

    private static JdbcServiceDao jdbcServiceDao;
    private final JdbcTemplate jdbcTemplate;


    public JdbcWorkOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<WorkOrder> getWorkOrders() {
        List<WorkOrder> workOrders = new ArrayList<>(); // add badge to db schema and change method to update badge

        String sql = "select work_order.work_order_id, " +
                "work_order.vehicle_id, make, model, year, color, " +
                "time_adjustment, is_approved " +
                "from work_order " +
                "join vehicle on work_order.vehicle_id = vehicle.vehicle_id;";
        String sql2 = "select users.user_id, username, first_name, last_name, role\n" +
                "from users\n" +
                "join users_work_order on users.user_id = users_work_order.user_id\n" +
                "where work_order_id = ?; ";
        String sql3 = "select work_order_service_status.service_id, service_description, " +
                "service_category, service_price, service_time,\n" +
                "work_order_service_status_id, status_description\n" +
                "from work_order_service_status\n" +
                "join service on work_order_service_status.service_id = service.service_id\n" +
                "join status on work_order_service_status_id = status.status_id\n" +
                "where work_order_id = ?;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                WorkOrder workOrder = mapRowToWorkOrder(rowSet);

                SqlRowSet rowSet2 = jdbcTemplate.queryForRowSet(sql2,rowSet.getInt("work_order.work_order_id"));
                List<User> workOrderUsers = new ArrayList<>();
                while (rowSet2.next()) {
                    User newUser = mapRowToUser(rowSet2);
                    workOrderUsers.add(newUser);
                }
                workOrder.setUsers(workOrderUsers);

                SqlRowSet rowSet3 = jdbcTemplate.queryForRowSet(sql3, rowSet.getInt("work_order.work_order_id"));
                List<ServiceStatus> workOrderServiceStatuses = new ArrayList<>();
                while (rowSet3.next()) {
                    ServiceStatus serviceStatus = mapRowToServiceStatus(rowSet3);
                    workOrderServiceStatuses.add(serviceStatus);
                }
                workOrder.setServiceStatuses(workOrderServiceStatuses);

                workOrders.add(workOrder);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return workOrders;

    }//COMPLETED
    @Override
    public List<WorkOrder> getWorkOrdersByUserId (int userId) {
        List<WorkOrder> workOrders = new ArrayList<>(); // add badge to db schema and change method to update badge

        String sql = "select work_order.work_order_id, \n" +
                "work_order.vehicle_id, make, model, year, color, \n" +
                "time_adjustment, is_approved\n" +
                "from work_order\n" +
                "join vehicle on work_order.vehicle_id = vehicle.vehicle_id\n" +
                "join users_work_order on work_order.work_order_id = users_work_order.work_order_id\n" +
                "where users_work_order.user_id = ?;";
        String sql2 = "select users.user_id, username, first_name, last_name, role\n" +
                "from users\n" +
                "join users_work_order on users.user_id = users_work_order.user_id\n" +
                "where work_order_id = ?; ";
        String sql3 = "select work_order_service_status.service_id, service_description, " +
                "service_category, service_price, service_time,\n" +
                "work_order_service_status_id, status_description\n" +
                "from work_order_service_status\n" +
                "join service on work_order_service_status.service_id = service.service_id\n" +
                "join status on work_order_service_status_id = status.status_id\n" +
                "where work_order_id = ?;";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,userId);
            while (rowSet.next()) {
                WorkOrder workOrder = mapRowToWorkOrder(rowSet);

                SqlRowSet rowSet2 = jdbcTemplate.queryForRowSet(sql2, rowSet.getInt("work_order.work_order_id"));
                List<User> workOrderUsers = new ArrayList<>();
                while (rowSet2.next()) {
                    User newUser = mapRowToUser(rowSet2);
                    workOrderUsers.add(newUser);
                }
                workOrder.setUsers(workOrderUsers);

                SqlRowSet rowSet3 = jdbcTemplate.queryForRowSet(sql3, rowSet.getInt("work_order.work_order_id"));
                List<ServiceStatus> workOrderServiceStatuses = new ArrayList<>();
                while (rowSet3.next()) {
                    ServiceStatus serviceStatus = mapRowToServiceStatus(rowSet3);
                    workOrderServiceStatuses.add(serviceStatus);
                }
                workOrder.setServiceStatuses(workOrderServiceStatuses);

                workOrders.add(workOrder);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return workOrders;

    }//COMPLETED

    public WorkOrder getWorkOrderById(int workOrderId) {
        WorkOrder workOrder = new WorkOrder();
        String sql = "select work_order.work_order_id,\n" +
                "work_order.vehicle_id, make, model, year, color, \n" +
                "time_adjustment, is_approved\n" +
                "from work_order\n" +
                "join vehicle on work_order.vehicle_id = vehicle.vehicle_id\n" +
                "where work_order.work_order_id = ?;";
        String sql2 = "select users.user_id, username, first_name, last_name, role\n" +
                "from users\n" +
                "join users_work_order on users.user_id = users_work_order.user_id\n" +
                "where work_order_id = ?; ";
        String sql3 = "select work_order_service_status.service_id, service_description, " +
                "service_category, service_price, service_time,\n" +
                "work_order_service_status_id, status_description\n" +
                "from work_order_service_status\n" +
                "join service on work_order_service_status.service_id = service.service_id\n" +
                "join status on work_order_service_status_id = status.status_id\n" +
                "where work_order_id = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, workOrderId);
            if (rowSet.next()) {
                workOrder = mapRowToWorkOrder(rowSet);

                SqlRowSet rowSet2 = jdbcTemplate.queryForRowSet(sql2, workOrderId);
                List<User> workOrderUsers = new ArrayList<>();
                while (rowSet2.next()) {
                    User newUser = mapRowToUser(rowSet2);
                    workOrderUsers.add(newUser);
                }
                workOrder.setUsers(workOrderUsers);

                SqlRowSet rowSet3 = jdbcTemplate.queryForRowSet(sql3, workOrderId);
                List<ServiceStatus> workOrderServiceStatuses = new ArrayList<>();
                while (rowSet3.next()) {
                    ServiceStatus serviceStatus = mapRowToServiceStatus(rowSet3);
                    workOrderServiceStatuses.add(serviceStatus);
                }
                workOrder.setServiceStatuses(workOrderServiceStatuses);


            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return workOrder;
    }//COMPLETED




    @Override
    public WorkOrder createWorkOrder(WorkOrder workOrder) {
        WorkOrder newWorkOrder = null;
        String insertWorkOrderSql = "INSERT INTO work_order (vehicle_id, time_adjustment, is_approved) " +
                                    "VALUES (?, ?, ?) " +
                                    "RETURNING ";
        try {
            Integer newWorkOrderId = jdbcTemplate.queryForObject(insertWorkOrderSql, Integer.class, workOrder.getWorkOrderStatusTimeStamp(), workOrder.getTimeAdjustment(), workOrder.isApproved());
            newWorkOrder = getWorkOrderById(newWorkOrderId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return newWorkOrder;
    }

    @Override
    public WorkOrder updateWorkOrder(WorkOrder workOrder) {
        WorkOrder updatedWorkOrder = null;
        String sql = "UPDATE work_order " +
                     "SET vehicle_id = ?, time_adjustment = ?, is_approved = ? " +
                     "WHERE work_order_id = ?;";
        try {
            int numberOfRows = jdbcTemplate.update(sql, workOrder.getVehicle().getVehicleId(), workOrder.getTimeAdjustment(), workOrder.isApproved());

            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                updatedWorkOrder = getWorkOrderById(workOrder.getWorkOrderId());
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return updatedWorkOrder;
    }

    @Override
    public int deleteWorkOrderById(int workOrderId) {
        int numberOfRows = 0;
        /**
         * Need to input all sql queries where workOrderId exist.
         * Starting with the tables where workOrderId is PK
         * and finsihing with its origin table work_order.
         */

        return 0;
    }


    public static WorkOrder mapRowToWorkOrder(SqlRowSet rowSet) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setWorkOrderId(rowSet.getInt("work_order.work_order_id"));
        workOrder.setVehicle((mapRowToVehicle(rowSet)));
        workOrder.setTimeAdjustment(rowSet.getDouble("time_adjustment"));
        workOrder.setApproved(rowSet.getBoolean("is_approved"));
        return workOrder;
    }

    public static Vehicle mapRowToVehicle(SqlRowSet rowSet) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVehicleId(rowSet.getInt("work_order.vehicle_id"));
        newVehicle.setMake(rowSet.getString("make"));
        newVehicle.setModel(rowSet.getString("model"));
        newVehicle.setYear(rowSet.getString("year"));
        newVehicle.setColor(rowSet.getString("color"));
        return newVehicle;
    }

    public static User mapRowToUser(SqlRowSet rowSet) {
        User newUser = new User();
        newUser.setId(rowSet.getInt("user_id"));
        newUser.setUsername(rowSet.getString("username"));
        newUser.setFirstName(rowSet.getString("first_name"));
        newUser.setLastName(rowSet.getString("last_name"));
        newUser.setRole(rowSet.getString("role"));
        //add badge here
        return newUser;
    }

    private Status mapRowToStatus(SqlRowSet rowSet) {
        Status newStatus = new Status();
        newStatus.setStatusId(rowSet.getInt("work_order_service_status_id"));
        newStatus.setDescription(rowSet.getString("status_description"));
        return newStatus;
    }

    private ServiceStatus mapRowToServiceStatus (SqlRowSet rowSet) {
        ServiceStatus newServiceStatus = new ServiceStatus();
        newServiceStatus.setService(jdbcServiceDao.mapRowToService(rowSet));
        newServiceStatus.setStatus(mapRowToStatus(rowSet));
        return newServiceStatus;
    }




}

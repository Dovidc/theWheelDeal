package com.techelevator.dao;

import com.techelevator.model.*;
import com.techelevator.security.exception.DaoException;
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

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                WorkOrder workOrder = mapRowToWorkOrder(rowSet); // less vehicle & less user

                SqlRowSet rowSet2 = jdbcTemplate.queryForRowSet(sql2,rowSet.getInt("work_order.work_order_id"));
                List<User> workOrderUsers = new ArrayList<>();
                while (rowSet2.next()) {
                    User newUser = mapRowToUser(rowSet2);
                    workOrderUsers.add(newUser);
                }
                workOrder.setUsers(workOrderUsers);
                workOrders.add(workOrder);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return workOrders;

    }//completed
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

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,userId);
            while (rowSet.next()) {
                WorkOrder workOrder = mapRowToWorkOrder(rowSet); // less vehicle & less user

                SqlRowSet rowSet2 = jdbcTemplate.queryForRowSet(sql2, rowSet.getInt("work_order.work_order_id"));
                List<User> workOrderUsers = new ArrayList<>();
                while (rowSet2.next()) {
                    User newUser = mapRowToUser(rowSet2);
                    workOrderUsers.add(newUser);
                }
                workOrder.setUsers(workOrderUsers);
                workOrders.add(workOrder);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return workOrders;

    }//completed

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
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return workOrder;
    }//completed




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


    private WorkOrder mapRowToWorkOrder(SqlRowSet rowSet) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setWorkOrderId(rowSet.getInt("work_order.work_order_id"));
        workOrder.setVehicle((mapRowToVehicle(rowSet)));
        workOrder.setTimeAdjustment(rowSet.getDouble("time_adjustment"));
        workOrder.setApproved(rowSet.getBoolean("is_approved"));
        return workOrder;
    }

    private Vehicle mapRowToVehicle(SqlRowSet rowSet) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVehicleId(rowSet.getInt("work_order.vehicle_id"));
        newVehicle.setMake(rowSet.getString("make"));
        newVehicle.setModel(rowSet.getString("model"));
        newVehicle.setYear(rowSet.getString("year"));
        newVehicle.setColor(rowSet.getString("color"));
        return newVehicle;
    }

    private static User mapRowToUser(SqlRowSet rowSet) {
        User newUser = new User();
        newUser.setId(rowSet.getInt("user_id"));
        newUser.setUsername(rowSet.getString("username"));
        newUser.setFirstName(rowSet.getString("first_name"));
        newUser.setLastName(rowSet.getString("last_name"));
        newUser.setRole(rowSet.getString("role"));
        //add badge here
        return newUser;
    }




}

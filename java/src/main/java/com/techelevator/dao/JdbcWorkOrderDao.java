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
    public WorkOrder getWorkOrderById(int workOrderId) {
        WorkOrder workOrder = null;
        String sql = "SELECT work_order_id, vehicle_id, time_adjustment, is_approved " +
                     "FROM work_order " +
                     "WHERE work_order_id =?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, workOrder);
            if (results.next()) {
                workOrder = mapRowToWorkOrder(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return workOrder;
    }
    @Override
    public List<WorkOrder> getWorkOrders() {
        List<WorkOrder> workOrders = new ArrayList<>();
        String sql = "SELECT work_order_id, vehicle_id, time_adjustment, is_approved " +
                     "FROM work_order";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                WorkOrder workOrder = mapRowToWorkOrder(results);
                workOrders.add(workOrder);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return workOrders;
    }



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

    /**
     * Need to start thinking about how to link tables For example
     *
     *  public void userWorkOrder(int workOrderId, int userId) {
     *         String sql = "INSERT INTO users_work_order (workOrderId, userId) VALUES (?, ?);";
     *         try {
     *             jdbcTemplate.update(sql, workOrderId, userId);
     *         } catch (CannotGetJdbcConnectionException e) {
     *             throw new DaoException("Unable to connect to server or database", e);
     *         } catch (DataIntegrityViolationException e) {
     *             throw new DaoException("Data integrity violation", e);
     *         }
     *     }
     */

    private WorkOrder mapRowToWorkOrder(SqlRowSet rs) {
        WorkOrder workOrder = new WorkOrder();
        workOrder.setWorkOrderId(rs.getInt("work_order_id"));
        workOrder.setVehicle((Vehicle)rs.getObject("vehicle_id"));
        workOrder.setUser((User) rs.getObject("user_id"));
        workOrder.setTimeAdjustment(rs.getDouble("time_adjustment"));
        workOrder.setApproved(true);
        return workOrder;
    }
}

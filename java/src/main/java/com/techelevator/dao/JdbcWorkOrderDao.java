package com.techelevator.dao;

import com.techelevator.model.Service;
import com.techelevator.model.Status;
import com.techelevator.model.User;
import com.techelevator.model.WorkOrder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class JdbcWorkOrderDao implements WorkOrderDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcWorkOrderDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public WorkOrder getWorkOrderById(int workOrderId) {
        WorkOrder workOrder = null;
        String sql = "SELECT work_order_id " +
                "FROM workOrder" +
                "WHERE work_order_id = ?";
        return null;
    }

    @Override
    public List<WorkOrder> getWorkOrderByUser(String username) {
        return null;
    }

    @Override
    public List<Service> getListOfServices(String serviceDescription) {
        return null;
    }

    @Override
    public List<Status> getListOfStatuses() {
        return null;
    }

    @Override
    public WorkOrder createWorkOrder(WorkOrder workOrder) {
        return null;
    }

    @Override
    public WorkOrder updateWorkOrder(WorkOrder workOrder) {
        return null;
    }

    @Override
    public int deleteWorkOrderById(int workOrderId) {
        return 0;
    }
}

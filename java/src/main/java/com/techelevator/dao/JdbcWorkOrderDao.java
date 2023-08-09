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
        return null;
    }

    @Override
    public List<WorkOrder> getWorkOrderByUser(User user) {
        return null;
    }

    @Override
    public List<Service> getListOfServices(int serviceId) {
        return null;
    }

    @Override
    public List<Status> getListOfStatuses(int statusId) {
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

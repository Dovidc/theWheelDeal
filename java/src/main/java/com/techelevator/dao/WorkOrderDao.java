package com.techelevator.dao;

import com.techelevator.model.Service;
import com.techelevator.model.Status;
import com.techelevator.model.User;
import com.techelevator.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface WorkOrderDao {

    /**
     * Get a workOrder from the datastore that has a given id
     * if not return null?
     */
    WorkOrder getWorkOrderById(int workOrderId);

    List<WorkOrder> getWorkOrderByUser(String username);

    List<Service> getListOfServices(String serviceDescription);

    List<Status> getListOfStatuses();


    WorkOrder createWorkOrder(WorkOrder workOrder);

    WorkOrder updateWorkOrder (WorkOrder workOrder);

    int deleteWorkOrderById(int workOrderId);




}

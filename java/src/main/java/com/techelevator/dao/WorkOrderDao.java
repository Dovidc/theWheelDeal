package com.techelevator.dao;

import com.techelevator.model.Service;
import com.techelevator.model.Status;
import com.techelevator.model.User;
import com.techelevator.model.WorkOrder;

import java.util.List;

public interface WorkOrderDao {

    /**
     * Get a workOrder from the datastore that has a given id
     * if not return null?
     */
    WorkOrder getWorkOrderById(int workOrderId);

    List<WorkOrder> getWorkOrderByUser(User user);

    List<Service> getListOfServices(int serviceId);

    List<Status> getListOfStatuses(int statusId);


    WorkOrder createWorkOrder(WorkOrder workOrder);

    WorkOrder updateWorkOrder (WorkOrder workOrder);

    int deleteWorkOrderById(int workOrderId);




}

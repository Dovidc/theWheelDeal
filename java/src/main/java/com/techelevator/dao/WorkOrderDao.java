package com.techelevator.dao;

import com.techelevator.model.Service;
import com.techelevator.model.Status;
import com.techelevator.model.User;
import com.techelevator.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface WorkOrderDao {


    List<WorkOrder> getWorkOrders();

    List<WorkOrder> getWorkOrdersByUserId(int userId);

    WorkOrder getWorkOrderById(int workOrderId);

    WorkOrder createWorkOrder(WorkOrder workOrder);

    WorkOrder updateWorkOrder (WorkOrder workOrder);

    int deleteWorkOrderById(int workOrderId);




}

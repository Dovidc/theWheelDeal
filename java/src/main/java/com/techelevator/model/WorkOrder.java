package com.techelevator.model;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotNull;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.List;

public class WorkOrder {

    @NotNull
    private int workOrderId;

    private Vehicle vehicle;

    private User user;

    private double timeAdjustment;

    private boolean isApproved = false;

    private LocalDate workOrderStatusTimeStamp;

    private List<Service> listOfWorkOrderServices;

    private List<Status> workOrderStatusList;

    public WorkOrder() {
    }

    public WorkOrder(int workOrderId, Vehicle vehicle, User user, double timeAdjustment, boolean isApproved, LocalDate workOrderStatusTimeStamp, List<Service> listOfWorkOrderServices, List<Status> workOrderStatusList) {
        this.workOrderId = workOrderId;
        this.vehicle = vehicle;
        this.user = user;
        this.timeAdjustment = timeAdjustment;
        this.isApproved = isApproved;
        this.workOrderStatusTimeStamp = workOrderStatusTimeStamp;
        this.listOfWorkOrderServices = listOfWorkOrderServices;
        this.workOrderStatusList = workOrderStatusList;
    }

    public int getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTimeAdjustment() {
        return timeAdjustment;
    }

    public void setTimeAdjustment(double timeAdjustment) {
        this.timeAdjustment = timeAdjustment;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public LocalDate getWorkOrderStatusTimeStamp() {
        return workOrderStatusTimeStamp;
    }

    public void setWorkOrderStatusTimeStamp(LocalDate workOrderStatusTimeStamp) {
        this.workOrderStatusTimeStamp = workOrderStatusTimeStamp;
    }

    public List<Service> getListOfWorkOrderServices() {
        return listOfWorkOrderServices;
    }

    public void setListOfWorkOrderServices(List<Service> listOfWorkOrderServices) {
        this.listOfWorkOrderServices = listOfWorkOrderServices;
    }

    public List<Status> getWorkOrderStatusList() {
        return workOrderStatusList;
    }

    public void setWorkOrderStatusList(List<Status> workOrderStatusList) {
        this.workOrderStatusList = workOrderStatusList;
    }
}
package com.techelevator.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Invoice {
    @NotNull
    private int invoiceID;
    @AssertTrue
    private User user;
    private WorkOrder workOrder;

    private List<Service> services;
    private boolean isPaid = false;

    @AssertTrue
    private boolean isListGreaterThanZero() {
        return services.size() >= 1;
    }

    @AssertTrue
    private boolean isUserCustomer() {
        return user.getRole().equals("Customer");
    }

    public Invoice(int invoiceID, User user, WorkOrder workOrder, List<Service> services, boolean isPaid) {
        this.invoiceID = invoiceID;
        this.user = user;
        this.workOrder = workOrder;
        this.services = services;
        this.isPaid = isPaid;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public WorkOrder getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(WorkOrder workOrder) {
        this.workOrder = workOrder;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}


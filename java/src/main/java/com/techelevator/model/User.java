package com.techelevator.model;

import org.springframework.data.relational.core.sql.In;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class User {
    @NotNull
    private int userId;
    @NotNull
    @NotBlank(message =  "Username is required")
    private String username;
    @NotNull
    @NotBlank(message =  "First name is required")
    private String firstName;
    @NotNull
    @NotBlank(message =  "Last name is required")
    private String lastName;

    private long passwordHash;
    @NotNull
    @NotBlank(message = "Email address is required")
    private String email;
    @NotNull
    private String role;
    @NotNull
    @NotBlank(message = "Phone Number is required")
    private String phoneNumber;

    private List<Vehicle> vehicle;
    private List<WorkOrder> workOrder;
    private List<Invoice> invoice;

    public User() {
    }

    private String fullName() {
        return firstName + " " + lastName ;
    }

    public User(int userId, String username, String firstName, String lastName, long passwordHash, String email, String role, String phoneNumber,List<Vehicle> vehicle, List<WorkOrder> workOrder, List<Invoice> invoice) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
        this.email = email;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.vehicle = vehicle;
        this.workOrder = workOrder;
        this.invoice = invoice;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(long passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public List<WorkOrder> getWorkOrder() {
        return workOrder;
    }

    public void setWorkOrder(List<WorkOrder> workOrder) {
        this.workOrder = workOrder;
    }

    public List<Invoice> getInvoice() {
        return invoice;
    }

    public void setInvoice(List<Invoice> invoice) {
        this.invoice = invoice;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

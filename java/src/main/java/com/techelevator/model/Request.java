package com.techelevator.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Request {
    private int requestId;
    private List<> serviceList;
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email;
    
    private Double estimate;
    private Date dropOff;
    private boolean isApproved;

}

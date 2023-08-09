package com.techelevator.dao;

import com.techelevator.model.Service;

import java.util.List;

public interface ServiceDao {

    List<Service> getServices();

    Service getServiceDescriptionById(int serviceId);


    Service createService(Service service);

    Service updateService(Service service);

    int deleteServiceById(int serviceId);
}

package com.techelevator.dao;

import com.techelevator.model.Service;

import java.util.List;

public interface ServiceDao {

    Service getServiceDescriptionById(int serviceId);

    List<Service> getServices();

    Service createService(Service service);

    Service updateService(Service service);
    int deleteServiceById(int serviceId);
}

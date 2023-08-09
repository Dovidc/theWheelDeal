package com.techelevator.dao;

import com.techelevator.model.Service;

public interface ServiceDao {

    Service getServiceDescriptionById(int serviceId);

    Service getPriceById(int serviceId);

    Service getServiceTimeById(int serviceId);

    Service createService(Service service);

    Service updateService(Service service);
    int deleteServiceById(int serviceId);
}

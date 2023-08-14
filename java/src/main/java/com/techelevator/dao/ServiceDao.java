package com.techelevator.dao;

import com.techelevator.model.Service;
import com.techelevator.model.ServiceDto;

import java.util.List;

public interface ServiceDao {

    List<Service> getServices();

    List<String> getServiceCategories();

    Service getServiceById(int serviceId);
    Service createService(ServiceDto serviceDto);

    Service updateService(Service service);


}

package com.example;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController {
    private static final Logger log = LoggerFactory.getLogger(VehicleController.class);
//    List<VehicleDetails> details;

    private final VehicleService vehicleService;
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @RequestMapping(value="/customer/{cid}/vehicledetails", method=RequestMethod.GET)
	public VehicleDetails getCustomerVehicleDetails(@PathVariable String cid) {
        log.info("Got a vehicledetails request");
		return vehicleService.getCustomerVehicleDetails(cid);
	}
    
}

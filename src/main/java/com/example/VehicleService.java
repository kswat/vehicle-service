package com.example;

import io.micrometer.observation.annotation.Observed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService {
    private static final Logger log = LoggerFactory.getLogger(VehicleService.class);
    List<VehicleDetails> details;

    public VehicleService() {

        details = new ArrayList<VehicleDetails>();
        details.add(new VehicleDetails("500", "Lincoln Contential", "SNUG30"));
        details.add(new VehicleDetails("501", "Chevrolet Camaro", "SNUG30"));
        details.add(new VehicleDetails("502", "Porsche Taycan", "GGLR20"));

    }

    @Observed(name="user.vehicle", contextualName = "getting Vehicle details")
	public VehicleDetails getCustomerVehicleDetails( String cid) {

		return details.stream().filter(detail -> cid.equals(detail.getCustomerId())).findAny().orElse(null);   
	}
    
}

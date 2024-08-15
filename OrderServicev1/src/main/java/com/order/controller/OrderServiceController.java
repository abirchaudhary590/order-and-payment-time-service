package com.order.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.order.dto.OrderServiceDto;
import com.order.dto.ResponseDto;
import com.order.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderServiceController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	Logger logger = LoggerFactory.getLogger(OrderServiceController.class);
	
	@PostMapping(value = "/createOrder")
	public ResponseDto createOrder (@RequestBody OrderServiceDto request){
		
		logger.info("incoming request", request);
		
		ResponseDto response = new ResponseDto();
		
		if (request.getCustomerName() == null || request.getCustomerName().isEmpty()) {
			response.setResponseCode("0001");
			response.setResponseMessage("missing field!");
			response.setPayload(null);
			return response;
		}
		
		try {
			
			
			response = orderService.createOrder(request);
			if (response != null) {
				logger.info("Order created successfully");
				
				request.setStatus("PROCESSING");
				
				logger.info("Processing Order");
				
				response = orderService.createOrder(request);
				
				logger.info("Connecting to paymentservice to get payment status");
				String status = restTemplate.getForObject("http://localhost:8080/payments/process", String.class);
				
				logger.info("Payment status is::" +status);
				request.setStatus(status);
				response = orderService.createOrder(request);
				
				logger.info("Final response::" +response);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return response;
	}

}

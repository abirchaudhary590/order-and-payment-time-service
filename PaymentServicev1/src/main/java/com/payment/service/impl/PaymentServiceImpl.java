package com.payment.service.impl;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.payment.service.PaymentService;



@Component
public class PaymentServiceImpl implements PaymentService {

	@Override	
	public String getStatus() {

		int currentMinute = LocalTime.now().getMinute();
		if (currentMinute % 2 == 0) {
			return "SUCCESS";
		} else {
			return "FAILURE";
		}

	}

}

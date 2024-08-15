package com.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.order.dao.OrderServiceDao;
import com.order.dto.OrderServiceDto;
import com.order.dto.ResponseDto;
import com.order.entity.OrderEntity;
import com.order.service.OrderService;
import com.order.util.ConversionUtility;

@Component
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderServiceDao orderServiceDao;
	
//	private ConversionUtility utility;
	
	@Override
	public ResponseDto createOrder(OrderServiceDto dto) {
		// TODO Auto-generated method stub
		ResponseDto responseDto = new ResponseDto();
		try {
			responseDto = insertRecord(dto);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return responseDto;
	}

	private ResponseDto insertRecord(OrderServiceDto dto) {
		// TODO Auto-generated method stub
		ResponseDto responseDto = new ResponseDto();

		OrderEntity entity = orderServiceDao.insertPayload(dto);

		if (entity != null) {
			responseDto.setPayload(entity);
			responseDto.setResponseCode("0000");
			responseDto.setResponseMessage("Data uploaded succesfully");
		}
		return responseDto;
	}

}

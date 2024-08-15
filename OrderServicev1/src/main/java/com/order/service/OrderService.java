package com.order.service;

import com.order.dto.OrderServiceDto;
import com.order.dto.ResponseDto;

public interface OrderService {

	public ResponseDto createOrder(OrderServiceDto dto);
}

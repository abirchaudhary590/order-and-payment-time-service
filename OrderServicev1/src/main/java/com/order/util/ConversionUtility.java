package com.order.util;

import com.order.dto.OrderServiceDto;
import com.order.entity.OrderEntity;

public class ConversionUtility {

	public static OrderEntity convertDtoToEntity(OrderServiceDto dto) {

		OrderEntity entity = new OrderEntity();

		entity.setCustomerName(dto.getCustomerName());
		entity.setStatus(dto.getStatus());
		entity.setAmount(dto.getAmount());

		return entity;

	}
}

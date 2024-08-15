package com.order.dao;

import com.order.dto.OrderServiceDto;
import com.order.entity.OrderEntity;

public interface OrderServiceDao {

	OrderEntity insertPayload(OrderServiceDto req);
	
}

package com.order.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.order.dao.OrderServiceDao;
import com.order.dto.OrderServiceDto;
import com.order.entity.OrderEntity;
import com.order.exception.DbTransactionException;
import com.order.repository.OrderRepository;
import com.order.util.ConversionUtility;


@Component
public class OrderServiceDaoImpl implements OrderServiceDao{

	@Autowired
	private OrderRepository orderRepository;


	@Override
	public OrderEntity insertPayload(OrderServiceDto req) {
		OrderEntity entity;

		try {
			entity = ConversionUtility.convertDtoToEntity(req);
			entity = orderRepository.save(entity);
			
		} catch (DbTransactionException e) {
			throw new DbTransactionException();
		}
		return entity;
	}
}

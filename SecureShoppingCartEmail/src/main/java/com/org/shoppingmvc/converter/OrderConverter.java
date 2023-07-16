/*
 * package com.org.shopping.converter;
 * 
 * import org.modelmapper.ModelMapper; import
 * org.springframework.stereotype.Component;
 * 
 * import com.org.shopping.dto.OrderDto; import
 * com.org.shopping.entity.Order;
 * 
 * @Component public class OrderConverter { public OrderDto entityToDto(Order
 * order) { ModelMapper mapper = new ModelMapper(); return mapper.map(order,
 * OrderDto.class); }
 * 
 * public Order dtoToEntity(OrderDto orderDto) { ModelMapper mapper = new
 * ModelMapper(); return mapper.map(orderDto, Order.class);
 * 
 * } }
 */
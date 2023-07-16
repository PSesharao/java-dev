package com.mindtree.shopping.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mindtree.shopping.dto.OrderDto;
import com.mindtree.shopping.embed.ProductInfo;
import com.mindtree.shopping.entity.Customer;
import com.mindtree.shopping.entity.Order;
import com.mindtree.shopping.exception.serviceexception.OrderServiceException;
import com.mindtree.shopping.repository.CustomerRepository;
import com.mindtree.shopping.repository.OrderRepository;

@SpringBootTest
class OrderServiceTest {

	@MockBean
	private OrderRepository orderRepository;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void testCreateOrder() throws OrderServiceException {
		OrderDto orderDto = new OrderDto();
		orderDto.setCustomer_Id(000000);
		List<ProductInfo> productList = new ArrayList<>();
		ProductInfo product1 = new ProductInfo();
		product1.setProductId(00);
		product1.setQuantity(5);
		ProductInfo product2 = new ProductInfo();
		product2.setProductId(0);
		product2.setQuantity(10);
		productList.add(product1);
		productList.add(product2);
		orderDto.setProductList(productList);
		Optional<Customer> customer = Optional.of(new Customer());
		customer.get().setName("mockName");
		customer.get().setPhoneNumber("mockPhoneNumber");
		customer.get().setOrderList(new ArrayList<Order>());
		doReturn(customer).when(customerRepository).findById((long) 000000);
		Optional<Customer> customerExpected = customerRepository.findById(orderDto.getCustomer_Id());
		Assertions.assertEquals(customerExpected, customer, "The expected customer is different");
		
		
		Optional<Order>  order = Optional.of(new Order());
		order.get().setCustomer(customer.get());
		order.get().setProductList(orderDto.getProductList());
		customer.get().getOrderList().add(order.get());
		
		doReturn(order.get()).when(orderRepository).save(order.get());
		
		Optional<Order>  ExpectedOrder = Optional.of(orderRepository.save(order.get()));
		
		Assertions.assertEquals(ExpectedOrder, order, "The expected order is different");
		
	}
}

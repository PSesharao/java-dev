package com.mindtree.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shopping.dto.OrderDto;
import com.mindtree.shopping.embed.ProductInfo;
import com.mindtree.shopping.entity.Customer;
import com.mindtree.shopping.entity.Order;
import com.mindtree.shopping.entity.Product;
import com.mindtree.shopping.exception.daoexception.ResourceNotFoundException;
import com.mindtree.shopping.exception.serviceexception.OrderServiceException;
import com.mindtree.shopping.repository.CustomerRepository;
import com.mindtree.shopping.repository.OrderRepository;
import com.mindtree.shopping.repository.ProductRepository;
import com.mindtree.shopping.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Order createOrder(OrderDto orderDto) throws OrderServiceException {
		Customer customer = null;
		try {
			customer = customerRepository.findById(orderDto.getCustomer_Id()).orElseThrow(
					() -> new ResourceNotFoundException("No customer found with id :" + orderDto.getCustomer_Id()));
		} catch (ResourceNotFoundException e) {
			throw new OrderServiceException(e.getLocalizedMessage());
		}
		Order order = new Order();
		order.setCustomer(customer);
		order.setProductList(orderDto.getProductList());
		
		double orderCost = 0;
		for (ProductInfo productOrderd : orderDto.getProductList()) {
			Product product = null;
			try {
				product = productRepository.findById(productOrderd.getProductId())
						.orElseThrow(() -> new ResourceNotFoundException(
								"No product found with product Id " + productOrderd.getProductId()));
			} catch (ResourceNotFoundException e) {
				throw new OrderServiceException(e.getLocalizedMessage());
			}
			int quantity = productOrderd.getQuantity();
			orderCost += quantity * product.getPrice();
		}
		order.setOrdercost(orderCost);
		customer.getOrderList().add(order);
		return orderRepository.save(order);
	}

}

package com.mindtree.shoppingmvc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shoppingmvc.dto.OrderDto;
import com.mindtree.shoppingmvc.entity.Customer;
import com.mindtree.shoppingmvc.entity.Order;
import com.mindtree.shoppingmvc.entity.Product;
import com.mindtree.shoppingmvc.repository.CustomerRepository;
import com.mindtree.shoppingmvc.repository.OrderRepository;
import com.mindtree.shoppingmvc.repository.ProductRepository;
import com.mindtree.shoppingmvc.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Order placeOrder(OrderDto orderDto) {
		Customer customer = customerRepository.findById(orderDto.getCustomer()).orElse(null);
		//List<Product> products = new ArrayList<>();
		Order order = new Order();
		order.setOrderDate(orderDto.getOrderDate());
		order.setProductList(new ArrayList<Product>());
		order.setCustomer(customer);
		customer.getOrderList().add(order);
		double orderCost =0;
		for(Long productId : orderDto.getCartList())
		{
			Product product =productRepository.findById(productId).get();
			order.getProductList().add(product);
			product.getOrderList().add(order);
			orderCost+=product.getPrice();
			//products.add(product);
		}
		order.setOrdercost(orderCost);	
		
		return orderRepository.save(order);
	}

}

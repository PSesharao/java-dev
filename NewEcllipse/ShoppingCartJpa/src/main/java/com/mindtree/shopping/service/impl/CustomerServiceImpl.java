package com.mindtree.shopping.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.shopping.converter.CustomerConverter;
import com.mindtree.shopping.converter.ProductConverter;
import com.mindtree.shopping.dto.CustomerDto;
import com.mindtree.shopping.embed.ProductInfo;
import com.mindtree.shopping.entity.Customer;
import com.mindtree.shopping.entity.Order;
import com.mindtree.shopping.entity.Product;
import com.mindtree.shopping.exception.daoexception.ResourceNotFoundException;
import com.mindtree.shopping.exception.serviceexception.CustomerServiceException;
import com.mindtree.shopping.repository.CustomerRepository;
import com.mindtree.shopping.repository.ProductRepository;
import com.mindtree.shopping.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerConverter customerConverter;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public Customer createCustomer(CustomerDto customerDto) throws CustomerServiceException {

		return customerRepository.save(customerConverter.dtoToEntity(customerDto));
	}

	@Override
	public List<Map<String, Object>> getCustomerInfo(String phoneNumber) throws CustomerServiceException {
		Customer customer = null;
		try {
			customer = customerRepository.findByPhoneNumber(phoneNumber)
					.orElseThrow(() -> new ResourceNotFoundException("No customer found with phone number " + phoneNumber));
		} catch (ResourceNotFoundException e) {
			
			throw new CustomerServiceException(e.getLocalizedMessage());
		}

		List<Map<String, Object>> allOrderinfo = new ArrayList<>();
		int totalOrderCost = 0;
		for (Order order : customer.getOrderList()) {
			Map<String, Object> orderInfo = new LinkedHashMap<>();
			
			List<Map<String, Object>> allProductInfo = new ArrayList<>();
			for (ProductInfo productOrderd : order.getProductList()) {
				Map<String, Object> productInfo = new LinkedHashMap<>();
				Product product = null;
				try {
					product = productRepository.findById(productOrderd.getProductId()).orElseThrow(() -> new ResourceNotFoundException("No product found with product Id " + productOrderd.getProductId()));
				} catch (ResourceNotFoundException e) {
					throw new CustomerServiceException(e.getLocalizedMessage());
				}
				int quantity = productOrderd.getQuantity();
				productInfo.put("product", productConverter.entityToDto(product));
				productInfo.put("quantity", quantity);
				productInfo.put("productCost", quantity * product.getPrice());
				
				allProductInfo.add(productInfo);
			}
			totalOrderCost += order.getOrdercost();
			orderInfo.put("orderDetails", allProductInfo);
			orderInfo.put("OrderCost", order.getOrdercost());
			allOrderinfo.add(orderInfo);
		}

		Map<String, Object> totalOrderCostInfo = new HashMap<>();
		totalOrderCostInfo.put("totalOrderCost", totalOrderCost);
		allOrderinfo.add(totalOrderCostInfo);

		return allOrderinfo;
	}

}

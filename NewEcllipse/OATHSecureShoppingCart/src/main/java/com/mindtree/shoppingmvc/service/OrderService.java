package com.mindtree.shoppingmvc.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.mindtree.shoppingmvc.dto.OrderDto;
import com.mindtree.shoppingmvc.entity.Order;

public interface OrderService {
	Order placeOrder(OrderDto orderDto);
	void sendMail(Order order) throws AddressException, MessagingException, IOException ;
}

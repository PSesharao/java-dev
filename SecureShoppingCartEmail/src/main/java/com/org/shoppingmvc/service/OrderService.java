package com.org.shoppingmvc.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.org.shoppingmvc.dto.OrderDto;
import com.org.shoppingmvc.entity.Order;

public interface OrderService {
	Order placeOrder(OrderDto orderDto);
	void sendMail(Order order) throws AddressException, MessagingException, IOException ;
}

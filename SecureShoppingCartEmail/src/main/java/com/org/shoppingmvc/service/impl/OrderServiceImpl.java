package com.org.shoppingmvc.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.shoppingmvc.dto.OrderDto;
import com.org.shoppingmvc.entity.Customer;
import com.org.shoppingmvc.entity.Order;
import com.org.shoppingmvc.entity.Product;
import com.org.shoppingmvc.repository.CustomerRepository;
import com.org.shoppingmvc.repository.OrderRepository;
import com.org.shoppingmvc.repository.ProductRepository;
import com.org.shoppingmvc.service.OrderService;

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
		// List<Product> products = new ArrayList<>();
		Order order = new Order();
		order.setOrderDate(orderDto.getOrderDate());
		order.setProductList(new ArrayList<Product>());
		order.setCustomer(customer);
		customer.getOrderList().add(order);
		double orderCost = 0;
		for (Long productId : orderDto.getCartList()) {
			Product product = productRepository.findById(productId).get();
			order.getProductList().add(product);
			product.getOrderList().add(order);
			orderCost += product.getPrice();
			// products.add(product);
		}
		order.setOrdercost(orderCost);

		return orderRepository.save(order);
	}
	

	@Override
	public void sendMail(Order order) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("seshuzoomin@gmail.com", "Nine963263756");
				// return new PasswordAuthentication("16kq1a05b2@pace.ac.in", "9963263756");
			}
		});

		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("seshuzoomin@gmail.com", false));
		msg.setSentDate(new Date());
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(order.getCustomer().getEmail()));
		msg.setSubject("Your Order Is Confirmed!!");

		
		Multipart multipart = new MimeMultipart();
		
		
		
		
		MimeBodyPart messageBodyPart1 = new MimeBodyPart();
		messageBodyPart1.setContent("<h2>"+"The order details "+"<h2>"+"\n","text/html");
		multipart.addBodyPart(messageBodyPart1);
		for(Product product : order.getProductList())
		{
			
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("\n"+"<b>"+product.getName()+"<b>"+"   "+"<b>Rs."+product.getPrice()+"<b>"+"/-","text/html");
			multipart.addBodyPart(messageBodyPart);
			MimeBodyPart attachPart = new MimeBodyPart();
			attachPart.attachFile(
					  "D:\\NewEcllipse\\SecureShoppingCartEmail\\uploads\\" +
							  
							  product.getImage());
			multipart.addBodyPart(attachPart);
		}
		
		MimeBodyPart messageBodyPart2= new MimeBodyPart();
		messageBodyPart2.setContent("\n"+"<h2>"+"Your order is arriving on "+order.getOrderDate() +" with total order cost"+ order.getOrdercost()+" to your shipping address " + order.getCustomer().getAddress()+"<h2>","text/html");
		multipart.addBodyPart(messageBodyPart2);
		
		/*
		 * MimeBodyPart messageBodyPart = new MimeBodyPart();
		 * messageBodyPart.setContent("Sample Content","text/html");
		 * multipart.addBodyPart(messageBodyPart);
		 */
		msg.setContent(multipart);
		Transport.send(msg);
	}

}

package com.mindtree.shoppingmvc.service.impl;

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
		

		//msg.setContent("Merry Christmas and Happy New Year Sesharao", "text/html");
		//msg.setSentDate(new Date());

		
		//messageBodyPart.setContent("Merry Christmas and Happy New Year Sesharao,and all the best", "text/html");
		//messageBodyPart.setContent("Looking foreward", "text/html");
		
		//multipart.addBodyPart(messageBodyPart);
		

		/*
		 * attachPart.attachFile("C:\\Users\\RR COMPUTERS\\Desktop\\profilepic.jpg");
		 * multipart.addBodyPart(attachPart);
		 */

		
		  int size = order.getProductList().size(); 
		 
		  
		  for(int i=0;i<size;i++) 
		  { 
			  Message msg= new MimeMessage(session);
			  msg.setFrom(new InternetAddress("seshuzoomin@gmail.com", false));

			  msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(order.getCustomer().getEmail()));
			  msg.setSubject("Your Order Is Confirmed!!");
			  MimeBodyPart messageBodyPart = new MimeBodyPart();  
			  Multipart multipart = new MimeMultipart();
			  MimeBodyPart attachPart = new MimeBodyPart();
		  messageBodyPart.setContent(order.getProductList().get(i).getName()+" "+order.getProductList().get(i).getPrice(), "text/html");
		  multipart.addBodyPart(messageBodyPart); 
		  attachPart.attachFile("D:\\NewEcllipse\\SecureShoppingCart\\uploads\\"+order.getProductList().get(i).getImage());
		  multipart.addBodyPart(attachPart);
		  msg.setContent(multipart); 
		  Transport.send(msg);

		  }
		 
		  Message msg= new MimeMessage(session);
		  msg.setFrom(new InternetAddress("seshuzoomin@gmail.com", false));

		  msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(order.getCustomer().getEmail()));
		  msg.setSubject("Your Order Is Confirmed!!");
		  MimeBodyPart messageBodyPart = new MimeBodyPart();  
		  Multipart multipart = new MimeMultipart();
		  messageBodyPart.setContent("Your order is arriving on " +order.getOrderDate() +" with total order cost " +order.getOrdercost() +" to your shipping address "+order.getCustomer().getAddress() , "text/html");
		  multipart.addBodyPart(messageBodyPart); 
		  msg.setContent(multipart); 
		  Transport.send(msg);
	}

}

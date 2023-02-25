package com.caiopivetta6;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.Address;
import com.caiopivetta6.domain.CardPayment;
import com.caiopivetta6.domain.Category;
import com.caiopivetta6.domain.City;
import com.caiopivetta6.domain.Client;
import com.caiopivetta6.domain.Order;
import com.caiopivetta6.domain.OrderItem;
import com.caiopivetta6.domain.Payment;
import com.caiopivetta6.domain.Product;
import com.caiopivetta6.domain.State;
import com.caiopivetta6.domain.enums.StatePayment;
import com.caiopivetta6.repositories.AddressRepository;
import com.caiopivetta6.repositories.CategoryRepository;
import com.caiopivetta6.repositories.CityRepository;
import com.caiopivetta6.repositories.ClientRepository;
import com.caiopivetta6.repositories.OrderItemRepository;
import com.caiopivetta6.repositories.OrderRepository;
import com.caiopivetta6.repositories.PaymentRepository;
import com.caiopivetta6.repositories.ProductRepository;
import com.caiopivetta6.repositories.StateRepository;

@SpringBootApplication
public class Ecommerce3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Ecommerce3Application.class, args);
	}
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository itemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	
	
	@Override
	public void run(String... args) throws Exception, ParseException {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//STATE AND CITY
		State state = new State(null, "Veneto");
		City city = new City(null, "Verona");
		
		state.getCities().add(city);
		city.setState(state);
		
		stateRepository.save(state);
		cityRepository.save(city);
		
		//CLIENT AND ADDRESS
		
		Address address = new Address(null, "47", "Via Mazzini", "Centro", "3465466");
		address.setCity(city);
		
		Client client = new Client(null, "Clair Blem", "clair@gmail.com");
		client.getPhone().add("34654679846");
		
		address.setClient(client);
		client.setAddress(address);
		
		clientRepository.save(client);
		addressRepository.save(address);
		
		//PRODUCT AND CATEGORY
		
		Product product = new Product(null, "Computer", 600.0);
		Category category = new Category(null, "Eletronic");
		
		product.setCategory(category);
		category.getProducts().add(product);
		
		categoryRepository.save(category);
		productRepository.save(product);
		
		//ORDER, ORDER ITEM AND PAYMENT
		
		Order order = new Order(null, sdf.parse("22/02/2023").toInstant());
		
		Payment payment = new CardPayment(null, StatePayment.PAID, order, sdf.parse("22/02/2023").toInstant());
		
		order.setPayment(payment);
		order.setAddress(client.getAddress());
		order.setClient(client);
		
		
		orderRepository.save(order);
		paymentRepository.save(payment);
		
		
		OrderItem item = new OrderItem(product, order, 2, product.getPrice());
		
		order.getOrderItem().add(item);
		product.getOrderitem().add(item);
		
		itemRepository.save(item);
		
		
		
		
		
		
		
		
	}

}

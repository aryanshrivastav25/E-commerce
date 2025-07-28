package com.spring.spring_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// import com.spring.spring_demo.model.Alien;
import com.spring.spring_demo.model.Laptop;
import com.spring.spring_demo.service.LaptopService;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);

		Laptop lap = context.getBean(Laptop.class);
		LaptopService service = context.getBean(LaptopService.class);

		service.addLaptop(lap);



		// Alien obj = context.getBean(Alien.class);
		// obj.code();
	}

}

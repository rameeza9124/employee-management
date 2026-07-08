package com.example.employee_management;

import com.example.employee_management.service.HomeService;
import com.example.employee_management.util.MessageUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(EmployeeManagementApplication.class, args);
		HomeService homeService1 = context.getBean(HomeService.class);
		HomeService homeService2 = context.getBean(HomeService.class);
		System.out.println(homeService1);
		System.out.println(homeService2);
		System.out.println(homeService1==homeService2);
		System.out.println(context.containsBean("homeService"));
		System.out.println(context.getBeanDefinitionCount());

//		String[] beanNames = context.getBeanDefinitionNames();
//		for(String bean: beanNames){
//			System.out.println(bean);
//		}

		MessageUtil messageUtil =
				context.getBean(MessageUtil.class);

		messageUtil.display();
	}

}

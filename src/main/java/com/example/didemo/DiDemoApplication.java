package com.example.didemo;

import com.example.didemo.controllersSpring.ConstructorInjectedSpringController;
import com.example.didemo.controllersSpring.MyController;
import com.example.didemo.controllersSpring.PropertyInjectedSpringController;
import com.example.didemo.controllersSpring.SetterInjectedSpringController;
import com.example.didemo.examplebeans.FakeDataSource;
import com.example.didemo.examplebeans.FakeJmsBroker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DiDemoApplication {

	// this way we can access beans in spring context and execute their methods
	public static void main(String[] args) {
		// we get the application context to work with (when we start the application)
		ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class, args);

		// we get the controller Bean from context (but specifying the first letter in lowercase (m) )
		// Spring Context gave us a reference to that bean
		MyController controller = (MyController) ctx.getBean("myController");

		// execute that specific method
		//controller.hello();

		System.out.println(controller.hello());
		System.out.println(ctx.getBean(PropertyInjectedSpringController.class).sayHello());
		System.out.println(ctx.getBean(SetterInjectedSpringController.class).sayHello());
		// here not autowiring is needed (except for service, but for the service, it is common for all 3 autowiring ways)
		System.out.println(ctx.getBean(ConstructorInjectedSpringController.class).sayHello());


		// we can also pass the type of the bean
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println();
		System.out.println("Properties values:");
		// now this property value is overriden by environment variable
		System.out.println(fakeDataSource.getName());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getUrl());
		System.out.println(fakeDataSource.getFavouriteClub());

		System.out.println();
		System.out.println("Fake JMS Properties (picked up atomatically from application.yml");
		FakeJmsBroker fakeJmsBroker = ctx.getBean(FakeJmsBroker.class);
		System.out.println(fakeJmsBroker.getUsername());
		System.out.println(fakeJmsBroker.getPassword());
		System.out.println(fakeJmsBroker.getUrl());
	}

}

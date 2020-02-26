package tn.iset.mahdia.formation;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tn.iset.mahdia.formation.model.User;
import tn.iset.mahdia.formation.sevices.MyService;
import tn.iset.mahdia.formation.sevices.UserService;

/**
 * Spring tutorial
 * @author : BEN SALEM Chokri
 */

public class App 
{
	private static ApplicationContext context ;
    public static void main( String[] args )
    {
    	bootStrapping();
    	//senario1();
    	//senario2();
//    	senario3();
    	senario4() ;
    }
    
    private static void senario2() {
		UserService userService=(UserService) context.getBean("userService");
		User user1=new User("chokri","123","chokri ben salem");
		User user2=new User("chokri1","123","chokri1 ben salem");
		User user3=new User("chokri2","123","chokri2 ben salem");
		userService.addUser(user1);
		userService.addUser(user2);
		userService.addUser(user3);
		
	}
	private static void bootStrapping() {
    	context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
    }
    private static void senario1() {
//    	MyService service=new MyService();
    	MyService service1=(MyService) context.getBean("myService");
    	service1.setName("Chokri");
    	// System.out.println(service.sayHello("Chokri") );
    	System.out.println("With service1: "+service1.sayHello() );
    	MyService service2=(MyService) context.getBean("myService");
    	System.out.println("With service2: "+service2.sayHello() );
    }
    private static void senario3() {
		UserService userService=(UserService) context.getBean("userService");
		User user=userService.getUser("chokri1");
		System.out.print(user);
		
	}
    private static void senario4() {
		UserService userService=(UserService) context.getBean("userService");
		List<User> users=userService.getListOfUser();
		users.forEach(System.out::println);
		
	}
}

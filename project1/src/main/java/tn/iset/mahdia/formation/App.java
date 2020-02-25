package tn.iset.mahdia.formation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tn.iset.mahdia.formation.sevices.MyService;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ApplicationContext context ;
    public static void main( String[] args )
    {
    	bootStrapping();
//    	MyService service=new MyService();
    	MyService service1=(MyService) context.getBean("myService");
    	service1.setName("Chokri");
    	// System.out.println(service.sayHello("Chokri") );
    	System.out.println("With service1: "+service1.sayHello() );
    	MyService service2=(MyService) context.getBean("myService");
    	System.out.println("With service2: "+service2.sayHello() );
    }
    private static void bootStrapping() {
    	context = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
    }
}

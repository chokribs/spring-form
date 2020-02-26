package tn.iset.mahdia.formation.sevices;

import javax.inject.Inject;
import javax.inject.Named;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//@Component
@Named
public class MyService {
	private String name;
	//@Autowired
	@Inject
	private CommonService commonService;
	public String sayHello(String name) {
		return "Hello "+name;
	}
	public String sayHello() {
		return "Hello "+commonService.getInitiale()+this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}
	

}

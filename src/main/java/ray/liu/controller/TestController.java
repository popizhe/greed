package ray.liu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ray.liu.service.TestService;


@RequestMapping("/test/")
@RestController
public class TestController {
	
	
	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/")
	public String test(){
		System.out.println(testService.getTestString());
		return "true";
	 }
	@RequestMapping(value = "/test")
	public void test2(){
		System.out.println("======> done");
	}
	
}

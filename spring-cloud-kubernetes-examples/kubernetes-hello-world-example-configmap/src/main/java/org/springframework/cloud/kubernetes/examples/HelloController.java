package org.springframework.cloud.kubernetes.examples;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;

@RestController
public class HelloController {

	@Value("${property.one}")
	String one;

	@Value("${property.two}")
	String two;

	@RequestMapping("/")
	public String hello() {
		return one +" " +two;
	}

}

package br.com.apistats;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	
	@RequestMapping(value = "/pimentao", method = RequestMethod.GET)
	@ResponseBody
	public EntityTest classe() {

		return new EntityTest(1, "qualquer coisa");
	}
	
	
}

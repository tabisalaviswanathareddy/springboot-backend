package net.javaguides.springboot.controller;

import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/rest/v1/")
public class LoginController {

	@Autowired
	UserService userService;

	@PostMapping(path = "/login")
	public boolean helloWorldBean(  @RequestBody Map<String, String> params) {
		//HttpSession session = request.getSession();
		String userName = params.get("userName");
		String password = params.get("password");
		return userService.findByUser(userName, password);
	}	
}

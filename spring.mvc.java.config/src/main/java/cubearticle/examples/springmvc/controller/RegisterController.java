package cubearticle.examples.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String logIn(@RequestParam String email, @RequestParam String name, @RequestParam String password1,
			Model model) {

		
		// insert it into db!
		model.addAttribute("name", name);
		return "hello";
	}

}
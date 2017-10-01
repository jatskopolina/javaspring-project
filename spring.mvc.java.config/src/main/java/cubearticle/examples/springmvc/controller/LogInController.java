package cubearticle.examples.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogInController {

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String logIn(@RequestParam String name, @RequestParam String password, Model model) {
		
		model.addAttribute("name", name);
		return "hello";
	}

}
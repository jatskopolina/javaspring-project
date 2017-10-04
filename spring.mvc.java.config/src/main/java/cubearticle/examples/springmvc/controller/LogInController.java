package cubearticle.examples.springmvc.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cubearticle.examples.springmvc.dbclasses.DBConnector;

@Controller
public class LogInController {

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String logIn(@RequestParam String name, @RequestParam String password, Model model)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		DBConnector connector = new DBConnector();
		String res = connector.findpassword(name);
		if (res.equals(password)) {
			System.out.println("IT s ok, you successfully have logged in");
			model.addAttribute("name", name);
			return "hello";
		} else {
			System.out.println("OH, smth wrong");
			return "index";
		}
	}

}
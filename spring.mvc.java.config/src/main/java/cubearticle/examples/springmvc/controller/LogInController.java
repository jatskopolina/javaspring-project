package cubearticle.examples.springmvc.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cubearticle.examples.springmvc.helpful.DBConnector;
import cubearticle.examples.springmvc.helpful.PasswordHasher;

@Controller
public class LogInController {

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String logIn(@RequestParam String name, @RequestParam String password, Model model) throws SQLException,
			InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchAlgorithmException {
		DBConnector connector = new DBConnector();
		String res = connector.findpassword(name);
		PasswordHasher ph = new PasswordHasher("MD5");
		password = ph.hash(password);
		if (res.equals(password)) {
			System.out.println("IT s ok, you successfully have logged in");
			model.addAttribute("name", name);
			return "hello";
		} else {
			System.out.println("OH, smth wrong!");
			return "index";
		}
	}

}
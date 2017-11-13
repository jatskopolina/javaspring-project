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
public class RegisterController {

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String logIn(@RequestParam String email, @RequestParam String name, @RequestParam String password1,
			Model model) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException,
			NoSuchAlgorithmException {
		DBConnector connector = new DBConnector();
		boolean exists = connector.selectall(name, email);
		if (!exists) {
			PasswordHasher ph = new PasswordHasher("MD5");
			password1 = ph.hash(password1);
			connector.insert(name, email, password1);
			model.addAttribute("name", name);
			System.out.println("It`s ok, i have created your account");
			return "hello";
		}
		System.out.println("Seems like your user name or your email is used already");
		return "index";
	}

}
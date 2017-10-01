package cubearticle.examples.springmvc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String logIn(@RequestParam String email, @RequestParam String name, @RequestParam String password1,
			Model model) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		// Had some problem with timezones.. used serverTimezone=Europe/Moscow
		// idk exactly wtf0))
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/test?user=root&password=1234&serverTimezone=Europe/Moscow");
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("SELECT * FROM users WHERE login = \"" + name + "\" OR email = \"" + email + "\";");
		if (res.next() == false) {
			stmt.executeUpdate("INSERT INTO users (login, email, password) VALUES (\"" + name + "\", \"" + email
					+ "\", \"" + password1 + "\");");
			model.addAttribute("name", name);
			System.out.println("It`s ok, i created your account");
			return "hello";
		}
		System.out.println("Seems like your user name or your email is used already");
		return "index";
	}

}
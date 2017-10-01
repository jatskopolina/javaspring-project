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
public class LogInController {

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String logIn(@RequestParam String name, @RequestParam String password, Model model)
			throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		// Had some problem with time zones.. used serverTimezone=Europe/Moscow
		// idk exactly wtf0))
		Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost/test?user=root&password=1234&serverTimezone=Europe/Moscow");
		Statement stmt = conn.createStatement();
		ResultSet res = stmt.executeQuery("SELECT password FROM users WHERE login = \"" + name + "\";");
		// HERE NUMERATION OF COLUMNS FROM 1.
		// WHEN YOU START THE ACTIONS, YOU ARE BEFORE THE FIRST LINE
		// SO DO NEXT() AND GETSTRING(1) TO GET THE FIRST
		// i know here only 1 column (i ask only for the password)
		// and MUST be only 1 line

		if (res.next() == true && res.getString(1).equals(password)) {// if the line exists and equals
			System.out.println("IT s oK, you successfully have logged in");
			model.addAttribute("name", name);
			return "hello";
		} else {
			System.out.println("OH, smth wrong");
			return "index";
		}
	}

}
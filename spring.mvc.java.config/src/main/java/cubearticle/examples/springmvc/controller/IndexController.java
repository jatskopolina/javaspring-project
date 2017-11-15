package cubearticle.examples.springmvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cubearticle.examples.springmvc.helpful.CookieUtils;

@Controller
public class IndexController {

	public IndexController() {
		// TODO Auto-generated constructor stub
		System.out.println("created");
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	
	public ModelAndView index(HttpServletRequest request) throws IOException {
		System.out.print("Index controller))");
		ModelAndView model = new ModelAndView("index");
		
		String[] array = CookieUtils.hasIt(request);
		model.addObject("userName", array[0]);
		model.addObject("userPassword", array[1]);
		return model;
	}

}
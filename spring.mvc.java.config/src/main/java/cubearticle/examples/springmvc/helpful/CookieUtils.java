package cubearticle.examples.springmvc.helpful;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;

public class CookieUtils {

	public static void demoUserCookie(HttpServletRequest request, HttpServletResponse response, JspWriter out)
			throws IOException {
		boolean found = false;

		// Get an array of Cookies associated with this domain
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			String lastLoginDatetime = null;
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("lastLoginDatetime")) {
					lastLoginDatetime = cookies[i].getValue();
				}
			}
			if (lastLoginDatetime != null) {
				found = true;
				out.println("Hello, we are glad to see you again!<br/>");
				out.println("Your last Login date and time is: " + lastLoginDatetime + "<br/>");
			}
		}

		// if no cookies or no datetime found
		if (!found) {
			out.println("Oh, it seems to me i have no your cookies<br/>");

			String userName = request.getParameter("name");

			Cookie cookieUserName = new Cookie("userName", userName);

			// Sets the maximum age in seconds for this Cookie. (24h)
			cookieUserName.setMaxAge(24 * 60 * 60);

			response.addCookie(cookieUserName);
		}
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date now = new Date();
		Cookie cookieLoginDatetime = new Cookie("lastLoginDatetime", df.format(now));

		// Sets the maximum age in seconds for this Cookie. (24h)
		cookieLoginDatetime.setMaxAge(24 * 60 * 60);

		// Store in the user's computer.
		response.addCookie(cookieLoginDatetime);

	}
}
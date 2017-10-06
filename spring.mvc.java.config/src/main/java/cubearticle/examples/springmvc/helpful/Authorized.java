package cubearticle.examples.springmvc.helpful;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

public class Authorized implements Filter {
	private FilterConfig filterConfig;

	public void destroy() {
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		String UriPath = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
		if (session == null || session.getAttribute("userLogin") == null) {
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			if ("index.jsp".equals(UriPath)) {
				chain.doFilter(request, response);

			}
			httpResponse.sendRedirect("inddex.jsp?destination=" + UriPath);
			return;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fc) throws ServletException {
		this.filterConfig = fc;
	}
}
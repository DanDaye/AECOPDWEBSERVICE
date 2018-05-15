package com.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class PriFilter
 */
public class PriFilter implements Filter {
	private FilterConfig filterConfig = null;
	private static final String[] dir = {};

    /**
     * Default constructor. 
     */
    public PriFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
		
		// pass the request along the filter chain
		System.out.println("this is filter");
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)res;
		
		String path = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(path);
		String existUser = (String)request.getSession().getAttribute("username");
		if(existUser == null ){
			if ("/".equals(path)||"/login".equals(path)){
				chain.doFilter(request, response);
				return;
			}else{
				response.sendRedirect(request.getContextPath());
				
			}
		}else{
			System.out.println("existUser"+existUser);
			chain.doFilter(request, response);
			return;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = fConfig;
	}

}

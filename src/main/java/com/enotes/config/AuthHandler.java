package com.enotes.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthHandler<Student> implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Student student =(Student)request.getSession().getAttribute("studentObj");
		if(student != null) {
			return true;
		}else {
			//response.sendRedirect("login");
			response.getWriter().print("<h1>Please Login</h1>");
			return false;
		}
	}
	
	

}

package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chicken.LoginService;

@WebServlet(urlPatterns = "/login.do")

public class LoginServlet extends HttpServlet {
	
	
	private LoginService service = new LoginService(); 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		boolean fatou = service.validateUser(name, password);
		
		if(fatou) {
			request.setAttribute("name", name);
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("errorMessage", "Invalid Credentials!!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

		}

		
		
		
	}


}

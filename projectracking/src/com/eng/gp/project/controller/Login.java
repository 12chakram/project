package com.eng.gp.project.controller;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eng.gp.project.domain.ProjectType;
import com.eng.gp.project.domain.UserDetails;
import com.eng.gp.project.services.ProjectTrackingService;
import com.eng.gp.project.services.ProjectTrackingServiceBean;
import com.eng.gp.project.util.JsonToObject;
import com.jayway.restassured.response.Response;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private JsonToObject jsonToObject = new JsonToObject();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginPath = "http://localhost:8080/publicApi/services/auth/login";
		String userName = request.getParameter("j_username");
		String password = request.getParameter("j_password");
		
			Response restResponse = given().queryParam("username", userName).queryParam("password", password).post(loginPath);

			String responseJson = restResponse.asString();
			System.out.println(responseJson);
			UserDetails userDetails = (UserDetails) jsonToObject.getStringToObject(responseJson, "userDetails", UserDetails.class);
		
			System.out.println(userDetails.getUsername());
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
			requestDispatcher.forward(request, response);
		}
	
	}


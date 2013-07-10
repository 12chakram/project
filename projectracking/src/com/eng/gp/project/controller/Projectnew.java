package com.eng.gp.project.controller;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eng.gp.project.util.StringTodate;
import com.gridpoint.energy.domainmodel.ProjectTrackingItem;
import com.jayway.restassured.response.Response;

/**
 * Servlet implementation class Project
 */
@WebServlet("/createProjectnew")
public class Projectnew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Projectnew() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@SuppressWarnings(value ="unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String createProject = "http://localhost:8080/publicApi/services/projectTracking/createProject";

		
		ProjectTrackingItem projectTracking = new ProjectTrackingItem();
		try{
			String projectName = request.getParameter("projectname");
		String projectTypeid = request.getParameter("projecttype");
		String[] channelDisplayName = request.getParameter("channelDisplayNames").split(",");
		String premisesId = request.getParameter("premisesid");
		
		//String sdate = request.getParameter("start").replace("/", "-");
		//sdate = sdate.replace("/", "-");
		  // String edate = request.getParameter("end").replace("/", "-");;
		//edate = edate.replace("/", "-");
		Date pstartDate =new Date(StringTodate.stringToDate(request.getParameter("start")));
		
		Date pendDate = new Date(StringTodate.stringToEndDate(request.getParameter("end")));
		
		Set<String>channels =new HashSet<String>();
		for(String chString :channelDisplayName){
			channels.add(chString);
		}
		
		projectTracking.setProjectName(projectName);
		projectTracking.setProjectTypeId(Long.parseLong(projectTypeid));
		projectTracking.setPremisesId(Long.parseLong(premisesId));
		/*projectTracking.setStartDate(pstartDate);
		projectTracking.setEndDate(pstartDate);*/
		projectTracking.setChannels(channels);
		
		HttpSession session = request.getSession(true);
		Map<String, String> loginCookie = (Map<String, String>) session.getAttribute("loginCookies");
		Response restCreateProject = given().cookies(loginCookie).queryParam("username", "cianalyst").queryParam("password", "password").request().body(projectTracking).post(createProject);
		String projectResponse = restCreateProject.asString();
		System.out.println(projectResponse);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/projectslist.jsp");
		requestDispatcher.forward(request, response);
		
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
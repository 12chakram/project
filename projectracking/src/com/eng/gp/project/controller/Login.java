package com.eng.gp.project.controller;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.eng.gp.project.domain.ProjectType;
import com.eng.gp.project.domain.UserDetails;
import com.eng.gp.project.services.ProjectTrackingService;
import com.eng.gp.project.services.ProjectTrackingServiceBean;
import com.eng.gp.project.util.DateFormats;
import com.eng.gp.project.util.JsonToObject;
import com.gridpoint.energy.domainmodel.Channel;
import com.jayway.restassured.response.Response;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private JsonToObject jsonToObject = new JsonToObject();
	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	ObjectMapper objectMapper = new ObjectMapper();
       
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession(true);
		String loginPath = "http://localhost:8080/publicApi/services/auth/login";
		String getChannel = "http://localhost:8080/publicApi/services/data/getChannelsByEndpointId";
		String userName = request.getParameter("j_username");
		String password = request.getParameter("j_password");
		ProjectTrackingService  service = new ProjectTrackingServiceBean();
		
		Response restResponse = given().queryParam("username", userName).queryParam("password", password).post(loginPath);
			Map<String, String> cookieMap = restResponse.getCookies();			
			session.setAttribute("loginCookies", cookieMap);
			String responseJson = restResponse.asString();
			System.out.println(responseJson);
			UserDetails userDetails = (UserDetails) jsonToObject.getStringToObject(responseJson, "userDetails", UserDetails.class);
			if(userDetails.getUsername()!=null){
				
				Long endpointId = Long.parseLong("10007");
				
				Map<String, String> loginCookie = (Map<String, String>) session.getAttribute("loginCookies");
				Response restChannelResponse = given().cookies(loginCookie).queryParam("username", userName).queryParam("password", password).queryParam("endpointId",endpointId).post(getChannel);
				String channelResponse = restChannelResponse.asString();
				
				System.out.println(channelResponse);
				
				//Channel channel = (Channel) jsonToObject.getStringToObject(channelResponse, "result", Channel.class);
				//System.out.println(channel.toString());
				
				List<Channel> channelList =null;
				
				try {
					JSONObject jsonObject = new JSONObject(channelResponse);
					JSONArray jsonArray = (JSONArray) jsonObject.get("result");
					if (jsonArray.length() > 0) 
					{
						objectMapper.getDeserializationConfig().setDateFormat(new SimpleDateFormat(DateFormats.DATE_FORMAT_LOCALDATETIME));
						channelList = new ArrayList<Channel>();
						for (int iCount = 0; iCount < jsonArray.length(); iCount++) 
						{
							JSONObject channelObject = jsonArray.getJSONObject(iCount); 
							channelList.add((Channel) objectMapper.readValue(channelObject.toString(), Channel.class));
						}

					}
				}catch(Exception ex){
					ex.printStackTrace();
					
				}
				List<ProjectType> projectslist;
				projectslist = service.getAllProjectTypes();
				request.setAttribute("allProjectstypes", projectslist);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/project.jsp");
				requestDispatcher.forward(request, response);

			}else {
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
				requestDispatcher.forward(request, response);
			}
		}
	
	}

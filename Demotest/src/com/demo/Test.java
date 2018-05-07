package com.demo;



import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.Dao.LoginDao;
import com.Dao.UserDao;
import com.bean.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Path("user")
public class Test {
	
	@Path("regester")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getRegester(String json) {
		 
		User u = null;
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = jsonParser.parse(json);
		if(jsonElement.isJsonObject()) {
			
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			 u = new User (jsonObject.get("name").getAsString(),jsonObject.get("password").getAsString(),jsonObject.get("email").getAsString());
			
		}
		
		UserDao userDao = new UserDao();
		String Msg = userDao.daoRegester(u);

		return Msg;
	}
	
	
	@Path("login")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String getLogin(String json) {
		 
		User u = null;
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = jsonParser.parse(json);
		if(jsonElement.isJsonObject()) {
			
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			 u = new User (jsonObject.get("password").getAsString(),jsonObject.get("email").getAsString());
			
		}
		
		LoginDao loginDao = new LoginDao();
		String Msg = loginDao.daoLogin(u);

		return Msg;
	}
	
	@Path("method2")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage1() {
		
		
		return "demo rest welcome method2";
	}

}

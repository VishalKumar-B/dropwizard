package com.motivity.Example2.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class Example2Resource {

	@GET
	public String welcome() {
		return "welcome";
	}
	
	@GET
	@Path("/greetings/{name}")
	public String getGreeting(@PathParam("name") String name) {
		return "Hello " + name + " !";
	}
	
}

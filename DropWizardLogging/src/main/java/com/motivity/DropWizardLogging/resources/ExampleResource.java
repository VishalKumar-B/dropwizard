package com.motivity.DropWizardLogging.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/")
public class ExampleResource {

	private static final Logger log = LoggerFactory.getLogger(ExampleResource.class);

	@GET
	public String welcome() {
		System.out.println("start...");
	      log.debug("Debug Message!");
	      log.info("Info Message!");
	      log.warn("Warn Message!");
	      log.error("Error Message!");
		System.out.println("end...");
		
		return "welcome to logging";
	}
}

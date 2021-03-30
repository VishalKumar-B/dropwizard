package com.motivity.Example;

import com.motivity.Example.health.TemplateHealthCheck;
import com.motivity.Example.resources.exResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class exApplication extends Application<exConfiguration> {

	public static void main(final String[] args) throws Exception {
		new exApplication().run(args);
	}

	@Override
	public String getName() {
		return "ex";
	}

	@Override
	public void initialize(final Bootstrap<exConfiguration> bootstrap) {
		
	}

	@Override
	public void run(final exConfiguration configuration, final Environment environment) {
		final exResource resource = new exResource(configuration.getTemplate(), configuration.getDefaultName());
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
	}

}

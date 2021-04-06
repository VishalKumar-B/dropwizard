package com.motivity.DropWizardHibernate.health;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.db.DataSourceFactory;

public class DatabaseHealthCheck extends HealthCheck{

	private final DataSourceFactory database;

    public DatabaseHealthCheck(DataSourceFactory dataSourceFactory) {
        this.database = dataSourceFactory;
    }
	
	@Override
	protected Result check() throws Exception {
		 if (database.getCheckConnectionOnConnect()) {
	            return Result.healthy("connected to database: " +database.getUrl());
	        } else {
	            return Result.unhealthy("Cannot connect to " + database.getUrl());
	        }
	    }

}

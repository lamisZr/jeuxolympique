package com.jeuxolympique.calendrier_service;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;


@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

	/*
	 * Provide a contact point to the configuration.
	 */
	@Override
	public String getContactPoints() {
		return "cassandradb";
	}

	/*
	 * Provide a keyspace name to the configuration.
	 */
	@Override
	public String getKeyspaceName() {
		return "spring_cassandra";
	}
}

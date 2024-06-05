package com.jeuxolympique.site_service;

import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Data;


public class SiteSitueADto {
	private String siteId;
	private float distance;
	private float timeByCar;
	private float timeByTransport;
	
	public String getSiteId() {
		return siteId;
	}
	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public float getTimeByCar() {
		return timeByCar;
	}
	public void setTimeByCar(float timeByCar) {
		this.timeByCar = timeByCar;
	}
	public float getTimeByTransport() {
		return timeByTransport;
	}
	public void setTimeByTransport(float timeByTransport) {
		this.timeByTransport = timeByTransport;
	}
	
}

package com.jeuxolympique.site_service;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "SiteSitueA")
public class SiteSitueA {
	@Id
	private String id;
	@DBRef
	private Site site;
	
	private float distance;
	private float timeByCar;
	private float timeByTransport;
	
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
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
	public SiteSitueA(Site site, float distance, float timeByCar, float timeByTransport) {
		super();
		this.site = site;
		this.distance = distance;
		this.timeByCar = timeByCar;
		this.timeByTransport = timeByTransport;
	}
	public SiteSitueA()
	{
		
	}
}

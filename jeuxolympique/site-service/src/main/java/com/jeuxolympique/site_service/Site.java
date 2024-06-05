package com.jeuxolympique.site_service;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "Site")
public class Site {
	@Id
	private String id;
	private float lon;
	private float lat;
	private String name;
	
	@DBRef
	private List<SiteSitueA> listSiteSitueA;
	
	

	public List<SiteSitueA> getListSiteSitueA() {
		return listSiteSitueA;
	}
	public void setListSiteSitueA(List<SiteSitueA> listSiteSitueA) {
		this.listSiteSitueA = listSiteSitueA;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getLon() {
		return lon;
	}
	public void setLon(float lon) {
		this.lon = lon;
	}
	public float getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Site(float lon, float lat, String name,List<SiteSitueA> listSiteSitueA) {
		super();
		this.lon = lon;
		this.lat = lat;
		this.name = name;
		this.listSiteSitueA = listSiteSitueA;
	}
	public Site(float lon, float lat, String name ) {
		super();
		this.lon = lon;
		this.lat = lat;
		this.name = name;
	}
	public Site()
	{
		
	}

}

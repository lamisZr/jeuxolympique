package com.jeuxolympique.site_service;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class SiteDto {
	
	private float lon;
	private float lat;
	private String name;
	private List<SiteSitueADto> listSiteSitueA;
	
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
	
	public List<SiteSitueADto> getListSiteSitueA() {
		return listSiteSitueA;
	}
	public void setListSiteSitueA(List<SiteSitueADto> listSiteSitueA) {
		this.listSiteSitueA = listSiteSitueA;
	}
	public SiteDto(float lon, float lat, String name) {
		super();
		this.lon = lon;
		this.lat = lat;
		this.name = name;
	}

}

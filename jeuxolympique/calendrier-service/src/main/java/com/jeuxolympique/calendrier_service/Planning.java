package com.jeuxolympique.calendrier_service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("planning")
public class Planning {
	@PrimaryKey
	private String id;
	private List<String> calendrierIds;
	private Long travelDurationByCar;
	private Long travelDurationByTransport;

	public Planning() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getCalendrierIds() {
		return calendrierIds;
	}

	public void setCalendrierIds(List<String> calendrierIds) {
		this.calendrierIds = calendrierIds;
	}

	public Long getTravelDurationByCar() {
		return travelDurationByCar;
	}

	public void setTravelDurationByCar(Long travelDurationByCar) {
		this.travelDurationByCar = travelDurationByCar;
	}

	public Long getTravelDurationByTransport() {
		return travelDurationByTransport;
	}

	public void setTravelDurationByTransport(Long travelDurationByTransport) {
		this.travelDurationByTransport = travelDurationByTransport;
	}

}

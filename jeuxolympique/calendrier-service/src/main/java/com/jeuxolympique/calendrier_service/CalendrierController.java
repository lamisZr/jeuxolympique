package com.jeuxolympique.calendrier_service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/calendriers")
public class CalendrierController {
	
	@Autowired
	private CalendrierService calendrierService;

	@GetMapping()
	public List<Calendrier> getAllCalendriers() {
		return this.calendrierService.getAllCalendrier();
	}

	@GetMapping("/{id}")
	public Optional<Calendrier> getCalendrierById(@PathVariable("id") String id) {
		// get sport by id
		return this.calendrierService.getCalendrierById(id);
	}

	@PutMapping("/{id}")
	public void updateCalendrier(@RequestBody Calendrier calendrier, @PathVariable("id") String id) {
		this.calendrierService.updateCalendrier(id, calendrier);
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void createCalendrier(@RequestBody Calendrier calendrier) {
		this.calendrierService.createCalendrier(calendrier);
	}
	
	
	
	
	@GetMapping("/timestamp/{timestamp}/site/{siteId}")
	public List<String> getSportsIds(@PathVariable("timestamp") String timestamp,@PathVariable("siteId") String siteId)
	{
		return this.calendrierService.getSportIds(new Date(Long.valueOf(timestamp)), siteId);
	}
	
	@GetMapping("/timestamp/{timestamp}/sport/{sportId}")
	public List<String> getSitesIds(@PathVariable("timestamp") String timestamp,@PathVariable("sportId") String sportId)
	{
		return this.calendrierService.getSitesIds(new Date(Long.valueOf(timestamp)), sportId);
	}
}

package com.jeuxolympique.sport_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/sports")
public class SportController {
	@Autowired
	private SportService sportService;

	@GetMapping()
	public List<Sport> getAllSports()
	{
		List<Sport> sports = this.sportService.getAllSports();
		return sports;
	}
	@GetMapping("/{id}")
	public Optional<Sport> getSportById(@PathVariable String id)
	{
		//get sport by id
		Optional<Sport> sport = this.sportService.getSportById(id);
		return sport;
	}
	@PutMapping("/{id}")
	public Sport updateSport(@RequestBody Sport sport, @PathVariable("id") String id)
	{
		Sport newSport = this.sportService.updateSport(id,sport);
		return newSport;
	}
	@PostMapping()
	public Sport createSport(@RequestBody Sport sport)
	{
		Sport newSport = this.sportService.createSport(sport);
		return newSport;
	}
	
	@GetMapping("/timestamp/{timestamp}/site/{siteId}")
	public List<Sport> getSportsBySiteOrDate(@PathVariable("timestamp") String timestamp,@PathVariable("siteId") String siteId) {
		return this.sportService.getSportByCriteria(timestamp, siteId);
	}
	
}

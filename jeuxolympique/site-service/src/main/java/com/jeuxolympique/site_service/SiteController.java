package com.jeuxolympique.site_service;

import java.util.ArrayList;
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
@RequestMapping("api/sites")
public class SiteController {
	@Autowired
	private SiteService siteService;

	@GetMapping()
	public List<Site> getAllSites()
	{
		List<Site> sites = this.siteService.getAllSites();
		return sites;
	}
	@GetMapping("/{id}")
	public Site getSiteById(@PathVariable("id") String id)
	{
		//get sport by id
		Optional<Site> site = this.siteService.getSiteById(id);
		return site.get();
	}
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateSite(@RequestBody SiteDto site,@PathVariable("id") String id)
	{
		this.siteService.updateSite(id,site);
	}
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void createSite(@RequestBody SiteDto site)
	{
		this.siteService.createSite(site);
	}
	
	@GetMapping("/timestamp/{timestamp}/sport/{sportId}")
	public List<Site> getSitesBySportOrDate(@PathVariable("timestamp") String timestamp,@PathVariable("sportId") String sportId) {
		return this.siteService.getSiteByCriteria(timestamp, sportId);
	}
}

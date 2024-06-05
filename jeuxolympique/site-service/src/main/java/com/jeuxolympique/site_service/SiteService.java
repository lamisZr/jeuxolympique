package com.jeuxolympique.site_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SiteService {
	@Autowired
	private SiteRepository siteRepository;
	
	@Autowired
	private SiteSitueARepository siteSitueARepository;

	@Autowired
	private WebClient webClient;
	
	public void createSite(SiteDto siteDto) {
		Site site = new Site();
		List<SiteSitueA> listSitueA = new ArrayList<SiteSitueA>();
		if(siteDto.getListSiteSitueA() != null)
		{
			listSitueA = siteDto.getListSiteSitueA().stream().map((siteSitueADto) -> {
				SiteSitueA siteSitueA =  new SiteSitueA(this.siteRepository.findById(siteSitueADto.getSiteId()).get(),
						siteSitueADto.getDistance(), siteSitueADto.getTimeByCar(), siteSitueADto.getTimeByTransport());
				return this.siteSitueARepository.save(siteSitueA);
			}).toList();
		}
		site.setLon(siteDto.getLon());
		site.setLat(siteDto.getLat());
		site.setName(siteDto.getName());
		site.setListSiteSitueA(listSitueA);
		this.siteRepository.save(site);
	}

	public List<Site> getAllSites() {
		return this.siteRepository.findAll();
	}

	public Optional<Site> getSiteById(String id) {
		return this.siteRepository.findById(id);
	}

	public void updateSite(String id, SiteDto siteDto) {
		Site site = this.siteRepository.findById(id).get();
		site.setLon(siteDto.getLon());
		site.setLat(siteDto.getLat());
		site.setName(siteDto.getName());
		this.siteRepository.save(site);
	}

	public List<Site> getSiteByCriteria(String timestamp, String sportId)
	{
		ArrayList<String> siteIds = webClient.get()
				.uri("http://calendrier-service:8082/api/calendriers/timestamp/"+timestamp + "/sport/"+sportId)
				.retrieve()
				.bodyToMono(ArrayList.class).block();
		List<Site> sites = this.siteRepository.findAllById(siteIds);
		return sites;
	}
}

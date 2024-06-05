package com.jeuxolympique.sport_service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Component
public class SportService {
	@Autowired
	private SportRepository sportRepository;

	@Autowired
	private WebClient webClient;

	public List<Sport> getAllSports() {
		List<Sport> sports = (List<Sport>) this.sportRepository.findAll();
		return sports;
	}

	public Optional<Sport> getSportById(String id) {
		// get sport by id
		Optional<Sport> sport = this.sportRepository.findById(id);
		return sport;
	}

	public Sport updateSport(String id, Sport sport) {
		Sport oldSport = this.sportRepository.findById(id).get();
		oldSport.setName(sport.getName());
		return this.sportRepository.save(oldSport);

	}

	public Sport createSport(Sport sport) {
		return this.sportRepository.save(sport);
	}

	public List<Sport> getSportByCriteria(String timestamp, String siteId) {
		ArrayList<String> sportIds = webClient.get()
				.uri("http://calendrier-service:8082/api/calendriers/timestamp/" + timestamp + "/site/" + siteId).retrieve()
				.bodyToMono(ArrayList.class).block();
		List<Sport> sports = sportIds.stream().map((sportId) -> {
			Optional<Sport> sport = this.sportRepository.findById(sportId);
			if(sport.isPresent())
			{
				return sport.get();
			}
			return new Sport();
		}).filter((sport)-> sport.getId() != null).toList();
		return sports;
	}
}

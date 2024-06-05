package com.jeuxolympique.calendrier_service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class PlanningService {

	@Autowired
	private PlanningRepository planningRepository;
	
	@Autowired
	private CalendrierService calendrierService;

	@Autowired
	private WebClient webClient;
	
	public List<Planning> getAllPlanning() {
		return this.planningRepository.findAll();
	}

	public Optional<Planning> getPlanningById(String id) {
		return this.planningRepository.findById(id);
	}

	public void updatePlanning(String id, Planning planning) {
		Planning oldPlanning= this.planningRepository.findById(id).get();
		oldPlanning.setCalendrierIds(planning.getCalendrierIds());
		oldPlanning.setTravelDurationByCar(planning.getTravelDurationByCar());
		oldPlanning.setTravelDurationByTransport(planning.getTravelDurationByTransport());
		this.planningRepository.save(oldPlanning);
	}

	public void createPlanning(Planning planning) {
		planning.setId(UUID.randomUUID().toString());
		this.planningRepository.save(planning);
	}


}

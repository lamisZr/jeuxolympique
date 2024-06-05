package com.jeuxolympique.calendrier_service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalendrierService {

	@Autowired
	private CalendrierRepository calendrierRepository;

	public List<Calendrier> getAllCalendrier() {
		return this.calendrierRepository.findAll();
	}

	public Optional<Calendrier> getCalendrierById(String id) {
		return this.calendrierRepository.findById(id);
	}
	
	public List<Calendrier> getAllCalendriersByIdSorted(ArrayList<String> calendrierIds)
	{
		List<Calendrier> calendriers = this.calendrierRepository.findAllById(calendrierIds);
		calendriers.sort((a,b)-> a.getDate().compareTo(b.getDate()));
		return calendriers;
	}

	public void updateCalendrier(String id, Calendrier calendrier) {
		Calendrier oldCalendrier= this.calendrierRepository.findById(id).get();
		oldCalendrier.setDate(calendrier.getDate());
		oldCalendrier.setSiteId(calendrier.getSiteId());
		oldCalendrier.setSportId(calendrier.getSportId());
		this.calendrierRepository.save(oldCalendrier);
	}

	public void createCalendrier(Calendrier calendrier) {
		calendrier.setId(UUID.randomUUID().toString());
		this.calendrierRepository.save(calendrier);
	}
	
	public List<String> getSportIds(Date timestamp, String siteId)
	{
		List<Calendrier> calendriers = new ArrayList<>();
		calendriers.addAll(this.calendrierRepository.findByDate(timestamp));
		calendriers.addAll(this.calendrierRepository.findBySiteId(siteId));
		return calendriers.stream().map((calendrier) -> {return calendrier.getSportId();}).distinct().toList();
	}
	
	public List<String> getSitesIds(Date timestamp, String sportId)
	{
		List<Calendrier> calendriers = new ArrayList<>();
		calendriers.addAll(this.calendrierRepository.findByDate(timestamp));
		calendriers.addAll(this.calendrierRepository.findBySportId(sportId));
		return calendriers.stream().map((calendrier) -> {return calendrier.getSiteId();}).distinct().toList();
	}
	
	public List<Calendrier> calculateTravelDuration(ArrayList<String> CalendrierIds)
	{
		List<Calendrier> calendriers = this.calendrierRepository.findAllById(CalendrierIds);
		calendriers.sort((a,b)-> a.getDate().compareTo(b.getDate()));
		return calendriers;
	}
}

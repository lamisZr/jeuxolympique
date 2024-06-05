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
@RequestMapping("api/calendriers/plannings")
public class PlanningController {

	@Autowired
	private PlanningService planningService;

	@GetMapping()
	public List<Planning> getAllPlannings() {
		return this.planningService.getAllPlanning();
	}

	@GetMapping("/{id}")
	public Optional<Planning> getPlanningById(@PathVariable("id") String id) {
		// get sport by id
		return this.planningService.getPlanningById(id);
	}

	@PutMapping("/{id}")
	public void updatePlanning(@RequestBody Planning planning, @PathVariable("id") String id) {
		this.planningService.updatePlanning(id, planning);
	}

	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public void createPlanning(@RequestBody Planning planning) {
		this.planningService.createPlanning(planning);
	}
}

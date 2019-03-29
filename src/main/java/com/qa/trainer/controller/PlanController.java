package com.qa.trainer.controller;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.qa.trainer.entities.Plan;
import com.qa.trainer.service.PlanService;

@RestController
@EnableWebMvc
public class PlanController {
	
	private PlanService svc;
	
	public PlanController(PlanService svc) {
		this.svc = svc;
	}
	
	@GetMapping("/getPlan/{trainerId}/{planId}")
	public Optional<Plan> getPlan(Long trainerId, Long planId) {
		return svc.getPlan(trainerId, planId);
	}
	
	@PostMapping("/createPlan/{planId}/{roomNumber}/{traineeGroup}/{topic}")
	public Plan createPlan(@PathVariable Long planId, @PathVariable int roomNumber, @PathVariable String day, @PathVariable String month, @PathVariable String year, @PathVariable String traineeGroup, @PathVariable String topic) {
		return svc.createPlan(planId, day, month, year, roomNumber, traineeGroup, topic);
	}
	
	@PostMapping("/updatePlan")
	public Plan updatePlan(Long planId, int roomNumber, String traineeGroup, String topic) {
		return svc.updatePlan(planId, roomNumber, traineeGroup, topic);
	}
	

	@PostMapping("/deletePlan/{planId}")
	public String deletePlan(Long planId) {
		return svc.deletePlan(planId);
	}
	
//	@RequestMapping("/checkDupes/")
//	public Plan checkDupes(Long trainerId, Long planId) {
//		return null;
//	}
//	
//	@RequestMapping("/checkTopics/")
//	public Plan checkTopics(Long trainerId, Long planId) {
//		return null;
//	}
	
}

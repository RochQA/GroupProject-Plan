package com.qa.trainer.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/createPlan")
	public String createPlan(@RequestBody Plan plan) {
		String dateRes= svc.checkDate(plan);
		if(dateRes.equals("Valid")) {
			String planRes = checkPlan(plan, getAllPlans());
			if(planRes.equals(Constants.VALID_MESSAGE)){
				//save plan
				//add plan to trainer
			}else return planRes;			
		}else return dateRes;
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

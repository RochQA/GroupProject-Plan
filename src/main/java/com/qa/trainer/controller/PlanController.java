package com.qa.trainer.controller;

import java.util.List;

import org.apache.catalina.authenticator.Constants;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.netflix.discovery.EurekaClient;
import com.qa.trainer.entities.Plan;
import com.qa.trainer.service.PlanService;



@RestController
@EnableWebMvc
public class PlanController {
	
	private PlanService svc;
	private RestTemplateBuilder rest;
	private EurekaClient client;
	
	public PlanController(PlanService svc) {
		this.svc = svc;
	}
	

	
	@PostMapping("/checkPlan")
	public String checkPlan(@RequestBody Plan plan) {
		String dateRes= svc.checkDate(plan);
		if(dateRes.equals("Valid")) {
			String planRes = svc.checkAvailible(plan, getAllPlans());
			if(planRes.equals("Valid")){
				return "Valid";
			}else return planRes;			
		}else return dateRes;
	}
	
	private List<Plan> getAllPlans() {
		return this.rest.build().exchange(client.getNextServerFromEureka("GATEWAY", false).getHomePageUrl()+"getAllAccounts", 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Plan>>(){}).getBody();

	}
	
//	@PostMapping("/updatePlan")
//	public Plan updatePlan(Long planId, int roomNumber, String traineeGroup, String topic) {
//		return svc.updatePlan(planId, roomNumber, traineeGroup, topic);
//	}
//	
//
//	@PostMapping("/deletePlan/{planId}")
//	public String deletePlan(Long planId) {
//		return svc.deletePlan(planId);
//	}
	
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

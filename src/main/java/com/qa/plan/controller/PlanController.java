package com.qa.plan.controller;

import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.netflix.discovery.EurekaClient;
import com.qa.plan.entities.Constants;
import com.qa.plan.entities.Plan;
import com.qa.plan.service.PlanService;



@RestController
@EnableWebMvc
public class PlanController {
	
	private PlanService srvc;
	private RestTemplateBuilder rest;
	private EurekaClient client;

	public PlanController(PlanService srvc, RestTemplateBuilder rest, EurekaClient client) {
		this.srvc = srvc;
		this.rest = rest;
		this.client = client;
	}

	@PostMapping("/checkPlan")
	public String checkPlan(@RequestBody Plan plan) {
		return srvc.checkValid(plan, getAllPlans());
	}
	@PostMapping("/checkUpdatePlan")
	public String checkUpdatePlan(@RequestBody Plan plan) {
		return srvc.checkUpdatePlan(plan, getPlan(plan.getId()), getAllPlans());
	}
	
	private List<Plan> getAllPlans() {
		return this.rest.build().exchange(client.getNextServerFromEureka(Constants.GATEWAY, false).getHomePageUrl()+Constants.GET_ALL_PLANS_PATH, 
				HttpMethod.GET, null, new ParameterizedTypeReference<List<Plan>>(){}).getBody();

	}
	private Plan getPlan(Long planId) {
		HttpEntity<Long> entity = new HttpEntity<>(planId);
		return this.rest.build().exchange(client.getNextServerFromEureka(Constants.GATEWAY, false).getHomePageUrl()+Constants.GET_PLAN_PATH, 
				HttpMethod.PUT, entity, Plan.class).getBody();

	}
	
}

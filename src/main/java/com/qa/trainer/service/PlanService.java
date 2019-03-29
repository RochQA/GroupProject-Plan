package com.qa.trainer.service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.time.Year; 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.trainer.entities.Plan;
import com.qa.trainer.repository.PlanRepository;

@Service
public class PlanService {
	
	
	private PlanRepository repo;	
	private Plan plan;
	 
	@Autowired
	public PlanService(PlanRepository repo) {
		this.repo = repo; 
//		this.plan = plan;
	}

	public Plan createPlan(Long planId, String day, String month, String year, int roomNumber, String traineeGroup, String topic) {
		Plan plan = new Plan();		// foreach loop through planId's and see if roomNumber has been taken
		
		plan.setPlanId(planId);
		plan.setDay(day);
		plan.setMonth(month);
		if(Integer.parseInt(year) >= Integer.parseInt(Year.now().toString())) {
			plan.setYear(year);
		}
		else {
			plan.setYear(Year.now().toString());
		}
		plan.setRoomNumber(roomNumber);
		plan.setTraineeGroup(traineeGroup);
		plan.setTopic(topic);
		return repo.save(plan);
	}
	
	public Optional<Plan> getPlan(Long trainerId, Long planId) {
		return repo.findById(planId);
	}
	
	public Plan updatePlan(Long planId, int roomNumber, String traineeGroup, String topic) {
		Plan plan = new Plan();
		plan.setRoomNumber(roomNumber);
		plan.setTraineeGroup(traineeGroup);
		plan.setTopic(topic);
		return repo.save(plan);
	}
	
	public String deletePlan(Long planId) {
		
		repo.deleteById(planId);
		return "Plan in room " + plan.getRoomNumber() + " with group " + plan.getTraineeGroup() + " doing " + plan.getTopic() + " has been removed from planner"; 
	}

}  

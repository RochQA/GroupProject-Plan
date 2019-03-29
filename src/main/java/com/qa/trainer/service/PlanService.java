package com.qa.trainer.service;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.trainer.entities.Plan;
import com.qa.trainer.repository.PlanRepository;

@Service
public class PlanService {
	
	
	private PlanRepository repo;	
	 
	@Autowired
	public PlanService(PlanRepository repo) {
		this.repo = repo; 
//		this.plan = plan;
	}
	
	public Plan createPlan() {
		
		if(checkDate(plan).equals("Valid")) {
			
		}
		return null;
	}
	
	public String checkDate(Plan plan) {
		if(!(plan.getYear() >= Calendar.getInstance().get(Calendar.YEAR) && !(plan.getYear() < Calendar.YEAR + 2))) {
			return "Year not valid!";
		} else if(!(plan.getMonth() >= Calendar.getInstance().get(Calendar.MONTH) + 1) || !(plan.getMonth() <= 12)) {
			return "Month not valid!";
		} else if(!(plan.getDay() <= YearMonth.of(plan.getYear(), plan.getMonth()).lengthOfMonth() || !(plan.getDay() >= Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1))) {
			return "Day not valid!";
		}
		return "Valid";
	}
	
	public String checkRoom(Plan plan, List<Plan> plans) {
		
//		List<Plan> bookedPlans = new ArrayList<>();
		List<Plan> bookedPlans =  plans.stream().filter(bookedPlan -> plan.getDay() == bookedPlan.getDay() && plan.getMonth() == bookedPlan.getMonth() && plan.getYear() == bookedPlan.getYear()).findAny().orElse(null);				
		if(bookedPlans!= null) {
			
			return "Room is already booked for this date";
		}
		
		return "Valid";
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
	
	public List<Plan> getAllPlans() {
		return repo.findAll();
	}
	
	public String deletePlan(Long planId) {
		
		repo.deleteById(planId);
		return "Plan in room " + plan.getRoomNumber() + " with group " + plan.getTraineeGroup() + " doing " + plan.getTopic() + " has been removed from planner"; 
	}

}   

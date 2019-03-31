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
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qa.trainer.entities.Plan;
import com.qa.trainer.repository.PlanRepository;

@Service
public class PlanService {
	
	public String checkValid(Plan plan, List<Plan> plans) {
		String dateRes= checkDate(plan);
		if(dateRes.equals("Valid")) {
			String planRes = checkAvailible(plan, plans);
			if(planRes.equals("Valid")){
				return "Valid";
			}else return planRes;			
		}else return dateRes;
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
	
	public String checkAvailible(Plan plan, List<Plan> plans) {
		List<Plan> bookedPlans =  plans.stream()
											.filter(bookedPlan -> plan.getDay() == bookedPlan.getDay()
											&& plan.getMonth() == bookedPlan.getMonth() 
											&& (plan.getYear() == bookedPlan.getYear()))
											.collect(Collectors.toList());			
		if((bookedPlans.stream().map(bookedPlan-> bookedPlan.getRoomNumber()).collect(Collectors.toList()).contains(plan.getRoomNumber()))) {			
			return "Room is already booked for this date";
		}else if((bookedPlans.stream().map(bookedPlan-> bookedPlan.getTrainerId()).collect(Collectors.toList()).contains(plan.getTrainerId()))) {			
			return "Trainer is Busy on this date";
		}		
		return "Valid";
	}
	
// ---------ALL FOR CONTROLLER----------
	
//	public String createPlan(Plan plan) {
//	String dateCheck = checkDate(plan);
//	if(dateCheck.equals("Valid")) {
//		
//	}else return dateCheck;
//}	
//	public Optional<Plan> getPlan(Long trainerId, Long planId) {
//		return repo.findById(planId);
//	}
//	
//	public Plan updatePlan(Long planId, int roomNumber, String traineeGroup, String topic) {
//		Plan plan = new Plan();
//		plan.setRoomNumber(roomNumber);
//		plan.setTraineeGroup(traineeGroup);
//		plan.setTopic(topic);
//		return repo.save(plan);
//	}
//	
//	public List<Plan> getAllPlans() {
//		return repo.findAll();
//	}
//	
//	public String deletePlan(Long planId) {
//		
//		repo.deleteById(planId);
//		return "Plan Deleted"; 
//	}

}   

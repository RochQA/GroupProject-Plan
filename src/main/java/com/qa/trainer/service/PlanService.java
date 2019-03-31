package com.qa.trainer.service;

import java.time.LocalDate;
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
		Date localDate = java.sql.Date.valueOf(LocalDate.now());
		if(plan.getStartDate().before(localDate)) {
			return "Date in past!";
		}else if(plan.getStartDate().after(plan.getEndDate())) {
			return "End date before start date!";		
//		} else if(!(plan.getMonth() >= Calendar.getInstance().get(Calendar.MONTH) + 1) || !(plan.getMonth() <= 12)) {
//			return "Month not valid!";
//		} else if(!(plan.getDay() <= YearMonth.of(plan.getYear(), plan.getMonth()).lengthOfMonth() || !(plan.getDay() >= Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + 1))) {
//			return "Day not valid!";
		}else return "Valid";
	}
	
	public String checkAvailible(Plan plan, List<Plan> plans) {
		Date startDate = plan.getStartDate();
		Date endDate = plan.getEndDate();
		List<Plan> bookedPlans =  plans.stream()
											.filter(bookedPlan -> 
											(startDate.before(bookedPlan.getStartDate())&&endDate.after(bookedPlan.getStartDate()))
											||(startDate.after(bookedPlan.getStartDate())&&startDate.before(bookedPlan.getEndDate()))
											||(startDate.before(bookedPlan.getEndDate())&&endDate.after(bookedPlan.getEndDate()))
											).collect(Collectors.toList());			
		if((bookedPlans.stream().map(bookedPlan-> bookedPlan.getRoomNumber()).collect(Collectors.toList()).contains(plan.getRoomNumber()))) {			
			return "Room is already booked for this date";
		}else if((bookedPlans.stream().map(bookedPlan-> bookedPlan.getTrainerName()).collect(Collectors.toList()).contains(plan.getTrainerName()))) {			
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

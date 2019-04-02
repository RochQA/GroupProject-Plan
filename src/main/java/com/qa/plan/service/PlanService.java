package com.qa.plan.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.plan.entities.Plan;

@Service
public class PlanService {

	public String checkValid(Plan plan, List<Plan> plans) {
		String dateRes = checkDate(plan);
		if (dateRes.equals("Valid")) {
			String planRes = checkAvailible(plan, plans);
			if (planRes.equals("Valid")) {
				return "Valid";
			} else
				return planRes;
		} else
			return dateRes;
	}

	public String checkDate(Plan plan) {
		Date localDate = java.sql.Date.valueOf(LocalDate.now());
		if (plan.getStartDate().before(localDate)) {
			return "Date in past!";
		} else if (plan.getStartDate().after(plan.getEndDate())) {
			return "End date before start date!";
		} else return "Valid";
	}

	public String checkAvailible(Plan plan, List<Plan> plans) {
		Date startDate = plan.getStartDate();
		Date endDate = plan.getEndDate();
		List<Plan> bookedPlans = plans.stream().filter(
				bookedPlan -> (startDate.before(bookedPlan.getStartDate()) && endDate.after(bookedPlan.getStartDate()))
						|| (startDate.after(bookedPlan.getStartDate()) && startDate.before(bookedPlan.getEndDate()))
						|| (startDate.before(bookedPlan.getEndDate()) && endDate.after(bookedPlan.getEndDate()))
						|| (startDate.equals(bookedPlan.getEndDate()))||startDate.equals(bookedPlan.getStartDate())||
							endDate.equals(bookedPlan.getStartDate())||endDate.equals(bookedPlan.getEndDate()))
				.collect(Collectors.toList());
		if ((bookedPlans.stream().map(bookedPlan -> bookedPlan.getRoomNumber()).collect(Collectors.toList())
				.contains(plan.getRoomNumber()))) {
			return "Room is already booked for this date";
		} else if ((bookedPlans.stream().map(bookedPlan -> bookedPlan.getTrainerName()).collect(Collectors.toList())
				.contains(plan.getTrainerName()))) {
			return "Trainer is busy on this date";
		}
		return "Valid";
	}

	public String checkUpdatePlan(Plan plan, Plan oldPlan, List<Plan> allPlans) {
		String dateRes = checkDate(plan);
		if (dateRes.equals("Valid")) {
			Plan matchingPlan = allPlans.stream()
					.filter(pln -> oldPlan.getId().equals(pln.getId()))
					.findFirst()
					.orElse(new Plan());
			allPlans.remove(matchingPlan);
			String planRes = checkAvailible(plan, allPlans);
			if (planRes.equals("Valid")) {
				return "Valid";
			} else return planRes;				
		} else return dateRes;
			
	}

}

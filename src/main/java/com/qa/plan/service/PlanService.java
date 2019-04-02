package com.qa.plan.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.qa.plan.entities.Constants;
import com.qa.plan.entities.Plan;

@Service
public class PlanService {

	public String checkValid(Plan plan, List<Plan> plans) {
		String dateRes = checkDate(plan);
		if (dateRes.equals(Constants.VALID_MESSAGE)) {
			return checkAvailible(plan, plans);
		} else return dateRes;
	}

	public String checkDate(Plan plan) {
		Date localDate = java.sql.Date.valueOf(LocalDate.now());
		if (plan.getStartDate().before(localDate)) {
			return Constants.DATE_PAST_MESSAGE;
		} else if (plan.getStartDate().after(plan.getEndDate())) {
			return Constants.END_BEFORE_START_MESSAGE;
		} else return (String) Constants.VALID_MESSAGE;
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
			return Constants.ROOM_BOOKED;
		} else if ((bookedPlans.stream().map(bookedPlan -> bookedPlan.getTrainerName()).collect(Collectors.toList())
				.contains(plan.getTrainerName()))) {
			return Constants.TRAINER_BUSY;
		}
		return (String) Constants.VALID_MESSAGE;
	}

	public String checkUpdatePlan(Plan plan, Plan oldPlan, List<Plan> allPlans) {
		String dateRes = checkDate(plan);
		if (dateRes.equals(Constants.VALID_MESSAGE)) {
			Plan matchingPlan = allPlans.stream()
					.filter(pln -> oldPlan.getId().equals(pln.getId()))
					.findFirst()
					.orElse(new Plan());
			allPlans.remove(matchingPlan);
			return checkAvailible(plan, allPlans);				
		} else return dateRes;
			
	}

}

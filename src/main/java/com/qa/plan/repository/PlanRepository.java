package com.qa.plan.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.plan.entities.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{

//	Plan findPlan(Long trainerId, Long planId);

}

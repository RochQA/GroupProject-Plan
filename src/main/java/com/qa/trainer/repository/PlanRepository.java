package com.qa.trainer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.trainer.entities.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long>{

//	Plan findPlan(Long trainerId, Long planId);

}

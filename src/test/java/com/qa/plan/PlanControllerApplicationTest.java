package com.qa.plan;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.plan.PlanControllerApplication;
import com.qa.plan.controller.PlanController;
import com.qa.plan.entities.Plan;
import com.qa.plan.service.PlanService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlanControllerApplication.class)
public class PlanControllerApplicationTest {
	
	@InjectMocks
	PlanController con;
	

	@Test
	public void contextLoads() {
		assertThat(con).isNotNull();
	}
}
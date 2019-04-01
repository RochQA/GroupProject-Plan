package com.qa.plan.RESTTests;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.plan.CONSTANTS;
import com.qa.plan.PlanControllerApplication;
import com.qa.plan.controller.PlanController;
import com.qa.plan.entities.Plan;
import com.qa.plan.PlanControllerApplication;
import com.qa.plan.service.PlanService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = PlanControllerApplication.class)
public class PlanRestTest {
	
	@Autowired
	CONSTANTS cons;
	

	@InjectMocks
	PlanController uCon;

	@Mock
	PlanService svc;

	@Mock
	Plan plan;
	
	

	@Before
	public void setup() {
//		uCon.svc;
	}

//	@Test
//	public void testGetAllPlans() {
//		List<Plan> MOCK_LIST = Arrays.asList(plan, plan, plan);
//		Mockito.when(svc.getAllPlans()).thenReturn(MOCK_LIST);
//		assertEquals(MOCK_LIST, uCon.getAllPlans());
//	}

//	@Test
//	public void testGetPlan() {
//		Optional<Plan> MOCK_OBJECT = new Plan();
//		Mockito.when(svc.getPlan(CONSTANTS.TEST_LONG, CONSTANTS.TEST_LONG)).thenReturn(CONSTANTS.MOCK_OPTIONAL_OBJECT);
//		assertEquals(MOCK_OBJECT, uCon.getPlan(CONSTANTS.TEST_LONG, CONSTANTS.TEST_LONG));
//	}
//
//	@Test
//	public void testUpdateAPlan() {
//		
//		
//		Mockito.when(svc.updatePlan(CONSTANTS.TEST_LONG, 0, CONSTANTS.TEST_STRING, null)).thenReturn(CONSTANTS.MOCK_OBJECT);
//		assertEquals(CONSTANTS.MOCK_OBJECT , uCon.updatePlan(CONSTANTS.TEST_LONG, 0, CONSTANTS.TEST_STRING, null));
//	}
//
//	@Test
//	public void testDeletePlan() {
//		Mockito.when(svc.deletePlan(CONSTANTS.TEST_LONG)).thenReturn(CONSTANTS.TEST_STRING);
//		assertEquals(CONSTANTS.TEST_STRING, uCon.deletePlan(CONSTANTS.TEST_LONG));
//	} 
}

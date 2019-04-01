package com.qa.plan.Business.serviceTests;

import static org.junit.Assert.assertEquals;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.plan.CONSTANTS;
import com.qa.plan.PlanControllerApplication;
import com.qa.plan.entities.Plan;
import com.qa.plan.repository.PlanRepository;
import com.qa.plan.service.PlanService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = PlanControllerApplication.class)
public class PlanServiceTest {

		private static final Long testLong = 1L;
		private static final String testString = "test";
		
		@InjectMocks
		PlanService svc;

		@Mock
		PlanRepository repo;

		@Before
		public void setup() {

		}
		
		@Test
		public void testCreatePlan() {
			int month = 7;
			System.out.println(Calendar.MONTH);
//			Mockito.when(repo.save(Mockito.any())).thenReturn(CONSTANTS.MOCK_OBJECT);
//			assertEquals(CONSTANTS.MOCK_OBJECT, svc.createPlan(CONSTANTS.TEST_LONG, "" + Calendar.getInstance().get(Calendar.DAY_OF_MONTH), "" + Calendar.getInstance().get(Calendar.MONTH), "" + Calendar.getInstance().get(Calendar.YEAR), CONSTANTS.TEST_INT, CONSTANTS.TEST_STRING, CONSTANTS.TEST_STRING));
		}
		
//		@Test
//		public void testGetPlan() {
//			Mockito.when(repo.findById(CONSTANTS.TEST_LONG)).thenReturn(CONSTANTS.MOCK_OPTIONAL_OBJECT);
//			assertEquals(CONSTANTS.MOCK_OPTIONAL_OBJECT, svc.getPlan(CONSTANTS.TEST_LONG, CONSTANTS.TEST_LONG));
//		}
	} 


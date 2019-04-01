package com.qa.plan.Business.serviceTests;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.plan.PlanControllerApplication;
import com.qa.plan.entities.Plan;
import com.qa.plan.repository.PlanRepository;
import com.qa.plan.service.PlanService;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = PlanControllerApplication.class)
public class PlanServiceTest {

		private static final Plan plan2 = new Plan();
		private static final Plan plan1  = new Plan();
		private static final Plan clashPlan = new Plan();
		private static final Date startDate1 = new Date(119, 5, 1);
		private static final Date endDate1 = new Date(119, 11, 1);
		private static final Date startDate2 = new Date(119, 1, 1);
		private static final Date endDate2 = new Date(119, 8, 1);
		private static final Date clashStart = new Date(119, 6, 1);
		private static final Date clashEnd = new Date(119, 7, 1);
		private static List<Plan> plans;
		
		@InjectMocks
		PlanService svc;

		@Mock
		PlanRepository repo;
		
		@Mock
		Plan plan;

		@Before
		public void setup() {
			plan2.setEndDate(endDate1);
			plan2.setStartDate(startDate1);
			plan2.setRoomNumber(7);
			plan2.setTrainerName("Jordan Harrison");
			plan1.setEndDate(endDate2);
			plan1.setStartDate(startDate2);
			plan1.setRoomNumber(5);
			plan1.setTrainerName("Chester Gardner");
			clashPlan.setEndDate(clashEnd);
			clashPlan.setStartDate(clashStart);
			clashPlan.setRoomNumber(6);
			clashPlan.setTrainerName("Jordan Harrison");
			
			plans = new ArrayList<Plan>();
			plans.add(plan2);
			
		}
		
		@Test
		public void testCheckDate1() {
			Mockito.when(plan.getStartDate()).thenReturn(startDate1);
			Mockito.when(plan.getEndDate()).thenReturn(endDate1);
			assertEquals(svc.checkDate(plan),"Valid");
		}
		
		@Test
		public void testCheckDate2() {
			Mockito.when(plan.getStartDate()).thenReturn(startDate2);
			assertEquals("Date in past!", svc.checkDate(plan));
		}
		
		@Test
		public void testCheckDate3() {
			Mockito.when(plan.getStartDate()).thenReturn(endDate2);
			Mockito.when(plan.getEndDate()).thenReturn(startDate2);
			assertEquals("End date before start date!", svc.checkDate(plan));
		}
		
		@Test
		public void testCheckAvailable() {
			assertEquals(svc.checkAvailible(plan1, plans), "Valid");
		}
		
		@Test
		public void testCheckAvailable2() {
			plan1.setRoomNumber(7);
			assertEquals(svc.checkAvailible(plan1, plans), "Room is already booked for this date");
		}
		
		@Test
		public void testCheckAvailable3() {
			
			assertEquals(svc.checkAvailible(clashPlan, plans), "Trainer is busy on this date");
		}
		
		@Test
		public void testCheckValid() {
			assertEquals(svc.checkValid(plan2, plans),"Valid");
		}
				
		@Test
		public void testCheckValid2() {
			assertEquals(svc.checkValid(plan1, plans),"Date in past!");
		}
		
		@Test
		public void testCheckValid3() {
			assertEquals(svc.checkValid(clashPlan, plans),"Trainer is busy on this date");
		}

	} 


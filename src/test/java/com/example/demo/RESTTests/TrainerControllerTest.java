package com.example.demo.RESTTests;


import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.CONSTANTS;
import com.qa.trainer.controller.TrainerController;
import com.qa.trainer.entities.Trainer;
import com.qa.trainer.service.TrainerService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TrainerControllerTest {
	
	@InjectMocks
	TrainerController con;
	
	@Mock
	TrainerService svc;
	
	@Test
	public void testGetAllTrainers() {
		Mockito.when(svc.getAllTrainers()).thenReturn(CONSTANTS.TRAINER_LIST);
		assertEquals(CONSTANTS.TRAINER_LIST, con.getAllTrainers());
	}
	
	@Test
	public void testGetATrainer() {
		CONSTANTS.JORDAN.setId(1L);
		CONSTANTS.JORDAN.setName(CONSTANTS.TEST_STRING);
		Mockito.when(svc.getTrainer(CONSTANTS.TEST_LONG)).thenReturn(CONSTANTS.JORDAN);
		assertEquals(CONSTANTS.TEST_STRING, con.getTrainer(1L).getName());
	}

	@Test
	public void testDeleteTrainer() {
		Mockito.when(svc.deleteTrainer(CONSTANTS.TEST_LONG)).thenReturn(CONSTANTS.TEST_STRING);
		assertEquals(CONSTANTS.TEST_STRING, con.deleteTrainer(CONSTANTS.TEST_LONG));
	} 
	
	@Test
	public void createTrainer() {
		CONSTANTS.JORDAN.setId(CONSTANTS.TEST_LONG);
		CONSTANTS.JORDAN.setName(CONSTANTS.TEST_STRING);
		Mockito.when(svc.createTrainer(CONSTANTS.JORDAN)).thenReturn(CONSTANTS.JORDAN);
		assertEquals(CONSTANTS.JORDAN, con.createTrainer(CONSTANTS.JORDAN));
	} 
}

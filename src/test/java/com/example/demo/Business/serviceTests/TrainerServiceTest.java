package com.example.demo.Business.serviceTests;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
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
import com.qa.trainer.entities.Trainer;
import com.qa.trainer.repository.TrainerRepository;
import com.qa.trainer.service.TrainerService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TrainerServiceTest {
	
	@InjectMocks
	TrainerService svc;
	
	@Mock
	TrainerRepository repo;
	
	@Test
	public void testGetAllTrainers() {
		Mockito.when(repo.findAll()).thenReturn(CONSTANTS.TRAINER_LIST);
		assertEquals(CONSTANTS.TRAINER_LIST, svc.getAllTrainers());
	}
	
	@Test
	public void testGetATrainer() {
		CONSTANTS.JORDAN.setId(CONSTANTS.TEST_LONG);
		CONSTANTS.TRAINER_LIST.add(CONSTANTS.JORDAN);
		Mockito.when(repo.findAll()).thenReturn(CONSTANTS.TRAINER_LIST);
		assertEquals(CONSTANTS.JORDAN, svc.getTrainer(CONSTANTS.TEST_LONG));
	}
	
	@Test
	public void testCreateTrainer() {
		CONSTANTS.JORDAN.setId(CONSTANTS.TEST_LONG);
		CONSTANTS.JORDAN.setName("Jordan Harrison");
		Mockito.when(repo.save(CONSTANTS.JORDAN)).thenReturn(CONSTANTS.JORDAN);
		assertEquals(CONSTANTS.JORDAN, svc.createTrainer(CONSTANTS.JORDAN));
	}
	
	@Test
	public void testDeleteTrainer() {
		//to do
	}
	
}

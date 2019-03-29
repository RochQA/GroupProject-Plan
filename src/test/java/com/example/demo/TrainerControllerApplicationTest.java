package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.qa.trainer.TrainerControllerApplication;
import com.qa.trainer.controller.TrainerController;
import com.qa.trainer.entities.Trainer;
import com.qa.trainer.service.TrainerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TrainerControllerApplication.class)
public class TrainerControllerApplicationTest {
	
	@InjectMocks
	TrainerController con;
	
	//Smoke Test
	@Test
	public void contextLoads() {
		assertThat(con).isNotNull();
	}
}

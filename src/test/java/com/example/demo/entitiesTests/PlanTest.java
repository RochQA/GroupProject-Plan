package com.example.demo.entitiesTests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.CONSTANTS;
import com.qa.trainer.TrainerControllerApplication;
import com.qa.trainer.entities.Plan;
import com.qa.trainer.repository.PlanRepository;

@SpringBootTest(classes = TrainerControllerApplication.class)
public class PlanTest {
	
    @Before
    public void setUp(){
    
    }
	
	@Test
	public void updatePlan_WithValidInput_ShouldReturnUpdatedInput() {
	    CONSTANTS.MOCK_OBJECT.setPlanId(CONSTANTS.TEST_LONG);
	    CONSTANTS.MOCK_OBJECT.setRoomNumber(CONSTANTS.TEST_INT);
	    CONSTANTS.MOCK_OBJECT.setTraineeGroup(CONSTANTS.TEST_STRING);
	    CONSTANTS.MOCK_OBJECT.setTopic(CONSTANTS.TEST_STRING);
	    CONSTANTS.MOCK_OBJECT.setTrainerId(CONSTANTS.TEST_LONG);
	    
	    assertEquals(CONSTANTS.TEST_LONG, CONSTANTS.MOCK_OBJECT.getPlanId());
	    assertEquals(CONSTANTS.TEST_INT, CONSTANTS.MOCK_OBJECT.getRoomNumber());
	    assertEquals(CONSTANTS.TEST_STRING, CONSTANTS.MOCK_OBJECT.getTraineeGroup());
	    assertEquals(CONSTANTS.TEST_STRING, CONSTANTS.MOCK_OBJECT.getTopic());
	    assertEquals(CONSTANTS.TEST_LONG, CONSTANTS.MOCK_OBJECT.getTrainerId());
	}
}

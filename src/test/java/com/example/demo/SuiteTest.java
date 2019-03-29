package com.example.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.example.demo.Business.serviceTests.TrainerServiceTest;
import com.example.demo.RESTTests.TrainerControllerTest;

@RunWith(Suite.class)

@SuiteClasses( { TrainerControllerApplicationTest.class, TrainerControllerTest.class, TrainerServiceTest.class } )

public class SuiteTest {

}
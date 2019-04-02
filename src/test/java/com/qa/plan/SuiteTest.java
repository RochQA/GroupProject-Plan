package com.qa.plan;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.qa.plan.Business.serviceTests.PlanServiceTest;

@RunWith(Suite.class)

@SuiteClasses( { PlanControllerApplicationTest.class, PlanServiceTest.class } )

public class SuiteTest {

}
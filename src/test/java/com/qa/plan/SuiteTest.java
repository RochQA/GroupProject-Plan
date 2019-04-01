package com.qa.plan;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.qa.plan.Business.serviceTests.PlanServiceTest;
import com.qa.plan.RESTTests.PlanRestTest;

@RunWith(Suite.class)

@SuiteClasses( { PlanControllerApplicationTest.class, PlanRestTest.class, PlanServiceTest.class } )

public class SuiteTest {

}
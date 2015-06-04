package br.com.edu.metodologia.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BruteForceTest.class, KMPTest.class, RabinKarpTest.class })
public class AllTests {

}

package br.com.edu.metodologia.main.search;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.edu.metodologia.test.BruteForceTest;
import br.com.edu.metodologia.test.KMPTest;
import br.com.edu.metodologia.test.RabinKarpTest;

@RunWith(Suite.class)
@SuiteClasses({ BruteForceTest.class, KMPTest.class, RabinKarpTest.class })
public class AllTests {

}

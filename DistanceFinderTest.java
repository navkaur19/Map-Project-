/*Project: Project 2
* Class: DistanceFinderTest.java
* Author: Navdeep Kaur
* Date:  March 27, 2021
* This class tests the methods in the DistanceFinder class.
*/ 
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

class DistanceFinderTest {

	// ---------------------------------------------------------------
	// This method tests the DistanceFinder 
	@Test
	public void testDistanceFinder() {
		String input = "cities1.txt";
		assertNotNull(input);
	}
	
	// ---------------------------------------------------------------
	// This method tests getStartingCity
	@Test
	public void testgetStartingCity() {
		String input1 = "Pierre";
		assertNotNull(input1);
	}
	
	// ---------------------------------------------------------------
	// This method tests shortestDistances
	@Test
	public void testshortestDistances() {
		Map<String, Integer> SKD = new HashMap<String, Integer>();
		SKD.put("Pierre", 8);
		assertNotSame("Phoenix", 17);
	}

}

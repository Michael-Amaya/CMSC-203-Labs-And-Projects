

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	ManagementCompany testCompany;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		testCompany = new ManagementCompany("Company P", "423e", 53);
		
		//student add three properties, with plots, to mgmt co
		Property testProp1 = new Property("Property1","Rockville",400,"Michael A", 1,1,1,1);
		Property testProp2 = new Property("Property2","Silver Spring",700,"Sierra T", 5,5,3,3);
		Property testProp3 = new Property("Property3","Gaithersburg",400,"Daniel A", 9,9,1,1);
		
		testCompany.addProperty(testProp1);
		testCompany.addProperty(testProp2);
		testCompany.addProperty(testProp3);
	}

	@After
	public void tearDown() {
		testCompany = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		assertEquals(3, testCompany.addProperty("Property4", "Silver Spring", 400, "Christopher A"), .001);
		//student should add property with 8 args
		assertEquals(4, testCompany.addProperty("Property5", "Gaithersburg", 200, "Hally K", 8, 8, 1, 1), .001);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1	
		assertEquals(-1, testCompany.addProperty("Fake Property", "Fairfax", 1000, "Mr. Fake", 3, 3, 1, 1), .001);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertTrue(testCompany.maxRentProp().split("\n")[3].contains("700"));
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(1500, testCompany.totalRent(), .001);
	}

 }

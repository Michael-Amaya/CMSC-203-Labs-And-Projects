import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	GradeBook gb1;	// Global test
	GradeBook gb2;	// Variables
	
	/** Setup 2 gradebooks */
	@BeforeEach
	void setUp() throws Exception {
		// Create 2 gradebooks with 5 capacity
		gb1 = new GradeBook(5);
		gb2 = new GradeBook(5);
		
		// Give dummy data
		gb1.addScore(100);
		gb1.addScore(94);
		gb1.addScore(78);
		gb1.addScore(93);
		
		gb2.addScore(73);
		gb2.addScore(95);
		gb2.addScore(53);
		gb2.addScore(64);
	}

	/** Reset the gradebooks when done */
	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}

	/** Test to make sure the addScore method works */
	@Test
	void testAddScore() {
		gb1.addScore(82);
		gb2.addScore(88);
		assertTrue(gb1.toString().equals("100.0 94.0 78.0 93.0 82.0 "));
		assertTrue(gb2.toString().equals("73.0 95.0 53.0 64.0 88.0 "));
	}

	/** Test to make sure sum method work */
	@Test
	void testSum() {
		assertEquals(365, gb1.sum(), .001);
		assertEquals(285, gb2.sum(), .001);
	}

	/** Test to make sure the minimum method works */
	@Test
	void testMinimum() {
		assertEquals(53, gb2.minimum(), .001);
		assertEquals(78, gb1.minimum(), .001);
	}

	/** Test to make sure the finalScore method works */
	@Test
	void testFinalScore() {
		assertEquals(287, gb1.finalScore(), .001);
		assertEquals(232, gb2.finalScore(), .001);
	}

	/** Test to make sure the getScoreSize method works */
	@Test
	void testGetScoreSize() {
		assertEquals(4, gb1.getScoreSize());
		assertEquals(4, gb2.getScoreSize());
	}

	/** Test to make sure the toString method works */
	@Test
	void testToString() {
		assertTrue(gb1.toString().equals("100.0 94.0 78.0 93.0 0.0 "));
		assertTrue(gb2.toString().equals("73.0 95.0 53.0 64.0 0.0 "));
	}

}

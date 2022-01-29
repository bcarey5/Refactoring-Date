package src;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDate {

	@Test
	void testMonth() {
		Date orig = new Date(1, 1, 1999);
		assertEquals(1, orig.getMonth());
	}

	@Test
	void testSetMonth() {
		Date orig = new Date(1, 1, 1999);
		orig.setMonth(2);
		assertEquals(2, orig.getMonth());
	}
	@Test
	void testMonthOK() {
		Date orig = new Date(1, 1, 1999);
		orig.setDate("January",1, 1999);
		assertEquals(1, orig.getMonth());
	}
}

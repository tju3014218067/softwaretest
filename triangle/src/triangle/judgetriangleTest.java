package triangle;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class judgetriangleTest {
	private static judgetriangle triangle = new judgetriangle();

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEquilateral() {
		int a = 1;
		int b = 1;
		int c = 1;
		assertEquals(true,triangle.equilateral(a, b, c));
	}

	@Test
	public void testIsosceles() {
		int a = 1;
		int b = 2;
		int c = 2;
		assertEquals(true,triangle.isosceles(a, b, c));
	}

	@Test
	public void testScalene() {
		int a = 2;
		int b = 3;
		int c = 4;
		assertEquals(true,triangle.scalene(a, b, c));
	}

}

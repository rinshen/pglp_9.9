package fr.uvsq.rinshen.ex99;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCarre {
	@Test
	public void testCreation() {
		int abs = 10;
		int ord = 20;
		int r = 10;
		Point p = new Point(abs, ord);
		Carre c = new Carre("c", p, r);
		assertEquals(abs, c.getCentre().getAbs());
		assertEquals(ord, c.getCentre().getOrd());
		assertEquals(r, c.getCote());
	}
	
	@Test
	public void testMove() {
		int abs = 10;
		int ord = 20;
		int r = 10;
		int d = 10;
		Point p = new Point(abs, ord);
		Carre c = new Carre("c", p, r);
		c.move(d,  d);
		assertEquals(abs + d, c.getCentre().getAbs());
		assertEquals(ord + d, c.getCentre().getOrd());
		assertEquals(r, c.getCote());
	}
}

package fr.uvsq.rinshen.ex99;

import static org.junit.Assert.*;

import org.junit.Test;

public class testCercle {
	@Test
	public void testCreation() {
		int abs = 10;
		int ord = 20;
		int r = 10;
		Point p = new Point(abs, ord);
		Cercle c = new Cercle("c", p, r);
		assertEquals(abs, c.getCentre().getAbs());
		assertEquals(ord, c.getCentre().getOrd());
		assertEquals(r, c.getRayon());
	}
	
	@Test
	public void testMove() {
		int abs = 10;
		int ord = 20;
		int r = 10;
		int d = 10;
		Point p = new Point(abs, ord);
		Cercle c = new Cercle("c", p, r);
		c.move(d,  d);
		assertEquals(abs + d, c.getCentre().getAbs());
		assertEquals(ord + d, c.getCentre().getOrd());
		assertEquals(r, c.getRayon());
	}
}

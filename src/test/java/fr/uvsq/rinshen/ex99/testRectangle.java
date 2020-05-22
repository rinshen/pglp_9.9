package fr.uvsq.rinshen.ex99;

import static org.junit.Assert.*;

import org.junit.Test;

public class testRectangle {
	@Test
	public void testCreation() {
		int abs = 10;
		int ord = 20;
		int l = 10;
		int h = 30;
		Point p = new Point(abs, ord);
		Rectangle r = new Rectangle("r", p, l, h);
		assertEquals(abs, r.getCentre().getAbs());
		assertEquals(ord, r.getCentre().getOrd());
		assertEquals(l, r.getLargeur());
		assertEquals(h, r.getHauteur());
	}
	
	@Test
	public void testMove() {
		int abs = 10;
		int ord = 20;
		int l = 10;
		int h = 30;
		int d = 10;
		Point p = new Point(abs, ord);
		Rectangle r = new Rectangle("r", p, l, h);
		r.move(d, d);
		assertEquals(abs + d, r.getCentre().getAbs());
		assertEquals(ord + d, r.getCentre().getOrd());
		assertEquals(l, r.getLargeur());
		assertEquals(h, r.getHauteur());
	}
}

package fr.uvsq.rinshen.ex99;

import static org.junit.Assert.*;

import org.junit.Test;

public class testPoint {
	@Test
	public void testCreation() {
		int abs = 10;
		int ord = 20;
		Point p = new Point(abs, ord);
		assertEquals(abs, p.getAbs());
		assertEquals(ord, p.getOrd());
	}
	
	@Test
	public void testDeplacer() {
		int abs = 10;
		int ord = 20;
		int x = 20;
		int y = 20;
		Point p = new Point(abs, ord);
		p.deplacer(x, y);
		assertEquals(abs+x, p.getAbs());
		assertEquals(ord+y, p.getOrd());
	}
}

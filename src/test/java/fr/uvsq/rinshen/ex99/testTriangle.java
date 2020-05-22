package fr.uvsq.rinshen.ex99;

import static org.junit.Assert.*;

import org.junit.Test;

public class testTriangle {
	@Test
	public void testCreation() {
		int abs1 = 10;
		int ord1 = 20;
		int abs2 = 50;
		int ord2 = 30;
		int abs3 = 40;
		int ord3 = 60;
		
		Point p1 = new Point(abs1, ord1);
		Point p2 = new Point(abs2, ord2);
		Point p3 = new Point(abs3, ord3);
		Triangle t = new Triangle("t", p1, p2, p3);
		
		assertEquals(abs1 , t.getP1().getAbs());
		assertEquals(ord1 , t.getP1().getOrd());
		assertEquals(abs2 , t.getP2().getAbs());
		assertEquals(ord2 , t.getP2().getOrd());
		assertEquals(abs3 , t.getP3().getAbs());
		assertEquals(ord3 , t.getP3().getOrd());
	}
	
	@Test
	public void testMove() {
		int abs1 = 10;
		int ord1 = 20;
		int abs2 = 50;
		int ord2 = 30;
		int abs3 = 40;
		int ord3 = 60;
		int d1 = 20;
		int d2 = 10;
		
		Point p1 = new Point(abs1, ord1);
		Point p2 = new Point(abs2, ord2);
		Point p3 = new Point(abs3, ord3);
		Triangle t = new Triangle("t", p1, p2, p3);
		t.move(d1, d2);
		
		assertEquals(abs1 + d1, t.getP1().getAbs());
		assertEquals(ord1 + d2, t.getP1().getOrd());
		assertEquals(abs2 + d1, t.getP2().getAbs());
		assertEquals(ord2 + d2, t.getP2().getOrd());
		assertEquals(abs3 + d1, t.getP3().getAbs());
		assertEquals(ord3 + d2, t.getP3().getOrd());
	}
}

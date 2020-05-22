package fr.uvsq.rinshen.ex99;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDessin {

	@Test
	public void testReinit() {
		Dessin d = new Dessin();
		d.getGroupes().add(new GroupeComposite("g"));
		d.getFormes().add(new Carre("c", new Point(0, 0), 10));
		d.reinit();
		assertEquals(0, d.getGroupes().size());
		assertEquals(0, d.getFormes().size());
	}
}

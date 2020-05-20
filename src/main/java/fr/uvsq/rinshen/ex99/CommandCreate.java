package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public class CommandCreate implements Command{
	public void execute(ArrayList<Forme> dessin, String commande) {
		String[] form = commande.split(" ");
		if(form.length<2) {
			System.out.println("Il manque un ou plusieurs arguments");
			return;
		}
		if(form[0].equals("carre")) {
			if(form.length<5) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point centre = new Point(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				Carre c = new Carre(form[1], centre, Integer.parseInt(form[4]));
				dessin.add(c);
			}
			return;
		}
		if(form[0].equals("cercle")) {
			if(form.length<5) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point centre = new Point(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				Cercle c = new Cercle(form[1], centre, Integer.parseInt(form[4]));
				dessin.add(c);
			}
			return;
		}
		if(form[0].equals("rectangle")) {
			if(form.length<6) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point centre = new Point(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				Rectangle r = new Rectangle(form[1], centre, Integer.parseInt(form[4]), Integer.parseInt(form[5]));
				dessin.add(r);
			}
			return;
		}
		if(form[0].equals("triangle")) {
			if(form.length<8) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point p1 = new Point(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				Point p2 = new Point(Integer.parseInt(form[4]), Integer.parseInt(form[5]));
				Point p3 = new Point(Integer.parseInt(form[6]), Integer.parseInt(form[7]));
				Triangle t = new Triangle(form[1], p1, p2, p3);
				dessin.add(t);
			}
			return;
		}
		System.out.println("Forme non reconnue");
		System.out.println(form[0] + " n'est pas une forme prise en charge par l'application");
	}
}

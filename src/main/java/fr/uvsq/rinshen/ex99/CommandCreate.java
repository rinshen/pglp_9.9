package fr.uvsq.rinshen.ex99;

public class CommandCreate implements Command {
	public void execute(Dessin dessin, String commande) {
		String[] form = commande.split(" ");
		if (form[0].equals("carre")) {
			if (form.length < 5) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point centre = new Point(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				Carre c = new Carre(form[1], centre, Integer.parseInt(form[4]));
				dessin.getFormes().add(c);
			}
			return;
		}
		if (form[0].equals("cercle")) {
			if (form.length < 5) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point centre = new Point(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				Cercle c = new Cercle(form[1], centre, Integer.parseInt(form[4]));
				dessin.getFormes().add(c);
			}
			return;
		}
		if (form[0].equals("rectangle")) {
			if (form.length < 6) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point centre = new Point(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				Rectangle r = new Rectangle(form[1], centre, Integer.parseInt(form[4]), Integer.parseInt(form[5]));
				dessin.getFormes().add(r);
			}
			return;
		}
		if (form[0].equals("triangle")) {
			if (form.length < 8) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point p1 = new Point(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				Point p2 = new Point(Integer.parseInt(form[4]), Integer.parseInt(form[5]));
				Point p3 = new Point(Integer.parseInt(form[6]), Integer.parseInt(form[7]));
				Triangle t = new Triangle(form[1], p1, p2, p3);
				dessin.getFormes().add(t);
			}
			return;
		}
		if (form[0].equals("simple")) {
			if (form.length < 2) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				;
			}
		}
		if (form[0].equals("composite")) {
			;
		}
		System.out.println("Forme non reconnue");
		System.out.println(form[0] + " n'est pas une forme prise en charge par l'application");
	}
}

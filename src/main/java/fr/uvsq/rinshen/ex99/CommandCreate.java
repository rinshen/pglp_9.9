package fr.uvsq.rinshen.ex99;

public class CommandCreate implements Command {
	/**
	 * Fonction qui reconnait le nom d'une forme donné en argument et construit l'objet
	 * correspondant avec les paramètres spécifiés.
	 * Chaque bloc suit la même structure: On vérifie le nombre d'arguments puis
	 * on apelle le constructeur de la classe voulue avec ces arguments.
	 */
	public void execute(Dessin dessin, String commande) {
		//On sépare la chaine contenant la commande pour pouvoir accéder a chaque argument
		String[] form = commande.split(" ");
		
		//Si l'utilisateur demande un carré
		if (form[0].equals("carre")) {
			if (form.length < 5) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point centre = new Point(Integer.parseInt(form[2]), 
						Integer.parseInt(form[3]));
				Carre c = new Carre(form[1], centre, Integer.parseInt(form[4]));
				dessin.getFormes().add(c);
			}
			return;
		}
		
		//Si l'utilisateur demande un cercle
		if (form[0].equals("cercle")) {
			if (form.length < 5) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point centre = new Point(
						Integer.parseInt(form[2]), 
						Integer.parseInt(form[3]));
				Cercle c = new Cercle(form[1], centre, 
						Integer.parseInt(form[4]));
				dessin.getFormes().add(c);
			}
			return;
		}
		
		//Si l'utilisateur demande un rectangle
		if (form[0].equals("rectangle")) {
			if (form.length < 6) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point centre = new Point(
						Integer.parseInt(form[2]),
						Integer.parseInt(form[3]));
				Rectangle r = new Rectangle(form[1], centre, 
						Integer.parseInt(form[4]), 
						Integer.parseInt(form[5]));
				dessin.getFormes().add(r);
			}
			return;
		}
		
		//Si l'utilisateur demande un triangle
		if (form[0].equals("triangle")) {
			if (form.length < 8) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				Point p1 = new Point(Integer.parseInt(form[2]), 
						Integer.parseInt(form[3]));
				Point p2 = new Point(Integer.parseInt(form[4]), 
						Integer.parseInt(form[5]));
				Point p3 = new Point(Integer.parseInt(form[6]), 
						Integer.parseInt(form[7]));
				Triangle t = new Triangle(form[1], p1, p2, p3);
				dessin.getFormes().add(t);
			}
			return;
		}
		
		//Si l'utilisateur demande un groupe simple
		if (form[0].equals("simple")) {
			if (form.length < 2) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				GroupeSimple g = new GroupeSimple(form[1]);
				dessin.getGroupes().add(g);
			}
			return;
		}
		
		//Si l'utilisateur demande un groupe composite
		if (form[0].equals("composite")) {
			if (form.length < 2) {
				System.out.println("Il manque un ou plusieurs arguments");
			} else {
				GroupeComposite g = new GroupeComposite(form[1]);
				dessin.getGroupes().add(g);
			}
			return;
		}
		
		//Si la forme en argument n'est pas prise en charge
		System.out.println("Forme non reconnue");
		System.out.println(form[0]
				+ " n'est pas une forme prise en charge par l'application");
	}
}

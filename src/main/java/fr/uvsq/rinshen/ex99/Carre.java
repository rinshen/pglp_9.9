package fr.uvsq.rinshen.ex99;

public class Carre extends Forme {
	private Point centre;
	private int cote;

	public Carre(String nom, Point p, int largeur) {
		points = 4;
		this.nom = nom;
		centre = p;
		cote = largeur;
	}

	@Override
	public void move(int horizontal, int vertical) {
		centre.deplacer(horizontal, vertical);	
	}

	@Override
	public void afficher() {
		System.out.println("Carré " + nom);
		System.out.println("Côté: " + cote);
		System.out.println("Centre:");
		centre.afficher();
		System.out.println("");
	}
}

package fr.uvsq.rinshen.ex99;

public class Rectangle extends Forme {
	private Point centre;
	private int largeur;
	private int hauteur;

	public Rectangle(String nom, Point p, int largeur, int hauteur) {
		points = 4;
		this.nom = nom;
		centre = p;
		this.largeur = largeur;
		this.hauteur = hauteur;
	}

	@Override
	public void move(int horizontal, int vertical) {
		centre.deplacer(horizontal, vertical);	
	}

	@Override
	public void afficher() {
		System.out.println("Rectangle " + nom);
		System.out.println("Largeur: " + largeur);
		System.out.println("Hauteur: " + hauteur);
		System.out.println("Centre:");
		centre.afficher();
		System.out.println("");
	}
}

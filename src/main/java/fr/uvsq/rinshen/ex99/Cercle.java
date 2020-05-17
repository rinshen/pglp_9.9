package fr.uvsq.rinshen.ex99;

public class Cercle extends Forme {
	private Point centre;
	private int rayon;
	
	/**
	 * Constructeur de la classe Cercle.
	 * @param nom Nom du cercle
	 * @param p Centre du cercle
	 * @param r Rayon du cercle
	 */
	public Cercle(String nom, Point p, int r) {
		type = 1;
		this.nom = nom;
		rayon = r;
		centre = p;
	}

	@Override
	public void move(int horizontal, int vertical) {
		centre.deplacer(horizontal, vertical);	
	}

	@Override
	public void afficher() {
		System.out.println("Cercle " + nom);
		System.out.println("Rayon: " + rayon);
		System.out.println("Centre:");
		centre.afficher();
		System.out.println("");
	}

	public Point getCentre() {
		return centre;
	}

	public int getRayon() {
		return rayon;
	}
}

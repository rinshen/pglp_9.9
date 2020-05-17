package fr.uvsq.rinshen.ex99;

public class Carre extends Forme {
	private Point centre;
	private int cote;

	/**
	 * Constructeur de la classe Carre.
	 * @param nom Nom du carré
	 * @param p Point au centre du carré
	 * @param largeur Taille du coté du carré
	 */
	public Carre(String nom, Point p, int largeur) {
		type = 2;
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

	public Point getCentre() {
		return centre;
	}

	public int getCote() {
		return cote;
	}
}

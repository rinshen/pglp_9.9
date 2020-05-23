package fr.uvsq.rinshen.ex99;

/**
 * Classe représentant un point.
 */
public class Point {
	//Coordonnées du point
	private int abs;
	private int ord;
	
	public Point(int x, int y) {
		this.setAbs(x);
		this.setOrd(y);
	}
	
	/**
	 * Fonction permettant de déplacer le point.
	 * @param horizontal -> Déplacement horizontal
	 * @param vertical -> Déplacement vertical
	 */
	public void deplacer(int horizontal, int vertical) {
		abs += horizontal;
		ord += vertical;
	}
	
	/**
	 * Fonction permettant d'afficher les coordonnées du point.
	 */
	public void afficher() {
		System.out.println("--abscisses: " + abs);
		System.out.println("--ordonnées: " + ord);
	}

	public int getAbs() {
		return abs;
	}

	public void setAbs(int x) {
		this.abs = x;
	}

	public int getOrd() {
		return ord;
	}

	public void setOrd(int y) {
		this.ord = y;
	}
}

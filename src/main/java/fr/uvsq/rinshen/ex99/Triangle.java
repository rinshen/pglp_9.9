package fr.uvsq.rinshen.ex99;

public class Triangle extends Forme {
	private Point p1;
	private Point p2;
	private Point p3;

	/**
	 * Constructeur de la classe Triangle.
	 * @param nom Nom du triangle
	 * @param p1 Premier point du triangle
	 * @param p2 Deuxième point du triangle
	 * @param p3 Troisième point du triangle
	 */
	public Triangle(String nom, Point p1, Point p2, Point p3) {
		type = 3;
		this.nom = nom;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	}
	
	@Override
	public void move(int horizontal, int vertical) {
		p1.deplacer(horizontal, vertical);
		p2.deplacer(horizontal, vertical);
		p3.deplacer(horizontal, vertical);
	}
	
	@Override
	public void afficher() {
		System.out.println("Triangle " + nom);
		System.out.println("Point 1:");
		p1.afficher();
		System.out.println("Point 2:");
		p2.afficher();
		System.out.println("Point 3:");
		p3.afficher();
		System.out.println("");
	}

	public Point getP1() {
		return p1;
	}

	public Point getP2() {
		return p2;
	}

	public Point getP3() {
		return p3;
	}
}

package fr.uvsq.rinshen.ex99;

public abstract class Forme {
	protected int points;
	protected String nom;

	public abstract void move(int horizontal, int vertical);

	public abstract void afficher();
	
	public int getPoints() {
		return points;
	}

	public String getNom() {
		return nom;
	}
}

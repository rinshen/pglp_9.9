package fr.uvsq.rinshen.ex99;

public abstract class Forme {
	protected int type;
	protected String nom;

	public abstract void move(int horizontal, int vertical);

	public abstract void afficher();
	
	public int getType() {
		return type;
	}

	public String getNom() {
		return nom;
	}
}

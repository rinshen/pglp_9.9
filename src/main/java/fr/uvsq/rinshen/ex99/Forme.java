package fr.uvsq.rinshen.ex99;

/**
 * Classe abstraite pour représenter les formes.
 */
public abstract class Forme {
	protected int type;
	protected String nom;

	/**
	 * Permet de déplacer la forme.
	 * @param horizontal -> Décalage horizontal
	 * @param vertical -> Décalage vertical
	 */
	public abstract void move(int horizontal, int vertical);

	/**
	 * Permet d'afficher la forme.
	 */
	public abstract void afficher();
	
	public int getType() {
		return type;
	}

	public String getNom() {
		return nom;
	}
}

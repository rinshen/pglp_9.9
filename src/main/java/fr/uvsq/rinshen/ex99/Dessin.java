package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

/**
 * Classe représentant un dessin. Elle peut contenir des formes et des groupes.
 */
public class Dessin {
	//Liste des formes
	private ArrayList<Forme> formes;
	//Liste des groupes
	private ArrayList<Groupe> groupes;
	
	public Dessin() {
		formes = new ArrayList<Forme>();
		groupes = new ArrayList<Groupe>();
	}

	/**
	 * Fonction qui efface le contenu du dessin.
	 */
	public void reinit() {
		formes = new ArrayList<Forme>();
		groupes = new ArrayList<Groupe>();
	}
	
	public ArrayList<Forme> getFormes() {
		return formes;
	}

	public ArrayList<Groupe> getGroupes() {
		return groupes;
	}
}

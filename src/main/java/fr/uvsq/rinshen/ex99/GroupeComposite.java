package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public class GroupeComposite extends Groupe {
	private ArrayList<Forme> sousGroupes;
	
	/**
	 * Constructeur pour le groupe composite.
	 * @param nom Nom du groupe
	 */
	public GroupeComposite(String nom) {
		super(nom);
		idType = 1;
		sousGroupes = new ArrayList<Forme>();
	}
	
	public void ajouteGroupe(Forme f) {
		sousGroupes.add(f);
	}
	
	public ArrayList<Forme> getSousGroupes() {
		return sousGroupes;
	}
}

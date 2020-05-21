package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public class GroupeComposite extends Groupe {
	private ArrayList<Groupe> sousGroupes;
	
	/**
	 * Constructeur pour le groupe composite.
	 * @param nom Nom du groupe
	 */
	public GroupeComposite(String nom) {
		super(nom);
		idType = 1;
		sousGroupes = new ArrayList<Groupe>();
	}
	
	public void move(int horizontal, int vertical) {
		for(int i = 0; i < formes.size(); i++) {
			formes.get(i).move(horizontal, vertical);
		}
		for(int i = 0; i < sousGroupes.size(); i++) {
			sousGroupes.get(i).move(horizontal, vertical);
		}
	}
	
	public void ajouteGroupe(Groupe f) {
		sousGroupes.add(f);
	}
	
	public ArrayList<Groupe> getSousGroupes() {
		return sousGroupes;
	}
}

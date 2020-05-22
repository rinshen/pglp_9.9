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
	
	@Override
	public void move(int horizontal, int vertical) {
		for (int i = 0; i < formes.size(); i++) {
			formes.get(i).move(horizontal, vertical);
		}
		for (int i = 0; i < sousGroupes.size(); i++) {
			sousGroupes.get(i).move(horizontal, vertical);
		}
	}
	
	@Override
	public void afficher() {
		System.out.println("\n\ncontenu du groupe " + nom);
		System.out.println("formes:");
		for (int i = 0; i < formes.size(); i++) {
			formes.get(i).afficher();
		}
		System.out.println("groupes:");
		for (int i = 0; i < sousGroupes.size(); i++) {
			sousGroupes.get(i).afficher();
		}
	}
	
	@Override
	public void aplanir() {
		for (int i = 0; i < sousGroupes.size(); i++) {
			sousGroupes.get(i).aplanir();
			formes.addAll(sousGroupes.get(i).getFormes());
		}
	}
	
	public void ajouteGroupe(Groupe f) {
		sousGroupes.add(f);
	}
	
	public ArrayList<Groupe> getSousGroupes() {
		return sousGroupes;
	}
}

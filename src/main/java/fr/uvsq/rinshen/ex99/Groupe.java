package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public abstract class Groupe {
	protected String nom;
	protected ArrayList<Forme> formes;
	protected int idType = 0;
	
	public Groupe(String nom) {
		this.nom = nom;
		this.formes = new ArrayList<Forme>();
	}
	
	public void ajouteFormes(Forme f) {
		formes.add(f);
	}
	
	public ArrayList<Forme> getFormes() {
		return formes;
	}
}

package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public class Dessin {
	private ArrayList<Forme> formes;
	private ArrayList<Groupe> groupes;
	
	public Dessin() {
		formes = new ArrayList<Forme>();
		groupes = new ArrayList<Groupe>();
	}

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

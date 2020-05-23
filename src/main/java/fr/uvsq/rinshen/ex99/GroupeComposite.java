package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public class GroupeComposite extends Groupe {
	//Liste des sous groupes (peut contenir n'importe quel objet héritant de Groupe)
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
	
	/**
	 * Déplace toutes les formes contenues dans le groupe et ses sous groupes.
	 */
	@Override
	public void move(int horizontal, int vertical) {
		for (int i = 0; i < formes.size(); i++) {
			formes.get(i).move(horizontal, vertical);
		}
		for (int i = 0; i < sousGroupes.size(); i++) {
			sousGroupes.get(i).move(horizontal, vertical);
		}
	}
	
	/**
	 * Affiche le contenu du groupe.
	 */
	@Override
	public void afficher() {
		System.out.println("\n\ncontenu du groupe " + nom);
		//Affichage des formes
		System.out.println("formes:");
		for (int i = 0; i < formes.size(); i++) {
			formes.get(i).afficher();
		}
		//Affichage des sous groupes
		System.out.println("groupes:");
		for (int i = 0; i < sousGroupes.size(); i++) {
			sousGroupes.get(i).afficher();
		}
	}
	
	/**
	 * Récupère récursivement la liste des formes contenues dans les sous groupes et leurs
	 * sous groupes pour les placer dans la liste des formes. Permet d'enregistrer toutes
	 * les formes contenues par le groupe dans la base de données.
	 */
	@Override
	public void aplanir() {
		for (int i = 0; i < sousGroupes.size(); i++) {
			//On apelle récursivement aplanir sur tous les groupes jusqu'a tomber
			//sur une feuille
			sousGroupes.get(i).aplanir();
			//On ajoute les formes des sous groupes à la liste des formes
			formes.addAll(sousGroupes.get(i).getFormes());
		}
	}
	
	/**
	 * Ajoute un groupe à la liste des sous groupes.
	 * @param f -> groupe à ajouter
	 */
	public void ajouteGroupe(Groupe f) {
		sousGroupes.add(f);
	}
	
	public ArrayList<Groupe> getSousGroupes() {
		return sousGroupes;
	}
}

package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public abstract class Groupe {
	protected String nom;
	protected ArrayList<Forme> formes;//Liste des formes contenues dans le groupe
	protected int idType = 0;//Vaut 1 si le groupe est composite, 2 si simple, 0 sinon
	
	public Groupe(String nom) {
		this.nom = nom;
		this.formes = new ArrayList<Forme>();
	}
	
	/**
	 * Déplace toutes les formes contenues dans le groupe.
	 */
	public void move(int horizontal, int vertical) {
		for (int i = 0; i < formes.size(); i++) {
			formes.get(i).move(horizontal, vertical);
		}
	}
	
	/**
	 * Affiche le contenu du groupe.
	 */
	public void afficher() {
		System.out.println("\ncontenu du groupe " + nom);
		for (int i = 0; i < formes.size(); i++) {
			formes.get(i).afficher();
		}
	}
	
	/**
	 * Ajoute une forme à la liste des formes.
	 * @param f -> Forme à ajouter
	 */
	public void ajouteFormes(Forme f) {
		formes.add(f);
	}
	
	public ArrayList<Forme> getFormes() {
		return formes;
	}

	public String getNom() {
		return nom;
	}

	public int getIdType() {
		return idType;
	}
	
	/**
	 * Utilisée pour aplanir les GroupesComposite. Une fonction vide dans les classes Groupe et
	 * GroupeSimple permet à la récurrence de s'arrêter lorsqu'elle a atteint un groupe ne
	 * pouvant pas posséder de sous groupes (voir aplanir() dans la classe GroupeComposite).
	 */
	public void aplanir() {
		
	}
}

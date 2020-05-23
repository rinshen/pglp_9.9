package fr.uvsq.rinshen.ex99;

public class CommandAffiche implements Command {
	/**
	 * Affichage du dessin.
	 */
	public void execute(Dessin dessin, String commande) {
		//Affichage des formes
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			dessin.getFormes().get(i).afficher();
		}
		//Affichage des groupes
		for (int i = 0; i < dessin.getGroupes().size(); i++) {
			dessin.getGroupes().get(i).afficher();
		}
	}
}

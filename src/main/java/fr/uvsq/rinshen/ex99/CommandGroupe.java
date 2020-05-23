package fr.uvsq.rinshen.ex99;

public class CommandGroupe implements Command {
	/**
	 * Fonction servant a inclure un objet dans un groupe.
	 */
	public void execute(Dessin dessin, String commande) {
		//On écrit chaque argument dans une chaine séparée
		String[] form = commande.split(" ");
		int groupe = 0;
		boolean g = false;
		boolean f = false;
		
		//On vérifie qu'il y ait suffisament d'arguments
		if (form.length < 3) {
			System.out.println("Commande invalide");
			return;
		}
		
		//On cherche le groupe à modifier
		for (int i = 0; i < dessin.getGroupes().size(); i++) {
			if (dessin.getGroupes().get(i).getNom().equals(form[1])) {
				groupe = i;
				g = true;
			}
			
		}
		if (!g) {
			//erreur si le groupe n'existe pas
			System.out.println("Groupe non Trouvé");
			return;
		}
		
		//On cherche la forme à ajouter
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if (dessin.getFormes().get(i).getNom().equals(form[2])) {
				dessin.getGroupes()
						.get(groupe)
						.ajouteFormes(dessin.getFormes().get(i));
				dessin.getFormes().remove(i);
				f = true;
			}
		}
		//Si la forme n'existe pas on vérifie si le nom de l'objet à ajouter est celui
		//d'un groupe
		if (!f) {
			for (int i = 0; i < dessin.getGroupes().size(); i++) {
				//Si le groupe à modifier est de type composite et que l'objet à
				//ajouter est un groupe alors on ajoute cet objet aux sous groupes
				//du composite
				if (dessin.getGroupes().get(i).getNom().equals(form[2])
						&& (dessin.getGroupes()
								.get(groupe)
								.getIdType() == 1)) {
					((GroupeComposite)dessin.getGroupes().get(groupe))
							.ajouteGroupe(dessin.getGroupes().get(i));
					dessin.getGroupes().remove(i);
					f = true;
				}
			}
		}
		//Si l'objet à ajouter n'est ni un groupe ni une forme, ou si on cherche à ajouter
		//un groupe à un GroupeSimple on affiche une erreur
		if (!f) {
			System.out.println("Forme non Trouvée");
			return;
		}
	}
}

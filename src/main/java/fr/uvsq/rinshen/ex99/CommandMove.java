package fr.uvsq.rinshen.ex99;

public class CommandMove implements Command {
	/**
	 * Fonction servant à déplacer les éléments du dessin.
	 */
	public void execute(Dessin dessin, String commande) {
		//On écrit chaque argument dans une chaine séparée
		String[] form = commande.split(" ");
		boolean find = false;
		
		//On vérifie qu'il y a au moins un nom de forme dans la commande
		//(pour empécher l'utilisateur d'entrer la commande move sans arguments)
		if (form.length < 2) {
			System.out.println("Commande invalide");
			return;
		}
		
		//Si l'utilisatuer cherche à déplacer un groupe
		if (form[1].equals("groupe")) {
			//Vérification du nombre d'arguments
			if (form.length != 5) {
				System.out.println("Commande invalide");
				return;
			}
			//On parcours tous les groupes et on déplace celui ayant le nom choisi
			for (int i = 0; i < dessin.getGroupes().size(); i++) {
				if (dessin.getGroupes().get(i).getNom().equals(form[2])) {
					dessin.getGroupes().get(i).move(
							Integer.parseInt(form[3]), 
							Integer.parseInt(form[4]));
					find = true;
				}
			}
			//Erreur si le groupe nest pas trouvé
			if (!find) {
				System.out.println("Aucun groupe ne possède ce nom");
			}

		//Sinon on cherche à déplacer une forme seule
		} else {
			//Vérification du nombre d'arguments
			if (form.length != 4) {
				System.out.println("Commande invalide");
				return;
			}
			//Parcours des formes du dessin et modification si nécessaire
			for (int i = 0; i < dessin.getFormes().size(); i++) {
				if (dessin.getFormes().get(i).getNom().equals(form[1])) {
					dessin.getFormes().get(i).move(
							Integer.parseInt(form[2]), 
							Integer.parseInt(form[3]));
					find = true;
				}
			}
			//Erreur si la forme n'est pas trouvée
			if (!find) {
				System.out.println("Aucune forme ne possède ce nom");
			}
		}
	}
}

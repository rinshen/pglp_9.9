package fr.uvsq.rinshen.ex99;

public class CommandGroupe implements Command {
	public void execute(Dessin dessin, String commande) {
		String[] form = commande.split(" ");
		int groupe = 0;
		if (form.length < 3) {
			System.out.println("Commande invalide");
			return;
		}
		for (int i = 0; i < dessin.getGroupes().size(); i++) {
			if (dessin.getGroupes().get(i).getNom().equals(form[1])) {
				groupe = i;
			}
			else {
				System.out.println("Groupe non Trouvé");
				return;
			}
		}
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if (dessin.getFormes().get(i).getNom().equals(form[2])) {
				dessin.getGroupes().get(groupe).ajouteFormes(dessin.getFormes().get(i));
			}
			else {
				System.out.println("Forme non Trouvée");
				return;
			}
		}
	}
}

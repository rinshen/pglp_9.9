package fr.uvsq.rinshen.ex99;

public class CommandMove implements Command {
	public void execute(Dessin dessin, String commande) {
		String[] form = commande.split(" ");
		boolean find = false;
		if (form.length != 4) {
			System.out.println("Commande invalide");
			return;
		}
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if (dessin.getFormes().get(i).getNom().equals(form[1])) {
				dessin.getFormes().get(i).move(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				find = true;
			}
		}
		if (!find) {
			System.out.println("Aucune forme ne possède ce nom");
		}
	}
}

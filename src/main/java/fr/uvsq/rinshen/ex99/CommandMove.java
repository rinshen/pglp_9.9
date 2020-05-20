package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public class CommandMove implements Command {
	public void execute(ArrayList<Forme> dessin, String commande) {
		String[] form = commande.split(" ");
		boolean find = false;
		if(form.length != 4) {
			System.out.println("Commande invalide");
			return;
		}
		for(int i = 0; i < dessin.size(); i++) {
			if(dessin.get(i).getNom() == form[1]) {
				dessin.get(i).move(Integer.parseInt(form[2]), Integer.parseInt(form[3]));
				find = true;
			}
		}
		if(!find) {
			System.out.println("Aucune forme ne possède ce nom");
		}
	}
}

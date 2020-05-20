package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public class CommandAffiche implements Command {
	public void execute(ArrayList<Forme> dessin, String commande) {
		for(int i = 0; i < dessin.size(); i++) {
				dessin.get(i).afficher();
		}
	}
}

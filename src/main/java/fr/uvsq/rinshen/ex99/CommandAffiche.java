package fr.uvsq.rinshen.ex99;

public class CommandAffiche implements Command {
	public void execute(Dessin dessin, String commande) {
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			dessin.getFormes().get(i).afficher();
		}
	}
}

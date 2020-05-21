package fr.uvsq.rinshen.ex99;

public class DrawingTui {
	public Command nextCommand(String commande) {
		if (commande.startsWith("move ")) {
			return new CommandMove();
		}
		if (commande.equals("affiche")) {
			return new CommandAffiche();
		}
		return new CommandCreate();
	}
}

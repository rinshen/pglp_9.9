package fr.uvsq.rinshen.ex99;

public class DrawingTui {
	public Command nextCommand(String commande) {
		if (commande.startsWith("move ")) {
			return new CommandMove();
		}
		if (commande.startsWith("grouper ")) {
			return new CommandGroupe();
		}
		if (commande.equals("afficher")) {
			return new CommandAffiche();
		}
		if (commande.equals("enregistrer")) {
			return new CommandSave();
		}
		if (commande.equals("charger")) {
			return new CommandLoad();
		}
		return new CommandCreate();
	}
}

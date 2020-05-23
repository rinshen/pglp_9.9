package fr.uvsq.rinshen.ex99;

public class DrawingTui {
	/**
	 * Fonction permettant de reconnaitre le type d'une commande.
	 * @param commande -> Commande à analyser
	 * @return Objet de type Command approprié
	 */
	public Command nextCommand(String commande) {
		//Commande de type move
		if (commande.startsWith("move ")) {
			return new CommandMove();
		}
		//Commande de type grouper
		if (commande.startsWith("grouper ")) {
			return new CommandGroupe();
		}
		//Commande afficher
		if (commande.equals("afficher")) {
			return new CommandAffiche();
		}
		//Commande enregistrer
		if (commande.equals("enregistrer")) {
			return new CommandSave();
		}
		//Commande charger
		if (commande.equals("charger")) {
			return new CommandLoad();
		}
		//Si la commande n'est pas reconnue on suppose qu'il s'agit d'un nom de forme et
		//on renvoie un objet permettant de créer une forme. Si la commande ne présente pas
		//un nom de forme valide alors CommandCreate.execute() affiche une erreur et on
		//demande à l'utilisateur d'entrer une autre commande
		return new CommandCreate();
	}
}

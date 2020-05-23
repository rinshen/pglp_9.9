package fr.uvsq.rinshen.ex99;

public class DrawingApp {
	public static void main(final String[] args) {
		run();
	}
	
	/**
	 * Fonction contenant la boucle principale.
	 */
	public static void run() {
		Dessin dessin = new Dessin();
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		DrawingTui tui = new DrawingTui();
		String commande = "";
		while (!commande.equals("exit")) {
			//On récupère ce que tape l'utilisateur
			commande = scanner.nextLine();
			//tui.nextCommand() reconnait le type de commande utilisée et crée l'objet
			//Command associé. La méthode next de cet objet exécute la commande.
			tui.nextCommand(commande).execute(dessin, commande);
		}
		scanner.close();
	}
}

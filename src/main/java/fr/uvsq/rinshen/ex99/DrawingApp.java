package fr.uvsq.rinshen.ex99;

public class DrawingApp {
	public static void main(final String[] args) {
		run();
	}
	
	public static void run() {
		Dessin dessin = new Dessin();
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		DrawingTui tui = new DrawingTui();
		String commande = "";
		while (commande != "exit") {
			commande = scanner.nextLine();
			tui.nextCommand(commande).execute(dessin, commande);
		}
		scanner.close();
	}
}

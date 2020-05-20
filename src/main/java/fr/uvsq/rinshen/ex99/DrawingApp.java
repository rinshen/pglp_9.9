package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public class DrawingApp {
	public static void main(final String[] args) {
		run();
	}
	
	public static void run() {
		ArrayList<Forme> dessin=new ArrayList<Forme>();
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		DrawingTui tui = new DrawingTui();
		String commande = "";
		while(commande != "exit") {
			commande = scanner.nextLine();
			System.out.println(commande);
			tui.nextCommand(commande).execute(dessin, commande);
		}
		scanner.close();
	}
}

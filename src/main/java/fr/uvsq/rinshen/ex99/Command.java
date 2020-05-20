package fr.uvsq.rinshen.ex99;

import java.util.ArrayList;

public interface Command {
	public void execute(ArrayList<Forme> dessin, String commande);
}

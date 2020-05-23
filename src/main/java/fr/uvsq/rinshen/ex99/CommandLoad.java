package fr.uvsq.rinshen.ex99;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CommandLoad implements Command {
	/**
	 * Fonction permettant de charger un dessin depuis la base de données.
	 */
	public void execute(Dessin dessin, String commande) {
		Statement db = null;
		Connection c = null;
		//On efface le dessin
		dessin.reinit();
		
		//Connexion à la base de données
		try {
			String url = "jdbc:derby:./database/dessin;create=true";
			c = DriverManager.getConnection(url);
			db = c.createStatement();
			
		} catch (SQLException e) {
			System.out.println("Impossible de se connecter à la base de données");
			e.printStackTrace();
		}
		
		//Lecture de la base de données
		lireCercles(dessin, db);
		lireCarres(dessin, db);
		lireRectangles(dessin, db);
		lireTriangles(dessin, db);
		
		//Suppression de la base de données (Permet de réenregistrer un dessin similaire
		//plus tard sans créer de doublons dans la bdd)
		InitBd ini = new InitBd(db);
		ini.efface();
		
		//Fermeture le la bdd
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println("Impossible de fermer la base de données");
		}
		System.out.println("Chargement terminé");
	}

	//////Fonctions permettant de récupérer les noms enregistrées dans la base de données
	
	/**
	 * Renvoie la liste des noms des cercles contenues dans la bd.
	 * @param db -> Statement pointant vers la base de données à examiner
	 * @return ArrayList contenant les noms des figures
	 */
	public ArrayList<String> nomsCercles(Statement db) {
		ArrayList<String> res = new ArrayList<String>();
		ResultSet table;
		try {
			table = db.executeQuery("select nom from cercle");
			while (table.next()) {
				res.add(table.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Renvoie la liste des noms des carrés contenues dans la bd.
	 * @param db -> Statement pointant vers la base de données à examiner
	 * @return ArrayList contenant les noms des figures
	 */
	public ArrayList<String> nomsCarres(Statement db) {
		ArrayList<String> res = new ArrayList<String>();
		ResultSet table;
		try {
			table = db.executeQuery("select nom from carre");
			while (table.next()) {
				res.add(table.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Renvoie la liste des noms des rectangles contenues dans la bd.
	 * @param db -> Statement pointant vers la base de données à examiner
	 * @return ArrayList contenant les noms des figures
	 */
	public ArrayList<String> nomsRectangles(Statement db) {
		ArrayList<String> res = new ArrayList<String>();
		ResultSet table;
		try {
			table = db.executeQuery("select nom from rectangle");
			while (table.next()) {
				res.add(table.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * Renvoie la liste des noms des triangles contenues dans la bd.
	 * @param db -> Statement pointant vers la base de données à examiner
	 * @return ArrayList contenant les noms des figures
	 */
	public ArrayList<String> nomsTriangles(Statement db) {
		ArrayList<String> res = new ArrayList<String>();
		ResultSet table;
		try {
			table = db.executeQuery("select nom from triangle");
			while (table.next()) {
				res.add(table.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	//////Fonctions permettant de récupérer les formes enregistrées dans la base de données/////
	
	//Toutes les fonctions suivent le meme modèle: On crée un DAO correspondant au type
	//d'objet que l'on cherche à récupérer, on récupère les noms de tous les objets de ce type
	//présents dans la bdd puis on appelle la fonction lire du DAO sur chacun de ces noms
	
	/**
	 * Fonction permettant de récupérer les cercles enregistrés.
	 * @param dessin -> dessin dans lequel recopier les formes
	 * @param db -> bdd dans laquelle les formes sont enregistrées
	 */
	public void lireCercles(Dessin dessin, Statement db) {
		CercleDao cercle = new CercleDao(db);
		ArrayList<String> noms = nomsCercles(db);
		for (int i = 0; i < noms.size(); i++) {
			dessin.getFormes().add(cercle.lire(noms.get(i)));
		}
	}
	
	/**
	 * Fonction permettant de récupérer les carrés enregistrés.
	 * @param dessin -> dessin dans lequel recopier les formes
	 * @param db -> bdd dans laquelle les formes sont enregistrées
	 */
	public void lireCarres(Dessin dessin, Statement db) {
		CarreDao carre = new CarreDao(db);
		ArrayList<String> noms = nomsCarres(db);
		for (int i = 0; i < noms.size(); i++) {
			dessin.getFormes().add(carre.lire(noms.get(i)));
		}
	}
	
	/**
	 * Fonction permettant de récupérer les rectangles enregistrés.
	 * @param dessin -> dessin dans lequel recopier les formes
	 * @param db -> bdd dans laquelle les formes sont enregistrées
	 */
	public void lireRectangles(Dessin dessin, Statement db) {
		RectangleDao rectangle = new RectangleDao(db);
		ArrayList<String> noms = nomsRectangles(db);
		for (int i = 0; i < noms.size(); i++) {
			dessin.getFormes().add(rectangle.lire(noms.get(i)));
		}
	}
	
	/**
	 * Fonction permettant de récupérer les triangles enregistrés.
	 * @param dessin -> dessin dans lequel recopier les formes
	 * @param db -> bdd dans laquelle les formes sont enregistrées
	 */
	public void lireTriangles(Dessin dessin, Statement db) {
		TriangleDao triangle = new TriangleDao(db);
		ArrayList<String> noms = nomsTriangles(db);
		for (int i = 0; i < noms.size(); i++) {
			dessin.getFormes().add(triangle.lire(noms.get(i)));
		}
	}
}

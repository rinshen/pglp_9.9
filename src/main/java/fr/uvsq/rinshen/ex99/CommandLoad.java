package fr.uvsq.rinshen.ex99;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CommandLoad implements Command {
	public void execute(Dessin dessin, String commande) {
		Statement db = null;
		Connection c = null;
		InitBd ini = new InitBd(db);
		
		try {
			String url = "jdbc:derby:./database/dessin;create=true";
			c = DriverManager.getConnection(url);
			db = c.createStatement();
			
		} catch (SQLException e) {
			System.out.println("Impossible de se connecter à la base de données");
			e.printStackTrace();
		}
		
		lireCercles(dessin, db);
		lireCarres(dessin, db);
		lireRectangles(dessin, db);
		lireTriangles(dessin, db);
		
		ini.efface();
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println("Impossible de fermer la base de données");
		}
	}
	
	/**
	 * Renvoie la liste des noms des cercles contenues dans la bd.
	 * @param db Statement pointant vers la base de données à examiner
	 * @return ArrayList contenant les noms des figures
	 */
	public ArrayList<String> nomsCercles(Statement db) {
		ArrayList<String> res = new ArrayList<String>();
		ResultSet table;
		try {
			table = db.executeQuery("select nom from cercle");
			while(table.next()) {
				res.add(table.getString(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<String> nomsCarres(Statement db) {
		ArrayList<String> res = new ArrayList<String>();
		ResultSet table;
		try {
			table = db.executeQuery("select nom from carre");
			while(table.next()) {
				res.add(table.getString(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<String> nomsRectangles(Statement db) {
		ArrayList<String> res = new ArrayList<String>();
		ResultSet table;
		try {
			table = db.executeQuery("select nom from rectangle");
			while(table.next()) {
				res.add(table.getString(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<String> nomsTriangles(Statement db) {
		ArrayList<String> res = new ArrayList<String>();
		ResultSet table;
		try {
			table = db.executeQuery("select nom from triangle");
			while(table.next()) {
				res.add(table.getString(1));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void lireCercles(Dessin dessin, Statement db) {
		CercleDao cercle = new CercleDao(db);
		ArrayList<String> noms = nomsCercles(db);
		for(int i = 0 ; i < noms.size(); i++) {
			dessin.getFormes().add(cercle.lire(noms.get(i)));
		}
	}
	
	public void lireCarres(Dessin dessin, Statement db) {
		CarreDao carre = new CarreDao(db);
		ArrayList<String> noms = nomsCarres(db);
		for(int i = 0 ; i < noms.size(); i++) {
			dessin.getFormes().add(carre.lire(noms.get(i)));
		}
	}
	
	public void lireRectangles(Dessin dessin, Statement db) {
		RectangleDao rectangle = new RectangleDao(db);
		ArrayList<String> noms = nomsRectangles(db);
		for(int i = 0 ; i < noms.size(); i++) {
			dessin.getFormes().add(rectangle.lire(noms.get(i)));
		}
	}
	
	public void lireTriangles(Dessin dessin, Statement db) {
		TriangleDao triangle = new TriangleDao(db);
		ArrayList<String> noms = nomsTriangles(db);
		for(int i = 0 ; i < noms.size(); i++) {
			dessin.getFormes().add(triangle.lire(noms.get(i)));
		}
	}
}

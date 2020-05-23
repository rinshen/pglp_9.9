package fr.uvsq.rinshen.ex99;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe chargée de la création et de la supression des tables de la base de données.
 */
public class InitBd {
	private Statement db;
	
	public InitBd(Statement database) {
		db = database;
	}
	
	/**
	 * Création des tables de la base de données.
	 */
	public void init() {
		initCercle();
		initCarre();
		initTriangle();
		initRectangle();
		initSimple();
		initComposite();
	}
	
	/**
	 * Table contenant les cercles.
	 */
	public void initCercle() {
		try {
			db.executeUpdate("create table cercle ("
					+ "nom varchar(30) primary key, "
					+ "centre int, "
					+ "abs1 int, "
					+ "abs2 int)");
		} catch (SQLException e) {
			System.out.println("La table cercle est déja initialisée");
		}
	}
	
	/**
	 * Table contenant les carrés.
	 */
	public void initCarre() {
		try {
			db.executeUpdate("create table carre ("
					+ "nom varchar(30) primary key, "
					+ "centre int, "
					+ "abs1 int, "
					+ "abs2 int)");
		} catch (SQLException e) {
			System.out.println("La table carre est déja initialisée");
		}
	}
	
	/**
	 * Table contenant les triangles.
	 */
	public void initTriangle() {
		try {
			db.executeUpdate("create table triangle ("
					+ "nom varchar(30) primary key, "
					+ "abs1 int, "
					+ "abs2 int, "
					+ "abs3 int, "
					+ "abs4 int, "
					+ "abs5 int, "
					+ "abs6 int)");
		} catch (SQLException e) {
			System.out.println("La table triangle est déja initialisée");
		}
	}
	
	/**
	 * Table contenant les rectangles.
	 */
	public void initRectangle() {
		try {
			db.executeUpdate("create table rectangle ("
					+ "nom varchar(30) primary key, "
					+ "largeur int, "
					+ "hauteur int, "
					+ "abs1 int, "
					+ "abs2 int)");
		} catch (SQLException e) {
			System.out.println("La table rectangle est déja initialisée");
		}
	}
	
	/**
	 * Table contenant le nom des groupes et des formes qui lui sont associées.
	 * (non utilisée dans la version finale).
	 */
	public void initSimple() {
		try {
			db.executeUpdate("create table simple ("
					+ "idForme int primary key, "
					+ "idGroupe int)");
		} catch (SQLException e) {
			System.out.println("La table simple est déja initialisée");
		}
	}

	/**
	 * Table Contenant le nom des groupes et des sous groupes qui lui sont associés.
	 * (non utilisée dans la version finale).
	 */
	public void initComposite() {
		try {
			db.executeUpdate("create table composite ("
					+ "idSimple int primary key, "
					+ "idComposite int)");
		} catch (SQLException e) {
			System.out.println("La table composite est déja initialisée");
		}
	}
	
	/**
	 * Supression des tables de la base de données.
	 */
	public void efface() {
		effaceCercle();
		effaceCarre();
		effaceRectangle();
		effaceTriangle();
		effaceSimple();
		effaceComposite();
	}
	
	/**
	 * Suppression de la table cercle.
	 */
	public void effaceCercle() {
		try {
			db.executeUpdate("Drop table cercle");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Suppression de la table carre.
	 */
	public void effaceCarre() {
		try {
			db.executeUpdate("Drop table carre");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Suppression de la table Rectangle.
	 */
	public void effaceRectangle() {
		try {
			db.executeUpdate("Drop table triangle");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Suppresion de la table triangle.
	 */
	public void effaceTriangle() {
		try {
			db.executeUpdate("Drop table rectangle");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Supression de la table simple.
	 */
	public void effaceSimple() {
		try {
			db.executeUpdate("Drop table simple");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Supression de la table composite.
	 */
	public void effaceComposite() {
		try {
			db.executeUpdate("Drop table composite");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

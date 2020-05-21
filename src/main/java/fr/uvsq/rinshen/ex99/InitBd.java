package fr.uvsq.rinshen.ex99;

import java.sql.SQLException;
import java.sql.Statement;

public class InitBd {
	private Statement db;
	
	public InitBd(Statement database) {
		db = database;
	}
	
	public void init(){
		initCercle();
		initCarre();
		initTriangle();
		initRectangle();
		initSimple();
		initComposite();
	}
	
	public void initCercle(){
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
	
	public void initCarre(){
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
	
	public void initTriangle(){
		try {
			db.executeUpdate("create table simple ("
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
	
	public void initRectangle(){
		try {
			db.executeUpdate("create table simple ("
					+ "nom varchar(30) primary key, "
					+ "largeur int, "
					+ "hauteur int, "
					+ "abs1 int, "
					+ "abs2 int)");
		} catch (SQLException e) {
			System.out.println("La table rectangle est déja initialisée");
		}
	}
	
	public void initSimple(){
		try {
			db.executeUpdate("create table simple ("
					+ "idForme int primary key, "
					+ "idGroupe int)");
		} catch (SQLException e) {
			System.out.println("La table simple est déja initialisée");
		}
	}

	public void initComposite(){
		try {
			db.executeUpdate("create table composite ("
					+ "idSimple int primary key, "
					+ "idComposite int)");
		} catch (SQLException e) {
			System.out.println("La table composite est déja initialisée");
		}
	}
	
	public void efface(){
		effaceCercle();
		effaceCarre();
		effaceRectangle();
		effaceTriangle();
		effaceSimple();
		effaceComposite();
	}
	
	public void effaceCercle(){
		try {
			db.executeUpdate("Drop table cercle");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void effaceCarre(){
		try {
			db.executeUpdate("Drop table carre");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void effaceRectangle(){
		try {
			db.executeUpdate("Drop table triangle");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void effaceTriangle(){
		try {
			db.executeUpdate("Drop table rectangle");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void effaceSimple(){
		try {
			db.executeUpdate("Drop table simple");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void effaceComposite(){
		try {
			db.executeUpdate("Drop table composite");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

package fr.uvsq.rinshen.ex99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupeCompositeDao implements DataAccessObject<GroupeComposite> {
	Statement db;
	
	public GroupeCompositeDao(Statement database) {
		db = database;
	}

	public void ecrireGroupes(GroupeComposite obj) {
		ArrayList<Groupe> tmp = obj.getSousGroupes();
		try {
			for (int i = 0; i < tmp.size(); i++) {
				db.executeUpdate("insert into composite values ("
						+ tmp.get(i).getNom() + ","
						+ obj.getNom() + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ecrireFormes(GroupeComposite obj) {
		ArrayList<Forme> tmp = obj.getFormes();
		try {
			for (int i = 0; i < tmp.size(); i++) {
				db.executeUpdate("insert into simple values ("
						+ tmp.get(i).getNom() + ","
						+ obj.getNom() + ")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ecrire(GroupeComposite obj) {
		ecrireGroupes(obj);
		ecrireFormes(obj);
	}

	public void lireGroupes(GroupeComposite obj) {
		ResultSet table;
		Groupe g;
		GroupeSimpleDao dao = new GroupeSimpleDao(db);
		try {
			table = db.executeQuery("select nomSimple from composite "
					+ "where nomComposite = "
					+ obj.getNom()
					);
			while (table.next()) {
				g = dao.lire(table.getString(1));
				obj.ajouteGroupe(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void lireFormes(GroupeComposite obj) {
		CarreDao carre = new CarreDao(db);
		CercleDao cercle = new CercleDao(db);
		TriangleDao triangle = new TriangleDao(db);
		RectangleDao rectangle = new RectangleDao(db);
		Forme f = null;
		try {
			ResultSet table = db.executeQuery("select nomForme from simple "
					+ "where nomGroupe = "
					+ obj.getNom());
			while (table.next()) {
				f = carre.lire(table.getString(1));
				if (f != null) {
					obj.ajouteFormes(f);
				}
				f = cercle.lire(table.getString(1));
				if (f != null) {
					obj.ajouteFormes(f);
				}
				f = triangle.lire(table.getString(1));
				if (f != null) {
					obj.ajouteFormes(f);
				}
				f = rectangle.lire(table.getString(1));
				if (f != null) {
					obj.ajouteFormes(f);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public GroupeComposite lire(String nom) {
		GroupeComposite g = new GroupeComposite(nom);
		lireFormes(g);
		lireGroupes(g);
		return g;
	}

	public void supprimer(String nom) {
		try {
			db.executeUpdate("delete from simple where nomSimple = " + nom);
			db.executeUpdate("delete from simple where nomComposite = " + nom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifier(GroupeComposite obj) {
		// TODO Auto-generated method stub
		
	}

}

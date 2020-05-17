package fr.uvsq.rinshen.ex99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupeSimpleDao implements DataAccessObject<GroupeSimple> {
	private Statement db;

	public GroupeSimpleDao(Statement database) {
		db = database;
	}

	public void ecrire(GroupeSimple obj) {
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

	public GroupeSimple lire(String nom) {
		GroupeSimple g = new GroupeSimple(nom);
		CarreDao carre = new CarreDao(db);
		CercleDao cercle = new CercleDao(db);
		TriangleDao triangle = new TriangleDao(db);
		RectangleDao rectangle = new RectangleDao(db);
		Forme f = null;
		try {
			ResultSet table = db.executeQuery("select nomForme from simple "
					+ "where nomGroupe = "
					+ nom);
			while (table.next()) {
				f = carre.lire(table.getString(1));
				if (f != null) {
					g.ajouteFormes(f);
				}
				f = cercle.lire(table.getString(1));
				if (f != null) {
					g.ajouteFormes(f);
				}
				f = triangle.lire(table.getString(1));
				if (f != null) {
					g.ajouteFormes(f);
				}
				f = rectangle.lire(table.getString(1));
				if (f != null) {
					g.ajouteFormes(f);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return g;
	}

	public void supprimer(String nom) {
		try {
			db.executeUpdate("delete from simple where nomGroupe = " + nom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifier(GroupeSimple obj) {
		supprimer(obj.getNom());
		ecrire(obj);
	}
}

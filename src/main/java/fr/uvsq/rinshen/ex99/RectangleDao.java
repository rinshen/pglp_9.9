package fr.uvsq.rinshen.ex99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RectangleDao implements DataAccessObject<Rectangle> {
	Statement db;
	
	public RectangleDao(Statement database) {
		db = database;
	}

	public void ecrire(Rectangle obj) {
		try {
			db.executeUpdate("insert into rectangle values ('"
					+ obj.getNom() + "',"
					+ obj.getLargeur() + ","
					+ obj.getHauteur() + ","
					+ obj.getCentre().getAbs() + ","
					+ obj.getCentre().getOrd() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Rectangle lire(String nom) {
		Rectangle r = null;
		ResultSet table;
		Point p;
		try {
			table = db.executeQuery("select * from rectangle "
					+ "where nom = '"
					+ nom + "'");
			table.next();
			p = new Point(table.getInt(4), table.getInt(5));
			r = new Rectangle(nom, p, table.getInt(2), table.getInt(3));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public void supprimer(String nom) {
		try {
			db.executeUpdate("delete from rectangle where nom = '" + nom + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifier(Rectangle obj) {
		supprimer(obj.getNom());
		ecrire(obj);
	}
}

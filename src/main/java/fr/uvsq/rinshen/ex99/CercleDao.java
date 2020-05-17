package fr.uvsq.rinshen.ex99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CercleDao implements DataAccessObject<Cercle> {
	Statement db;
	
	public CercleDao(Statement database) {
		db = database;
	}

	public void ecrire(Cercle obj) {
		try {
			db.executeUpdate("insert into cercle values ('"
					+ obj.getNom() + "',"
					+ obj.getRayon() + ","
					+ obj.getCentre().getAbs() + ","
					+ obj.getCentre().getOrd() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Cercle lire(String nom) {
		Cercle c = null;
		ResultSet table;
		Point p;
		try {
			table = db.executeQuery("select * from cercle "
					+ "where nom = "
					+ nom);
			table.next();
			p = new Point(table.getInt(3), table.getInt(4));
			c = new Cercle(nom, p, table.getInt(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public void supprimer(String nom) {
		try {
			db.executeUpdate("delete from cercle where nom = " + nom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifier(Cercle obj) {
		supprimer(obj.getNom());
		ecrire(obj);
	}
}

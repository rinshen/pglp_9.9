package fr.uvsq.rinshen.ex99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TriangleDao implements DataAccessObject<Triangle> {
	Statement db;
	
	public TriangleDao(Statement database) {
		db = database;
	}

	public void ecrire(Triangle obj) {
		try {
			db.executeUpdate("insert into triangle values ('"
					+ obj.getNom() + "',"
					+ obj.getP1().getAbs() + ","
					+ obj.getP1().getOrd() + ","
					+ obj.getP2().getAbs() + ","
					+ obj.getP2().getOrd() + ","
					+ obj.getP3().getAbs() + ","
					+ obj.getP3().getOrd() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Triangle lire(String nom) {
		Triangle t = null;
		ResultSet table;
		Point p1;
		Point p2;
		Point p3;
		try {
			table = db.executeQuery("select * from triangle "
					+ "where nom = '"
					+ nom + "'");
			table.next();
			p1 = new Point(table.getInt(2), table.getInt(3));
			p2 = new Point(table.getInt(4), table.getInt(5));
			p3 = new Point(table.getInt(6), table.getInt(7));
			t = new Triangle(nom, p1, p2, p3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public void supprimer(String nom) {
		try {
			db.executeUpdate("delete from triangle where nom = '" + nom + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifier(Triangle obj) {
		supprimer(obj.getNom());
		ecrire(obj);
	}
}

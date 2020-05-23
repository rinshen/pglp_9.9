package fr.uvsq.rinshen.ex99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RectangleDao implements DataAccessObject<Rectangle> {
	Statement db;
	
	public RectangleDao(Statement database) {
		db = database;
	}

	/**
	 * Ecrit un objet de type Rectangle dans la base de données.
	 * @param obj -> Objet à écrire
	 */
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

	/**
	 * Lit un objet de type Rectangle dans la base de données.
	 * @param nom -> Nom du rectangle
	 * @return Objet de type Rectangle initialisé ou null en cas d'erreur
	 */
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

	/**
	 * Supprime un objet de type Rectangle de la base de données.
	 * @param nom -> Nom de l'objet a supprimer
	 */
	public void supprimer(String nom) {
		try {
			db.executeUpdate("delete from rectangle where nom = '" + nom + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Modifie un objet de type Rectangle déja présent dans la base de données.
	 * @param obj -> Rectangle à modifier
	 */
	public void modifier(Rectangle obj) {
		supprimer(obj.getNom());
		ecrire(obj);
	}
}

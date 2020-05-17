package fr.uvsq.rinshen.ex99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarreDao implements DataAccessObject<Carre> {
	Statement db;
	
	public CarreDao(Statement database) {
		db = database;
	}

	/**
	 * Ecrit un objet de type Carre dans la base de données.
	 * @param obj Objet à écrire
	 */
	public void ecrire(Carre obj) {
		try {
			db.executeUpdate("insert into carre values ('"
					+ obj.getNom() + "',"
					+ obj.getCote() + ","
					+ obj.getCentre().getAbs() + ","
					+ obj.getCentre().getOrd() + ")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lit un objet de type Carre dans la base de données.
	 * @param nom Nom du cercle
	 * @return Objet de type Carre initialisé ou null si le nom n'apparait pas dans la base de données
	 */
	public Carre lire(String nom) {
		Carre c = null;
		ResultSet table;
		Point p;
		try {
			table = db.executeQuery("select * from carre "
					+ "where nom = "
					+ nom);
			table.next();
			p = new Point(table.getInt(3), table.getInt(4));
			c = new Carre(nom, p, table.getInt(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	/**
	 * Supprime un objet de type Carre de la base de données
	 * @param nom Nom de l'objet a supprimer
	 */
	public void supprimer(String nom) {
		try {
			db.executeUpdate("delete from carre where nom = " + nom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void modifier(Carre obj) {
		supprimer(obj.getNom());
		ecrire(obj);
	}
}

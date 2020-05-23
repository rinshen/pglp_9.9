package fr.uvsq.rinshen.ex99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CercleDao implements DataAccessObject<Cercle> {
	Statement db;
	
	public CercleDao(Statement database) {
		db = database;
	}

	/**
	 * Ecrit un objet de type Cercle dans la base de données.
	 * @param obj -> Objet à écrire
	 */
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

	/**
	 * Lit un objet de type Cercle dans la base de données.
	 * @param nom -> Nom du cercle
	 * @return Objet de type Cercle initialisé ou null en cas d'erreur
	 */
	public Cercle lire(String nom) {
		Cercle c = null;
		ResultSet table;
		Point p;
		try {
			table = db.executeQuery("select * from cercle "
					+ "where nom = '"
					+ nom + "'");
			table.next();
			p = new Point(table.getInt(3), table.getInt(4));
			c = new Cercle(nom, p, table.getInt(2));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}


	/**
	 * Supprime un objet de type Cercle de la base de données.
	 * @param nom -> Nom de l'objet a supprimer
	 */

	public void supprimer(String nom) {
		try {
			db.executeUpdate("delete from cercle where nom = '" + nom + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Modifie un objet de type Cercle déja présent dans la base de données.
	 * @param obj -> Cercle à modifier
	 */
	public void modifier(Cercle obj) {
		supprimer(obj.getNom());
		ecrire(obj);
	}
}

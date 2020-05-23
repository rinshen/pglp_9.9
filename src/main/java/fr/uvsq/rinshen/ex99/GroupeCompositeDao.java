package fr.uvsq.rinshen.ex99;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Permet d'enregistrer des GroupeComposite.
 * Classe non utilisée dans la version finale.
 */
public class GroupeCompositeDao implements DataAccessObject<GroupeComposite> {
	Statement db;
	
	public GroupeCompositeDao(Statement database) {
		db = database;
	}

	/**
	 * Ecrit la liste des sous groupes dans la base de données.
	 * @param obj -> GroupeComposite
	 */
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

	/**
	 * Ecrit la liste des formes dans la base de données.
	 * @param obj -> GroupeComposite
	 */
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
	
	/**
	 * Ecrit un objet de type Groupe dans la base de données.
	 * @param obj -> Objet à écrire
	 */
	public void ecrire(GroupeComposite obj) {
		ecrireGroupes(obj);
		ecrireFormes(obj);
	}

	/**
	 * Lit la liste des sous groupes dans la base de données.
	 * @param obj -> GroupeComposite
	 */
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

	/**
	 * Lit la liste des formes dans la base de données.
	 * @param obj -> GroupeComposite
	 */
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

	/**
	 * Lit un objet de type Groupe dans la base de données.
	 * @param nom -> Nom du Groupe
	 * @return Objet de type Groupe initialisé ou null en cas d'erreur
	 */	
	public GroupeComposite lire(String nom) {
		GroupeComposite g = new GroupeComposite(nom);
		lireFormes(g);
		lireGroupes(g);
		return g;
	}


	/**
	 * Supprime un objet de type GroupeCoposite de la base de données.
	 * @param nom -> Nom de l'objet a supprimer
	 */
	public void supprimer(String nom) {
		try {
			db.executeUpdate("delete from simple where nomSimple = " + nom);
			db.executeUpdate("delete from simple where nomComposite = " + nom);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Modifie un objet de type GroupeComposite déja présent dans la base de données.
	 * @param obj -> Groupe à modifier
	 */
	public void modifier(GroupeComposite obj) {
		supprimer(obj.getNom());
		ecrire(obj);
	}

}

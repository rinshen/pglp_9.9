package fr.uvsq.rinshen.ex99;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandSave implements Command {
	/**
	 * Fonction permettant d'écrire le dessin dans la base de données.
	 */
	public void execute(Dessin dessin, String commande) {
		//connection à la base de données
		Statement db = null;
		Connection c = null;
		try {
			String url = "jdbc:derby:./database/dessin;create=true";
			c = DriverManager.getConnection(url);
			db = c.createStatement();
			InitBd ini = new InitBd(db);
			ini.init();
		} catch (SQLException e) {
			System.out.println("Impossible de se connecter à la base de données");
			e.printStackTrace();
		}
		
		//On récupère les formes contenues dans les groupes
		videGroupes(dessin);
		
		//Ecriture des formes
		enregistrerCercle(dessin, db);
		enregistrerCarre(dessin, db);
		enregistrerTriangle(dessin, db);
		enregistrerRectangle(dessin, db);
		
		//On efface le dessin et on ferme la connection à la ase de données
		dessin.reinit();
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println("Impossible de fermer la base de données");
		}
		System.out.println("Enregistrement terminé");
	}
	
	/**
	 * Fonction permettant de vider toutes les formes contenues dans les groupes
	 * et de les ajouter à la liste des formes du dessin. (Une forme ajoutée à
	 * un groupe est supprimée de la liste des formes du dessin, cette étape
	 * est donc obligatoire pour enregistrer les formes contenues dans les groupes
	 * @param dessin -> Dessin à aplanir
	 */
	public void videGroupes(Dessin dessin) {
		for (int i = 0; i < dessin.getGroupes().size(); i++) {
			dessin.getGroupes().get(i).aplanir();
			dessin.getFormes().addAll(dessin.getGroupes().get(i).getFormes());
		}
	}
	
	//////Fonctions d'enregistrement des formes//////
	
	//Pour chaque fonction on crée un DAO pour un type de forme, on parcours toutes les
	//formes du dessin, si une forme à ce type alors on apelle le DAO sur cette forme.
	//Le cast permet de confirmer le type d'objet au DAO, le tableau de dessin
	//contenant des Formes alors que les DAO prennent en paramètre des objets dérivés
	
	/**
	 * Fonction d'enregistrement des cercles.
	 * @param dessin -> Dessin à enregistrer
	 * @param db -> bdd dans laquelle écrire
	 */
	public void enregistrerCercle(Dessin dessin, Statement db) {
		CercleDao dao = new CercleDao(db);
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if (dessin.getFormes().get(i).getType() == 1) {
				dao.ecrire((Cercle)dessin.getFormes().get(i));
			}
		}
	}

	/**
	 * Fonction d'enregistrement des carrés.
	 * @param dessin -> Dessin à enregistrer
	 * @param db -> bdd dans laquelle écrire
	 */
	public void enregistrerCarre(Dessin dessin, Statement db) {
		CarreDao dao = new CarreDao(db);
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if (dessin.getFormes().get(i).getType() == 2) {
				dao.ecrire((Carre)dessin.getFormes().get(i));
			}
		}
	}

	/**
	 * Fonction d'enregistrement des triangles.
	 * @param dessin -> Dessin à enregistrer
	 * @param db -> bdd dans laquelle écrire
	 */
	public void enregistrerTriangle(Dessin dessin, Statement db) {
		TriangleDao dao = new TriangleDao(db);
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if (dessin.getFormes().get(i).getType() == 3) {
				dao.ecrire((Triangle)dessin.getFormes().get(i));
			}
		}
	}

	/**
	 * Fonction d'enregistrement des rectangles.
	 * @param dessin -> Dessin à enregistrer
	 * @param db -> bdd dans laquelle écrire
	 */
	public void enregistrerRectangle(Dessin dessin, Statement db) {
		RectangleDao dao = new RectangleDao(db);
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if (dessin.getFormes().get(i).getType() == 4) {
				dao.ecrire((Rectangle)dessin.getFormes().get(i));
			}
		}
	}
}

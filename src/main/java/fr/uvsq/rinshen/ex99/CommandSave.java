package fr.uvsq.rinshen.ex99;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandSave implements Command {
	public void execute(Dessin dessin, String commande) {
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
		
		videGroupes(dessin);
		enregistrerCercle(dessin, db);
		enregistrerCarre(dessin, db);
		enregistrerTriangle(dessin, db);
		enregistrerRectangle(dessin, db);
		
		dessin.reinit();
		try {
			c.close();
		} catch (SQLException e) {
			System.out.println("Impossible de fermer la base de données");
		}
		System.out.println("Enregistrement terminé");
	}
	
	public void videGroupes(Dessin dessin) {
		for(int i = 0; i < dessin.getGroupes().size(); i++) {
			dessin.getGroupes().get(i).aplanir();
			dessin.getFormes().addAll(dessin.getGroupes().get(i).getFormes());
		}
	}
	
	public void enregistrerCercle(Dessin dessin, Statement db) {
		CercleDao dao = new CercleDao(db);
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if(dessin.getFormes().get(i).getType() == 1) {
				dao.ecrire((Cercle)dessin.getFormes().get(i));
			}
		}
	}
	
	public void enregistrerCarre(Dessin dessin, Statement db) {
		CarreDao dao = new CarreDao(db);
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if(dessin.getFormes().get(i).getType() == 2) {
				dao.ecrire((Carre)dessin.getFormes().get(i));
			}
		}
	}
	
	public void enregistrerTriangle(Dessin dessin, Statement db) {
		TriangleDao dao = new TriangleDao(db);
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if(dessin.getFormes().get(i).getType() == 3) {
				dao.ecrire((Triangle)dessin.getFormes().get(i));
			}
		}
	}
	
	public void enregistrerRectangle(Dessin dessin, Statement db) {
		RectangleDao dao = new RectangleDao(db);
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if(dessin.getFormes().get(i).getType() == 4) {
				dao.ecrire((Rectangle)dessin.getFormes().get(i));
			}
		}
	}
}

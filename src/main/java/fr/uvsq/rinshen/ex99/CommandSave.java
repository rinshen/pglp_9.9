package fr.uvsq.rinshen.ex99;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CommandSave implements Command {
	public void execute(Dessin dessin, String commande) {
		Statement db = null;
		try {
			String url = "jdbc:derby:./database/dessin;create=true";
			Connection c = DriverManager.getConnection(url);
			db = c.createStatement();
		} catch (SQLException e) {
			System.out.println("Impossible de se connecter à la base de données");
			e.printStackTrace();
		}
		CarreDao carre = new CarreDao(db);
		CercleDao cercle = new CercleDao(db);
		TriangleDao triangle = new TriangleDao(db);
		RectangleDao rectangle = new RectangleDao(db);
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if(dessin.getFormes().get(i).getType() == 1) {
				cercle.ecrire((Cercle)dessin.getFormes().get(i));
			}
		}
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if(dessin.getFormes().get(i).getType() == 2) {
				carre.ecrire((Carre)dessin.getFormes().get(i));
			}
		}
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if(dessin.getFormes().get(i).getType() == 3) {
				rectangle.ecrire((Rectangle)dessin.getFormes().get(i));
			}
		}
		for (int i = 0; i < dessin.getFormes().size(); i++) {
			if(dessin.getFormes().get(i).getType() == 4) {
				triangle.ecrire((Triangle)dessin.getFormes().get(i));
			}
		}
	}
}

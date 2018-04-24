package com.mkyong.dao;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mkyong.User;
import com.mysql.jdbc.Connection;

public class UserDao {

	public boolean createClient(User leuserAdd) {

		try {

			// Etape 1 : Importer le driver
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver ok");

			// Etape 2 : Connexion a la BDD
			String url = "jdbc:mysql://127.0.0.1:3306/jsfwebservicebdd";
			String user = "root";
			String passwd = "root";

			java.sql.Connection con = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion ok");

			// si le driver n'est pas importer on affiche une erreur

			// Etape 3 : Preparation de la requete
			java.sql.Statement stmt = con.createStatement();
			String SqlIns = "Insert Into utilisateur( nom, prenom, datedenaissance, genre, email, niveaudeservice) Value ('" + leuserAdd.getNom()
					+ "','" + leuserAdd.getPrenom() + "','" + leuserAdd.getDatedenaissance() + "' , '"
					+ leuserAdd.getGenre() + "' , '" + leuserAdd.getEmail()+  "' , '" + leuserAdd.getNiveaudeservice()+"' )";
			// System.out.println(SqlIns);

			// etape 4 : executer la requete
			int rs2 = stmt.executeUpdate(SqlIns);
			return true;
		} catch (ClassNotFoundException e) {

			System.out.println("probleme d'importation du driver  : " + e.getMessage());
			// e.printStackTrace();
			return false;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			return false;
		}

	}

	
}

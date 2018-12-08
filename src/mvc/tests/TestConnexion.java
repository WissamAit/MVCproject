package mvc.tests;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.entity.Personne;
import mvc.services.ServicePersonne;
import mvc.utils.Connexion;

public class TestConnexion {

	public static void main(String[] args) throws SQLException {
		
		/********************************************************/
		/******************** Before MVC ************************/
		/********************************************************/
		Connection connexion = Connexion.getConnection();
		Statement smt = connexion.createStatement() ;
		ResultSet resultSet = smt.executeQuery("select * from personne") ;
		
		List<Personne> personnes = new ArrayList<Personne>();
		
		while (resultSet.next()) {
				int idPersonne 	= resultSet.getInt("id_personne") ;
			   String nom 		= resultSet.getString("nom") ;
			   int age 			= resultSet.getInt("age") ;
			   String adresse 	=resultSet.getString("adresse") ;
			   Personne personne = new Personne(idPersonne, nom, age, adresse);
			   personnes.add(personne);
			}
		
		System.out.println(personnes.toString());
		/********************************************************/
		
		/********************************************************/
		/******************** Using MVC *************************/
		/********************************************************/
		
		ServicePersonne servicePersonne = new ServicePersonne();
		ArrayList<Personne> listPersons = servicePersonne.getPersons();
		System.out.println(listPersons);
		
		/********************************************************/
				
		
	}

}

package mvc.doa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mvc.entity.Personne;
import mvc.utils.Connexion;

/**
 * 
 * The aim of this class is to implement the Interface related to this concret Data Access Object (DAO)
 * this class launches CRUD requests directly to the database - table personne- and these results will be returned 
 * to services, in an nutshell these methods will be asked by the class which represents PersonneService
 * 
 *  1- This is the only place that we should find the real queries to personne table
 *  2- We have to get an instance of the connection to database
 *  3- think to a coherent result to return to the services when the methods are asked 
 */
public class DaoPersonne implements IDaoPersonne{

	Connection connexion = null;
	// initialize the connection
	public DaoPersonne() {
		this.connexion = Connexion.getConnection();
	}
	

	@Override
	public ArrayList<Personne> getAllPersonnes() {
		
		ArrayList<Personne> personnes = new ArrayList<Personne>();
		try {
			/** 1- prepare the query to get all personnes */
			Statement smt = connexion.createStatement();
			ResultSet resultSet = smt.executeQuery("select * from personne") ;

			/** 2- build a result to return to the service */			
			while (resultSet.next()) {
				int idPersonne 	= resultSet.getInt("id_personne") ;
				String nom 		= resultSet.getString("nom") ;
				int age 			= resultSet.getInt("age") ;
				String adresse 	=resultSet.getString("adresse") ;
				Personne personne = new Personne(idPersonne, nom, age, adresse);
				personnes.add(personne);
			}
		} catch (SQLException e) {e.printStackTrace();}
		
		/** 3- return the result to the service */
		return personnes;
	}

	@Override
	public Personne getPersonneById(int id) {
		Personne personne = null;
		try {
		Statement smt = connexion.createStatement();
		ResultSet resultSet = smt.executeQuery("select * from personne where id_personne = '" + id + "' ");
		
		// Check if there is any result
		if (resultSet.next()) {
			/** if the given id is found in the database we execute this bloc  */			

			int idPersonne 	= resultSet.getInt("id_personne") ;
			String nom 		= resultSet.getString("nom") ;
			int age 		= resultSet.getInt("age") ;
			String adresse 	=resultSet.getString("adresse") ;
			
			personne = new Personne(idPersonne, nom, age, adresse);
		}
		
		// Here we can find two cases : if the result found we return the Personne built in the if bloc
		// Else we return null because we didnt initialize the personne variable
		return personne;
		
		}catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean addPersonne(Personne personne) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePersonne(Personne personne) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePersonne(Personne personne) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePersonneById(int idPersonne) {
		// TODO Auto-generated method stub
		return false;
	}

	
}

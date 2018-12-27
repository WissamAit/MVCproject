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
		ArrayList<Personne> personnes = new ArrayList<Personne>();

		
		try {
			/** 1- prepare the query to get all personnes */
			Statement smt = connexion.createStatement();
			ResultSet resultSet = smt.executeQuery("select * from personne where id_personne='"+id+"'") ;
			
			/** 2- build a result to return to the service */			
			while (resultSet.next()) {
				int idPersonne 	= resultSet.getInt("id_personne") ;
				String nom 		= resultSet.getString("nom") ;
				int age 			= resultSet.getInt("age") ;
				String adresse 	=resultSet.getString("adresse") ;
				Personne personne = new Personne(idPersonne, nom, age, adresse);
			
				personnes.add(personne);
			
		return personne;
		}}
		catch (SQLException e) {e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addPersonne(int id_personne, String nom, int age, String adresse) {
		 ArrayList<Personne> personnes = new ArrayList<Personne>();

			
			try {
				Statement smt = connexion.createStatement();
				String sql="INSERT INTO personne VALUES( '"+id_personne+"', '"+nom+"', '"+age+"','"+adresse+"')";
				smt.executeUpdate(sql);	
				ResultSet resultSet = smt.executeQuery("select * from personne") ;
				/** 2- build a result to return to the service */			
				while (resultSet.next()) {
					int id_personnes 	= resultSet.getInt("id_personne") ;
					String noms 		= resultSet.getString("nom") ;
					int ages 			= resultSet.getInt("age") ;
					String adresses 	=resultSet.getString("adresse") ;
					Personne person = new Personne(id_personnes, noms, ages, adresses);
				personnes.add(person);
				System.out.println(personnes);
					
				
			return true;
			}}
			catch (SQLException e) {e.printStackTrace();
			}
			
		return false;
	}

	@Override
	public boolean updatePersonne(Personne personne) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePersonne(int id_personne, String nom, int age, String adresse) {
    ArrayList<Personne> personnes = new ArrayList<Personne>();

		
		try {
			Statement smt = connexion.createStatement();
			
			Personne person=new Personne(id_personne, nom, age, adresse);
			String sql=("delete from personne where nom='"+nom+"' ") ;
			smt.executeUpdate(sql);	
			ResultSet resultSet = smt.executeQuery("select * from personne") ;
			/** 2- build a result to return to the service */			
			while (resultSet.next()) {
				int id_personnes 	= resultSet.getInt("id_personne") ;
				String noms 		= resultSet.getString("nom") ;
				int ages 			= resultSet.getInt("age") ;
				String adresses 	=resultSet.getString("adresse") ;
				Personne personne = new Personne(id_personnes, noms, ages, adresses);
			personnes.remove(person);
			System.out.println(personnes);
				
			
		return true;
		}}
		catch (SQLException e) {e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public boolean deletePersonneById(int idPersonne) {
ArrayList<Personne> personnes = new ArrayList<Personne>();

		
		try {
			Statement smt = connexion.createStatement();
			String sql=("delete from personne where id_personne="+idPersonne+"") ;
			smt.executeUpdate(sql);	
			ResultSet resultSet = smt.executeQuery("select * from personne") ;
			/** 2- build a result to return to the service */			
			while (resultSet.next()) {
				int idPersonnes 	= resultSet.getInt("id_personne") ;
				String nom 		= resultSet.getString("nom") ;
				int age 			= resultSet.getInt("age") ;
				String adresse 	=resultSet.getString("adresse") ;
				Personne personne = new Personne(idPersonnes, nom, age, adresse);
			personnes.remove(personne);
			System.out.println(personnes);
				
			
		return true;
		}}
		catch (SQLException e) {e.printStackTrace();
		}
		
		
		return false;
	}

	
}

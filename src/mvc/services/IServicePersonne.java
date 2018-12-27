
package mvc.services;

import java.util.ArrayList;

import mvc.entity.Personne;

public interface IServicePersonne {

		public ArrayList<Personne> getPersons();
		
		public Personne getPersonById(int id);
		
		public boolean createPerson(int id_personne, String nom, int age, String adresse);
		
		public boolean updatePerson(Personne personne);
		
		
		public boolean deletePersonById(int idPersonne);

		public boolean deletePerson(int id_personne, String nom, int age, String adresse);

		
		
}


package mvc.services;

import java.util.ArrayList;

import mvc.entity.Personne;

public interface IServicePersonne {

		public ArrayList<Personne> getPersons();
		
		public Personne getPersonById(int id);
		
		public boolean createPerson(Personne personne);
		
		public boolean updatePerson(Personne personne);
		
		public boolean deletePerson(Personne personne);
		
		public boolean deletePersonById(int idPersonne);
		
}

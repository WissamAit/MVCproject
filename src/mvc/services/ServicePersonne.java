package mvc.services;

import java.util.ArrayList;

import mvc.doa.DaoPersonne;
import mvc.entity.Personne;
/**
 * 
 * This class interact with the DAO and returns the results to the client in this case 
 *
 */
public class ServicePersonne implements IServicePersonne {

	DaoPersonne daoPersonne = null;
	public ServicePersonne() {
		
		this.daoPersonne = new DaoPersonne();
	}
	
	// Return all persons to the client
	@Override
	public ArrayList<Personne> getPersons() {
		return daoPersonne.getAllPersonnes();
	}

	@Override
	public Personne getPersonById(int id) {
		// TODO Auto-generated method stub
		return daoPersonne.getPersonneById(id);
	}

	@Override
	public boolean createPerson(int id_personne, String nom, int age, String adresse) {
		// TODO Auto-generated method stub
		return daoPersonne.addPersonne( id_personne,  nom,  age,  adresse);
	}

	@Override
	public boolean updatePerson(Personne personne) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(int id_personne, String nom, int age, String adresse) {
		// TODO Auto-generated method stub
		return daoPersonne.deletePersonne( id_personne, nom,  age, adresse);
	}

	@Override
	public boolean deletePersonById(int idPersonne) {
		return daoPersonne.deletePersonneById(idPersonne);
	}

}


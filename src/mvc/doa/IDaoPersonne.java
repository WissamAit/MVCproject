package mvc.doa;

import java.util.ArrayList;

import mvc.entity.Personne;

/**
 * 
 * Cette interface définit les actions (CRUD) à effectuer sur la table personne
 * CRUD => CREATE READ UPDATE DELETE
 * 
 * cette interface va être implémenté par le DAO concret qui va définir 
 * les méthodes de cette interface et le but c'est d'intéragir directement 
 * avec la base de données
 */
public interface IDaoPersonne {
	// retourne toutes les personnes de la base de données
	public ArrayList<Personne> getAllPersonnes();
	
	// retourne une personne selon le id donné
	public Personne getPersonneById(int id);
	
	// crée une nouvelle personne dans la base de données
	public boolean addPersonne(Personne personne);
	
	// mis à jour la personne donnée
	public boolean updatePersonne(Personne personne);
	
	// supprime la personne donnée
	public boolean deletePersonne(Personne personne);
	
	// supprime la personne donnée selon un id
	public boolean deletePersonneById(int idPersonne);

}

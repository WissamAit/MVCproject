package mvc.doa;

import java.util.ArrayList;

import mvc.entity.Personne;

/**
 * 
 * Cette interface d�finit les actions (CRUD) � effectuer sur la table personne
 * CRUD => CREATE READ UPDATE DELETE
 * 
 * cette interface va �tre impl�ment� par le DAO concret qui va d�finir 
 * les m�thodes de cette interface et le but c'est d'int�ragir directement 
 * avec la base de donn�es
 */
public interface IDaoPersonne {
	// retourne toutes les personnes de la base de donn�es
	public ArrayList<Personne> getAllPersonnes();
	
	// retourne une personne selon le id donn�
	public Personne getPersonneById(int id);
	
	// cr�e une nouvelle personne dans la base de donn�es
	public boolean addPersonne(Personne personne);
	
	// mis � jour la personne donn�e
	public boolean updatePersonne(Personne personne);
	
	// supprime la personne donn�e
	public boolean deletePersonne(Personne personne);
	
	// supprime la personne donn�e selon un id
	public boolean deletePersonneById(int idPersonne);

}

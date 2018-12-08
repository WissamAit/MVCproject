package mvc.tests;

import mvc.entity.Personne;
import mvc.services.ServicePersonne;

public class TestGetPersonByID {

	public static void main(String[] args) {
		
		
		// On imagine qu'on reçu une requête pour récupérer la personne qui a ID = 2
		ServicePersonne servicePersonne = new ServicePersonne();
		Personne personne = servicePersonne.getPersonById(66);
		
		if(personne != null) {
		System.out.println(personne.toString());
		}else {
			System.out.println("Person Not found");
		}

	}

}

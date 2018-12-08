package mvc.entity;

/**
 * 
 * @author wissam
 * 
 * Cette classe represente la classe entity (model) qui va traduire chaque tuple de la table personne de la bd
 * en un objet de type Personne en java
 */
public class Personne {

	
	private int idPersonne;
	private String nom;
	private int age;
	private String adresse;
	
	public Personne() {
		super();
	}
	/**
	 * Constructor with fields
	 * @param idPersonne
	 * @param nom
	 * @param age
	 * @param adresse
	 */
	public Personne(int idPersonne, String nom, int age, String adresse) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.age = age;
		this.adresse = adresse;
	}
/**
 * 
 * GETTERS AND SETTERS
 */
	public int getidPersonne() {
		return idPersonne;
	}
	public void setidPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nom=" + nom + ", age=" + age + ", adresse=" + adresse + "]";
	}
	
	
	
}

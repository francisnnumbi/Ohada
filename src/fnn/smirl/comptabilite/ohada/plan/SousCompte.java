package fnn.smirl.comptabilite.ohada.plan;
import fnn.smirl.comptabilite.ohada.enums.*;

public class SousCompte extends Compte
{
	private int ids = 0;
	private String titre = "";
	
	public SousCompte(){
		this(1, "Social");
		metCompte(new Compte());
	}
	
	public SousCompte(Classe classe, int cptId, int id, String cptTitre,  String titre) {
		super(new Compte(classe, cptId, cptTitre));
		this.ids = id;
		this.titre = titre;
		metCompte(new Compte(classe, cptId, cptTitre));
	}

	public SousCompte(int id, String titre) {
		super();
		this.ids = id;
		this.titre = titre;
		metCompte(new Compte());
	}
	
	public void metCompte(Compte compte){
		super.metCompte(compte);
	}
	
	public Compte compte() {
		return super.compte();
	}

	public void metTitre(String titre) {
		this.titre = titre;
	}
	
	public SousCompte sousCompte(){
		return this;
	}
	
	public void metSousCompte(SousCompte sCompte){
	super.metCompte(sCompte.compte());
	this.ids = sCompte.ids;
	this.titre = sCompte.titre;
	}

	public String titre() {
		return titre;
	}
	
	public String titreComplet() {
		return super.titre() + " " + titre;
	}

	public int id() {
		return Integer.parseInt(super.id() + "" + ids);
	}

	@Override
	public String toString() {
		// TODO: Implement this method
		return "[" + id() + " : " + titreComplet() + " = " + solde + "]";
	}
}

package fnn.smirl.comptabilite.ohada.plan;
import fnn.smirl.comptabilite.ohada.enums.*;

public class CompteDivisionnaire extends SousCompte {
	private int id = 0;
	private String titre = "";

	public CompteDivisionnaire(int id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
		metSousCompte(new SousCompte());
	}

	public CompteDivisionnaire(Classe classe, int cptId, int sCptId, int id, String cptTitre,  String sCptTitre, String titre) {
		super(classe, cptId, sCptId, cptTitre, sCptTitre);
		this.id = id;
		this.titre = titre;
		metSousCompte(new SousCompte(classe, cptId, sCptId, cptTitre, sCptTitre));
	}

	@Override
	public SousCompte sousCompte() {
		return super.sousCompte();
	}

	@Override
	public void metSousCompte(SousCompte sCompte) {
		// TODO: Implement this method
		super.metSousCompte(sCompte);
	}

	public CompteDivisionnaire compteDivisionnaire() {
		return this;
	}

	public void metCompteDivisionnaire(CompteDivisionnaire dCompte) {
		super.metSousCompte(dCompte.sousCompte());
		this.id = dCompte.id;
		this.titre = dCompte.titre;
	}

	public void metTitre(String titre) {
		this.titre = titre;
	}

	public String titre() {
		return titre;
	}

	public String titreComplet() {
		return super.titreComplet() + " " + titre;
	}

	public int id() {
		return Integer.parseInt(super.id() + "" + id);
	}

	@Override
	public String toString() {
		// TODO: Implement this method
		return "[" + id() + " : " + titreComplet() +  " = " + solde + "]";
	}
}

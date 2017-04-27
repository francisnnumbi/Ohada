package fnn.smirl.comptabilite.ohada.plan;
import fnn.smirl.comptabilite.ohada.enums.*;
import fnn.smirl.comptabilite.ohada.operations.*;
import java.util.*;

public class Compte {
	public String reference = "";
	private Classe classe;
	private String titre = "";
	private int id = 0;
	protected double solde= 0.0d, soldeInit = 0d;
	protected ArrayList<Transaction> trans =
	new ArrayList<Transaction>();

	public Compte() {
		this(Classe.Un, 0, "Capital");
	}
	public Compte(Classe classe, int id, String titre) {
		this.classe = classe;
		this.titre = titre;
		this.id = Integer.parseInt(classe.getId() + "" + id);
	}

	public Compte(Compte compte) {
		this(compte.classe, compte.id, compte.titre);
	}

	public Classe classe() {
		return classe;
	}

	public void ajoute(Entree entree) {
		int i = entree.id;
		boolean b = false;
		for (Transaction t : trans) {
			if (t.getId() == i) {
				b = t.ajoute(entree);
			}
		}
		if(b == false){
			Transaction t = new Transaction(i);
			t.ajoute(entree);
			trans.add(t);
		}
		consolidate();
	}
	
	public void metTitre(String titre) {
		this.titre = titre;
	}

	public String titre() {
		return titre;
	}

	public int id() {
		return id;
	}

	public void metCompte(Compte compte) {
		this.classe = compte.classe;
		this.id = compte.id;
		this.titre = compte.titre;
	}

	public Compte compte() {
		return this;
	}
	@Override
	public String toString() {
		// TODO: Implement this method
		return "[" + id + " : " + titre + " = " + solde + "]";
	}

	public double solde() {
		consolidate();
		return solde;
	}

	public void metSoldeInitial(double amnt) {
		soldeInit = amnt;
	}

	private void consolidate() {
		double tmp = 0;
		trans.get(0).metSoldeInitial(soldeInit);
		tmp = trans.get(0).soldeFinal();
		for(int i = 1; i < trans.size(); i++){
			trans.get(i).metSoldeInitial(tmp);
			tmp = trans.get(i).soldeFinal();
		}
		solde = tmp;
	}
//
//	public void soustrait(double mnt) {
//		solde -= mnt;
//	}
	
//	private double miniSomme(Entree.Cote cote){
//		double ms = 0;
//		for(Entree e : entrees(cote)){
//			ms += e.montant;
//		}
//		return ms;
//	}
	

}

package fnn.smirl.comptabilite.ohada.tcp_c;
import fnn.smirl.comptabilite.ohada.groupes.*;
import fnn.smirl.comptabilite.ohada.plan.*;

public class Resultat {
	public enum TABLEAU {
		CHARGE, PRODUIT;
	}
	public final String designation;
	private Charge charge;
	private Produit produit;

	public Resultat() {
		designation = "Résultat";
		charge = new Charge();
		produit = new Produit();
	}

	public boolean ajoute(Poste poste, TABLEAU tableau) {
		if (tableau == TABLEAU.CHARGE) {
			return	charge.ajoute(poste);
		} else if (tableau == TABLEAU.PRODUIT) {
			return	produit.ajoute(poste);
		}
		return false;
	}

	public Partie charge() {
		return charge;
	}

	public Partie produit() {
		return produit;
	}

	public double totalCharge() {
		return charge.somme();
	}

	public double totalProduit() {
		return produit.somme();
	}
	
	public double solde(){
	return	produit.somme() - charge.somme();
	}
}

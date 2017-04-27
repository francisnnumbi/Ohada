package fnn.smirl.comptabilite.ohada.groupes;
import fnn.smirl.comptabilite.ohada.enums.*;
import java.util.*;
import fnn.smirl.comptabilite.ohada.plan.*;

public class Poste
{
	public String reference = "";
	private Categorie categorie;
	private String designation;
	HashSet<Compte> comptes;

	public Poste(Categorie categorie, String designation) {
		this.categorie = categorie;
		this.designation = designation;
		comptes = new HashSet<Compte>();
	}
	
	public boolean ajoute(Compte cpt){
		return comptes.add(cpt);
	}
	
	public HashSet<Compte> comptes(){
		return comptes;
	}
	
	public double somme(){
		double s = 0.0d;
		if(comptes.size() == 0){
			s = 0.0d;
		}else{
			for(Compte c : comptes){
				s += c.solde();
			}
		}
		return s;
	}
}

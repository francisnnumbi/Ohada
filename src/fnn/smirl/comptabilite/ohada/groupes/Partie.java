package fnn.smirl.comptabilite.ohada.groupes;
import fnn.smirl.comptabilite.ohada.enums.*;
import java.util.*;
import fnn.smirl.comptabilite.ohada.plan.*;

public class Partie
{
	private Categorie categorie;
	private HashSet<Poste> postes;

	public Partie(Categorie categorie) {
		this.categorie = categorie;
		postes = new HashSet<Poste>();
	}
	
	public Categorie categorie(){
		return categorie;
	}
	
	public HashSet<Poste> postes(){
		return postes;
	}
	
	public boolean ajoute(Poste poste){
		return postes.add(poste);
	}
	
	public double somme(){
		double s = 0;
		if(postes.size() == 0){
			s = 0;
		}else{
			for(Poste p : postes){
				s += p.somme();
			}
		}
		return s;
	}
}

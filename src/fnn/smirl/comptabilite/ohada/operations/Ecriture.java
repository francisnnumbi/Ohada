package fnn.smirl.comptabilite.ohada.operations;
import java.util.*;
import fnn.smirl.comptabilite.ohada.plan.*;

public class Ecriture
{

	int id;
	long date = 0l;
	String libele = "";
	HashSet<Entree> entrees;
	
	public Ecriture(int id, long date, String libele){
		this.id = id;
		this.date = date;
		this.libele = libele;
		entrees = new HashSet<Entree>();
	}
	
	public boolean ajoute(Compte cpt, double mnt, Entree.Cote cote){
		return entrees.add(new Entree(id, date, cpt.id(), libele, mnt, cote));
	}
	
	public HashSet<Entree> entrees(Entree.Cote cote){
		HashSet<Entree> set = new HashSet<Entree>();
		for(Entree e : entrees){
			if(e.cote == cote)set.add(e);
		}
		return set;
	}
	
	public boolean equilibre(){
		return miniSomme(Entree.Cote.DEBIT) == miniSomme(Entree.Cote.CREDIT);
	}
	
	private double miniSomme(Entree.Cote cote){
		double ms = 0;
		for(Entree e : entrees(cote)){
			ms += e.montant;
		}
		return ms;
	}
	
}

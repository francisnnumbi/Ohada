package fnn.smirl.comptabilite.ohada.tcp_c;
import fnn.smirl.comptabilite.ohada.groupes.*;
import fnn.smirl.comptabilite.ohada.plan.*;

public class Bilan
{
	public enum TABLEAU{
		ACTIF, PASSIF;
	}
	public final String designation;
	private Actif actif;
	private Passif passif;
	
	public Bilan(){
		designation = "Bilan";
		actif = new Actif();
		passif = new Passif();
	}
	
	public boolean ajoute(Poste poste, TABLEAU tableau){
		if(tableau == TABLEAU.ACTIF){
		return	actif.ajoute(poste);
		}else if(tableau == TABLEAU.PASSIF){
		return	passif.ajoute(poste);
		}
		return false;
	}
	
	public Partie actif(){
		return actif;
	}
	
	public Partie passif(){
		return passif;
	}
	
	public double totalActif(){
		return actif.somme();
	}
	
	public double totalPassif(){
		return passif.somme();
	}
}

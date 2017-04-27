package fnn.smirl.comptabilite.ohada.enums;
import fnn.smirl.comptabilite.ohada.enums.classes.*;
import java.util.*;

public enum Classe
{
	Un(1, "Ressources durables"),
	Deux(2, "Actif Immobilisé"),
	Trois(3, "Stocks"),
	Quatre(4, "Tiers"),
	Cinq(5, "Trésorerie"),
	Six(6, "Charges des Activités Ordinaires"),
	Sept(7, "Produits des Activités Ordinaires"),
	Huit(8, "Autres Charges et Autres Produits"),
	Neuf(9, "Engagements Hors Bilan et Comptabilité Analytique de Gestion");
	private int id;
	private String titre;
	private Classe(int id, String titre){
		this.id = id;
		this.titre = titre;
	}

	public int getId(){
		return id;
	}

	public String getTitre(){
		return titre;
	}
	
	public static Classe1 classe1 = new Classe1();
}

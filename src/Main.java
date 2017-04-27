import fnn.smirl.comptabilite.ohada.enums.*;
import fnn.smirl.comptabilite.ohada.operations.*;
import fnn.smirl.comptabilite.ohada.plan.*;

public class Main {
	public static void main(String[] args) {

		Compte client = new SousCompte(Classe.Quatre, 1, 1, "Client", "");
		client.metSoldeInitial(2000);
		Compte bque = new SousCompte(Classe.Cinq, 2, 1, "Banque", "");
		bque.metSoldeInitial(800);
		Compte rrr = new SousCompte(Classe.Quatre, 1, 9, "Client", "RRR");
		rrr.metSoldeInitial(0);
		
		System.out.println(client.toString() + "\n" + bque.toString() + "\n" + rrr.toString());
		
		Ecriture ecriture = new Ecriture(1, 1, "Client paie dette");
		ecriture.ajoute(bque, 450, Entree.Cote.DEBIT);
		ecriture.ajoute(client, 500, Entree.Cote.CREDIT);
		ecriture.ajoute(rrr, 50, Entree.Cote.DEBIT);
		
		System.out.println("Ecriture en equilibre : " + ecriture.equilibre());
		
		System.out.println(ecriture.entrees(Entree.Cote.DEBIT));
		System.out.println(ecriture.entrees(Entree.Cote.CREDIT));
		
		
	}
}

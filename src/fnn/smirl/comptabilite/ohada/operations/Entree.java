package fnn.smirl.comptabilite.ohada.operations;
import fnn.smirl.comptabilite.ohada.plan.*;

public class Entree
{
	public enum Cote{
		DEBIT, CREDIT;
	}

	public int id;
	public long date = 0l;
	public int cptId;
	public String libele = "";
	public Cote cote = Cote.DEBIT;
	public double montant = 0d;

	public Entree(int id, long date, int cptId, String libele, double montant, Cote cote) {
		this.id = id;
		this.date = date;
		this.cptId = cptId;
		this.libele = libele;
		this.cote = cote;
		this.montant = montant;
	}
	
	@Override
	public String toString() {
		// TODO: Implement this method
		return "[id : " + id + ", Date : " + date + ", Compte : " + cptId + ", Libelé : " + libele + ", Montant : " + montant + ", Côté : " + cote;
	}
	
	
}

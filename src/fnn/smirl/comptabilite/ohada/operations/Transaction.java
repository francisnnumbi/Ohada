package fnn.smirl.comptabilite.ohada.operations;
import java.util.*;

public class Transaction implements Comparable
{

	private int id;
	private double soldeInitial = 0d;
	private double soldeFinal = 0d;
	private HashSet<Entree> entrees;
	
	public Transaction(int id){
		this.id = id;
		entrees = new HashSet<Entree>();
	}

	public int getId() {
		return id;
	}
	
public boolean ajoute(Entree entree){
	return entrees.add(entree);
}

	public void metSoldeInitial(double soldeInitial) {
		this.soldeInitial = soldeInitial;
	}

	public double soldeInitial() {
		return soldeInitial;
	}

	public double soldeFinal() {
		soldeFinal = soldeInitial;
		for(Entree e : entrees){
			if(e.cote == Entree.Cote.DEBIT)soldeFinal += e.montant;
			if(e.cote == Entree.Cote.CREDIT)soldeFinal -= e.montant;
		}
		return soldeFinal;
	}

	public HashSet<Entree> entrees() {
		return entrees;
	}

	@Override
	public int compareTo(Object p1) {
		// TODO: Implement this method
		return Integer.compare(this.id, ((Transaction)p1).id);
	}

	@Override
	public boolean equals(Object o) {
		// TODO: Implement this method
		return this.id == ((Transaction)o).id;
	}
	
	
}

package solution;

import java.util.ArrayList;
import java.util.HashMap;

import pbl.PblPartition;

public class PartialSolutionPartition implements PartialSolution {
	
	private PblPartition pb;
	private HashMap<Integer, ArrayList<Integer>> solution;
	private int nbEntiers;
	
	public PartialSolutionPartition(PblPartition pb) {
		this.pb = pb;
		this.nbEntiers = 0;
	}
	
	@Override
	public boolean complete() {
		return this.nbEntiers == this.pb.getNbEntiers();
	}

	@Override
	public void display() {
		System.out.println("----------Partial Solution----------");
		System.out.println("NbSacs: " + this.solution.size());
		System.out.print("NbEntiers: " + this.nbEntiers + " |");
		
		for(Integer entier : this.pb.getEntiers()) {
			System.out.print(" " + entier);
		}
		
		System.out.println();
		
		for(Integer sac : this.solution.keySet()) {
			int total = 0;
			System.out.print("Sac " + sac + ": ");
			for(Integer entier : this.solution.get(sac)) {
				System.out.print(entier + " ");
				total += entier;
			}
			System.out.print(" | Total: " + total);
			System.out.println();
		}
	}
	
	public void setSolution(HashMap<Integer, ArrayList<Integer>> solution) {
		this.solution = solution;
		
		this.nbEntiers = 0;
		
		for(Integer sac : this.solution.keySet()) {
			this.nbEntiers += this.solution.get(sac).size();
		}
	}
}

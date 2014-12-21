package solution;

import java.util.ArrayList;
import java.util.HashMap;

import pbl.PblBinPack;

class PartialSolutionBinPack implements PartialSolution {
	
	private PblBinPack pb;
	private HashMap<Integer, ArrayList<Integer>> solution;
	private int nbObjets;
	
	public PartialSolutionBinPack(PblBinPack pb) {
		this.pb = pb;
		this.nbObjets = 0;
	}
	
	@Override
	public boolean complete() {
		return this.nbObjets == this.pb.getNbObjets();
	}

	@Override
	public void display() {
		System.out.println("----------Partial Solution----------");
		System.out.println("SacCap: " + this.pb.getCap());
		System.out.println("NbSacs: " + this.solution.size());
		System.out.print("NbObjets: " + this.nbObjets + " |");
		
		for(Integer objet : this.pb.getObjets()) {
			System.out.print(" " + objet);
		}
		System.out.println();
		
		for(Integer sac : this.solution.keySet()) {
			System.out.print("Sac " + sac + ": ");
			for(Integer objet : this.solution.get(sac)) {
				System.out.print(objet + " ");
			}
			System.out.println();
		}
	}
	
	public void setSolution(HashMap<Integer, ArrayList<Integer>> solution) {
		this.solution = solution;
		
		this.nbObjets = 0;
		
		for(Integer sac : this.solution.keySet()) {
			this.nbObjets += this.solution.get(sac).size();
		}
	}

}
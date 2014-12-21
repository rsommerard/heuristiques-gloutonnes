package solution;

import java.util.ArrayList;
import java.util.HashMap;

import pbl.PblPartition;
import enumeration.EnumerationObjets;

public class SolutionWalkerPartitionNextFit extends SolutionWalkerPartition {

	private PblPartition pb;
	private EnumerationObjets en;
	private PartialSolutionPartition ps;
	
	private HashMap<Integer, ArrayList<Integer>> sacsEntiers;
	private int currentBag;
	
	public SolutionWalkerPartitionNextFit(PblPartition pbl, EnumerationObjets en){
		this.en = en;
		this.pb = pbl;
		this.sacsEntiers = new HashMap<Integer, ArrayList<Integer>>();
		this.currentBag = 0;
		this.sacsEntiers.put(0, new ArrayList<Integer>());
		this.sacsEntiers.put(1, new ArrayList<Integer>());
		this.ps = new PartialSolutionPartition(this.pb);
	}

	@Override
	public boolean terminated() {
		return !this.en.hasMoreElements();
	}

	@Override
	public PartialSolution current() {
		return this.ps;
	}

	@Override
	public void nextPartialSolution() {
		int entier = en.nextElement();
		
		this.sacsEntiers.get(this.currentBag).add(entier);
		this.currentBag = (this.currentBag + 1) % 2;
		
		this.ps.setSolution(this.sacsEntiers);
	}

}

package solution;

import java.util.ArrayList;
import java.util.HashMap;

import pbl.PblPartition;
import enumeration.EnumerationObjets;

public class SolutionWalkerPartitionBestFit extends SolutionWalkerPartition {

	private PblPartition pb;
	private EnumerationObjets en;
	private PartialSolutionPartition ps;
	
	private HashMap<Integer, ArrayList<Integer>> sacsEntiers;
	private int currentBag;
	
	public SolutionWalkerPartitionBestFit(PblPartition pbl, EnumerationObjets en){
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
		
		int capPart[] = new int[2];
		
		for(Integer sacI : this.sacsEntiers.keySet()) {
			for(Integer entierI : this.sacsEntiers.get(sacI)) {
				capPart[sacI] += entierI;
			}
		}
		
		if(capPart[0] <= capPart[1]) {
			this.currentBag = 0;
		}
		else {
			this.currentBag = 1;
		}
		
		this.sacsEntiers.get(this.currentBag).add(entier);
		
		this.ps.setSolution(this.sacsEntiers);
	}

}

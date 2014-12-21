package solution;

import java.util.ArrayList;
import java.util.HashMap;

import enumeration.EnumerationObjets;
import pbl.PblBinPack;


public class SolutionWalkerBinPackNextFit extends SolutionWalkerBinPack {
	
	private PblBinPack pb;
	private EnumerationObjets en;
	private PartialSolutionBinPack ps;
	
	private HashMap<Integer, ArrayList<Integer>> sacsObjets;
	private int currentBag;
	private int currentCap;
	
	public SolutionWalkerBinPackNextFit(PblBinPack pbl, EnumerationObjets en){
		this.en = en;
		this.pb = pbl;
		this.sacsObjets = new HashMap<Integer, ArrayList<Integer>>();
		this.currentBag = 0;
		this.sacsObjets.put(this.currentBag, new ArrayList<Integer>());
		this.currentCap = 0;
		this.ps = new PartialSolutionBinPack(this.pb);
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
		int objet = en.nextElement();
		
		if(this.currentCap + objet <= this.pb.getCap()) {
			this.currentCap += objet;
		}
		else {
			this.currentCap = objet;
			this.currentBag++;
			this.sacsObjets.put(this.currentBag, new ArrayList<Integer>());
		}
		
		this.sacsObjets.get(this.currentBag).add(objet);
		
		this.ps.setSolution(this.sacsObjets);
	}

}

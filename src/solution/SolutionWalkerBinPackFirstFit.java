package solution;
import java.util.ArrayList;
import java.util.HashMap;

import enumeration.EnumerationObjets;
import pbl.PblBinPack;


public class SolutionWalkerBinPackFirstFit extends SolutionWalkerBinPack {
	
	private PblBinPack pb;
	private EnumerationObjets en;
	private PartialSolutionBinPack ps;
	
	private HashMap<Integer, ArrayList<Integer>> sacsObjets;
	private int nbBag;
	
	public SolutionWalkerBinPackFirstFit(PblBinPack pbl, EnumerationObjets en){
		this.en = en;
		this.pb = pbl;
		this.sacsObjets = new HashMap<Integer, ArrayList<Integer>>();
		this.nbBag = 0;
		this.sacsObjets.put(this.nbBag, new ArrayList<Integer>());
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
		int sac = -1;
		
		for(Integer sacI : this.sacsObjets.keySet()) {
			int capI = 0;
			for(Integer objetI : this.sacsObjets.get(sacI)) {
				capI += objetI;
			}
			
			if(capI + objet <= this.pb.getCap()) {
				sac = sacI;
				break;
			}
		}
		
		if(sac == -1) {
			this.nbBag++;
			this.sacsObjets.put(this.nbBag, new ArrayList<Integer>());
			this.sacsObjets.get(this.nbBag).add(objet);
		}
		else {
			this.sacsObjets.get(sac).add(objet);
		}
		
		this.ps.setSolution(this.sacsObjets);
	}

}

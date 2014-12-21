package solution;
import java.util.ArrayList;
import java.util.HashMap;

import enumeration.EnumerationObjets;
import pbl.PblBinPack;


public class SolutionWalkerBinPackBestFit extends SolutionWalkerBinPack {
	
	private PblBinPack pb;
	private EnumerationObjets en;
	private PartialSolutionBinPack ps;
	
	private HashMap<Integer, ArrayList<Integer>> sacsObjets;
	private int nbBag;
	
	public SolutionWalkerBinPackBestFit(PblBinPack pbl, EnumerationObjets en) {
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
		int[] remp = new int[this.nbBag + 1];
		
		for(Integer sacI : this.sacsObjets.keySet()) {
			int capI = 0;
			for(Integer objetI : this.sacsObjets.get(sacI)) {
				capI += objetI;
			}
			
			if(capI + objet <= this.pb.getCap()) {
				remp[sacI] = sacI + objet;
			}
			else {
				remp[sacI] = -1;
			}
		}
		
		int sac = 0;
		int max = remp[0];
		for(int i = 1; i < remp.length; i++) {
			if(remp[i] != -1) {
				if(remp[i] > max) {
					sac = i;
					max = remp[i];
				}
			}
		}
		
		if(max == -1) {
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

package pbl;

public class PblBinPack extends Pbl {

	private int nbObjets;
	private int poids[];
	private int cap;
	
	public PblBinPack(int n, int p[], int c){
		this.nbObjets = n;
		this.poids = p;
		this.cap = c;
	}
	
	public int getNbObjets() {
		return this.nbObjets;
	}
	
	public int[] getObjets() {
		return this.poids;
	}
	
	public int getPoids(int obj) {
		return this.poids[obj];
	}
	
	public int getCap() {
		return this.cap;
	}
	
}
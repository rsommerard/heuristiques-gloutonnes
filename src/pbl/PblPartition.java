package pbl;

public class PblPartition extends Pbl {
	
	private int nbEntiers;
	private int entiers[];
	
	public PblPartition(int nbEntiers, int[] entiers) {
		this.nbEntiers = nbEntiers;
		this.entiers = entiers;
	}
	
	public int getNbEntiers() {
		return this.nbEntiers;
	}
	
	public int[] getEntiers() {
		return this.entiers;
	}

}
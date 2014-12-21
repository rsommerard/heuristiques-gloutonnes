package enumeration;

public class EnumerationOnline implements EnumerationObjets {
	
	private int nbObjets;
	private int poids[];
	private int iterator;
	
	public EnumerationOnline(int n, int[] p) {
		this.nbObjets = n;
		
		this.poids = new int[nbObjets];
		
		for(int i = 0; i < nbObjets; i++) {
			this.poids[i] = p[i];
		}
		
		this.iterator = 0;
	}

	@Override
	public boolean hasMoreElements() {
		return this.nbObjets - 1 >= this.iterator;
	}

	@Override
	public int nextElement() {
		return this.poids[this.iterator++];
	}

	@Override
	public void reset() {
		this.iterator = 0;
	}

}

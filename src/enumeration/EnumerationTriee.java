package enumeration;

import java.util.Arrays;

public class EnumerationTriee implements EnumerationObjets {
	
	private int nbObjets;
	private int poids[];
	private int iterator;
	
	public EnumerationTriee(int n, int[] p) {
		this.nbObjets = n;
		
		this.poids = new int[nbObjets];
		int[] tmp = new int[nbObjets];
		
		for(int i = 0; i < nbObjets; i++) {
			tmp[i] = p[i];
		}
		
		Arrays.sort(tmp);
		
		int j = nbObjets - 1;
		for(int i = 0; i < nbObjets; i++) {
			this.poids[i] = tmp[j--];
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

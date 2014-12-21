package solution;

interface SolutionWalker {

	public boolean terminated(); //la solution courante est complete

	public void nextPartialSolution(); //passe a UNE solution suivante

	public PartialSolution current(); //la solution courante
	
}

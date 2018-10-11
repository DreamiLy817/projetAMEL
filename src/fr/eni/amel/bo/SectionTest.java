package fr.eni.amel.bo;

public class SectionTest {
	private int nbQuestionsATirer;

	// getter et setter
	public int getNbQuestionsATirer() {
		return nbQuestionsATirer;
	}

	public void setNbQuestionsATirer(int nbQuestionsATirer) {
		this.nbQuestionsATirer = nbQuestionsATirer;
	}

	//constructeur
	/**
	 * @param nbQuestionsATirer
	 */
	public SectionTest(int nbQuestionsATirer) {
		super();
		setNbQuestionsATirer(nbQuestionsATirer);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SectionTest [nbQuestionsATirer=");
		builder.append(nbQuestionsATirer);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	
	

}

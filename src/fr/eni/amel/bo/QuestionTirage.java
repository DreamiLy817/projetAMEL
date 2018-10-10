package fr.eni.amel.bo;

public class QuestionTirage {
	
	private boolean estmarqu�;
	private Question question;
	private int numordre;
	private Epreuve epreuve;
	private Proposition proposition;
	
	//Constructeur
	
	public QuestionTirage() {
		
	}
	
	public QuestionTirage(boolean estmarqu�, Question question, int numordre, Epreuve epreuve,
			Proposition proposition) {
		this.estmarqu� = estmarqu�;
		this.question = question;
		this.numordre = numordre;
		this.epreuve = epreuve;
		this.proposition = proposition;
	}

	//Getter
	
	public boolean isEstmarqu�() {
		return estmarqu�;
	}

	public Question getQuestion() {
		return question;
	}

	public int getNumordre() {
		return numordre;
	}

	public Epreuve getEpreuve() {
		return epreuve;
	}

	public Proposition getProposition() {
		return proposition;
	}
	
	
	//Setter

	public void setEstmarqu�(boolean estmarqu�) {
		this.estmarqu� = estmarqu�;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setNumordre(int numordre) {
		this.numordre = numordre;
	}

	public void setEpreuve(Epreuve epreuve) {
		this.epreuve = epreuve;
	}

	public void setProposition(Proposition proposition) {
		this.proposition = proposition;
	}
	

}

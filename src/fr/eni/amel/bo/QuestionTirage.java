package fr.eni.amel.bo;

public class QuestionTirage {
	
	private boolean estmarquee;
	private Question question;
	private int numordre;
	private Epreuve epreuve;
	private Proposition proposition;
	
	//Constructeur
	
	public QuestionTirage() {
		
	}
	
	public QuestionTirage(boolean estmarquee, Question question, int numordre, Epreuve epreuve,
			Proposition proposition) {
		this.estmarquee = estmarquee;
		this.question = question;
		this.numordre = numordre;
		this.epreuve = epreuve;
		this.proposition = proposition;
	}

	//Getter
	
	public boolean isEstmarquee() {
		return this.estmarquee;
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

	public void setEstmarquee(boolean estmarquee) {
		this.estmarquee = estmarquee;
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

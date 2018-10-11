package fr.eni.amel.bll.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.eni.amel.bll.manager.EpreuveManager;
import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.SectionTest;
import fr.eni.amel.dal.EpreuveDAO;
import fr.eni.amel.dal.SectionTestDao;
import fr.eni.amel.dal.factory.DaoFactory;

import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.util.ValidationUtil;

public class EpreuveManagerImpl implements EpreuveManager {

	private static EpreuveManagerImpl instance;
	private EpreuveDAO epreuveDAO = DaoFactory.epreuveDAO();
	private SectionTestDao sectionTestDAO = DaoFactory.getSectionDao();

	private EpreuveManagerImpl() {

	}

	public static EpreuveManagerImpl getInstance() {
		if (instance == null) {
			instance = new EpreuveManagerImpl();
		}
		return instance;
	}

	/**
	 * lorqu'un candidat est authentifi�, lister les �preuves auxquels il est
	 * inscrit
	 */
	@Override
	public List<Epreuve> listerEpreuvesPourUtilisateur(Integer idUtilisateur) {
		List<Epreuve> listeEpreuvesUtilisateur = null;

		try {
			ValidationUtil.checkNotNull(idUtilisateur);
			listeEpreuvesUtilisateur = epreuveDAO.selectByUtilisateur(idUtilisateur);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeEpreuvesUtilisateur;
	}

	/**
	 * Pour une �preuve s�lectionn�e, r�cup�rer pour le test , les sections
	 * tests associ�es avec le nombre de questions � tirer et le th�me des
	 * questions
	 * 
	 * @return
	 */
	@Override
	public List<SectionTest> listerSectionsTestsPourEpreuve(Integer idEpreuve) {
		List<SectionTest> listeSectionTest = null;
		try {
			ValidationUtil.checkNotNull(idEpreuve);
			listeSectionTest = epreuveDAO.selectById(idEpreuve).getTest().getListeSectionTests();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		return listeSectionTest;
	}

	
	

	/**
	 * Pour une sectionTest, r�cup�rer  les questions
	 */
	public List<Question> tirerAuSortQuestions(Integer idEpreuve){
		ValidationUtil.checkNotNull(idEpreuve);
		List<Question> listeQuestionsEpreuve = new ArrayList();
		for(SectionTest section : this.listerSectionsTestsPourEpreuve(idEpreuve)){
			//Pour une sectionTest, r�cup�rer le nombre de questions � tirer
			long nbQuestionsATirer= section.getNbQuestionsATirer();
			
			//Pour une sectionTest, r�cup�rer la liste de questions du th�me
			List<Question> listeQuestions = section.getTheme().getListeQuestions();
			
			//Initialisation du nombre de questions tir�es
			long nbQuestionsTirees = 0;
			
			// Tant que le nb de questions tir�es par section 
			// est inf�rieur au nb de questions � tirer par section
			// on tire un nb al�atoire compris entre 0 et la taille de la liste de questions
			// on r�cup�re la question tir�e, on l'ajoute � la liste de questions de l'�preuve
			// on retire la question de la liste de questions du th�me pour �tre s�r qu'elle ne sorte 
			// pas en double
			while(nbQuestionsTirees <= nbQuestionsATirer){
				Random RANDOM = new Random();
				Integer rand= RANDOM.nextInt(listeQuestions.size());
				Question questionTiree = listeQuestions.get(rand);
				nbQuestionsTirees = nbQuestionsTirees+1;
				listeQuestionsEpreuve.add(questionTiree);
				listeQuestions.remove(questionTiree);
			}
		}
		System.out.println(listeQuestionsEpreuve);
		return listeQuestionsEpreuve;
	}
}

package fr.eni.amel.dal.factory;

import fr.eni.amel.dal.PropositionDao;
import fr.eni.amel.dal.QuestionDao;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.ThemeDao;
import fr.eni.amel.dal.UtilisateurDao;
import fr.eni.amel.dal.impl.PropositionDaoImpl;
import fr.eni.amel.dal.impl.QuestionDaoImpl;
import fr.eni.amel.dal.impl.TestDaoImpl;
import fr.eni.amel.dal.impl.ThemeDaoImpl;
import fr.eni.amel.dal.impl.UtilisateurDaoImpl;

public class DaoFactory {
	
	public static TestDao getTestDao() {
		return TestDaoImpl.getInstance();
	}
	public static ThemeDao getThemeDao() {
		return ThemeDaoImpl.getInstance();
		
	}

	public static PropositionDao propositionDAO() {
		return PropositionDaoImpl.getInstance();
	}
	 
 	public static QuestionDao questionDAO() {
		return QuestionDaoImpl.getInstance();
	}
 	
 	public static UtilisateurDao utilisateurDao() {
		UtilisateurDao utilisateurDAO = new UtilisateurDaoImpl();
 		return utilisateurDAO;
 		
 	}
}

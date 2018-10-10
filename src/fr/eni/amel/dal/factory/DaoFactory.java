package fr.eni.amel.dal.factory;

import fr.eni.amel.dal.PropositionDao;
import fr.eni.amel.dal.QuestionDao;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.impl.PropositionDaoImpl;
import fr.eni.amel.dal.impl.QuestionDaoImpl;
import fr.eni.amel.dal.impl.TestDaoImpl;

public class DaoFactory {
	
	public static TestDao getTestDao() {
		TestDao testDAO = new TestDaoImpl();
		return testDAO;
	}

	public static PropositionDao propositionDAO() {
		return PropositionDaoImpl.getInstance();
	}
	 
 	public static QuestionDao questionDAO() {
		return QuestionDaoImpl.getInstance();
	}
}

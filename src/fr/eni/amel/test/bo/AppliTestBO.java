package fr.eni.amel.test.bo;

import java.util.List;

import fr.eni.amel.bo.Test;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class AppliTestBO {
	public static void main(String[] args) throws DaoException {
		// declaration et instanciation de la DAO

		TestDao testDAO = DaoFactory.getTestDao();

		// Creer un nouveau test
		Test test1 = new Test("zezrz", "test sur l'anglais", 60, 80, 20);
		Test test2 = new Test("math", "test sur la langue francaise", 60, 80, 20);
		
		System.out.println(test1);
		System.out.println(test2);
	}
}

package fr.eni.amel.test.bo;

import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.Test;
import fr.eni.amel.dal.TestDao;
import fr.eni.amel.dal.factory.DaoFactory;

public class AppliTestBO {
	public static void main(String[] args) {
		// declaration et instanciation de la DAO
		
				TestDao testDAO = DaoFactory.getTestDao();
				
				// Creer un nouveau test 
				Test test1 = new Test("JAVA","test sur le language de programmation JAVA", 60, 80, 20);
				System.out.println(test1);

				
			
	}
}

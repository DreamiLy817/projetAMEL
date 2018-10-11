package fr.eni.amel.test.dal;

import java.util.List;

import fr.eni.amel.bo.Profil;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class AppliProfilDAL {

	public static void main(String[] args) {
		
		// test s�lection d'un profil
		try {
			Profil unProfil = DaoFactory.getProfilDao().selectById(4);
			
			System.out.println(unProfil.toString());
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// test s�lection de tous les profils
		List<Profil> listeProfils;
		try {
			listeProfils = DaoFactory.getProfilDao().selectAll();
			
			for ( Profil profil : listeProfils) {
				System.out.println(profil);
			}
			
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}

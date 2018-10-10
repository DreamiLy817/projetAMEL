package fr.eni.amel.test.bo;

import fr.eni.amel.bo.Profil;
import fr.eni.amel.bo.Promotion;
import fr.eni.amel.bo.Utilisateur;

public class AppliTestUtilisateurBO {

		public static void main(String[] args) {
			
					// Creer une nouvelle utilisatrice 
					Profil unProfil = new Profil(3, "interne");
					Promotion unePromo = new Promotion(1, "CDI-00");
					Utilisateur unUtil = new Utilisateur(5, "Vasseur","Marion", "m.vasseur@mail.com", "mv", unProfil, unePromo);
					System.out.println(unUtil.toString());

		}
}

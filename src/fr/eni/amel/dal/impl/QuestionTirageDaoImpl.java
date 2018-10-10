package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Epreuve;
import fr.eni.amel.bo.Question;
import fr.eni.amel.bo.QuestionTirage;
import fr.eni.amel.dal.QuestionTirageDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;

public class QuestionTirageDaoImpl implements QuestionTirageDAO{
	
private static final String insert 	= "INSERT INTO QUESTION_TIRAGE (estMarquee, idQuestion, numordre, idEpreuve) VALUES (?, ?, ?, ?)";
private static final String select_all 	= "SELECT * FROM QUESTION_TIRAGE ";
private static final String select_epreuve 	= "SELECT * FROM QUESTION_TIRAGE WHERE idEpreuve = ?";


private static QuestionTirageDaoImpl instance;

public static QuestionTirageDaoImpl getInstance() {
	if (instance == null) {
		instance = new QuestionTirageDaoImpl();
	}
	return instance;
}

@Override
	public Object insert(Object element) throws DaoException {
		
		Connection cnx=null;
		PreparedStatement rqt=null;
		QuestionTirage tirage = (QuestionTirage)element;
		
		try{
			cnx = MSSQLConnectionFactory.get();
			rqt=cnx.prepareStatement(insert);
			rqt.setBoolean(1, tirage.isEstmarquee());
			rqt.setInt(2,tirage.getQuestion().getIdQuestion());
			rqt.setInt(3, tirage.getNumordre());
			rqt.setInt(4, tirage.getEpreuve().getIdEpreuve());
			rqt.executeUpdate();
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return tirage;
	}

	@Override
	public void update(Object element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object selectById(Object id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List selectAll() throws DaoException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<QuestionTirage> question_tirages = new ArrayList<QuestionTirage>();
		QuestionTirage question_tirage = null;
		try{
			cnx = MSSQLConnectionFactory.get();
			rqt = cnx.prepareStatement(select_all);
			rs=rqt.executeQuery();
			
			
			// SI on trouve au moins 1 r�sultat, on prend le 1er pour mettre � jour les informations de l'animateur utilis� pour la recherche.
			while(rs.next()){
				question_tirage = new QuestionTirage();
				question_tirage.setEstmarquee(rs.getBoolean("estMarquee"));;
				question_tirage.setNumordre(rs.getInt("numordre"));
				
				//Ajouter epreuve
				EpreuveDaoImpl epreuveDAO = EpreuveDaoImpl.getInstance();
				Epreuve epreuve = (Epreuve)epreuveDAO.selectById(rs.getInt("idEpreuve"));
				question_tirage.setEpreuve(epreuve);
								
				//Ajouter question
				QuestionDaoImpl questionDAO = QuestionDaoImpl.getInstance();
				Question question = (Question)questionDAO.selectById(rs.getInt("idQuestion"));
				question_tirage.setQuestion(question);
				
				
				question_tirages.add(question_tirage);
			}
			
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return question_tirages;
	}
	

	@Override
	public Object selectByIdEpreuve(Object id) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<QuestionTirage> question_tirages = new ArrayList<QuestionTirage>();
		QuestionTirage question_tirage = null;
		try{
			cnx = MSSQLConnectionFactory.get();
			rqt = cnx.prepareStatement(select_epreuve);
			rqt.setInt(1, (int)id);
			rs=rqt.executeQuery();
			
			
			// SI on trouve au moins 1 r�sultat, on prend le 1er pour mettre � jour les informations de l'animateur utilis� pour la recherche.
			while(rs.next()){
				question_tirage = new QuestionTirage();
				question_tirage.setEstmarquee(rs.getBoolean("estMarquee"));;
				question_tirage.setNumordre(rs.getInt("numordre"));
				
				//Ajouter epreuve
				EpreuveDaoImpl epreuveDAO = EpreuveDaoImpl.getInstance();
				Epreuve epreuve = (Epreuve)epreuveDAO.selectById(rs.getInt("idEpreuve"));
				question_tirage.setEpreuve(epreuve);
								
				//Ajouter question
				QuestionDaoImpl questionDAO = QuestionDaoImpl.getInstance();
				Question question = (Question)questionDAO.selectById(rs.getInt("idQuestion"));
				question_tirage.setQuestion(question);
				
				
				question_tirages.add(question_tirage);
			}
			
		}catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		}
		return question_tirages;
	} 	
}

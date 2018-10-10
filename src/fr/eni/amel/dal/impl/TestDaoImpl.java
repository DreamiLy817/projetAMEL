package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.amel.bo.Test;
import fr.eni.amel.dal.TestDao;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;

//idTest,libelle,description,duree,seuil_haut,seuil_bas
public class TestDaoImpl implements TestDao{
	private static final String INSERT_TEST_QUERY = "INSERT INTO TEST(libelle, description, duree, seuil_haut, seuil_bas) VALUES(?,?,?,?,?)";
	//private static final String SELECT_TEST_QUERY = "SELECT idTest, libelle, description, duree, seuil_haut, seuil_bas FROM QUESTION q WHERE q.idQuestion=?";
	//private static final String SELECT_ALL_TEST = "SELECT q.idQuestion, q.enonce, q.media, q.points, q.idTheme FROM QUESTION q";
	private static final String UPDATE_TEST_QUERY = "UPDATE TEST SET (libelle=? , description=?, duree=?, seuil_haut=?, seuil_bas=?) WHERE idTest =? ";
	//private static final String DELETE_TEST_QUERY = "DELETE FROM QUESTION WHERE idQuestion =? ";
	
	private static TestDaoImpl instance;

	public static TestDaoImpl getInstance() {
		if (instance == null) {
			instance = new TestDaoImpl();
		}
		return instance;
	}

	
	@Override
	public Test insert(Test test) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;

		try {
			cnx = MSSQLConnectionFactory.get();
			rqt = cnx.prepareStatement(INSERT_TEST_QUERY , Statement.RETURN_GENERATED_KEYS);

			String libelle = test.getLibelle();
			String description = test.getDescription();
			Integer duree = test.getDuree();
			Integer seuil_haut = test.getSeuil_haut();
			Integer seuil_bas = test.getSeuil_bas();
			
			rqt.setString(1, libelle);
			rqt.setString(2, description);
			rqt.setInt(3, duree);
			rqt.setInt(4, seuil_haut);
			rqt.setInt(5, seuil_bas);
		

			int nbRows = rqt.executeUpdate();
			if (nbRows == 1) {
				// recuperation du tampon
				rs = rqt.getGeneratedKeys();
				// je vais sur le premier enregistrement s'il existe
				if (rs.next()) {
					test.setIdTest(rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return test;
	}

	@Override
	public void update(Test test) throws DaoException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = MSSQLConnectionFactory.get();
			rqt = cnx.prepareStatement(UPDATE_TEST_QUERY);
		
			rqt.setString(1, test.getLibelle());
			rqt.setString(2, test.getDescription());
			rqt.setInt(3, test.getDuree());
			rqt.setInt(4, test.getSeuil_haut());
			rqt.setInt(5, test.getSeuil_bas());
	
			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
				}
				if (cnx != null) {
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void delete(Integer id) throws DaoException {
		
		
	}

	@Override
	public Test selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Test> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

}

package fr.eni.amel.dal.impl;

import java.util.List;

import fr.eni.amel.bo.Theme;
import fr.eni.amel.dal.ThemeDao;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class ThemeDaoImpl  implements ThemeDao{
	
	private static final String INSERT_TEST_QUERY = "INSERT INTO TEST(libelle, description, duree, seuil_haut, seuil_bas) VALUES(?,?,?,?,?)";
	//private static final String SELECT_TEST_QUERY = "SELECT idTest, libelle, description, duree, seuil_haut, seuil_bas FROM QUESTION q WHERE q.idQuestion=?";
	//private static final String SELECT_ALL_TEST = "SELECT q.idQuestion, q.enonce, q.media, q.points, q.idTheme FROM QUESTION q";
	private static final String UPDATE_TEST_QUERY = "UPDATE TEST SET (libelle=? , description=?, duree=?, seuil_haut=?, seuil_bas=?) WHERE idTest =? ";
	//private static final String DELETE_TEST_QUERY = "DELETE FROM QUESTION WHERE idQuestion =? ";
	
	private static ThemeDaoImpl instance;

	public static ThemeDaoImpl getInstance() {
		if (instance == null) {
			instance = new ThemeDaoImpl();
		}
		return instance;
	}

	@Override
	public Theme insert(Theme element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Theme element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Theme selectById(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Theme> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	



}

package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.amel.bo.Profil;
import fr.eni.amel.dal.ProfilDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public class ProfilDaoImpl implements ProfilDAO {

	private static final String SELECT_PROFIL_QUERY = "SELECT p.codeProfil, p.libelle FROM PROFIL p WHERE p.codeProfil = ?";
	private static final String SELECT_ALL = "SELECT p.codeProfil, p.libelle FROM PROFIL p";
	
	
	@Override
	public Profil insert(Profil element) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Profil element) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer id) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Profil selectById(Integer id) throws DaoException {
		
		Connection cnx = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Profil unProfil = null;
		
		return unProfil;
	}

	@Override
	public List<Profil> selectAll() throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	
}

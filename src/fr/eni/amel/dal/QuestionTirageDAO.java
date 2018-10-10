package fr.eni.amel.dal;

import fr.eni.tp.web.common.dal.dao.GenericDAO;
import fr.eni.tp.web.common.dal.exception.DaoException;

public interface QuestionTirageDAO extends GenericDAO{

	public Object selectByIdEpreuve(Object id) throws DaoException;

}

package fr.eni.amel.dal.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.amel.bo.Proposition;
import fr.eni.amel.bo.Question;
import fr.eni.amel.dal.QuestionDao;
import fr.eni.amel.dal.factory.DaoFactory;
import fr.eni.tp.web.common.dal.exception.DaoException;
import fr.eni.tp.web.common.dal.factory.MSSQLConnectionFactory;
import fr.eni.tp.web.common.util.ResourceUtil;

public class QuestionDaoImpl implements QuestionDao {

	private static final String INSERT_QUESTION_QUERY = "INSERT INTO QUESTION(enonce,media, points, idTheme) VALUES(?,?,?,?)";
	private static final String SELECT_QUESTION_QUERY = "SELECT q.idQuestion, q.enonce, q.media, q.points, q.idTheme FROM QUESTION q WHERE q.idQuestion=?";
	private static final String SELECT_ALL_QUESTIONS = "SELECT q.idQuestion, q.enonce, q.media, q.points, q.idTheme FROM QUESTION q";
	private static final String UPDATE_QUESTION_QUERY = "UPDATE QUESTION SET (enonce=? , media=?, points=?, idTheme=?) WHERE idQuestion =? ";
	private static final String DELETE_QUESTION_QUERY = "DELETE FROM QUESTION WHERE idQuestion =? ";

	private static QuestionDaoImpl instance;

	public static QuestionDaoImpl getInstance() {
		if (instance == null) {
			instance = new QuestionDaoImpl();
		}
		return instance;
	}

	@Override
	public Question insert(Question question) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(INSERT_QUESTION_QUERY, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, question.getEnonce());
			statement.setString(2, question.getMedia());
			statement.setLong(3, question.getPoints());
			statement.setInt(4, idTheme);
			if (statement.executeUpdate() == 1) {
				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					question.setIdQuestion(resultSet.getInt(1));
				}
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return question;
	}

	@Override
	public void update(Question question) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(UPDATE_QUESTION_QUERY, question.getIdQuestion());
			statement.setString(1, question.getEnonce());
			statement.setString(2, question.getMedia());
			statement.setLong(3, question.getPoints());
			statement.setInt(4, question.getTheme());

			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

	}

	@Override
	public void delete(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(DELETE_QUESTION_QUERY);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

	}

	@Override
	public Question selectById(Integer id) throws DaoException {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Question question = null;
		List<Proposition> listePropositions= new ArrayList();
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.prepareStatement(SELECT_QUESTION_QUERY);
			statement.setInt(1, id);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				question = new Question();
				question.setEnonce(resultSet.getString("enonce"));
				question.setIdQuestion(id);
				question.setMedia(resultSet.getString("media"));
				question.setPoints(resultSet.getLong("points"));
				question.setTheme(resultSet.getInt("idTheme"));
				listePropositions = DaoFactory.propositionDAO().listePropositionsParQuestion(id);
				question.setListePropositions(listePropositions);
			
			}

		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return question;

	}

	@Override
	public List<Question> selectAll() throws DaoException {
		List<Question> listeQuestions = new ArrayList<>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Integer questionId = null;
		Question question = null;
		List<Proposition> listePropositions = new ArrayList();
		
		try {
			connection = MSSQLConnectionFactory.get();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL_QUESTIONS);

			while (resultSet.next()) {
				question = new Question();
				question.setEnonce(resultSet.getString("enonce"));
				question.setIdQuestion(resultSet.getInt("idQuestion"));
				question.setMedia(resultSet.getString("media"));
				question.setPoints(resultSet.getLong("points"));
				question.setTheme(resultSet.getInt("idTheme"));
				listePropositions = DaoFactory.propositionDAO().listePropositionsParQuestion(question.getIdQuestion());
				question.setListePropositions(listePropositions);
				listeQuestions.add(question);
			}
		} catch (SQLException e) {
			throw new DaoException(e.getMessage(), e);
		} finally {
			ResourceUtil.safeClose(resultSet, statement, connection);
		}

		return listeQuestions;
	}

}

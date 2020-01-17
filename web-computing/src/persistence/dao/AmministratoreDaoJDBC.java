package persistence.dao;
import java.util.LinkedList;
import java.util.List;

import model.Amministratore;

import java.sql.*;
public class AmministratoreDaoJDBC implements AmministratoreDao {
	private DataSource dataSource;

	public AmministratoreDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Amministratore> findAll() {
		Connection connection = this.dataSource.getConnection();
		List<Amministratore> studenti = new LinkedList<>();
		try {
			Amministratore amministratore;
			PreparedStatement statement;
			String query = "select * from amministratore";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				amministratore = new Amministratore();
				amministratore.setId(result.getString("id"));
				amministratore.setNome(result.getString("nome"));
				amministratore.setEmail(result.getString("email"));
				amministratore.setPassword(result.getString("password"));
				studenti.add(amministratore);
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return studenti;
	}

	
	@Override
	public void save(Amministratore amministratore) {
		Connection connection = this.dataSource.getConnection();
		try {
			String insert = "insert into amministratore(Id, Password, Nome, email,) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, amministratore.getId());
			statement.setString(2, amministratore.getPassword());
			statement.setString(3, amministratore.getNome());
			statement.setString(4, amministratore.getEmail());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public Amministratore findByPrimaryKey(String id) {
		Connection connection = this.dataSource.getConnection();
		Amministratore amministratore = null;
		try {
			PreparedStatement statement;
			String query = "select * from amministratore where Id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				amministratore = new Amministratore();
				amministratore.setId(result.getString("Id"));
				amministratore.setNome(result.getString("Nome"));
				amministratore.setEmail(result.getString("Cognome"));
				amministratore.setPassword(result.getString("email"));
			}
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		return amministratore;
	}

	@Override
	public void update(Amministratore amministratore) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update amministratore SET id = ?, Nome = ?, email = ?, password = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, amministratore.getId());
			statement.setString(2, amministratore.getNome());
			statement.setString(3, amministratore.getEmail());
			statement.setString(4, amministratore.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

	@Override
	public void delete(Amministratore amministratore) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "DELETE FROM Amministratore WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, amministratore.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
	}

}

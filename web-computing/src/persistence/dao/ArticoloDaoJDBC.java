package persistence.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Articolo;
import model.Model;
import model.Utente;
public class ArticoloDaoJDBC implements Dao {
	private DataSource dataSource;

	public ArticoloDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Model> findAll() {
		Connection connection = null;
		List<Model> studenti = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Articolo utente;
			PreparedStatement statement;
			String query = "select * from articolo";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new Articolo();
				utente.setNome(result.getString("titolo"));
				utente.setEmail(result.getString("contenuto"));
				utente.setPassword(result.getString("immagine"));
				studenti.add(utente);
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
	public void save(Model utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			System.out.println("Primo try");
			String insert = "INSERT INTO articolo(titolo, contenuto, immagine) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			statement.setString(1, utente.getNome());
			statement.setString(2, utente.getEmail());
			statement.setString(3, utente.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {System.out.println("secondo try");
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	@Override
	public Model findByPrimaryKey(String id) {
		Connection connection = null;
		Articolo utente = null;
		try {
			connection = this.dataSource.getConnection();
			PreparedStatement statement;
			String query = "select * from utente where Id = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Articolo();
				utente.setId(result.getString("id"));
				utente.setNome(result.getString("nome"));
				utente.setEmail(result.getString("cognome"));
				utente.setPassword(result.getString("email"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return utente;
	}

	@Override
	public void update(Model utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String update = "update utente SET id = ?, Nome = ?, email = ?, password = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			statement.setString(1, utente.getId());
			statement.setString(2, utente.getNome());
			statement.setString(3, utente.getEmail());
			statement.setString(4, utente.getPassword());
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
	public void delete(Model utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			String delete = "DELETE FROM Utente WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(delete);
			statement.setString(1, utente.getId());
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

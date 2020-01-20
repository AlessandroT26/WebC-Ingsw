package persistence.dao;
import java.util.LinkedList;
import java.util.List;

import model.Utente;


import java.sql.*;
public class UtenteDaoJDBC implements UtenteDao {
	private DataSource dataSource;

	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public List<Utente> findAll() {
		Connection connection = null;
		List<Utente> studenti = new LinkedList<>();
		try {
			connection = this.dataSource.getConnection();
			Utente utente;
			PreparedStatement statement;
			String query = "select * from utente";
			statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				utente = new Utente();
				utente.setNome(result.getString("nome"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));
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
	public void save(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			System.out.println("Primo try");
			String insert = "INSERT INTO utente(nome, email, password) values (?,?,?)";
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

	public boolean loginAccess(String nome, String password) {
		String n=null;
		String p=null;
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from utente where nome = ? and password = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				n=result.getString("nome");
				p=result.getString("password");
			}
			
		}catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		if(n!=null && p!= null)
			return true;
		return false;
	}
	
	@Override
	public Utente findByPrimaryKey(String nome) {
		Connection connection = this.dataSource.getConnection();
		Utente utente = null;
		try {
			PreparedStatement statement;
			String query = "select * from utente where nome = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, nome);
			ResultSet result = statement.executeQuery();
			if (result.next()) {
				utente = new Utente();
				//utente.setId(result.getString("id"));
				utente.setNome(result.getString("nome"));
				utente.setEmail(result.getString("email"));
				utente.setPassword(result.getString("password"));
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
	public void update(Utente utente) {
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
	public void delete(Utente utente) {
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

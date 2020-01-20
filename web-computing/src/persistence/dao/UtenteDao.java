package persistence.dao;
import java.util.List;

import model.Utente;

public interface UtenteDao {
	public void save(Utente utente); // Create
	public Utente findByPrimaryKey(String id); // Retrieve
	public List<Utente> findAll();
	public void update(Utente utente); // Update
	public void delete(Utente utente); // Delete
	public boolean loginAccess(String nome, String password);
}

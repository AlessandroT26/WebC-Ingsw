package persistence.dao;
import java.util.List;

import model.Amministratore;

public interface AmministratoreDao {
	public void save(Amministratore amministratore); // Create
	public Amministratore findByPrimaryKey(String id); // Retrieve
	public List<Amministratore> findAll();
	public void update(Amministratore amministratore); // Update
	public void delete(Amministratore amministratore); // Delete
}

package persistence.dao;
import java.util.List;

import model.Model;

public interface Dao {
	public void save(Model amministratore); // Create
	public Model findByPrimaryKey(String id); // Retrieve
	public List<Model> findAll();
	public void update(Model amministratore); // Update
	public void delete(Model amministratore); // Delete
}

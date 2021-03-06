package persistence.dao;
public class DAOFactory {
	public static DataSource dataSource;
	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			dataSource = new DataSource("jdbc:postgresql://localhost:5432/postgres", "postgres", "Accettare7");
			// dataSource = new DataSource("jdbc:mysql://localhost:3306/sql11215312",
			// "root", "");
		} catch (Exception e) {
			//System.err.println("MySQLDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			System.out.println("porca madonna");
			e.printStackTrace();
		}
	}

	public static Dao getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}
	
	public static Dao getAmministratoreDAO() {
		return new AmministratoreDaoJDBC(dataSource);
	}

	public static Dao makeArticoloDAO() {
		// TODO Auto-generated method stub
		return new ArticoloDaoJDBC(dataSource);
	}

	
}

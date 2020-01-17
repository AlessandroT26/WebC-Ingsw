package persistence.dao;
public class DAOFactory {
	public static DataSource dataSource;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dataSource = new DataSource("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11215312", "sql11215312",
					"lBDflwqHkN");
			// dataSource = new DataSource("jdbc:mysql://localhost:3306/sql11215312",
			// "root", "");
		} catch (Exception e) {
			System.err.println("MySQLDAOFactory.class: failed to load MySQL JDBC driver\n" + e);
			e.printStackTrace();
		}
	}

	public static UtenteDao getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}
	
	public static AmministratoreDao getAmministratoreDAO() {
		return new AmministratoreDaoJDBC(dataSource);
	}

	
}

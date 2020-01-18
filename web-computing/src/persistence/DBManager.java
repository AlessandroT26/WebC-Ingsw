package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import persistence.dao.DataSource;



public class DBManager {
	private static  DataSource dataSource;

	static {
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
//			dataSource=new DataSource("jdbc:postgresql://52.39.164.176:5432/xx","xx","p@xx");
			dataSource=new DataSource("jdbc:postgresql://localhost:5432/postgres","postgres","Accettare7");
			
		} 
		catch (Exception e) {
			System.err.println("PostgresDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
//	List<Scuola> scuole;
//	List<Studente> studenti;
//	List<Dipartimento> dipartimenti;
	
	public static DBManager instance = null;
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	public static void main(String[] args) throws SQLException {
		DBManager.getInstance();
		Connection connection = dataSource.getConnection();
		PreparedStatement statement;
		String query = "select * from utente";
		statement = connection.prepareStatement(query);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			System.out.println(result.getString("nome"));
		}
	}
	
}
	
//	private DBManager() {
////		scuole = new ArrayList<Scuola>();
////		
////		Scuola s1 = new Scuola();
////		s1.setId((long)1);
////		s1.setCodiceMeccanografico("RC546545646");
////		s1.setNome("Istituto Professionale");
////		scuole.add(s1);
////		
////		studenti = new ArrayList<Studente>();
////		
////		Studente s = new Studente();
////		s.setMatricola("12345");
////		s.setNome("Mario");
////		s.setCognome("Bianchi");
////		s.setScuolaDiDiploma(s1);
////		studenti.add(s);
////		
////		dipartimenti = new ArrayList<Dipartimento>();
////		
////		Dipartimento d1 = new Dipartimento();
////		d1.setId("1");
////		d1.setNome("Matematica e Informatica");
////		
////		CorsoDiLaurea m = new CorsoDiLaurea();
////		m.setId("1");
////		m.setNome("Matematica");
////		m.setDipartimento(d1);
////		
////		CorsoDiLaurea i = new CorsoDiLaurea();
////		i.setId("2");
////		i.setNome("Informatica");
////		i.setDipartimento(d1);
////		
////		List<CorsoDiLaurea> corsi = new ArrayList<CorsoDiLaurea>();
////		corsi.add(m);
////		corsi.add(i);
////		
////		d1.setCorsiDiLaurea(corsi);
////		
////		dipartimenti.add(d1);
//		
//	}
//	
//	public List<Scuola> dammiScuole(){
//		return getScuolaDAO().findAll();
//	}
//	
//	public void inserisciStudente (Studente s) {
//		getStudenteDAO().save(s);
////		studenti.add(s);
//	}
//	
//	public Scuola dammiScuolaById(Long id){
//		return getScuolaDAO().findByPrimaryKey(id);
////		for (Scuola s : scuole) {
////			if (s.getId() == id) {
////				return s; 
////			}
////		}
////		return null;
//	}
//	
//	public Utente login(String username, String password) {
//		//Verificare se l'utente esiste su db
//		if (username.equals("kristian") && password.equals("kristian")) {
//			Utente u = new Utente();
//			u.setUsername(username);
//			u.setPassword(password);
//			return u;
//		}else {
//			return null;
//		}
//	}
//
//	public List<Studente> dammiStudenti() {		
//		return getStudenteDAO().findAll();
//	}
//	
//	public List<Dipartimento> dammiDipartimenti() {		
//		return getDipartimentoDAO().findAll();
//	}
//
//	public Dipartimento dammiDipartimento(String dipartimento) {
//		return getDipartimentoDAO().findByPrimaryKey(Long.parseLong(dipartimento));
////		for (Dipartimento dip : dipartimenti) {
////			if (dip.getId().equals(dipartimento)) {
////				return dip;
////			}
////		}
////		return null;
//	}
//
//	public Studente dammiStudente(String matricola) {
//		return getStudenteDAO().findByPrimaryKey(matricola);
////		for (Studente stud : studenti) {
////			if (stud.getMatricola().equals(matricola)) {
////				return stud;
////			}
////		}
////		return null;
//	}
//	
//	public StudenteDao getStudenteDAO() {
//		return new StudenteDaoJDBC(dataSource);
//	}
//	
//	public ScuolaDao getScuolaDAO() {
//		return new ScuolaDaoJDBC(dataSource);
//	}
//	
//	public CorsoDiLaureaDao getCorsoDiLaureaDAO() {
//		return new CorsoDiLaureaDaoJDBC(dataSource);
//	}
//	
//	public DipartimentoDao getDipartimentoDAO() {
//		return new DipartimentoDaoJDBC(dataSource);
//	}
//}

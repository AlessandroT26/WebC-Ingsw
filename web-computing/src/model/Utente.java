package model;
public class Utente implements Model{//elimina id(?)
	private String nome;
	private String email;
	private String id;
	private String password;
	
	public Utente(String nome, String email, String password) {
		super();
		this.nome = nome;
		this.email = email;
		this.password = password;
	}
	
	public Utente() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		Utente utente = (Utente) obj;
		return (this.getId()== utente.getId());
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
		
}

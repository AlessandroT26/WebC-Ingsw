package model;
public class Amministratore implements Model{
	private String nome;
	private String email;
	private String password;
	private String id;
	public Amministratore(String nome, String email, String password, String id) {
		super();
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.id = id;
	}
	
	public Amministratore() {
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object obj) {
		Amministratore ammi = (Amministratore) obj;
		return (this.getId()==ammi.getId());
	}
}

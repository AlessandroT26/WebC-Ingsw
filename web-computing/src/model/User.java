package model;


public class User {
	private String id;
	private String nome;
	private int tipo;
	private String email;
	
	public User(String id, String nome, String email, int tipo) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.tipo = tipo;
	}

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "[ " + this.nome + ", " + ", " + this.tipo + " ]";
	}

}

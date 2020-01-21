package model;
public class Articolo implements Model{//elimina id(?)
	
	private String titolo;
	private String contenuto;
	private String immagini;
	private String Id;

	
	public Articolo(String nome, String email, String password) {
		super();
		this.titolo = nome;
		this.contenuto = email;
		this.immagini = password;
	}
	
	public Articolo() {
		
	}
	
	@Override
	public boolean equals(Object obj) {
		Articolo utente = (Articolo) obj;
		return (this.getId()== utente.getId());
	}
	
	public String getNome() {
		return titolo;
	}
	public void setNome(String nome) {
		this.titolo = nome;
	}
	public String getEmail() {
		return contenuto;
	}
	public void setEmail(String email) {
		this.contenuto = email;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getPassword() {
		return immagini;
	}
	public void setPassword(String password) {
		this.immagini = password;
	}
		
}

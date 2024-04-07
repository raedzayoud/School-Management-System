package metier;

public class Personnel {
	private String nom;
	private int idU;
	private String prenom;
	private String type;
	private String pwd;
	private String login;
	public Personnel(String nom, int idU, String prenom,String login,String pwd,String type) {
		super();
		this.nom = nom;
		this.idU = idU;
		this.prenom = prenom;
		this.login=login;
		this.type=type;
		this.pwd=pwd;
	}
	public Personnel(String nom,String prenom, int idU) {
		this.nom=nom;
		this.prenom=prenom;
		this.idU=idU;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getIdU() {
		return idU;
	}
	public void setIdU(int idU) {
		this.idU = idU;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	


}

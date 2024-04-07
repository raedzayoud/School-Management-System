package metier;

public class EnseignantList {
	    private int id;
	    private int telephone;
	    private String sexe;
       private int idU;
	    public  EnseignantList(int id,String sexe,int telephone,int idU) {
	    	this.idU=idU;
	        this.id=id;
	        this.sexe=sexe;
	        this.telephone=telephone;
	    }
		public int getIdU() {
			return idU;
		}


		public void setIdU(int idU) {
			this.idU = idU;
		}
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getTelephone() {
			return telephone;
		}

		public void setTelephone(int telephone) {
			this.telephone = telephone;
		}

		public String getSexe() {
			return sexe;
		}

		public void setSexe(String sexe) {
			this.sexe = sexe;
		}

}

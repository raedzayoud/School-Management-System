package metier;

public class EtudiantList {
	    private int id;
	    private int telephone;
	    private String sexe;
        private int idU;

		public EtudiantList(int id, int telephone, String sexe, int idU) {
			super();
			this.id = id;
			this.telephone = telephone;
			this.sexe = sexe;
			this.idU = idU;
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

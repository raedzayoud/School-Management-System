package Project;

import javax.swing.table.DefaultTableModel;

public class ModelJtable {
	 public DefaultTableModel getTableModelStudent() {
	        String[] columnNames = { "ID", "Nom", "prenom", "Téléphone","sexe","idU"};
	        Object[][] data = {} ;
	        return new DefaultTableModel(data, columnNames);
	    }
	 public DefaultTableModel getTableModelEnseignant() {
	        String[] columnNames = { "ID", "Nom", "prenom", "Téléphone","sexe","idU"};
	        Object[][] data = {} ;
	        return new DefaultTableModel(data, columnNames);
	    }
	 public DefaultTableModel getTableModelMatiere() {
	        String[] columnNames = { "ID", "Nom"};
	        Object[][] data = {} ;
	        return new DefaultTableModel(data, columnNames);
	    }
}

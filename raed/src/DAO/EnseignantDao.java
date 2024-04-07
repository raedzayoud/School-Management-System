package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Project.ModelJtable;

public class EnseignantDao {
	private Connection c=SingleConnection.getInstance();
	private Statement statement;
	
    public void consulterListeMatiere(String username,String password) throws SQLException {
    	int id;
    	int idEnseignant = 0; 
    	ModelJtable l=new ModelJtable();
    	 DefaultTableModel model = l.getTableModelMatiere();
    	statement = c.createStatement();
	        ResultSet rs = statement.executeQuery("SELECT * FROM ecole.user WHERE login='" + username + "' AND pwd='" + password + "'");
	        if (rs.next()) {
	            idEnseignant = rs.getInt("idU"); // Retrieve the ID
	        }
	        ResultSet rs1=statement.executeQuery("SELECT id FROM ecole.enseignant WHERE idU="+idEnseignant);

	      
	        if (rs1.next()) {
	            id = rs1.getInt("id");
	            ResultSet matieres=statement.executeQuery("SELECT * FROM ecole.matiere WHERE idEN ="+id);
	            while (matieres.next()) {
	                int idMatiere = matieres.getInt("id");
	                String nomMatiere = matieres.getString("nom");
	                model.addRow(new Object[]{idMatiere, nomMatiere});
	            }

	            // Create a JTable using the DefaultTableModel
	            JTable table = new JTable(model);

	            // Create a JScrollPane to allow scrolling of the table
	            JScrollPane scrollPane = new JScrollPane(table);

	            // Create a JFrame to display the table
	            JFrame frame = new JFrame("Liste des matières");

	            // Add the scroll pane to the frame
	            frame.add(scrollPane);
	            frame.setSize(600, 400);
	            frame.setVisible(true);
	        }


    }
    public void consulterListeEtudiant() {
    	try {
            ModelJtable l=new ModelJtable();
			DefaultTableModel model = l.getTableModelStudent();
			 statement=c.createStatement();
			 ResultSet rst=statement.executeQuery("SELECT * FROM ecole.etudiant");
			 statement=c.createStatement();
			 while(rst.next()) {
	           int telephone = rst.getInt("telephone");
	           int id=rst.getInt("id");
	           String sexe=rst.getString("sexe");
	           int idU=rst.getInt("idU");
	           ResultSet rst1=statement.executeQuery("SELECT * FROM ecole.user where idU="+idU);
	           if(rst1.next()) {
	           	String nom=rst1.getString("nom");
	           	String prenom=rst1.getString("prenom");
	               int idU2=rst1.getInt("idU");
	   
	           model.addRow(new Object[]{id,nom,prenom,telephone,sexe,idU2});}
			 }
			
			// Create a JTable using the DefaultTableModel
		
			JTable   table = new JTable(model);
		   //JScrollPane est un composant de la bibliothèque Swing qui est utilisé pour ajouter la fonctionnalité  des composants tels que JTextArea ou JTable.		// Create a JScrollPane to allow scrolling of the table
		    JScrollPane scrollPane = new JScrollPane(table);

		    // Create a JFrame to display the table
		    JFrame frame = new JFrame("Liste des étudiants");

		    // Add the scroll pane to the frame
		    frame.add(scrollPane);
		    frame.setSize(600, 400);
		    frame.setVisible(true);
			 
		}catch (Exception e2) {
			System.out.println(e2.getMessage());
		}

    }
    public void affiche(DefaultTableModel model,JTable enseignantTable) throws SQLException {
    	 statement=c.createStatement();
		 ResultSet rst=statement.executeQuery("SELECT * FROM ecole.enseignant");
		 statement=c.createStatement();
		 while(rst.next()) {
            int telephone = rst.getInt("telephone");
            int id=rst.getInt("id");
            String sexe=rst.getString("sexe");
            int idU=rst.getInt("idU");
            ResultSet rst1=statement.executeQuery("SELECT * FROM ecole.user where idU="+idU);
            if(rst1.next()) {
            	String nom=rst1.getString("nom");
            	String prenom=rst1.getString("prenom");
                int idU2=rst1.getInt("idU");
    
            model.addRow(new Object[]{id,nom,prenom,telephone,sexe,idU2});}
		 }
			

    }
    }



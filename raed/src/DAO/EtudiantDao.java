package DAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Project.*;

public class EtudiantDao {
    private Statement statement;
	private  Connection c=SingleConnection.getInstance();
    public void consulterListeMatiere() {
        int idEtudiant = 0;
	    try {

	    	ModelJtable l=new ModelJtable();
	        DefaultTableModel model = l.getTableModelMatiere();
	        String[]tab=Login.getUsernamePassword();
	        // Get the username and password of the currently logged in student
	        String username = tab[0];
	        String password = tab[1];

	        // Query the database to get the ID of the student
	        statement = c.createStatement();
	        ResultSet rs = statement.executeQuery("SELECT idU FROM ecole.user WHERE login='" + username + "' AND pwd='" + password + "'");
	        if (rs.next()) {
	            idEtudiant = rs.getInt("idU");
                 System.out.println(idEtudiant);
                 statement = c.createStatement();
			         rs = statement.executeQuery("SELECT id FROM ecole.etudiant WHERE idU="+idEtudiant);
	            // Query the database for the subjects of the student using a join statement
	            if(rs.next()) {
	            int idEtudiant1=rs.getInt("id");	
	            
			       //  PreparedStatement pst = c.prepareStatement("SELECT m.id, m.nom FROM ecole.matiere m JOIN ecole.affectation a ON m.id = a.idM WHERE a.idE = ?");
			         ResultSet matieres=statement.executeQuery("SELECT m.id, m.nom FROM ecole.matiere m JOIN ecole.affectation a ON m.id = a.idM WHERE a.idE ="+idEtudiant1);
			   /*      pst.setInt(1, idEtudiant1);
	            ResultSet matieres = pst.executeQuery();*/
			         

	            // Loop through the results and add the details of each subject to the table model
	            while (matieres.next()) {
	                int idMatiere = matieres.getInt("id");
	                String nomMatiere = matieres.getString("nom");
	                model.addRow(new Object[]{idMatiere, nomMatiere});
	            }
	        }
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

	    } catch (Exception e2) {
	        System.out.println(e2.getMessage());
	    }
	
    }
    public void consulterListeEnseignant() {
    	try {
    		 ModelJtable l=new ModelJtable();
			DefaultTableModel model = l.getTableModelEnseignant();
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
			
			// Create a JTable using the DefaultTableModel
		
			JTable   table = new JTable(model);
		    // Create a JScrollPane to allow scrolling of the table
		    JScrollPane scrollPane = new JScrollPane(table);

		    // Create a JFrame to display the table
		    JFrame frame = new JFrame("Liste des enseignant");

		    // Add the scroll pane to the frame
		    frame.add(scrollPane);
		    frame.setSize(600, 400);
		    frame.setVisible(true);
			 
		}catch (Exception e2) {
			System.out.println(e2.getMessage());
		}
			}
    
    public void afficheJTable(DefaultTableModel model, JTable studentTable) throws SQLException {
             Statement statement = c.createStatement(); 
            ResultSet rst = statement.executeQuery("SELECT * FROM ecole.etudiant");
            while (rst.next()) {
                int telephone = rst.getInt("telephone");
                int id = rst.getInt("id");
                String sexe = rst.getString("sexe");
                int idU = rst.getInt("idU");
                try (Statement statement1 = c.createStatement()) {
                    ResultSet rst1 = statement1.executeQuery("SELECT * FROM ecole.user where idU=" + idU);
                    if (rst1.next()) {
                        String nom = rst1.getString("nom");
                        String prenom = rst1.getString("prenom");
                        int idU2 = rst1.getInt("idU");

                        model.addRow(new Object[]{id, nom, prenom, telephone, sexe, idU2});
                    }
                }
            }
        }
    }

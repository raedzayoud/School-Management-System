package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import metier.EnseignantList;
import metier.EtudiantList;
import metier.Personnel;

public class AdministrateurDao {
	 private Statement statement;
		private  Connection c=SingleConnection.getInstance();
		
		public void addEtudiant(EtudiantList e) {
		    try {
		    	statement=c.createStatement();
		        String query = "INSERT INTO ecole.etudiant ( id, telephone, sexe, idU) VALUES ('"+e.getId()+"','"+e.getTelephone()+"','"+e.getSexe()+"','"+e.getIdU()+"')";
			    statement.executeUpdate(query);

		        JOptionPane.showMessageDialog(null, "L'étudiant a été ajouté avec succès à la base de données.");
		    } catch (SQLException e2) {
		        if (e2 instanceof SQLIntegrityConstraintViolationException) {
		            JOptionPane.showMessageDialog(null, "Erreur : l'ID de l'étudiant existe déjà dans la base de données.");
		        } else {
		            e2.printStackTrace();
		        }
		    }
		}
		public void affichiePasswordLogin(Personnel p) {
			
			try {
			statement=c.createStatement();//pour faire l excution des requetes et la mise a jour .
		    String query = "INSERT INTO ecole.user (idU, login, type, pwd,nom,prenom) VALUES ('"+p.getIdU()+"','"+p.getLogin()+"','"+p.getType()+"','"+p.getPwd()+"','"+p.getNom()+"','"+p.getPrenom()+"')";
		    statement.executeUpdate(query);
			}catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
            public void deleteEtudiant(EtudiantList l) throws SQLException {
	        statement = c.createStatement();

	        // Delete rows from tables with foreign key constraints referencing `idU` in the `user` table
	        String query1 = "DELETE FROM ecole.affectation WHERE idE IN (SELECT id FROM ecole.etudiant WHERE idU=" + l.getIdU() + ")";
	        statement.executeUpdate(query1);

	        // Delete rows from the `etudiant` table
	        String query2 = "DELETE FROM ecole.etudiant WHERE idU=" + l.getIdU();
	        statement.executeUpdate(query2);

	        // Delete row from the `user` table
	        String query3 = "DELETE FROM ecole.user WHERE idU=" + l.getIdU();
	        statement.executeUpdate(query3);

	        JOptionPane.showMessageDialog(null, "L'étudiant a été supprimé avec succès de la base de données.");
	    }

	    public void modifierEtudiant(EtudiantList l) throws SQLException {
	    	statement = c.createStatement();
	        String query = "UPDATE ecole.Etudiant SET  telephone='" + l.getTelephone()+ "', sexe='" + l.getSexe() + "' WHERE id=" + l.getId();
		    try {
		    	   statement.executeUpdate(query);
		      
		     } catch (SQLException e2) {
		        e2.printStackTrace();
		     }      
	        JOptionPane.showMessageDialog(null, "L etudiant a été modifier avec succès ");
	    }
	    public void affecterEtudiant(int idE,int idM) throws SQLException {
	    	 statement=c.createStatement();
			    String query = "INSERT INTO ecole.affectation (iDE,idM) VALUES ('"+idE+"','"+idM+"')";
			    statement.executeUpdate(query);
	        JOptionPane.showMessageDialog(null, "La matière a été affectée à l'etudiant avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);
	     
	    }
	    public void ajouterEnseignant(EnseignantList m) throws SQLException {
	        statement = c.createStatement();
	        try {
	
	           
	            String query = "INSERT INTO ecole.enseignant (id, telephone, sexe, idU) VALUES ('"+m.getId()+"','"+m.getTelephone()+"','"+m.getSexe()+"','"+m.getIdU()+"')";
			    statement.executeUpdate(query);   
	         JOptionPane.showMessageDialog(null, "L'enseignant a été ajouté avec succès à la base de données.");
	        } catch (SQLIntegrityConstraintViolationException e) {
	            if (e.getMessage().contains("enseignant.PRIMARY")) {
	                JOptionPane.showMessageDialog(null, "L'enseignant avec cet ID existe déjà dans la base de données.");
	            }
	        }
	    }
	    public void modifierEnsiegnant(EnseignantList l) throws SQLException {
	     	statement = c.createStatement();
	        String query = "UPDATE ecole.Enseignant SET  telephone='" + l.getTelephone()+ "', sexe='" + l.getSexe() + "' WHERE id=" + l.getId();
		    try {
		    	   statement.executeUpdate(query);
		      
		     } catch (SQLException e2) {
		        e2.printStackTrace();
		     }    
	        JOptionPane.showMessageDialog(null, "L  enseignant a été enregistrées avec succès dans la base de données.");
	   
	    	
		
	   }
	    public void affichiePasswordLoginEnseignant(Personnel p) {
			try {
			statement=c.createStatement();
		    String query = "INSERT INTO ecole.user (idU, login, type, pwd,nom,prenom) VALUES ('"+p.getIdU()+"','"+p.getLogin()+"','"+p.getType()+"','"+p.getPwd()+"','"+p.getNom()+"','"+p.getPrenom()+"')";
		    statement.executeUpdate(query);
	
			}catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	    public void deleteEnseignant(EnseignantList l) throws SQLException {
	    	statement = c.createStatement();
	    	// Supprimer les matières associées à l'enseignant
	    	String query = "UPDATE matiere SET idEN = NULL WHERE idEN ="+l.getId();
		    statement.executeUpdate(query);

	    	
			String query1 = "DELETE FROM ecole.enseignant WHERE id="+l.getId();
		    statement.executeUpdate(query1);
		    
		    String query2 = "DELETE FROM ecole.user WHERE idU="+l.getIdU();
		    statement.executeUpdate(query2);
		
	    }
	    public void affecterEnseignant(int idMa, int idENA) throws SQLException{
	        try {
	            statement = c.createStatement();
	            // Vérification pour s'assurer qu'il existe une entrée avec la même clé primaire
	            ResultSet rs = statement.executeQuery("SELECT * FROM ecole.matiere WHERE id = " + idMa);
	            if (rs.next()) {
	                // Si une entrée existe avec cette clé primaire, mettez à jour l'ID de l'enseignant
	                String query = "UPDATE ecole.matiere SET idEN = " + idENA + " WHERE id = " + idMa;
	                statement.executeUpdate(query);
	            } else {
	                // Sinon, afficher un message d'erreur indiquant que l'entrée n'existe pas
	                JOptionPane.showMessageDialog(null, "L'ID de matière spécifié n'existe pas dans la table de matières.", "Erreur", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (SQLException e2) {
	            e2.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'affectation de l'enseignant à la matière.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    public void modifierUser(Personnel p) {
	        String query2 = "UPDATE ecole.user SET nom='" + p.getNom() + "', prenom='" + p.getPrenom() + "' WHERE idU=" + p.getIdU();
	        try {
	            Statement statement = c.createStatement();
	            statement.executeUpdate(query2);
	            statement.close();
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	    }
}

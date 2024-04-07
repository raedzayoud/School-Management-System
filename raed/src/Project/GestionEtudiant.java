package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import DAO.*;

import metier.EtudiantList;
import metier.Personnel;
public class GestionEtudiant implements ActionListener {
  	private JLabel IDM=new JLabel("IDMATIERE");
    JLabel image1 =new JLabel(); 
	JTable table=new JTable();
	private JFrame frame=new JFrame();
	private JTextField nom=new JTextField(); 
	private JTextField idU=new JTextField();
	private JTextField Login=new JTextField();
	private JTextField pwd=new JTextField();
	private JTextField type=new JTextField();
	private JLabel idU1=new JLabel("idU");
	private JLabel Login1=new JLabel("Login");
	private JLabel pwd1=new JLabel("pwd");
	private JLabel type1=new JLabel("type");
	private JTextField prenom=new JTextField();
	private	JTextField id1=new JTextField();
	private	JTextField telephone=new JTextField();
	private JLabel id=new JLabel("idEtudiant");
	private JLabel nom1=new JLabel("NomEtdiant");
	private JLabel prenom1=new JLabel("PrenomEtudiant");
	private JLabel telephone1=new JLabel("TelephoneEtudiant");
	private JButton Ajouter=new JButton("AjouterEtuidant");
	private JButton Modifier=new JButton("ModifierEtudiant");
	private	JButton Supprimer=new JButton("SupprimerEtudiant");
	private	JButton enregistrer=new JButton("enregistrerEtudiant");
	private	JButton retour=new JButton("Retour");
    private JTable studentTable;
	private Connection c=SingleConnection.getInstance();
	 private	JButton fermer=new JButton("fermer");
		private JPanel panel=new JPanel();
		private String[] sexe= {" ","Homme","Femme"};
		private JComboBox<String>combox;
		private JLabel sexe1=new JLabel("sexe");
        private ModelJtable l=new ModelJtable();
        private DefaultTableModel model=l.getTableModelStudent();
        private ArrayList<EtudiantList>etudiantAjoutee;
        private ArrayList<EtudiantList> etudiantsASupprimer;
        private ArrayList<EtudiantList> etudiantsModfier=new ArrayList<>();
        private ArrayList<Personnel> userAjout = new ArrayList<>();
       private ArrayList<Personnel> userModifier = new ArrayList<>();
        
        private	JButton affecter=new JButton("AffecterMatiereEtudiant");
       private  EtudiantDao EtudiantD=new EtudiantDao();
       private AdministrateurDao ADMIND; 
    	private JTextField idMT=new JTextField();
	   
    	public GestionEtudiant() throws SQLException {
		
    		IDM.setBounds(600,230, 1000, 100);
		IDM.setFont(new Font("Mv Boli",Font.BOLD,20));
        idMT.setBounds(600,300,150,25);
		frame.add(IDM);
		frame.add(idMT);
		ADMIND	= new AdministrateurDao();
	
		
		combox=new JComboBox<>(sexe);
		sexe1.setBounds(205, 300, 1000, 100);
		sexe1.setFont(new Font("Mv Boli",Font.ITALIC,30));
        combox.setBounds(205,370,150,25);
		frame.add(combox);
		frame.add(sexe1);
		frame.getContentPane().setBackground(Color.WHITE);
		ImageIcon  image=new ImageIcon("image/isimg.jpg");
		  JLabel label = new JLabel(image);
		  label.setBounds(530, 40, 300, 300);
		  frame.add(label);
		 
		  etudiantAjoutee=new ArrayList<>();
		 etudiantsASupprimer = new ArrayList<>();
			fermer.addActionListener(this);
			fermer.setFont(new Font("Arial", Font.ITALIC, 20));
			// creation d une label 
			nom1.setBounds(205, 70, 1000, 100);
			nom1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        nom.setBounds(205,130,150,25);
			frame.add(nom);
			
			id.setBounds(205, 140, 1000, 100);
			id.setFont(new Font("Mv Boli",Font.BOLD,20));
	        id1.setBounds(205,210,150,25);
			frame.add(id);
			frame.add(id1);
			
			
		    prenom1.setBounds(400, 70, 1000, 100);
			prenom1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        prenom.setBounds(400,130,150,25);
			frame.add(prenom);
			frame.add(prenom1);
			
			
		    type1.setBounds(400, 140, 1000, 100);
			type1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        type.setBounds(400,210,150,25);
	       
	        
	        frame.add(type);
			frame.add(type1);
			
			
		    pwd1.setBounds(400, 215, 1000, 100);
			pwd1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        pwd.setBounds(400,285,150,25);
			frame.add(pwd);
			frame.add(pwd1);
			
			Login1.setBounds(400, 300, 1000, 100);
			Login1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        Login.setBounds(400,370,150,25);
			frame.add(Login1);
			frame.add(Login);
			
			idU1.setBounds(600, 300, 1000, 100);
			idU1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        idU.setBounds(600,370,150,25);
			frame.add(idU1);
			frame.add(idU);
			
			
			enregistrer.setBounds(0, 350, 200, 50);
			enregistrer.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			enregistrer.setForeground(Color.black);
			enregistrer.setBackground(Color.red);
			enregistrer.setFont(new Font("Arial", Font.ITALIC, 18));
			frame.add(enregistrer);
			telephone1.setBounds(205,215, 1000, 100);
			telephone1.setFont(new Font("Mv Boli",Font.BOLD,19));
	        telephone.setBounds(205,290,150,25);
			frame.add(telephone1);
			frame.add(telephone);
			
			JLabel labelText=new JLabel();
			labelText.setText("EspaceEtudiant");
			labelText.setBounds(0,-80,400,250);
			labelText.setVerticalTextPosition(JLabel.TOP);
			labelText.setForeground(new Color(0x00FF00));
			labelText.setFont(new Font("Mv Boli",Font.BOLD,26));
			frame.add(labelText);
			
			Ajouter.setBounds(0, 200, 200, 50); 
			Ajouter.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			Ajouter.setForeground(Color.white);
			Ajouter.setBackground(Color.LIGHT_GRAY);
		    Modifier.addActionListener(this); 
		 //   Ajouter.addActionListener(this);
			
			
			Modifier.setBounds(0, 250, 200, 50);
			Modifier.setFocusable(true);
			Ajouter.setFont(new Font("Arial", Font.ITALIC, 20));
			Modifier.setFont(new Font("Arial", Font.ITALIC, 20));
		    //changer la couleur d'arrière plan du bouton
			Modifier.setForeground(Color.white);
			Modifier.setBackground(Color.LIGHT_GRAY);
		    
			Supprimer.setBounds(0, 300, 200, 50); 
			Supprimer.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			Supprimer.setForeground(Color.white);
			Supprimer.setBackground(Color.LIGHT_GRAY);
			Supprimer.setFont(new Font("Arial", Font.ITALIC, 20));
			fermer.setBounds(0, 650, 200, 50); 
			fermer.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			fermer.setForeground(Color.black);
			fermer.setBackground(Color.red);
			retour.setBounds(0, 600, 200, 50); 
			retour.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			retour.setForeground(Color.black);
			retour.setBackground(Color.red);
			retour.addActionListener(this);
			//retour.addActionListener(this);
			retour.setFont(new Font("Arial", Font.ITALIC, 20));
			frame.add(retour);
		    Ajouter.addActionListener(this);
			Supprimer.addActionListener(this);
		    panel.setBackground(Color.gray);
		   
		    panel.setBounds(0, 4, 200, 710);
		    //La méthode "getContentPane()" est une méthode de l'objet JFrame en Java qui renvoie le panneau de contenu de la fenêtre principale. Ce panneau de contenu est l'endroit où vous pouvez ajouter des composants graphiques tels que des boutons, des zones de texte, des étiquettes, etc.
		    frame.getContentPane().add(panel);
		    affecter.setBounds(0, 400, 200, 50); 
			affecter.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			affecter.setForeground(Color.black);
			affecter.setBackground(Color.red);
			frame.add(affecter);
			affecter.setFont(new Font("Arial", Font.ITALIC, 15));
			affecter.addActionListener(this);
		   enregistrer.addActionListener(this);
			// pour affichier Jtable
			afficheJtable();
			frame.add(image1);
		    frame.add(fermer);
			frame.add(nom1);
			frame.add(prenom1);
			frame.add(telephone1);
			frame.add(Ajouter);
			frame.add(enregistrer);
			frame.add(Supprimer);
			frame.add(Modifier);
			frame.setSize(1000,750);
			frame.add(panel);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(null);
			frame.setVisible(true);
			
			
		
		
	}
	public void afficheJtable() throws SQLException {
		         EtudiantD.afficheJTable(model, studentTable);
		         studentTable = new JTable(model);
		        // Ajouter la table à un panneau défilant
		       JScrollPane scrollPane = new JScrollPane(studentTable);
		        scrollPane.setBounds(200, 400, 785, 750);	
		      //  JPanel panel = new JPanel();
		     //   scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		       frame. getContentPane().add(scrollPane);
		        //frame.add(panel);
		        //frame.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fermer) {
			frame.dispose();
		}
		else if(e.getSource()==retour) {
			Welcome w=new Welcome();
			frame.dispose();
		}
		else if(e.getSource() == Ajouter) {
		    String type1 = type.getText().trim();
		    String pwd1 = pwd.getText().trim();
		    String login1 = Login.getText().trim();
		    String idU1 = idU.getText().trim();
		    String id = id1.getText().trim();
		    String prenom2 = prenom.getText().trim();
		    String nom2 = nom.getText().trim();
		    String telephone2 = telephone.getText().trim();
		    String sexe = combox.getItemAt(combox.getSelectedIndex());

		    // Vérifier que le téléphone est un entier
		    int telephone = 0;
		    try {
		        telephone = Integer.parseInt(telephone2);
		    } catch(NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "Le numéro de téléphone doit être un entier.");
		        combox.setSelectedIndex(0);
			    nom.setText("");
			    prenom.setText("");
			    id1.setText("");
			    this.telephone.setText("");
			    idU.setText("");
			    type.setText("");
			    pwd.setText("");
			    Login.setText("");
			    return ;
		    }

		    // Vérifier que l'ID est un entier
		    int id2 = 0;
		    try {
		        id2 = Integer.parseInt(id);
		    } catch(NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "L'ID doit être un entier.");
		        combox.setSelectedIndex(0);
			    nom.setText("");
			    prenom.setText("");
			    id1.setText("");
			    this.telephone.setText("");
			    idU.setText("");
			    type.setText("");
			    pwd.setText("");
			    Login.setText("");
			    return ;
		    }

		    // Vérifier que l'ID utilisateur est un entier
		    int idU2 = 0;
		    try {
		        idU2 = Integer.parseInt(idU1);
		    } catch(NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "L'IDU utilisateur doit être un entier.");
		        combox.setSelectedIndex(0);
			    nom.setText("");
			    prenom.setText("");
			    id1.setText("");
			    this.telephone.setText("");
			    idU.setText("");
			    type.setText("");
			    pwd.setText("");
			    Login.setText("");
			    return ;
		    }

		    // Vérifier que le nom et le prénom sont des chaînes de caractères
		    if(!nom2.matches("[a-zA-Z]+") || !prenom2.matches("[a-zA-Z]+")) {
		        JOptionPane.showMessageDialog(null, "Le nom et le prénom doivent être des chaînes de caractères.");
		        combox.setSelectedIndex(0);
			    nom.setText("");
			    prenom.setText("");
			    id1.setText("");
			    this.telephone.setText("");
			    idU.setText("");
			    type.setText("");
			    pwd.setText("");
			    Login.setText("");
			    return ;
		    }

		    // Ajouter l'étudiant et l'utilisateur à la liste
		    EtudiantList e2 = new EtudiantList(id2, telephone, sexe, idU2);
		    etudiantAjoutee.add(e2);
		    Personnel p = new Personnel(nom2, idU2, prenom2, login1, pwd1, type1);
		    userAjout.add(p);

		    // Ajouter une nouvelle ligne au tableau
		    model.addRow(new Object[]{id, nom2, prenom2, telephone2, sexe, idU2});
		    JOptionPane.showMessageDialog(null, "L'étudiant a été ajouté avec succès dans le tableau.");
		    combox.setSelectedIndex(0);
		    nom.setText("");
		    prenom.setText("");
		    id1.setText("");
		    this.telephone.setText("");
		    idU.setText("");
		    type.setText("");
		    pwd.setText("");
		    Login.setText("");
		    
		}

			
		else	if(e.getSource() == Modifier) {
			 int row = studentTable.getSelectedRow();
			    if (row == -1) {
			        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à modifier.");
			        return;
			    }
			    String nom_Etudiant = nom.getText();
			    String telephone_Etudiant = telephone.getText().trim();
			    String sexe= combox.getItemAt(combox.getSelectedIndex());
			    int telephone = Integer.parseInt(telephone_Etudiant);
			    String prenom_Etudiant = prenom.getText();
			    int idU = (int) model.getValueAt(row, 5);
			    model.setValueAt(nom_Etudiant, row, 1);
			    model.setValueAt(prenom_Etudiant, row, 2);
			    model.setValueAt(telephone, row, 3);
			    model.setValueAt(sexe, row, 4);
			    int id1 = (int) model.getValueAt(row, 0);
			    String nomEtudiant = (String) model.getValueAt(row, 1);
			    String prenomEtudiant = (String) model.getValueAt(row, 2);
			    int telephoneEtudiant = (int) model.getValueAt(row, 3);
			    String sexeEtudiant = (String) model.getValueAt(row, 4);

			    JOptionPane.showMessageDialog(null, "L'étudiant a été modifié avec succès dans le JTable.");
          
			    // Création de l'objet Etudiant correspondant à partir des valeurs récupérées
			    EtudiantList etudiant = new EtudiantList(id1, telephoneEtudiant, sexeEtudiant,idU);
			    etudiantsModfier.add(etudiant);
			    Personnel p=new Personnel(nomEtudiant, prenomEtudiant, idU);
			    userModifier.add(p);
		    combox.setSelectedIndex(0);
  		    this.nom.setText("");
  		    this.prenom.setText("");
  		    this.id1.setText("");
  		    this.telephone.setText("");
  		    this.idU.setText("");
        	
        }
		else  if (e.getSource() == Supprimer) {
            int rowIndex = studentTable.getSelectedRow();
            if (rowIndex >= 0) {
                // Récupération des valeurs de la ligne sélectionnée dans la JTable
                int id = (int) model.getValueAt(rowIndex, 0);
                int telephone = (int) model.getValueAt(rowIndex, 3);
                String sexe = (String) model.getValueAt(rowIndex, 4);
                 int idU = (int) model.getValueAt(rowIndex, 5);
                // Création de l'objet Etudiant correspondant à partir des valeurs récupérées
                EtudiantList etudiant = new EtudiantList(id, telephone, sexe,idU);
                // Suppression de l'objet Etudiant correspondant de la liste et de la JTable
                etudiantsASupprimer.add(etudiant);
                model.removeRow(rowIndex);
                // Ajout de l'étudiant à la liste des étudiants à supprimer de la base de données
      
                JOptionPane.showMessageDialog(null, "L'étudiant a été supprimé avec succès dans le JTable.");
            }
        }
       
			    
			  
        
		else if(e.getSource() == affecter) {  
            try {
                c.setAutoCommit(false);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            String idM = idMT.getText().trim();
            String idE1 = id1.getText().trim();
            int idMa;
            int idE;

            // Vérifier que les identifiants de l'étudiant et du module sont bien des entiers
            try {
                idMa = Integer.parseInt(idM);
                idE = Integer.parseInt(idE1);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Les identifiants doivent être des nombres entiers.");
                id1.setText("");
                idMT.setText("");
                return;
            }

            try {
                ADMIND.affecterEtudiant(idE, idMa);
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            id1.setText("");
            idMT.setText("");

            // Enregistrer les informations dans la base de données
            try {
                c.commit();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

           
      
	

		else if (e.getSource() == enregistrer) {
    	   // Connection conn = SingleConnection.getInstance();
    	    try {
    	    	 c.setAutoCommit(false);
    	    	 for (Personnel person :userAjout) {
                  //   AdministrateurDao p = new AdministrateurDao();
                     ADMIND.affichiePasswordLogin(person);
                 	
                 }
    	        // Ajout des étudiants à la base de données
    	        for (EtudiantList etudiant : etudiantAjoutee) {
				//	AdministrateurDao p = new AdministrateurDao();	
					ADMIND.addEtudiant(etudiant);
					
					// Réinitialisation des champs de saisie
					this.nom.setText("");
					this.prenom.setText("");
					this.id1.setText("");
					this.telephone.setText("");
					this.idU.setText("");
					this.type.setText("");
					this.pwd.setText("");
					this.Login.setText("");
					combox.setSelectedIndex(0);
    	        }
    	        
    	        // Suppression des étudiants de la base de données
    	        for (EtudiantList etudiant : etudiantsASupprimer) {
    	           // AdministrateurDao e1 = new AdministrateurDao();
    	            ADMIND.deleteEtudiant(etudiant);
    	        }
    	        for(Personnel person:userModifier) {
              	//  AdministrateurDao p=new AdministrateurDao();
                  ADMIND.modifierUser(person);
              }
    	        
    	        // Modification des étudiants dans la base de données
    	        for (EtudiantList etudiant : etudiantsModfier) {   	            
    	          //  AdministrateurDao a = new AdministrateurDao();
    	            ADMIND.modifierEtudiant(etudiant);
    	        }
    	        
    	        c.commit();
    	        JOptionPane.showMessageDialog(null, "Les modifications ont été enregistrées avec succès dans la base de données.");
    	    } catch (SQLException ex) {
    	        ex.printStackTrace();
    	        try {
    	            c.rollback();
    	        } catch (SQLException e1) {
    	            e1.printStackTrace();
    	        }
    	    }
    	}
    	    }
      }
	
	
	





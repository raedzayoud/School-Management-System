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
import DAO.AdministrateurDao;
import DAO.EnseignantDao;
import DAO.SingleConnection;
import metier.EnseignantList;
import metier.Personnel;
public class GestionEnseignat implements ActionListener {
    JLabel image1 =new JLabel(); 
	private JFrame frame=new JFrame();
	private JTextField idMT=new JTextField();
	
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
	private JLabel id=new JLabel("idEnseignant");
	private JLabel nom1=new JLabel("NomEnseignant");
	private JLabel prenom1=new JLabel("PrenomEnseignat");
	private JLabel telephone1=new JLabel("TelephoneEnseignant");
	private JButton Ajouter=new JButton("AjouterEnseignant");
	private JButton Modifier=new JButton("ModifierEnseignant");
	private	JButton Supprimer=new JButton("SupprimerEnseignant");
	private	JButton enregistrer=new JButton("enregistrerEnseignant");
	private	JButton retour=new JButton("Retour");
	 private	JButton fermer=new JButton("fermer");
		private JPanel panel=new JPanel();
		//JButton recherche;
		private String[] sexe= {" ","Homme","Femme"};
		private JComboBox<String>combox;
		private JLabel sexe1=new JLabel("sexe");
        private EnseignantList e2;
        private Personnel person;
        private Connection connection=SingleConnection.getInstance();
        private EnseignantDao EnseignantD=new EnseignantDao();
        private AdministrateurDao ADMIND =new AdministrateurDao();
        // Créer le modèle de table
        private ModelJtable l=new ModelJtable();
       // DefaultTableModel model = new DefaultTableModel(data, columnNames);
        private  DefaultTableModel model=l.getTableModelEnseignant();
        private ArrayList<EnseignantList>enseignantAjoutee;
        private ArrayList<EnseignantList> enseignantASupprimer;
        private ArrayList<Personnel>userAjouter;
        private ArrayList<Personnel>userModifier;
        private ArrayList<EnseignantList> enseignantsModfier=new ArrayList<>();
    	private JLabel IDM=new JLabel("IDMATIERE");
    	private	JButton affecter=new JButton("AffecterMatiereEnseignat");
		private JTable enseignantTable;
	public  GestionEnseignat() throws SQLException {
		combox=new JComboBox<>(sexe);
		sexe1.setBounds(205, 300, 1000, 100);
		sexe1.setFont(new Font("Mv Boli",Font.ITALIC,30));
        combox.setBounds(205,370,150,25);
		frame.add(combox);
		userAjouter=new ArrayList<>();
		frame.add(sexe1);
		frame.getContentPane().setBackground(Color.WHITE);
		ImageIcon  image=new ImageIcon("image/isimg.jpg");
		  JLabel label = new JLabel(image);
		  label.setBounds(530, 15, 300, 300);
		  frame.add(label);
		 
		  enseignantAjoutee=new ArrayList<>();
		 enseignantASupprimer = new ArrayList<>();
			fermer.addActionListener(this);
			fermer.setFont(new Font("Arial", Font.ITALIC, 20));

		//	fermer.addActionListener(this);
			// creation d une label 
			nom1.setBounds(205, 60, 1000, 100);
			nom1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        nom.setBounds(205,130,150,25);
			frame.add(nom);
			userModifier=new ArrayList<>();
			id.setBounds(205, 150, 1000, 100);
			id.setFont(new Font("Mv Boli",Font.BOLD,20));
	        id1.setBounds(205,220,150,25);
			frame.add(id);
			frame.add(id1);
			
			
		    prenom1.setBounds(400, 60, 1000, 100);
			prenom1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        prenom.setBounds(400,130,150,25);
			frame.add(prenom);
			frame.add(prenom1);
			
			
		    type1.setBounds(400, 150, 1000, 100);
			type1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        type.setBounds(400,220,150,25);
	       
	        
	        frame.add(type);
			frame.add(type1);
			
			
		    pwd1.setBounds(400, 230, 1000, 100);
			pwd1.setFont(new Font("Mv Boli",Font.BOLD,20));
	        pwd.setBounds(400,300,150,25);
			frame.add(pwd);
			frame.add(pwd1);
			
			affecter.setBounds(0, 400, 200, 50); 
			affecter.setFocusable(true);
		    // définit la couleur du texte du bouton sur noir.
			affecter.setForeground(Color.black);
			//définit la couleur de fond du bouton sur rouge.
			affecter.setBackground(Color.red);
			frame.add(affecter);
			affecter.setFont(new Font("Arial", Font.ITALIC, 15));
			affecter.addActionListener(this);
			
			
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
			enregistrer.setFont(new Font("Arial", Font.ITALIC, 17));
			frame.add(enregistrer);
			enregistrer.addActionListener(this);
			
			
			IDM.setBounds(600,230, 1000, 100);
			IDM.setFont(new Font("Mv Boli",Font.BOLD,20));
	        idMT.setBounds(600,300,150,25);
			frame.add(IDM);
			frame.add(idMT);
			
			telephone1.setBounds(205,230, 1000, 100);
			telephone1.setFont(new Font("Mv Boli",Font.BOLD,18));
	        telephone.setBounds(205,300,150,25);
			frame.add(telephone1);
			frame.add(telephone);
			
			JLabel labelText=new JLabel();
			labelText.setText("EspaceEnseignant");
			labelText.setBounds(0,-80,400,250);
			labelText.setVerticalTextPosition(JLabel.TOP);
			labelText.setForeground(new Color(0x00FF00));
			labelText.setFont(new Font("Mv Boli",Font.BOLD,24));
			frame.add(labelText);
			
			Ajouter.setBounds(0, 200, 200, 50); 
			Ajouter.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			Ajouter.setForeground(Color.white);
			Ajouter.setBackground(Color.LIGHT_GRAY);
		 //   Ajouter.addActionListener(this);
			
			
			Modifier.setFocusable(true);
			Modifier.setBounds(0, 250, 200, 50); 
			Ajouter.setFont(new Font("Arial", Font.ITALIC, 17));
			Modifier.setFont(new Font("Arial", Font.ITALIC, 17));
		    //changer la couleur d'arrière plan du bouton
			Modifier.setForeground(Color.white);
			Modifier.setBackground(Color.LIGHT_GRAY);
		    
			Supprimer.setBounds(0, 300, 200, 50); 
			Supprimer.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			Supprimer.setForeground(Color.white);
			Supprimer.setBackground(Color.LIGHT_GRAY);
			Supprimer.setFont(new Font("Arial", Font.ITALIC, 17));
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
			retour.setFont(new Font("Arial", Font.ITALIC, 20));
		    Ajouter.addActionListener(this);
			Supprimer.addActionListener(this);
			Modifier.addActionListener(this);
		    panel.setBackground(Color.gray);
		    panel.setBounds(0, 2, 200, 710);
		    frame.getContentPane().add(panel);
			// pour affichier Jtable
			afficheJTable();
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
			frame.add(retour);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(null);
			frame.setVisible(true);
			
			
		
		
	}
	public void afficheJTable() throws SQLException {
		EnseignantD.affiche(model, enseignantTable);
        enseignantTable = new JTable(model);

       // Ajouter la table à un panneau défilant
      JScrollPane scrollPane = new JScrollPane(enseignantTable);
      
       scrollPane.setBounds(200, 400, 785, 750);
     //  JPanel panel = new JPanel();
      // scrollPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
      frame. getContentPane().add(scrollPane);
      // frame.add(panel);
     //  frame.pack();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fermer) {
			frame.dispose();
		}
		if(e.getSource()==retour) {
			Welcome w=new Welcome();
			frame.dispose();
		}
		if(e.getSource()==Ajouter) {
		    String type1 = type.getText().trim();
		    String pwd1 = pwd.getText().trim();
		    String login1 = Login.getText().trim();
		    String idU1=idU.getText().trim();
		    int idU2 = 0;
		    try {
		        idU2 = Integer.parseInt(idU1);
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "L'idU de l'utilisateur doit être un entier.");
		        combox.setSelectedIndex(0);
			    this.nom.setText("");
			    this.prenom.setText("");
			    this.id1.setText("");
			    this.telephone.setText("");
			    this.idU.setText("");
			    this.type.setText("");
			    this.pwd.setText("");
			    this.Login.setText("");
		        return;
		    }
		    String id=id1.getText().trim();
		    int id2 = 0;
		    try {
		        id2 = Integer.parseInt(id);
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "L'id de l'enseignant doit être un entier.");
		        combox.setSelectedIndex(0);
			    this.nom.setText("");
			    this.prenom.setText("");
			    this.id1.setText("");
			    this.telephone.setText("");
			    this.idU.setText("");
			    this.type.setText("");
			    this.pwd.setText("");
			    this.Login.setText("");
		        return;
		    }
		    String prenom2=prenom.getText();
		    String nom2=nom.getText();
		    String telephone2=telephone.getText().trim();
		    
		    // Tester si l'entrée utilisateur est un nombre pour le téléphone
		    int telephone = 0;
		    try {
		        telephone = Integer.parseInt(telephone2);
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(null, "Le numéro de téléphone doit être un entier.");
		        combox.setSelectedIndex(0);
			    this.nom.setText("");
			    this.prenom.setText("");
			    this.id1.setText("");
			    this.telephone.setText("");
			    this.idU.setText("");
			    this.type.setText("");
			    this.pwd.setText("");
			    this.Login.setText("");
		        return;
		    }
		    
		    // Tester si l'entrée utilisateur est une chaîne de caractères alphabétiques pour le nom et le prénom
		    if (!nom2.matches("[a-zA-Z]+") || !prenom2.matches("[a-zA-Z]+")) {
		        JOptionPane.showMessageDialog(null, "Le nom et le prénom doivent être des chaînes de caractères alphabétiques.");
		        combox.setSelectedIndex(0);
			    this.nom.setText("");
			    this.prenom.setText("");
			    this.id1.setText("");
			    this.telephone.setText("");
			    this.idU.setText("");
			    this.type.setText("");
			    this.pwd.setText("");
			    this.Login.setText("");
		        return;
		    }
		    
		    // Créer un nouvel objet EnseignantList et Personnel et les ajouter aux listes
		    String sexe= combox.getItemAt(combox.getSelectedIndex());
		    e2=new EnseignantList( id2, sexe, telephone,idU2);
		    person=new Personnel(nom2, idU2, prenom2, login1, pwd1, type1);
		    enseignantAjoutee.add(e2);
		    userAjouter.add(person);
		    
		    // Ajouter une nouvelle ligne dans la table
		    model.addRow(new Object[]{id,nom2,prenom2,telephone2,sexe,idU2});
		    
		    JOptionPane.showMessageDialog(null, "L'enseignant a été ajouté avec succès dans le JTable.");
		    
		    // Réinitialiser les champs de saisie
		    combox.setSelectedIndex(0);
		    this.nom.setText("");
		    this.prenom.setText("");
		    this.id1.setText("");
		    this.telephone.setText("");
		    this.idU.setText("");
		    this.type.setText("");
		    this.pwd.setText("");
		    this.Login.setText("");
		}
		if(e.getSource()==affecter) {
		    try {
		        // Connexion à la base de données
		        connection = SingleConnection.getInstance();  
		        connection.setAutoCommit(false);
		        String idM = idMT.getText().trim();
		        String idEN = id1.getText().trim();
		        
		        // Tester si les entrées utilisateur sont des nombres
		        if (!idM.matches("[0-9]+") || !idEN.matches("[0-9]+")) {
		            JOptionPane.showMessageDialog(null, "Les identifiants doivent être des nombres.");
		            id1.setText("");
			        idMT.setText("");
		            return;
		        }
		        
		        int idMa = Integer.parseInt(idM);
		        int idENA = Integer.parseInt(idEN);
		        
		        ADMIND.affecterEnseignant(idMa, idENA);
		        JOptionPane.showMessageDialog(null, "La matière a été affectée à l'enseignant avec succès.", "Succès", JOptionPane.INFORMATION_MESSAGE);    
		        id1.setText("");
		        idMT.setText("");
		    } catch (SQLException e2) {
		        e2.printStackTrace();
		        JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'affectation de la matière à l'enseignant.", "Erreur", JOptionPane.ERROR_MESSAGE);
		    } 
		    try {
		        connection.commit();
		    } catch (SQLException e1) {
		        e1.printStackTrace();
		    }
		}

		if (e.getSource() == Modifier) {
		    int row = enseignantTable.getSelectedRow();
		    if (row == -1) {
		        JOptionPane.showMessageDialog(null, "Veuillez sélectionner une ligne à modifier.");
		        return;
		    }
		    String nom_Enseignant = nom.getText();
		    String telephone_Enseignant = telephone.getText();
		    String sexe = combox.getItemAt(combox.getSelectedIndex());
		    int telephone =0;
		    //if (!telephone_Enseignant.isEmpty()) {
		        telephone = Integer.parseInt(telephone_Enseignant);
		    
		       // telephone = Integer.parseInt(telephone_Enseignant);
		    String prenom_Enseignant = prenom.getText();
		    int idU = (int) model.getValueAt(row, 5);
		    model.setValueAt(nom_Enseignant, row, 1);
		    model.setValueAt(prenom_Enseignant, row, 2);
		    model.setValueAt(telephone, row, 3);
		    model.setValueAt(sexe, row, 4);
		    int id1 = (int) model.getValueAt(row, 0);
		    String nomEnseignant = (String) model.getValueAt(row, 1);
		    String prenomEnseignant = (String) model.getValueAt(row, 2);
		    int telephoneEtudiant = (int) model.getValueAt(row, 3);
		    String sexeEtudiant = (String) model.getValueAt(row, 4);

		    JOptionPane.showMessageDialog(null, "L'énseignant a été modifié avec succès dans le JTable.");
		    EnseignantList etudiant = new EnseignantList(id1, sexeEtudiant, telephoneEtudiant, idU);
		    Personnel p=new Personnel(nomEnseignant,prenomEnseignant,idU);
		    enseignantsModfier.add(etudiant);
		    userModifier.add(p);
		    combox.setSelectedIndex(0);
            this.nom.setText("");
            this.prenom.setText("");
            this.id1.setText("");
            this.telephone.setText("");
            this.idU.setText("");
		 
		}

        if (e.getSource() == Supprimer) {
            int rowIndex = enseignantTable.getSelectedRow();
            if (rowIndex >= 0) {
                // Récupération des valeurs de la ligne sélectionnée dans la JTable
                int id = (int) model.getValueAt(rowIndex, 0);
                int telephone = (int) model.getValueAt(rowIndex, 3);
                String sexe = (String) model.getValueAt(rowIndex, 4);
                 int idU = (int) model.getValueAt(rowIndex, 5);
               EnseignantList enseignant = new EnseignantList(id, sexe, telephone,idU);
                // Suppression de l'objet Etudiant correspondant de la liste et de la JTable
                enseignantASupprimer.add(enseignant);
                model.removeRow(rowIndex);
                // Ajout de l'étudiant à la liste des étudiants à supprimer de la base de données
      
                JOptionPane.showMessageDialog(null, "L'énseignant a été supprimé avec succès dans le JTable.");
            }
        }
        if (e.getSource() == enregistrer) {
            try {
                connection.setAutoCommit(false);
                for (Personnel person :userAjouter) {
                    ADMIND.affichiePasswordLoginEnseignant(person);
                	
                }
                // Ajout des enseignants à la base de données
                for (EnseignantList enseignant : enseignantAjoutee) {
                    try {
                        ADMIND.ajouterEnseignant(enseignant);
                        combox.setSelectedIndex(0);
                        this.nom.setText("");
                        this.prenom.setText("");
                        this.id1.setText("");
                        this.telephone.setText("");
                        this.idU.setText("");
                        this.type.setText("");
                        this.pwd.setText("");
                        this.Login.setText("");
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }

                // Suppression des enseignants de la base de données
                for (EnseignantList enseignant : enseignantASupprimer) {
                 //   AdministrateurDao e1 = new AdministrateurDao();
                    ADMIND.deleteEnseignant(enseignant);
                    JOptionPane.showMessageDialog(null, "L'enseignant a été supprimé avec succès de la base de données.");
                }
                for(Personnel person:userModifier) {
           //         AdministrateurDao p=new AdministrateurDao();
                    ADMIND.modifierUser(person);
                }

                // Modification des enseignants dans la base de données
                for (EnseignantList enseignant : enseignantsModfier) {      
                  //  AdministrateurDao a = new AdministrateurDao();
                    ADMIND.modifierEnsiegnant(enseignant);
                   // a.modofierEnsiegnant(telephone, sexe, id, prenom, nom, idU);
                }

                JOptionPane.showMessageDialog(null, "Les modification ont été enregistrés avec succès dans la base de données.");
                combox.setSelectedIndex(0);
                this.nom.setText("");
                this.prenom.setText("");
                this.id1.setText("");
                this.telephone.setText("");
                this.idU.setText("");

                connection.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
	}
}
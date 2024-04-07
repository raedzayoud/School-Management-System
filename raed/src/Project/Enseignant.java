package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import DAO.EnseignantDao;

public class Enseignant implements ActionListener {
	private JFrame frame=new JFrame();
	private JPanel panel=new JPanel();
	private JButton ListeMatiere,ListeEtudiant;
	 private JButton btnQuitter = new JButton("Quitter");
	  private ImageIcon  image2 =new ImageIcon("image/raed.gif");
	  private EnseignantDao a=new EnseignantDao();
	  public Enseignant() {
	
	ListeMatiere=new JButton("ListeMatiere");
	ListeEtudiant=new JButton("ListeEtudiant");
	ListeEtudiant.setBounds(0, 250, 200, 50); 
	ListeEtudiant.setFocusable(true);
    //changer la couleur d'arrière plan du bouton
	ListeEtudiant.setForeground(Color.white);
	ListeEtudiant.setBackground(Color.LIGHT_GRAY);
    ListeEtudiant.setFont(new Font("Arial", Font.ITALIC, 20));
    
	ListeMatiere.setBounds(0, 200, 200, 50); 
	 ListeMatiere.setFocusable(true);
   //changer la couleur d'arrière plan du bouton
	 ListeMatiere.setForeground(Color.white);
   ListeMatiere.setBackground(Color.LIGHT_GRAY);
   ListeMatiere.setFont(new Font("Arial", Font.ITALIC, 20));
	
	frame.add(ListeEtudiant);
	frame.add(ListeMatiere);
   JLabel labelText=new JLabel();
	labelText.setText("Enseignant");
	labelText.setBounds(0,-80,400,250);
	labelText.setVerticalTextPosition(JLabel.TOP);
	labelText.setForeground(new Color(0x00FF00));
	labelText.setFont(new Font("Mv Boli",Font.ITALIC,40));
	frame.add(labelText);
    panel.setBackground(Color.gray);
    panel.setBounds(0, 4, 200, 900);
    frame.getContentPane().add(panel);
	frame.setSize(1000,1000);
	
	 btnQuitter.setBounds(0, 650, 200, 50);
	 btnQuitter.setFocusable(true);
	   //changer la couleur d'arrière plan du bouton
	 btnQuitter.setForeground(Color.white);
	 btnQuitter.setBackground(Color.red);
	 btnQuitter.setFont(new Font("Arial", Font.ITALIC, 20));
	    btnQuitter.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	           Login l=new Login();
	           frame.dispose();
	        }
	    });
	    
	  ListeEtudiant.addActionListener(this);
	     JLabel label2 = new JLabel(image2);
	     label2.setBounds(200, 30, 800, 800);
	     frame.add(label2);
	    
	    
	 ListeMatiere.addActionListener(this);
	JLabel  lblTitle = new JLabel("Bienvenue  Enseignant !");
	lblTitle.setBounds(300,-100,400,250);
    lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
    frame.add(lblTitle);
    frame.add(btnQuitter);
    frame.add(panel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ListeEtudiant) {
	//	EnseignantDao e1=new EnseignantDao();
		a.consulterListeEtudiant();
		}
		if(e.getSource()==ListeMatiere) {
			

			  try {
			      String[]tab=Login.getUsernamePassword();
			     String username = tab[0];
			        String password = tab[1];

			       a.consulterListeMatiere(username, password); 
			    } catch (Exception e2) {
			        System.out.println(e2.getMessage());
			    }
			}
		}
}

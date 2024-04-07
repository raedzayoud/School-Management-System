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

import DAO.EtudiantDao;

public class Etudiant  implements ActionListener {
	private JFrame frame=new JFrame();
	private JLabel nom1=new JLabel("Nom");
	private JLabel prenom1=new JLabel("Prenom");
	private JLabel telephone1=new JLabel("Telephone");
	private JButton Ajouter=new JButton("Ajouter");
	private JButton Modifier=new JButton("Modifier");
	private	JButton Supprimer=new JButton("Supprimer");
	private	JButton enregistrer=new JButton("enregistrer");
	private	JButton fermer=new JButton("fermer");
	private JPanel panel=new JPanel();    
	private JButton consulter1=new JButton("ListeMatiere");
	private JButton consulter2=new JButton("ListeEnseignant");
	private EtudiantDao e2;
	public Etudiant() {
		JLabel labelText=new JLabel();
		labelText.setText("Etudiant");
		labelText.setBounds(0,-80,400,250);
		labelText.setVerticalTextPosition(JLabel.TOP);
		labelText.setForeground(new Color(0x00FF00));
		labelText.setFont(new Font("Mv Boli",Font.ITALIC,40));
		frame.add(labelText);
		
		e2=new EtudiantDao();
		consulter1.setBounds(0, 250, 200, 50);
	    //changer la couleur d'arrière plan du bouton
		consulter1.setForeground(Color.white);
		consulter1.setBackground(Color.LIGHT_GRAY);
		consulter1.setFont(new Font("Arial", Font.ITALIC, 20));
		
		consulter2.setBounds(0, 300, 200, 50); 
	    //changer la couleur d'arrière plan du bouton
		consulter2.setForeground(Color.white);
		consulter2.setBackground(Color.LIGHT_GRAY);
		consulter2.setFont(new Font("Arial", Font.ITALIC, 20));
		frame.add(consulter2);
		frame.add(consulter1);
		

		
		fermer.setBounds(0, 650, 200, 50); 
		fermer.setFocusable(true);
	    //changer la couleur d'arrière plan du bouton
		fermer.setForeground(Color.black);
		fermer.setBackground(Color.red);
		fermer.setFont(new Font("Arial", Font.ITALIC, 20));
		ImageIcon  image=new ImageIcon("image/mp.jpg");
	     JLabel label = new JLabel(image);
	     label.setBounds(200, 5, 700, 800);
	     frame.add(label);
	     frame.getContentPane().setBackground(Color.WHITE);
		
	    panel.setBackground(Color.gray);
	    panel.setBounds(0, 4, 200, 800);
	    frame.getContentPane().add(panel);
	
	
        fermer.addActionListener(this);
       consulter2.addActionListener(this);
		 consulter1.addActionListener(this);
	    //changer la couleur d'arrière plan du bouton
	    frame.add(fermer);
		frame.add(nom1);
		frame.add(prenom1);
		frame.add(telephone1);
		frame.add(Ajouter);
		frame.add(enregistrer);
		frame.add(Supprimer);
		frame.add(Modifier);
		frame.setSize(900,1500);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==fermer) {
			Login l=new Login();
			frame.dispose();
		}
	
				if(e.getSource()==consulter1) {
					e2.consulterListeMatiere();
				}
				if(e.getSource()==consulter2) {
					e2.consulterListeEnseignant();  			
				}
	}
}


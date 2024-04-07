package Project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Welcome implements ActionListener {
	private JFrame frame=new JFrame();
	private  JButton Enseginat=new JButton("GererEnseignant");
	private  JButton Etudiant=new JButton("GererEtudiant");
	private  JButton Decontecer=new JButton("se Decontecer");
	private  JPanel panel=new JPanel();  
	

	public Welcome() {
		
		 panel.setBackground(new Color	(0,128,0));
		    panel.setBounds(0, 4, 200, 700);
		    frame.getContentPane().add(panel);
		    
		    Enseginat.setBounds(0, 100, 200, 50);
			 Enseginat.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			 Enseginat.setForeground(Color.white);
		    Enseginat.setBackground(new Color(2, 48, 32));
		    Enseginat.setFont(new Font("Arial", Font.ITALIC, 20));
		    Etudiant.setBounds(0, 150, 200, 50);
			 Etudiant.setFocusable(true);
			  Etudiant.setFont(new Font("Arial", Font.ITALIC, 20));
			 
		    //changer la couleur d'arrière plan du bouton
			 Etudiant.setForeground(Color.white);
		    Etudiant.setBackground(new Color(2, 48, 32));
		    
		 
			
			 Decontecer.setBounds(0, 610, 200, 50);
			  Decontecer.setFocusable(true);
		    //changer la couleur d'arrière plan du bouton
			 Decontecer.setForeground(Color.white);
		    Decontecer.setBackground(Color.red);
		    Decontecer.setFont(new Font("Arial", Font.ITALIC, 20));
		Etudiant.addActionListener(this);
		Decontecer.addActionListener(this);
		Enseginat.addActionListener(this);
	    // creation d une image
		ImageIcon  image=new ImageIcon("image/bb.jpg");
	     JLabel label = new JLabel(image);
	     label.setBounds(210, 40, 600, 600);
	     frame.add(label);
	    frame.getContentPane().setBackground(Color.WHITE);
	    frame.setTitle("systeme de gestion d ecole");
		frame.add(Enseginat);
		frame.add(Etudiant);
		frame.add(Decontecer);
		frame.setSize(900,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override 
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Etudiant) {
	       try {
			GestionEtudiant n=new GestionEtudiant();
			frame.dispose();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		if(e.getSource()==Decontecer) {
			Login l=new Login();
			frame.dispose();
		}
		if(e.getSource()==Enseginat) {
		  try {
			GestionEnseignat o=new GestionEnseignat();
			frame.dispose();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
	}
	

}

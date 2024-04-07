package Project;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import DAO.LoginDao;

public class Login implements ActionListener {
	private JFrame frame=new JFrame();
	// creation de button
 	private  JButton loginButton=new JButton("Login");
	private  JButton resetButton=new JButton("Reset");
	
	//creation de texte
	private static JTextField userID =new JTextField();
	private  static JPasswordField passwordId=new JPasswordField();
	//creation d une nom de label
	private  JLabel userLabel=new JLabel("user ID");
    private   JLabel passworLabel=new JLabel("passwordID");
	
	
   private  JLabel messageLabel=new JLabel("Connectez-Vous "); 
   private  JLabel messageLabel2=new JLabel();
 
	public Login() {
		   userID.setFont(new Font("Arial", Font.PLAIN, 15));
		   passwordId.setFont(new Font("Arial", Font.PLAIN, 15));
		   userLabel.setBounds(30,100,75,25);
 
		   userLabel.setFont(new Font("Arial", Font.BOLD, 15));
	       userLabel.setForeground(Color.black);
	       userLabel.setBackground(Color.gray);
		   passworLabel.setBounds(30, 150, 100, 25);
		   passworLabel.setFont(new Font("Arial", Font.BOLD, 15));
	       passworLabel.setForeground(Color.black);
	        passworLabel.setBackground(Color.gray);
		   
		    frame.setTitle("System de gestion d ecole");
		    frame.setSize(900,500);
		     ImageIcon  image=new ImageIcon("image/ml.jpg");
	     JLabel label4 = new JLabel(image);
	     label4.setBounds(400, 0, 500, 500);
	    frame.add(label4);
		
	
		
		messageLabel.setBounds(120,10,300,100);
		messageLabel.setFont(new Font(null,Font.ITALIC,30));
		messageLabel.setForeground(Color.RED);
		
		messageLabel2.setBounds(150,225,250,25);
		messageLabel2.setFont(new Font(null,Font.BOLD,20));
		userID.setBounds(125,100,200,25);
		
		
		passwordId.setBounds(125,150,200,25);
		
		
		
		 loginButton.setFont(new Font("Arial", Font.PLAIN, 15));
	        loginButton.setForeground(Color.WHITE);
	        loginButton.setBackground(Color.gray);
		loginButton.setBounds(120,200,120,25);
		loginButton.setFocusable(true);
		loginButton.addActionListener(this);
		
		 resetButton.setFont(new Font("Arial", Font.PLAIN, 15));
	        resetButton.setForeground(Color.WHITE);
	        resetButton.setBackground(Color.gray);
		resetButton.setBounds(220, 200, 120, 25);
		resetButton.setFocusable(true);
		resetButton.addActionListener(this);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(messageLabel);
		frame.add(userID);
		frame.add(passwordId);
		frame.add(messageLabel2);
		 frame.add(userLabel);
		    frame.add(passworLabel);
		    
		    // pour faire la Background blanc on utlise cette method
		 frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout est null car j ai utlisée la method setBounds
		frame.setLayout(null);
		frame.setVisible(true);

	  
		
	}
	public static String[] getUsernamePassword() {
		 String[] tab = new String[2]; 
		 String userId=userID.getText();
	     String password=String.valueOf(passwordId.getPassword());
	     tab[0]=userId;
	     tab[1]=password;
	     return tab;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetButton) {
			userID.setText("");
			passwordId.setText("");
		} 
		if(e.getSource()==loginButton) {
		     String userId=userID.getText();
		     String password=String.valueOf(passwordId.getPassword());
			 ArrayList<String> login = new ArrayList<>();
			try {
				login = LoginDao.tabLogin();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 
			 ArrayList<String> pwd =new ArrayList<>();
			try {
				pwd = LoginDao.tabPwd();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 
			 ArrayList<String> type = new  ArrayList<>();
			try {
				type = LoginDao.tabType();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} 
		     int i=0,j=0,w=0;
			 while((i<login.size())&&(j<pwd.size())&&(w<type.size())){
			    if(userId.equals(login.get(i))&&pwd.get(j).equals(password)&&type.get(w).equals("etudiant")) {
			    	Etudiant e4 =new Etudiant();
			    	  JOptionPane.showMessageDialog(null, "welcome to elite student.");
			    	frame.dispose();
			    	break;
			    }
			    if(userId.equals(login.get(i))&&pwd.get(j).equals(password)&&type.get(w).equals("enseignant")) {
			    	Enseignant p=new Enseignant();
			    	 JOptionPane.showMessageDialog(null, "welcome to elite teacher.");
			    	frame.dispose();
			    	break;
			    	
			    }
			    if(userId.equals(login.get(i))&&pwd.get(j).equals(password)&&type.get(w).equals("personnel")) {
			    	//PlanP o=new PlanP();
			    	Welcome w1=new Welcome();
			    	  JOptionPane.showMessageDialog(null, "welcome to admisiration.");
			    	frame.dispose();
			    	break;
			    	
			    }
			    i++;
			    j++;
			    w++;
			 
			 }
			
     }
     
		
	}
	}





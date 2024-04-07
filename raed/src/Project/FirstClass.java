package Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FirstClass implements ActionListener {
	private JFrame frame=new JFrame();
	 private JButton button = new JButton("Bienvenue");
    public FirstClass() {
    frame.setTitle("System Gestion Ecole");
    ImageIcon  image=new ImageIcon("image/aa.jpg");
    JLabel label = new JLabel("", image, JLabel.CENTER);
    button.setBounds(400, 328, 150, 70);
    button.setFont(new Font("Arial", Font.ITALIC, 25));
    button.setForeground(Color.black);
    //button.setBackground(Color.gray);
    button.setBackground(Color.WHITE);
    button.setBorder(BorderFactory.createLineBorder(Color.white));
	button.setFocusable(true);
	button.addActionListener(this);
    frame.add(button);
    frame.add(label, BorderLayout.CENTER);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(1000, 650);
    frame.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button) {
			Login l=new Login();
			frame.dispose();
		}
		
	}
	
	

}

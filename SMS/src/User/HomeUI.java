package User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.paint.Color;

import OurMessage.Message;
import OurMessage.QTypes;
import chat.Client;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class HomeUI extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JButton btnLogout = new JButton(new ImageIcon("img\\homeui\\rsz_btnlogout.png"));
	private final JLabel lblWelcome = new JLabel("Welcome:");
	private final JLabel lblname = new JLabel("");

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public HomeUI() {
		setBackground(java.awt.Color.WHITE);
		
		setResizable(false);
		setTitle("School Mangement System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 388);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(java.awt.Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(java.awt.Color.WHITE);
		panel.setBounds(10, 59, 424, 202);
		
		contentPane.add(panel);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Client.client.sendToServer(new Message("UPDATE users SET Status = 1 WHERE ID="+Client.user.getID()+"/User: "+Client.user.getID(),QTypes.update));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogout.setBounds(391, 11, 30, 30);
		
		btnLogout.setOpaque(false);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setBorderPainted(false);
		contentPane.add(btnLogout);
		lblWelcome.setBounds(10, 15, 72, 14);
		
		contentPane.add(lblWelcome);
		lblname.setBounds(10, 29, 46, 14);
		
		contentPane.add(lblname);
	}
	public void logout(){
		this.setVisible(false);
		Client.clientGUI.dispose();
		Client.clientGUI=new LoginUI();
		try {
			Client.client.closeConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Client.user=null;
		Client.clientGUI.setVisible(true);
	}
	

}

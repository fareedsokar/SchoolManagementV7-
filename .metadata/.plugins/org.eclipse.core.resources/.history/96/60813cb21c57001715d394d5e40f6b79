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
import javax.swing.Icon;

public class HomeUI extends JFrame {

	public JPanel innerpanel = new JPanel();
	public JPanel contentPane;
	private final JButton btnLogout = new JButton(new ImageIcon("img\\homeui\\rsz_btnlogout.png"));
	private final JButton btnchangepass = new JButton(new ImageIcon("img\\homeui\\resetpassword.png"));
	private final JButton btngetinfo = new JButton(new ImageIcon("img\\homeui\\information.png"));
	private final JLabel lblWelcome = new JLabel("Welcome:");
	private final JLabel lblid = new JLabel("ID: ");

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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 388);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(java.awt.Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		lblWelcome.setBounds(10, 15, 222, 14);
		lblWelcome.setText(lblWelcome.getText()+" "+Client.user.getName());
		contentPane.add(lblWelcome);
		
		
		btnchangepass.setOpaque(false);
		btnchangepass.setContentAreaFilled(false);
		btnchangepass.setBorderPainted(false);
		btnchangepass.setBounds(358, 11, 30, 30);
		contentPane.add(btnchangepass);
		
		
		btngetinfo.setOpaque(false);
		btngetinfo.setContentAreaFilled(false);
		btngetinfo.setBorderPainted(false);
		btngetinfo.setBounds(318, 11, 30, 30);
		contentPane.add(btngetinfo);
		
		
		lblid.setBounds(10, 34, 165, 14);
		lblid.setText(lblid.getText()+" "+Client.user.getID());
		contentPane.add(lblid);
		
		
		innerpanel.setBounds(0, 60, 444, 211);
		
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

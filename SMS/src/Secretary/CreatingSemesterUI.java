package Secretary;

import javax.swing.JPanel;

import OurMessage.Message;
import OurMessage.QTypes;
import chat.Client;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class CreatingSemesterUI extends JPanel {
	private JPanel panel;
	private JButton btncheck = new JButton(new ImageIcon("img\\Secretary\\CreateSemesterUI\\Arrow-reload-3-icon.png"));
	private JLabel lblCheckIfCurrent;

	/**
	 * Create the panel.
	 */
	public CreatingSemesterUI() {
		setLayout(null);
		setBounds(10, 59, 424, 300);
		panel = new JPanel();
		panel.setBounds(10, 47, 404, 242);
		add(panel);
		btncheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client.client.handleMessageFromClientUI(
						new Message("select * from semster where id=(select max(id) FROM semster);",QTypes.checksemester));
			}
		});
		
		
		//JLabel lblicon=new JLabel("Check Semester!");
		//lblicon.setIcon(new ImageIcon("img\\homeui\\resetpassword.png"));
		//button = new JButton("Hello!");//(Icon) lblicon);
		btncheck.setBounds(267, 11, 30, 30);
		btncheck.setOpaque(false);
		btncheck.setContentAreaFilled(false);
		btncheck.setBorderPainted(false);
		add(btncheck);
		
		lblCheckIfCurrent = new JLabel("Check if current semester duration had expired!");
		lblCheckIfCurrent.setBounds(10, 17, 259, 14);
		add(lblCheckIfCurrent);

	}
}

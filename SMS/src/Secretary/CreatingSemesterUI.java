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
	private JLabel imgstart = new JLabel(new ImageIcon("img\\Secretary\\CreateSemesterUI\\Picture1.png"));
	private JLabel lblCheckIfCurrent;
	private JLabel imgend= new JLabel(new ImageIcon("img\\Secretary\\CreateSemesterUI\\Picture2.png"));
	private JLabel imgabs= new JLabel(new ImageIcon("img\\Secretary\\CreateSemesterUI\\Abs-icon.png"));

	/**
	 * Create the panel.
	 */
	public CreatingSemesterUI() {
		setLayout(null);
		setBounds(10, 59, 424, 300);
		panel = new JPanel();
		panel.setBounds(10, 47, 404, 242);
		add(panel);
		panel.setLayout(null);
		btncheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Client.client.handleMessageFromClientUI(
						new Message("select * from semster where id=(select max(id) FROM semster);",QTypes.checksemester));
			}
		});
		
		
		//JLabel lblicon=new JLabel("Check Semester!");
		//lblicon.setIcon(new ImageIcon("img\\homeui\\resetpassword.png"));
		//button = new JButton("Hello!");//(Icon) lblicon);
		btncheck.setBounds(10, 6, 30, 30);
		btncheck.setOpaque(false);
		btncheck.setContentAreaFilled(false);
		btncheck.setBorderPainted(false);
		add(btncheck);
		
		lblCheckIfCurrent = new JLabel("Check if current semester duration had expired!");
		lblCheckIfCurrent.setBounds(50, 11, 259, 14);
		add(lblCheckIfCurrent);

		imgstart.setBounds(88, 37, 30, 30);
		panel.add(imgstart);
		
		
		imgend.setBounds(88, 82, 30, 30);
		panel.add(imgend);
		
		
		imgabs.setBounds(88, 123, 30, 30);
		panel.add(imgabs);
		
		
	}
}

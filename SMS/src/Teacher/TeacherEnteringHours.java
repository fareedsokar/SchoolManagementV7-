package Teacher;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import OurMessage.*;
import User.HomeUI;
import chat.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Teacher.*;
public class TeacherEnteringHours extends JPanel {
	private JTextField textTeacherId;
	private JTextField textHours;
	public JPanel newpanel;
	
	/**
	 * Create the panel.
	 */
	public TeacherEnteringHours() {
		setBounds(135, 0, 289, 300);
		setLayout(null);
		newpanel=new JPanel();
		newpanel.setBounds(135, 0, 289, 300);
		JLabel lblTeacherId = new JLabel("Teacher ID :");
		lblTeacherId.setBounds(26, 45, 68, 14);
		add(lblTeacherId);
		
		textTeacherId = new JTextField();
		textTeacherId.setBounds(118, 42, 86, 20);
		add(textTeacherId);
		textTeacherId.setColumns(10);
		
		JLabel lblWorkingHours = new JLabel("Working Hours:");
		lblWorkingHours.setBounds(26, 88, 86, 14);
		add(lblWorkingHours);
		
		textHours = new JTextField();
		textHours.setBounds(118, 85, 86, 20);
		add(textHours);
		textHours.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 	Message Msg=new Message(" update teacher set user_id=124 ,TU_id=15,maxhours=20,currenthours=8 where user_id=124;",QTypes.EnteringHours);
				 	Client.client.handleMessageFromClientUI(Msg);
				 	
			}
		});
		btnSave.setBounds(36, 151, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((TeacherHomeUI)((HomeUI)Client.clientGUI).innerpanel).remove(((TeacherHomeUI)((HomeUI)Client.clientGUI).innerpanel).contentpane);
				((HomeUI)Client.clientGUI).resizeHome();
				((TeacherHomeUI)((HomeUI)Client.clientGUI).innerpanel).contentpane =newpanel; 
			}
		});
		btnCancel.setBounds(162, 151, 89, 23);
		add(btnCancel);

	}

}

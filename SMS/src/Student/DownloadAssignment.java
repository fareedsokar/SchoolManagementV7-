package Student;

import javax.swing.JPanel;

import OurMessage.Message;
import OurMessage.QTypes;
import User.HomeUI;
import chat.Client;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DownloadAssignment extends JPanel {
 
	JPanel newpan=new JPanel();
	public JComboBox coursecombo;
	public JComboBox assignmentcombo;
	
	/**
	 * Create the panel.
	 */
	public DownloadAssignment() {
		
		setBounds(135, 0, 289, 300);
		setLayout(null);
		newpan.setBounds(135, 0, 289, 300);
		JLabel lblCourseName = new JLabel("Course ID");
		lblCourseName.setBounds(10, 63, 109, 21);
		add(lblCourseName);
		
		coursecombo = new JComboBox();
		coursecombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		         Message msg=new Message("select distinct CourseId from assignemntcourse;",QTypes.coursedownload);    
		         Client.client.handleMessageFromClientUI(msg);
			}
		});
		coursecombo.setBounds(129, 63, 108, 21);
		add(coursecombo);
		
		JLabel lblAssignment = new JLabel("Assignment:");
		lblAssignment.setBounds(10, 143, 109, 22);
		add(lblAssignment);
		
		assignmentcombo = new JComboBox();
		assignmentcombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 Message msg=new Message("select assignemntpersourse from assignemntcourse where CourseId="+Integer.parseInt((coursecombo.getSelectedItem().toString()))+";",QTypes.assignmentcombodownload);    
		         Client.client.handleMessageFromClientUI(msg);
			}
		});
		assignmentcombo.setBounds(129, 145, 108, 20);
		add(assignmentcombo);
		
		JButton btnDownload = new JButton("Download");
		btnDownload.setBounds(10, 226, 94, 23);
		add(btnDownload);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel);
				((HomeUI)Client.clientGUI).resizeHome();
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=newpan; 
			}
		});
		btnCancel.setBounds(148, 226, 89, 23);
		add(btnCancel);
		
		JLabel lblDownloadAssignment = new JLabel("Download Assignment :");
		lblDownloadAssignment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDownloadAssignment.setBounds(10, 11, 168, 21);
		add(lblDownloadAssignment);
		

	}
}

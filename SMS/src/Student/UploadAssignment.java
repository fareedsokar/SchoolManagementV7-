package Student;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import User.HomeUI;
import chat.Client;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class UploadAssignment extends JPanel {
	private final JLabel lblCourseNumber = new JLabel("Course Number : ");
	private final JComboBox coursecombo = new JComboBox();
	private final JLabel lblAssignment = new JLabel("Assignment:");
	private final JComboBox assignmentcombo = new JComboBox();
	private final JButton Submit = new JButton("Submitt");
	private final JButton Cancel = new JButton("Cancel");
	private final JTextField textField = new JTextField();
	private final JButton Browse = new JButton("Browse");
	JPanel newpan=new JPanel();
	/**
	 * Create the panel.
	 */
	public UploadAssignment() {
		textField.setBounds(13, 145, 177, 30);
		textField.setColumns(10);
		setBounds(135, 0, 289, 300);
		setLayout(null);
		newpan.setBounds(135, 0, 289, 300);
		lblCourseNumber.setBounds(10, 11, 89, 23);
		
		add(lblCourseNumber);
		coursecombo.setBounds(59, 30, 122, 22);
		
		add(coursecombo);
		lblAssignment.setBounds(10, 63, 82, 23);
		
		add(lblAssignment);
		assignmentcombo.setBounds(68, 80, 122, 23);
		
		add(assignmentcombo);
		Submit.setBounds(10, 225, 89, 23);
		
		add(Submit);
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel);
				((HomeUI)Client.clientGUI).resizeHome();
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=newpan; 
			}
		});
		Cancel.setBounds(129, 225, 89, 23);
		
		add(Cancel);
		
		add(textField); // saving the path in the text field 
		Browse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 JFileChooser fileChooser = new JFileChooser();
				 
			        // For Directory
			        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			 
			        // For File
			        //fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			 
			        fileChooser.setAcceptAllFileFilterUsed(false);
			 
			        int rVal = fileChooser.showOpenDialog(null);
			        if (rVal == JFileChooser.APPROVE_OPTION) {
			        	textField.setText(fileChooser.getSelectedFile().toString());
				
			}
		}});
		Browse.setBounds(199, 147, 67, 26);
		add(Browse);
	}
}

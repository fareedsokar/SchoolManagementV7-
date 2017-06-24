package Student;

import javax.swing.JPanel;

import User.HomeUI;
import chat.Client;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAssignmentGui extends JPanel {

	JPanel newpan=new JPanel();
	/**
	 * Create the panel.
	 */
	public ViewAssignmentGui() {
		setBounds(135, 0, 289, 300);
		setLayout(null);
		newpan.setBounds(135, 0, 289, 300);
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(10, 50, 101, 22);
		add(lblCourseName);
		
		JLabel lblAssignment = new JLabel("Assignment :");
		lblAssignment.setBounds(10, 102, 101, 22);
		add(lblAssignment);
		
		JButton btnView = new JButton("View");
		btnView.setBounds(10, 203, 89, 28);
		add(btnView);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel);
				((HomeUI)Client.clientGUI).resizeHome();
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=newpan;  
			}
		});
		btnCancel.setBounds(150, 203, 89, 28);
		add(btnCancel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(123, 50, 128, 22);
		add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(123, 102, 128, 22);
		add(comboBox_1);
		
		JLabel lblViewAssignment = new JLabel("View Assignment :");
		lblViewAssignment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblViewAssignment.setBounds(10, 11, 182, 28);
		add(lblViewAssignment);
	}

}

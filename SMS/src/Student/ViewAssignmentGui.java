package Student;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;

public class ViewAssignmentGui extends JPanel {

	/**
	 * Create the panel.
	 */
	public ViewAssignmentGui() {
		setBounds(135, 0, 289, 300);
		setLayout(null);
		
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

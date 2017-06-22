package sysAdmin;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddCourseUI extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AddCourseUI() {
		
		setBackground(SystemColor.activeCaption);
		setBounds(10, 59, 424, 300);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(56, 54, 46, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(135, 51, 86, 20);
		add(textField);
		textField.setColumns(10);

	}
}

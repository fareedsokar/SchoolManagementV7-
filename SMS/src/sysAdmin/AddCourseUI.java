package sysAdmin;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;

public class AddCourseUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblLearnHours;
	private JTextField textField_3;
	private JList list;

	/**
	 * Create the panel.
	 */
	public AddCourseUI() {
		
		setBackground(SystemColor.activeCaption);
		setBounds(10, 59, 424, 300);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course id :");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNewLabel.setBounds(45, 31, 67, 20);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField.setBounds(110, 31, 118, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblName.setBounds(66, 63, 46, 18);
		add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(110, 62, 118, 20);
		add(textField_1);
		
		JLabel lblTeachingUnit = new JLabel("Teaching Unit :");
		lblTeachingUnit.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblTeachingUnit.setBounds(20, 92, 92, 20);
		add(lblTeachingUnit);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(110, 92, 118, 20);
		add(textField_2);
		
		lblLearnHours = new JLabel("Learn Hours :");
		lblLearnHours.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblLearnHours.setBounds(30, 123, 82, 20);
		add(lblLearnHours);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		textField_3.setColumns(10);
		textField_3.setBounds(110, 123, 118, 20);
		add(textField_3);
		
		list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBounds(93, 170, 136, 60);
		add(list);

	}
}

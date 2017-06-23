package sysAdmin;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Choice;

public class AddCourseUI extends JPanel {
	private JTextField txtcourseid;
	private JTextField txtcoursename;
	private JTextField txtteachunit;
	private JLabel lblLearnHours;
	private JTextField txtlearnhours;
	private JList list;
	private JLabel lblPrecourses;

	/**
	 * Create the panel.
	 */
	public AddCourseUI() {
		
		setBackground(SystemColor.activeCaption);
		setBounds(10, 59, 302, 301);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course id :");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblNewLabel.setBounds(45, 31, 67, 20);
		add(lblNewLabel);
		
		txtcourseid = new JTextField();
		txtcourseid.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtcourseid.setBounds(110, 31, 118, 20);
		add(txtcourseid);
		txtcourseid.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblName.setBounds(66, 63, 46, 18);
		add(lblName);
		
		txtcoursename = new JTextField();
		txtcoursename.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtcoursename.setColumns(10);
		txtcoursename.setBounds(110, 62, 118, 20);
		add(txtcoursename);
		
		JLabel lblTeachingUnit = new JLabel("Teaching Unit :");
		lblTeachingUnit.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblTeachingUnit.setBounds(20, 92, 92, 20);
		add(lblTeachingUnit);
		
		txtteachunit = new JTextField();
		txtteachunit.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtteachunit.setColumns(10);
		txtteachunit.setBounds(110, 92, 118, 20);
		add(txtteachunit);
		
		lblLearnHours = new JLabel("Learn Hours :");
		lblLearnHours.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblLearnHours.setBounds(30, 123, 82, 20);
		add(lblLearnHours);
		
		txtlearnhours = new JTextField();
		txtlearnhours.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtlearnhours.setColumns(10);
		txtlearnhours.setBounds(110, 123, 118, 20);
		add(txtlearnhours);
		
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
		list.setBounds(110, 154, 136, 60);
		add(list);
		
		lblPrecourses = new JLabel("Pre-Courses :");
		lblPrecourses.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblPrecourses.setBounds(30, 154, 82, 20);
		add(lblPrecourses);

	}
}

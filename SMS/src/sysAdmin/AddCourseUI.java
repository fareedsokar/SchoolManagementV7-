package sysAdmin;

import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Choice;
import java.awt.Color;

public class AddCourseUI extends JPanel {
	public JTextField txtcourseid;
	public JTextField txtcoursename;
	public JTextField txtteachunit;
	public JLabel lblLearnHours;
	public JTextField txtlearnhours;
	public JList list;
	public JLabel lblPrecourses;
	public Choice teacunit_choice;

	/**
	 * Create the panel.
	 */
	public AddCourseUI() {
		
		
		setBackground(Color.WHITE);
		setBounds(10, 59, 500, 350);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Course id :");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNewLabel.setBounds(46, 31, 75, 20);
		add(lblNewLabel);
		
		txtcourseid = new JTextField();
		txtcourseid.setBackground(Color.LIGHT_GRAY);
		txtcourseid.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtcourseid.setBounds(120, 32, 118, 20);
		add(txtcourseid);
		txtcourseid.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblName.setBounds(70, 65, 51, 18);
		add(lblName);
		
		txtcoursename = new JTextField();
		txtcoursename.setBackground(Color.LIGHT_GRAY);
		txtcoursename.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtcoursename.setColumns(10);
		txtcoursename.setBounds(120, 65, 118, 20);
		add(txtcoursename);
		
		JLabel lblTeachingUnit = new JLabel("Teaching Unit :");
		lblTeachingUnit.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblTeachingUnit.setBounds(19, 92, 102, 20);
		add(lblTeachingUnit);
		
		txtteachunit = new JTextField();
		txtteachunit.setBackground(Color.LIGHT_GRAY);
		txtteachunit.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtteachunit.setColumns(10);
		txtteachunit.setBounds(120, 93, 118, 20);
		add(txtteachunit);
		
		lblLearnHours = new JLabel("Learn Hours :");
		lblLearnHours.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblLearnHours.setBounds(28, 122, 93, 20);
		add(lblLearnHours);
		
		txtlearnhours = new JTextField();
		txtlearnhours.setBackground(Color.LIGHT_GRAY);
		txtlearnhours.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtlearnhours.setColumns(10);
		txtlearnhours.setBounds(120, 123, 118, 20);
		add(txtlearnhours);
		
		list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
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
		lblPrecourses.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblPrecourses.setBounds(19, 154, 93, 20);
		add(lblPrecourses);
		
		
		teacunit_choice = new Choice();
		teacunit_choice.setBounds(290, 31, 111, 20);
		add(teacunit_choice);

	}
}

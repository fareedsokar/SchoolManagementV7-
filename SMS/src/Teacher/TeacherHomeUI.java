package Teacher;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JToolBar;

import User.HomeUI;
import chat.Client;
import sysAdmin.AddCourseUI;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//import com.jgoodies.forms.factories.DefaultComponentFactory;

import Secretary.CreatingSemesterUI;
import Secretary.SecretaryHomeUI;
import Student.HomeStudent;
import Student.ViewReportGui;

import javax.swing.JList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;





public class TeacherHomeUI extends JPanel {

	
	//private JPanel  menup;
	public JPanel  contentpane;
	
	/**
	 * Create the panel.
	 */
	public TeacherHomeUI() {
		DefaultListModel<String>model= new DefaultListModel<String>(); 
		model.addElement("Entering Hours");
		model.addElement("Upload Assigment");
		model.addElement("Report/Grades");
		model.addElement("Check Assigment ");
		model.addElement("Upload Matrials");
		model.addElement("Response");
		setBounds(10, 59, 424, 300);
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(225, 5, 0, 0);
		add(label);

		
		
		JList list = new JList(model);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Object res=list.getSelectedValue();
				switch((String)res){
				case "Entering Hours":
					((TeacherHomeUI)((HomeUI)Client.clientGUI).innerpanel).remove(contentpane);
					((HomeUI)Client.clientGUI).resizeHome();
					((TeacherHomeUI)((HomeUI)Client.clientGUI).innerpanel).contentpane =new TeacherEnteringHours(); 
					break;
				case "Upload Assigment":
				    break;
				case "Report/Grades":
				    break;
				case "Check Assigment":
					break;
				case "Upload Matrials":
					break;
				case "Response":
					break;
				default:
					break;
					
				}
				add(contentpane);
				}
			});
		list.setBounds(0, 0, 134, 300);
	    add(list);
		
	   contentpane = new JPanel();
		contentpane.setBounds(135, 0, 289, 300);
		
		

	}
}

package Student;

import javax.swing.JPanel;

import OurMessage.Message;
import OurMessage.QTypes;
import User.HomeUI;
import chat.Client;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewMaterialsGui extends JPanel {
    public JComboBox Coursecombo ;
	JPanel newpan=new JPanel(); 
	public JComboBox MaterialCombo;
	/**
	 * Create the panel.
	 */
	public ViewMaterialsGui() {
		int parent_id=0; 
		setBounds(135, 0, 289, 300);
		setLayout(null);
		newpan.setBounds(135, 0, 289, 300);
		JLabel lblMaterialsPerCourse = new JLabel(" Materials per Course :");
		lblMaterialsPerCourse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaterialsPerCourse.setBounds(10, 11, 138, 33);
		add(lblMaterialsPerCourse);
		
	    Coursecombo = new JComboBox();
	    Coursecombo.addMouseListener(new MouseAdapter() {
	    	@Override
	    	public void mouseClicked(MouseEvent e) {
	    		 Message msg=new Message("select distinct CourseId from materialcourse; ",QTypes.coursecombomaterial);    
		         Client.client.handleMessageFromClientUI(msg);
	    	}
	    });
		Coursecombo.setBounds(66, 91, 138, 27);
		add(Coursecombo);
		
		JLabel lblCourseName = new JLabel("Course Name :");
		lblCourseName.setBounds(10, 55, 138, 29);
		add(lblCourseName);
		
		JLabel lblMaterials = new JLabel("Materials:");
		lblMaterials.setBounds(10, 147, 83, 27);
		add(lblMaterials);
		
		 MaterialCombo = new JComboBox();
		 MaterialCombo.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		// select MaterialId from sms.materialcourse where CourseId=1234;
		 		 Message msg=new Message("select  MaterialId from materialcourse where CourseId="+Integer.parseInt(Coursecombo.getSelectedItem().toString())+";",QTypes.materialcourse);    
		         Client.client.handleMessageFromClientUI(msg);
		 		
		 	}
		 });
		MaterialCombo.setBounds(66, 172, 138, 27);
		add(MaterialCombo);
		
		JButton btnView = new JButton("View");
		btnView.setBounds(10, 246, 89, 23);
		add(btnView);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel);
				((HomeUI)Client.clientGUI).resizeHome();
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=newpan;
			}
		});
		btnCancel.setBounds(130, 246, 89, 23);
		add(btnCancel);

	}
}

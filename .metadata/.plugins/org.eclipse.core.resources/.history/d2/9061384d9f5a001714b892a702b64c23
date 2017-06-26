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

public class DownloadMaterialsGui extends JPanel {

	public JComboBox coursecombo;
	public JComboBox materialcombo;
	JPanel newpan=new JPanel();
	/**
	 * Create the panel.
	 */
	public DownloadMaterialsGui() {
		setBounds(135, 0, 289, 300);
		setLayout(null);
		newpan.setBounds(135, 0, 289, 300);
		JLabel lblDownloadMaterials = new JLabel("Download Materials :");
		lblDownloadMaterials.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDownloadMaterials.setBounds(43, 11, 142, 34);
		add(lblDownloadMaterials);
		
		JLabel lblCourseName = new JLabel("Course ID:");
		lblCourseName.setBounds(20, 56, 119, 26);
		add(lblCourseName);
		materialcombo = new JComboBox();
		 coursecombo = new JComboBox();
		coursecombo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // filling Material Combo
				materialcombo.removeAllItems();
				Message msg=new Message("select  MaterialId from materialcourse where CourseId="+Integer.parseInt(coursecombo.getSelectedItem().toString())+";",QTypes.materialcombodownload);    
		         Client.client.handleMessageFromClientUI(msg);
			}
		});
		coursecombo.setBounds(59, 83, 126, 26);
		add(coursecombo);
		
		JLabel lblMaterial = new JLabel("Material :");
		lblMaterial.setBounds(20, 145, 61, 26);
		add(lblMaterial);
		
	
	
		materialcombo.setBounds(59, 182, 133, 26);
		add(materialcombo);
		
		JButton btnNewButton = new JButton("Download");
		btnNewButton.setBounds(10, 239, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel);
				((HomeUI)Client.clientGUI).resizeHome();
				((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=newpan; 
			}
		});
		btnNewButton_1.setBounds(137, 239, 89, 23);
		add(btnNewButton_1);
	}

}

package Student;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class DownloadMaterialsGui extends JPanel {

	/**
	 * Create the panel.
	 */
	public DownloadMaterialsGui() {
		setBounds(135, 0, 289, 300);
		setLayout(null);
		
		JLabel lblDownloadMaterials = new JLabel("Download Materials :");
		lblDownloadMaterials.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDownloadMaterials.setBounds(43, 11, 142, 34);
		add(lblDownloadMaterials);
		
		JLabel lblCourseName = new JLabel("Course Name:");
		lblCourseName.setBounds(20, 56, 119, 26);
		add(lblCourseName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(59, 83, 126, 26);
		add(comboBox);
		
		JLabel lblMaterial = new JLabel("Material :");
		lblMaterial.setBounds(20, 145, 61, 26);
		add(lblMaterial);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(59, 182, 133, 26);
		add(comboBox_1);
		
		JButton btnNewButton = new JButton("Download");
		btnNewButton.setBounds(10, 239, 89, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.setBounds(137, 239, 89, 23);
		add(btnNewButton_1);
	}

}

package sysAdmin;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JPopupMenu;

import User.HomeUI;
import chat.Client;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class sysAdminHomeUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public sysAdminHomeUI() {
		setBackground(SystemColor.activeCaption);

		setBounds(10, 59, 424, 300);
		setLayout(null);
		
		
		JButton btnAddCourse = new JButton("Add Course");
		btnAddCourse.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		btnAddCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//((HomeUI)Client.clientGUI).remove(getParent());
				((HomeUI)Client.clientGUI).contentPane.remove(((HomeUI)Client.clientGUI).innerpanel);
				((HomeUI)Client.clientGUI).innerpanel = new AddCourseUI();
				((HomeUI)Client.clientGUI).contentPane.add(((HomeUI)Client.clientGUI).innerpanel);
				((HomeUI)Client.clientGUI).resizeHome();
			}
		});
		btnAddCourse.setBounds(54, 123, 100, 23);
		add(btnAddCourse);

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

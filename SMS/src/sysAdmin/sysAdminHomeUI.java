package sysAdmin;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class sysAdminHomeUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public sysAdminHomeUI() {
		setBackground(SystemColor.activeCaption);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(this, popupMenu);

		setBounds(10, 59, 424, 300);
		setLayout(null);

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

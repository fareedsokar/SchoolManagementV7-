package Secretary;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import chat.Client;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class SecretaryHomeUI extends JPanel {

	/**
	 * Create the panel.
	 */
	public SecretaryHomeUI() {
		
		setBounds(10, 59, 424, 300);
		setLayout(null);
		
		JLabel lblHelloThereThis = new JLabel("Hello There This is a TEXT");
		lblHelloThereThis.setBounds(142, 159, 219, 14);
		add(lblHelloThereThis);
		Client.clientGUI.setTitle("Secretary Menu!");
	}
}

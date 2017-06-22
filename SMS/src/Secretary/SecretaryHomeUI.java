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
import javax.swing.JButton;

public class SecretaryHomeUI extends JPanel {
	private JPanel menubtnspnl;
	private JPanel viewpanel;
	private JButton btnS;

	/**
	 * Create the panel.
	 */
	public SecretaryHomeUI() {
		
		setBounds(10, 59, 424, 300);
		setLayout(null);
		
		menubtnspnl = new JPanel();
		menubtnspnl.setBounds(0, 0, 110, 300);
		add(menubtnspnl);
		menubtnspnl.setLayout(null);
		
		btnS = new JButton("S");
		btnS.setBounds(0, 11, 89, 23);
		menubtnspnl.add(btnS);
		
		viewpanel = new JPanel();
		viewpanel.setBounds(109, 0, 315, 300);
		add(viewpanel);
		Client.clientGUI.setTitle("Secretary Menu!");
	}
}

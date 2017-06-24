package Secretary;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import User.HomeUI;
import chat.Client;
import sysAdmin.sysAdminHomeUI;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//((SecretaryHomeUI)((HomeUI)Client.clientGUI).innerpanel).ChangeSJPanel(new CreatingSemesterUI());
				((HomeUI)Client.clientGUI).ChangeJPanel(new CreatingSemesterUI());
			}
		});
		btnS.setBounds(0, 11, 89, 23);
		menubtnspnl.add(btnS);
		
		viewpanel = new JPanel();
		viewpanel.setBounds(109, 0, 315, 300);
		add(viewpanel);
		Client.clientGUI.setTitle("Secretary Menu!");
	}
	public void ChangeSJPanel(JPanel spanel){
		((SecretaryHomeUI)((HomeUI)Client.clientGUI).innerpanel).remove(
				((SecretaryHomeUI)((HomeUI)Client.clientGUI).innerpanel).viewpanel);
		((SecretaryHomeUI)((HomeUI)Client.clientGUI).innerpanel).viewpanel=spanel;
		((SecretaryHomeUI)((HomeUI)Client.clientGUI).innerpanel).add(
				((SecretaryHomeUI)((HomeUI)Client.clientGUI).innerpanel).viewpanel);
		((HomeUI)Client.clientGUI).resizeHome();
	}
}

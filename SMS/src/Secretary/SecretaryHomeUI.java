package Secretary;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

import User.HomeUI;
import chat.Client;
import sysAdmin.sysAdminHomeUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class SecretaryHomeUI extends JPanel {
	private JPanel menubtnspnl;
	private JPanel viewpanel;
	private final JButton btnCreate = new JButton("");
	private JButton btnAssocciate;
	private JButton btnExcep;
	private JButton btnExRes;
	/**
	 * Create the panel.
	 */
	public SecretaryHomeUI() {
		setBackground(Color.WHITE);
		
		setBounds(10, 59, 424, 300);
		setLayout(null);
		
		menubtnspnl = new JPanel();
		menubtnspnl.setBackground(Color.WHITE);
		menubtnspnl.setBounds(0, 0, 177, 300);
		add(menubtnspnl);
		menubtnspnl.setLayout(null);
		
		
		//Button Items
		//Menu Item 1:
		JLabel iconLabel = new JLabel(new ImageIcon("img\\Secretary\\SecretaryHomeUI\\Add-icon.png"));
		JLabel clickMe = new JLabel("Creating Semester", SwingConstants.CENTER);
		btnCreate.setLayout(new BorderLayout());
		btnCreate.add(iconLabel, BorderLayout.WEST);
		btnCreate.add(clickMe, BorderLayout.CENTER);
		btnCreate.setOpaque(false);
		btnCreate.setContentAreaFilled(false);
		btnCreate.setBorderPainted(false);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//((SecretaryHomeUI)((HomeUI)Client.clientGUI).innerpanel).ChangeSJPanel(new CreatingSemesterUI());
				((HomeUI)Client.clientGUI).ChangeJPanel(new CreatingSemesterUI());
			}
		});
		btnCreate.setBounds(0, 11, 177, 35);
		menubtnspnl.add(btnCreate);
		//Menu Item 2:
		JLabel iconLabelAsc = new JLabel(new ImageIcon("img\\Secretary\\SecretaryHomeUI\\Group-icon.png"));
		JLabel clickMeAsc = new JLabel("Assocciating Class", SwingConstants.CENTER);
		btnAssocciate = new JButton("");
		btnAssocciate.setLayout(new BorderLayout());
		btnAssocciate.add(iconLabelAsc, BorderLayout.WEST);
		btnAssocciate.add(clickMeAsc, BorderLayout.CENTER);
		btnAssocciate.setOpaque(false);
		btnAssocciate.setContentAreaFilled(false);
		btnAssocciate.setBorderPainted(false);
		btnAssocciate.setBounds(0, 46, 177, 35);
		menubtnspnl.add(btnAssocciate);
		//Menu Item 3:
		JLabel iconLabelExc = new JLabel(new ImageIcon("img\\Secretary\\SecretaryHomeUI\\Find-person-icon.png"));
		JLabel clickMeExc = new JLabel("Exception Student", SwingConstants.CENTER);
		btnExcep = new JButton("");
		btnExcep.setLayout(new BorderLayout());
		btnExcep.add(iconLabelExc, BorderLayout.WEST);
		btnExcep.add(clickMeExc, BorderLayout.CENTER);
		btnExcep.setOpaque(false);
		btnExcep.setContentAreaFilled(false);
		btnExcep.setBorderPainted(false);
		btnExcep.setBounds(0, 81, 177, 35);
		menubtnspnl.add(btnExcep);
		//Menu Item 4:
		JLabel iconLabelRes = new JLabel(new ImageIcon("img\\Secretary\\SecretaryHomeUI\\Pencil-icon.png"));
		JLabel clickMeRes = new JLabel("Update Response", SwingConstants.CENTER);
		btnExRes = new JButton("");
		btnExRes.setLayout(new BorderLayout());
		btnExRes.add(iconLabelRes, BorderLayout.WEST);
		btnExRes.add(clickMeRes, BorderLayout.CENTER);
		btnExRes.setOpaque(false);
		btnExRes.setContentAreaFilled(false);
		btnExRes.setBorderPainted(false);
		btnExRes.setBounds(0, 116, 177, 35);
		menubtnspnl.add(btnExRes);
		//===============================
		viewpanel = new JPanel();
		viewpanel.setBackground(Color.WHITE);
		viewpanel.setBounds(176, 0, 248, 300);
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

package sysAdmin;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JPopupMenu;
import javax.swing.Painter;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.TreePath;

import User.HomeUI;
import chat.Client;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.border.CompoundBorder;

public class sysAdminHomeUI extends JPanel {

	/**
	 * Create the panel.
	 */
	sysAdminMenuUI mytree = new sysAdminMenuUI();
	public JPanel innerpanel = new JPanel();
	public JPanel contentPane;
	
	
	public sysAdminHomeUI() {
		setBackground(Color.GRAY);
		setBounds(10, 59, 424, 300);
		setLayout(null);
		
		JPanel panel = new JPanel();
		//panel.setBorder(null);
		panel.setBounds(0, 0, 173, 300);
		add(panel);
		panel.add(mytree.makeUI());
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		contentPane = new JPanel();
		contentPane.setBounds(172, 0, 252, 300);
		contentPane.setBackground(java.awt.Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		//panel.addInputMethodListener(l);
		
		mytree.tree.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    		    TreePath tp = mytree.tree.getPathForLocation(me.getX(), me.getY());
		    		    if(tp != null)
		    		    {
		    		    	String s = tp.getLastPathComponent().toString();
		    		    	if(s.equals("Add New Course"))
		    		    	{
		    		    		innerpanel = new AddCourseUI();
		    		    		contentPane.add(innerpanel);
		    		    		contentPane.revalidate();
		    		    		contentPane.repaint();
		    		    		//lblNewLabel.setText(tp.getLastPathComponent().toString());
		    		    	}
		    		    }
		        }
		      });

	}
	
}

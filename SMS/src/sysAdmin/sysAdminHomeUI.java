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
import javax.swing.JFrame;

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
	private Boolean pressed = false;
	
	
	public sysAdminHomeUI() {
		setBackground(Color.GRAY);
		setBounds(2, 59, 600, 350);
		setLayout(null);
		
		JPanel panel = new JPanel();
		//panel.setBorder(null);
		panel.setBounds(0, 0, 173, 350);
		add(panel);
		panel.add(mytree.makeUI());
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		contentPane = new JPanel();
		contentPane.setBounds(172, 0, 428, 350);
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
		    		    	if(s.equals("Add New Course") && (pressed == false))
		    		    	{
		    		    		pressed = true;
		    		    		contentPane.remove(innerpanel);
		    		    		innerpanel = new AddCourseUI();
		    		    		contentPane.add(innerpanel);
		    		    		resizesysAdminHome();
		    		    		//contentPane.revalidate();
		    		    		//contentPane.repaint();
		    		    		//lblNewLabel.setText(tp.getLastPathComponent().toString());
		    		    	}
		    		    }
		        }
		      });

	}
	
	public void resizesysAdminHome(){
		int mypanelX = 0;
		int mypanelY = 0;
		if ( innerpanel.getWidth() >= contentPane.getWidth())
			mypanelX = innerpanel.getWidth();
		else 
			mypanelX = contentPane.getWidth();
		if(innerpanel.getHeight() >= contentPane.getHeight() )
			mypanelY = innerpanel.getHeight();
		else
			mypanelY = contentPane.getHeight();
		
		System.out.print(mypanelY +"  se\n");
			//myorgpanel = 172 + mypanelY;
		contentPane.setBounds(172, 0, mypanelX, mypanelY);
		((HomeUI)Client.clientGUI).innerpanel.setBounds(((HomeUI)Client.clientGUI).innerpanel.getX(), 
				((HomeUI)Client.clientGUI).innerpanel.getY() ,
				(mypanelX +  173), mypanelY);
		((HomeUI)Client.clientGUI).resizeHome();
		contentPane.revalidate();
		contentPane.repaint();
		//((HomeUI)Client.clientGUI).innerpanel.setBounds(((HomeUI)Client.clientGUI).innerpanel.getBounds().x, ((HomeUI)Client.clientGUI).innerpanel.getBounds().y, ((HomeUI)Client.clientGUI).innerpanel.getWidth() + myplus, ((HomeUI)Client.clientGUI).innerpanel.getHeight());
		//((HomeUI)Client.clientGUI).resizeHome();
		/*
		if(innerpanel.getWidth() + mytree.tree.getWidth() >= ((HomeUI)Client.clientGUI).innerpanel.getWidth() )
		{
			myY = innerpanel.getWidth() + mytree.tree.getWidth();
		}
		else
			myY = ((HomeUI)Client.clientGUI).innerpanel.getWidth();
		
		if(((HomeUI)Client.clientGUI).getWidth() >= ((HomeUI)Client.clientGUI).innerpanel.getWidth())
			myY = ((HomeUI)Client.clientGUI).getWidth();
		else
		{
			myY = ((HomeUI)Client.clientGUI).innerpanel.getWidth();
			myplus = ((HomeUI)Client.clientGUI).innerpanel.getWidth() - ((HomeUI)Client.clientGUI).getWidth();
		}
		btnLogout.setBounds(391 + myplus, 11, 30, 30);
		btnchangepass.setBounds(358 + myplus, 11, 30, 30);
		btngetinfo.setBounds(318 + myplus, 11, 30, 30);
		((HomeUI)Client.clientGUI).setBounds(((HomeUI)Client.clientGUI).getX()
        		,((HomeUI)Client.clientGUI).getY()
        		,myY
        		,((HomeUI)Client.clientGUI).innerpanel.getHeight()
        		+((HomeUI)Client.clientGUI).innerpanel.getY()+40);
		//((HomeUI)Client.clientGUI).btnLogout.setBounds(btnLogout.getBounds().x + , 11, width, height);
        ((HomeUI)Client.clientGUI).setResizable(false);
    ((HomeUI)Client.clientGUI).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    Client.clientGUI.setVisible(true);
    */
	}
	
}

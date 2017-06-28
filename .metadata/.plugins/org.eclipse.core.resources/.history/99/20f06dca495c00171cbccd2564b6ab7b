package Student;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.List;
import javax.swing.event.ListSelectionListener;

import OurMessage.Message;
import OurMessage.QTypes;
import User.HomeUI;
import chat.Client;

import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import chat.Client;
public class HomeStudent extends JPanel {
	/**
	 * Create the panel.
	 */
	 public JPanel panel;
	public HomeStudent() {
			setBounds(10, 59, 424, 300);
		setLayout(null);
		panel=new JPanel();
		panel.setLayout(null);
	      int value=0; 
		DefaultListModel <String>model = new DefaultListModel<String>();
		model.addElement("View Report");
		model.addElement("Download Assignment");
		model.addElement("Blocking parent");
		model.addElement("View Assignment");
		model.addElement("View Materials");
		model.addElement("Download Materials");
		model.addElement("Upload Assignment");
		JList list = new JList(model);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				  Object Res=list.getSelectedValue();
					switch((String)Res)
					{
					case "View Report": 
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(panel);
						((HomeUI)Client.clientGUI).resizeHome();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=new ViewReportGui(); 
						//((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
							break;
					case "Download Assignment":
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(panel);
						((HomeUI)Client.clientGUI).resizeHome();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=new DownloadAssignment(); 
						Message msg3=new Message("select distinct CourseId from assignemntcourse;",QTypes.coursedownload);    
				         Client.client.handleMessageFromClientUI(msg3);
				         ((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
				         break; 
					case "Blocking parent":

						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(panel);
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						((HomeUI)Client.clientGUI).resizeHome();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=new BlockingParentGui(); 
				           Message msg=new Message(" select parent_id from student_parent where student_id="+Client.client.user.getID()+";",QTypes.blockparent); // getting parent id 
					       Client.client.handleMessageFromClientUI(msg);
					       Message msg2=new Message(" select id from messages;",QTypes.getidmessage); // getting parent id 
					       Client.client.handleMessageFromClientUI(msg2);
					       ((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						//System.out.print("Blockparentpanel");
						break; 
					case "View Assignment":
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(panel);
						((HomeUI)Client.clientGUI).resizeHome();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=new ViewAssignmentGui(); 
						 Message msg4=new Message("select distinct CourseId from assignemntcourse;",QTypes.courseassignment);    
				         Client.client.handleMessageFromClientUI(msg4);
				         ((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						break;
					case "View Materials":
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(panel);
						((HomeUI)Client.clientGUI).resizeHome();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=new ViewMaterialsGui(); 
						 Message msg5=new Message("select distinct CourseId from materialcourse; ",QTypes.coursecombomaterial);    
				         Client.client.handleMessageFromClientUI(msg5);
				         ((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						break;
					case "Download Materials":
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(panel);
						((HomeUI)Client.clientGUI).resizeHome();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=new DownloadMaterialsGui();
						Message msg6=new Message("select distinct CourseId from materialcourse;",QTypes.materialcoursedownload);    
				         Client.client.handleMessageFromClientUI(msg6);
				         ((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						break;
					case "Upload Assignment":
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).remove(panel);
						((HomeUI)Client.clientGUI).resizeHome();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel=new UploadAssignment();
						((HomeStudent)((HomeUI)Client.clientGUI).innerpanel).panel.repaint();
						break; 
						default:
							break;
						}
					add(panel);
			}
		});
	
		list.setBounds(0, 0, 134, 300);
		add(list);
		panel.setBounds(135, 0, 289, 300);
		
	}
	
}

package chat;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import ocsf.client.AbstractClient;
import Entities.Semester;
import Entities.TeachUnit;
import Entities.User;
import OurMessage.*;
import Secretary.SecretaryHomeUI;
import User.HomeUI;
import sysAdmin.sysAdminHomeUI;
import sysAdmin.AddCourseUI;
import User.LoginUI;
import Secretary.CreatingSemesterUI;
import Student.*; 
//import common.Sys;
/**
 * Client class represents as the user who sends the message to the server and
 * gets the message from the server.
 * 
 * @author 
 *
 */
public class Client extends AbstractClient {

	//Sys clientUI;

	public static JFrame clientGUI;
	public static Client client;
    public static User user;
    
	/**
	 * Constructor for creating the client.
	 * 
	 * @param host
	 *            is the host of the server used to connecting to the server.
	 * @param port
	 *            is the port used
	 */
    public Client (String host, int port){
    	super(host, port);
    }
	public Client (String host, int port, JFrame m) throws IOException  {
        super(host, port); //Call the superclass constructor
        //this.id = ID;
        //this.clientUI = clientUI;
        this.clientGUI = m;
       /*try {
            openConnection();
        } catch (IOException e) {
            System.out.println("Error: Can't setup connection! Awaiting command");
            return;
        }
       /*
        try {
            sendToServer("#login " + "id");
        } catch (IOException e) {
            clientUI.display("An error occurred.  Terminating client.");
            quit();
        }
        */
		
	}
	
	public void quit() {
        try {
            closeConnection();
        } catch (IOException e) {
        }
        System.exit(0);
    }
	
	public void SetUser(User n) {
		this.user = n;
    }

	/**
	 * Handles all the different type of messages received from the server and
	 * displays on its ui.
	 * 
	 * @param msg
	 *            is the message received from the server.
	 */
	@Override
	public void handleMessageFromServer(Object msg) {
		System.out.println("I am here HMFS");
		int op = ((Request)msg).getRtype();
		System.out.println("Code: "+op);
		switch(op){
		case 4:
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				((HomeUI)clientGUI).logout();
			}
			else{
				//System Error
			}
			break;
		case 5://Login Case
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				((LoginUI)clientGUI).lblerr.setForeground(Color.RED);
				Boolean flag = (Boolean)((Request)msg).getRequest();
				if(flag == true)
					((LoginUI)clientGUI).setstatus("Username or password is incorrect. !");
				else
					((LoginUI)clientGUI).setstatus("Your account is not Active !");
			}
			if(((Request)msg).getRequest() instanceof User)
			{ 
				User us=(User)(((Request)msg).getRequest());
				this.user=us;
				((LoginUI)clientGUI).loginsuccess(us.getAccess().getAccess());//Treat Login Case in loginsuccess function
				//clientGUI.setVisible(false);
				System.out.println("I am here Request User");
				
				
			}
			break;
		case 101:
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if((Boolean)(((Request)msg).getRequest())){
					//DB is Empty (NO SEMESTER CREATED YET)
					((CreatingSemesterUI)((HomeUI)clientGUI).innerpanel).setSemester();
				}else{
					//Semester is still on
					((CreatingSemesterUI)((HomeUI)clientGUI).innerpanel).setErrSemester();
				}
			}
			if(((Request)msg).getRequest() instanceof Semester){
				//semester expired
				
				((CreatingSemesterUI)((HomeUI)clientGUI).innerpanel).setSemester(
						((Semester)msg).getSemester_id(), ((Semester)msg).getSemesterLetter());
				
			}
			break;
			
			
			
		case 200:
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("empty");
				}
			}
			if(((Request)msg).getRequest() instanceof ArrayList<?>)
			{
				ArrayList<TeachUnit> m = ((ArrayList<TeachUnit>)((Request)msg).getRequest());
				for (int i = 0; i < m.size(); i++) {
		            ((AddCourseUI)((sysAdminHomeUI)((HomeUI)clientGUI).innerpanel).innerpanel).teacunit_choice.add(m.get(i).getTeachUnit_Name() + " '" + m.get(i).getTeachUnit_ID() +"'");
		        }
			}
			/*if(((Request)msg).getRequest() instanceof TeachUnit[]){
				//there is teachunits
				TeachUnit[] alltu = (TeachUnit[])(((Request)msg).getRequest());
				for(TeachUnit x : alltu)
				{
					((AddCourseUI)((sysAdminHomeUI)((HomeUI)clientGUI).innerpanel).innerpanel).teacunit_choice.add(x.getTeachUnit_Name() + " '" + x.getTeachUnit_ID() +"'");
					((sysAdminHomeUI)((HomeUI)clientGUI).innerpanel).resizesysAdminHome();
				}
			}*/
			break;
		case 300:
			if(((Request)msg).getRequest() instanceof Integer)
			{
				
					 ((BlockingParentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).parent_id=((Integer)((Request)msg).getRequest());
			}
			else 
			{
				 System.out.println("Error sending parent id case 300");
				
			}
			break; 
			
		case 301:// filling the course comboBox :
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("empty combo");
				}
			}
			if(((Request)msg).getRequest() instanceof ArrayList<?>)
			{    ((ViewAssignmentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).coursecombo.removeAllItems();
				ArrayList<Integer> m = ((ArrayList<Integer>)((Request)msg).getRequest());
				for (int i = 0; i < m.size(); i++) {
					((ViewAssignmentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).coursecombo.addItem(m.get(i));; 
				}
			}
			break; 
		case 302:// filling the course comboBox :
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("empty assignment combo");
				}
			}
			if(((Request)msg).getRequest() instanceof ArrayList<?>)
			{
				((ViewAssignmentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).comboassignment.removeAllItems();
				ArrayList<Integer> m = ((ArrayList<Integer>)((Request)msg).getRequest());
				for (int i = 0; i < m.size(); i++) {
					((ViewAssignmentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).comboassignment.addItem(m.get(i));; 
					((ViewAssignmentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).repaint();
					
				}
			}
			break; 
		case 303:// filling the course comboBox :
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("empty assignment combo");
				}
			}
			if(((Request)msg).getRequest() instanceof ArrayList<?>)
			{
				((DownloadAssignment)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).coursecombo.removeAllItems();
				ArrayList<Integer> m = ((ArrayList<Integer>)((Request)msg).getRequest());
				for (int i = 0; i < m.size(); i++) {
					((DownloadAssignment)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).coursecombo.addItem(m.get(i));; 
				}
			}
			break;
		case 304:// filling the course comboBox :
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("empty assignment combo");
				}
			}
			if(((Request)msg).getRequest() instanceof ArrayList<?>)
			{
				((DownloadAssignment)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).assignmentcombo.removeAllItems();
				ArrayList<Integer> m = ((ArrayList<Integer>)((Request)msg).getRequest());
				for (int i = 0; i < m.size(); i++) {
					((DownloadAssignment)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).assignmentcombo.addItem(m.get(i));; 
				}
			}
			break;
			
		case 305:// filling the course comboBox for material:
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("empty assignment combo");
				}
			}
			if(((Request)msg).getRequest() instanceof ArrayList<?>)
			{
				((ViewMaterialsGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).Coursecombo.removeAllItems();
				ArrayList<Integer> m = ((ArrayList<Integer>)((Request)msg).getRequest());
				for (int i = 0; i < m.size(); i++) {
					((ViewMaterialsGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).Coursecombo.addItem(m.get(i));; 
				}
			}
			break;
		case 306:// filling the course comboBox for material:
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("empty assignment combo");
				}
			}
			if(((Request)msg).getRequest() instanceof ArrayList<?>)
			{
				((ViewMaterialsGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).MaterialCombo.removeAllItems();
				ArrayList<Integer> m = ((ArrayList<Integer>)((Request)msg).getRequest());
				for (int i = 0; i < m.size(); i++) {
					((ViewMaterialsGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).MaterialCombo.addItem(m.get(i));; 
				}
			}
			break;
			
		case 307:// filling the course comboBox for material:
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("empty assignment combo");
				}
			}
			if(((Request)msg).getRequest() instanceof ArrayList<?>)
			{
				((DownloadMaterialsGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).coursecombo.removeAllItems();
				ArrayList<Integer> m = ((ArrayList<Integer>)((Request)msg).getRequest());
				for (int i = 0; i < m.size(); i++) {
					((DownloadMaterialsGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).coursecombo.addItem(m.get(i));; 
				}
			}
			break;
			
		case 308:// filling the course comboBox for material:
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("empty assignment combo");
				}
			}
			if(((Request)msg).getRequest() instanceof ArrayList<?>)
			{
				((DownloadMaterialsGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).materialcombo.removeAllItems();
				ArrayList<Integer> m = ((ArrayList<Integer>)((Request)msg).getRequest());
				for (int i = 0; i < m.size(); i++) {
					((DownloadMaterialsGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).materialcombo.addItem(m.get(i));; 
				}
			}
			break;
		case 309:// filling the course comboBox for material:
			if(((Request)msg).getRequest() instanceof Boolean)
			{
				if(!(Boolean)(((Request)msg).getRequest())){
					//DB is Empty
					System.out.print("Error client parent id case 309");
				}
			}
			if(((Request)msg).getRequest() instanceof Integer)
			{
				((BlockingParentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).parent_id=(Integer)((Request)msg).getRequest();
			}
			break;
			
			
	case 310:// 
		if(((Request)msg).getRequest() instanceof Boolean)
		{
			if(!(Boolean)(((Request)msg).getRequest())){
				//DB is Empty
				System.out.print("Error client parent id case 310");
			}
			else 
			{
				((BlockingParentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).lblMsg.setText("Your request has been sent successfully");
				((BlockingParentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).lblMsg.setVisible(true);
			}
		}
		
		break;
		
	case 311:// getting message id number 
		if(((Request)msg).getRequest() instanceof Boolean)
		{
			if(!(Boolean)(((Request)msg).getRequest())){
				//DB is Empty
				System.out.print("Error client parent id case 311");
			}
		}
		if(((Request)msg).getRequest() instanceof Integer)
		{
			((BlockingParentGui)((HomeStudent)((HomeUI)clientGUI).innerpanel).panel).id_message=(Integer)((Request)msg).getRequest();
		}
		break;
		
	case 700:// getting message id number 
		if(((Request)msg).getRequest() instanceof Integer)
		{
			if(!(Boolean)(((Request)msg).getRequest())){
				//DB is Empty
				System.out.print("Error client parent id case 700");
			}else{
				//changing label
				
				
			}
			}
		
		break;}
		}

		
		
	
	
		
	
	
    /**
     * This method handles all data coming from the UI
     *
     * @param message The message from the UI.
     */
    public void handleMessageFromClientUI(Message msg) {
    	if (!isConnected()) {
            //((LoginUI) clientGUI.setst("Could not send message to server. Terminating client.");
        } else {
        	try {
				sendToServer(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    	
    }


    public void handleCommand(String command) throws IOException {
    	if(command.equals("#Checklogin"))
    	{
    		try {
                openConnection();
                sendToServer(command);
                System.out.println("Connected to server!");
            } catch (IOException e) {
            }
    	}
        /*if (command.equals("#quit")) {
            quit();
        } else if (command.equals("#logoff")) {
            try {
                closeConnection();
            } catch (IOException e) {
            }
        } else if (command.contains("#sethost")) {
            if (!isConnected()) {
                String newHost = command.substring(9);
                setHost(newHost);
                System.out.println("Changed host to " + newHost);
            } else {
                System.out.println("Already connected!");
            }
        } else if (command.contains("#setport")) {
            if (!isConnected()) {
                int newPort = Integer.parseInt(command.substring(9));
                setPort(newPort);
                System.out.println("Changed port to " + newPort);
            } else {
                System.out.println("Already connected!");
            }
        } else if (command.contains("#login")) {
            if (!isConnected()) {
                try {
                    openConnection();
                    sendToServer(command);
                    System.out.println("Connected to server!");
                } catch (IOException e) {
                }
            } else {
                System.out.println("Already connected!");
            }
        } else if (command.equals("#gethost")) {
            System.out.println("Host: " + getHost());
        } else if (command.equals("#getport")) {
            System.out.println("Port: " + getPort());
        } else if (command.equals("#1")) {
            sendToServer("#1");
        } else if (command.equals("#2")) {
            sendToServer("#2");
        } else if (command.equals("#3")) {
            sendToServer("#3");
        } else if (command.equals("#4")) {
            sendToServer("#4");
        } else if (command.equals("#5")) {
            sendToServer("#5");
        } else if (command.equals("#6")) {
            sendToServer("#6");
        } else if (command.equals("#7")) {
            sendToServer("#7");
        } else if (command.equals("#8")) {
            sendToServer("#8");
        } else if (command.equals("#9")) {
            sendToServer("#9");
        } else if (command.equals("#createGame")) {
            sendToServer("#createGame");
        } else if (command.equals("#getGameList")) {
            sendToServer("#getGameList");
        } else {
            System.out.println("Command not recognized!");
        }
        */
    }
	
}

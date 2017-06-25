package server;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Date;

import ocsf.server.*;

import OurMessage.*;
import Entities.AccessProfiles;
import Entities.Semester;
import Entities.TeachUnit;
import Entities.User;
public class Server extends AbstractServer {
	//Class variables ***************************************************
	  
	  /**
	   * The default port to listen on.
	   */
	  final public static int DEFAULT_PORT = 5555;
	  private Connection conn;
	  private ServerGUI serv;
	  private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	  //Constructors ****************************************************
	  
	  /**
	   * Constructs an instance of the echo server.
	   *
	   * @param port The port number to connect on.
	   */
	  
	  public Server(ServerGUI srv,int port)
	  {
		  super(port);
		  this.serv = srv;
		  srv.setVisible(true);
	  }
	  
	  //Instance methods ************************************************
	  
	  /**
	   * This method create the connection between the server and the DB
	   *
	   * @param dbName The database name.
	   * @param user mysql username.
	   * @param pass mysql password.
	   */
	  
	  public boolean initDBConnection(String dbName,String user, String pass) throws Exception
	  {
		
		  try 
			{
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+dbName+"?verifyServerCertificate=false"+ "&useSSL=false"+ "&requireSSL=false", user, pass);
	            System.out.println("SQL connection succeed");
	            return true;
	        } catch (SQLException ex) {return false;}
	  }
	 
	  /**
	   * This method handles any messages received from the client.
	   *
	   * @param msg The message received from the client , it's the query that the server should do.
	   * @param client The connection from which the message originated.
	 * @throws SQLException 
	   */
	  
	  @Override
		protected void handleMessageFromClient(Object msg, ConnectionToClient client) {
		  //Getting Current Date time
		  LocalDateTime now = LocalDateTime.now();
		  
		  //Server Check
		  Statement stmt=null;//INSERT & SELECT Query statement;
		  PreparedStatement pstmt;//UPDATE prepared statement
		  ResultSet rs=null;
		  try 
		  {	 
			  stmt = conn.createStatement();
			  int op = ((Message)msg).GetQType();
			  
			  switch(op){
			  case 4:
				  String[] parts = (((Message)msg).GetQuery()).split("/");
				  stmt.executeUpdate(parts[0]);
				  serv.display("["+dtf.format(now)+"] "+parts[1]+" has been disconnected!" );
				  try {
					client.sendToClient(new Request(true,QTypes.update));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  break;
			  case 5://Login User 
				  rs = stmt.executeQuery(((Message) msg).GetQuery());
				  if (rs.next()) {
					  int res=rs.getInt(5);//get status
					  if(res==1){
						  User us=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),res,new AccessProfiles(rs.getInt(6)));
						  Request req=new Request(us,QTypes.getuser);
						  serv.display("["+dtf.format(now)+"] User: "+us.getID()+" has been connected!" );
						  try{
							  client.sendToClient(req);
							  stmt.executeUpdate("UPDATE users SET Status = 0 WHERE ID="+ Integer.parseInt(rs.getString(1)));
						  }catch(IOException ex){
							 //Do Somthing
							  serv.display("["+dtf.format(now)+"] Error Sending back User Details!");
						  }
					  }else{
						  Request req=new Request(false,QTypes.getuser);
						  try{
							  client.sendToClient(req);
						  }catch(IOException ex){
							 //Do Somthing
							  serv.display("["+dtf.format(now)+"] Error Sending back false statment!");
						  }
					  }
				  }
				  else
				  {
					  Request req=new Request(true,QTypes.getuser);
					  try{
						  client.sendToClient(req);
					  }catch(IOException ex){
						 //Do Somthing
						  serv.display("["+dtf.format(now)+"] Error Sending back false statment!");
					  }
				  }
				  break;
			  case 6:
				  stmt.executeUpdate(((Message)msg).GetQuery());
				  serv.display("["+dtf.format(now)+"] User: "+client.getInfo("name")+" has been disconnected!" );
				  break;
				  
			//System-Administrator	Cases
			  case 200:
				  rs = stmt.executeQuery(((Message) msg).GetQuery());
				  if(rs.next()) { // Checks for any results and moves cursor to first row,
					  ArrayList<TeachUnit> alltu=new ArrayList<TeachUnit>();
					  int i =0;
					    do { // Use 'do...while' to process the first row, while continuing to process remaining rows
					    	alltu.add(new TeachUnit (rs.getString(1), rs.getString(2)));
					    	//System.out.print(alltu[i].getTeachUnit_ID() + " " +  alltu[i].getTeachUnit_Name() +"\n and hereeee");
					    } while (rs.next());
					    Request req200=new Request(alltu,QTypes.GetTeachunits);
					    try{
							  client.sendToClient(req200);
						  }catch(IOException ex){
							 //Do Somthing
							  serv.display("["+dtf.format(now)+"] Error Sending back Teaching units statment!");
						  }
					}
				  else 
				  {
					  Request req200=new Request(false,QTypes.GetTeachunits);
					  try{
						  client.sendToClient(req200);
					  }catch(IOException ex){
						 //Do Somthing
						  serv.display("["+dtf.format(now)+"] Error Sending back false statment!");
					  }
				  }
				  break;
				  // Student .
			  case 301:
				  rs = stmt.executeQuery(((Message) msg).GetQuery());
				 
				  if(rs.next()) { // Checks for any results and moves cursor to first row,
					  ArrayList<Integer> alltu=new ArrayList<Integer>();
					 // int i =0;
					 do{ 
					    	//i++;
					    	alltu.add(Integer.parseInt((rs.getString(1))));
					
					    }  while (rs.next()); 
					    Request req301=new Request(alltu,QTypes.courseassignment);
					    try{ System.out.print("server301 send to client");
							  client.sendToClient(req301);
						  }catch(IOException ex){
							 //Do Somthing
							  serv.display("["+dtf.format(now)+"] Error Sending back coursename statment!");
						  }
					}
				  else 
				  {
					  Request req301=new Request(false,QTypes.courseassignment);
					  try{
						  client.sendToClient(req301);
					  }catch(IOException ex){
						 //Do Somthing
						  serv.display("["+dtf.format(now)+"] Error Sending back false statment!");
					  }
				  }
				  break;
			  case 302:
				  rs = stmt.executeQuery(((Message) msg).GetQuery());
				 
				  if(rs.next()) { // Checks for any results and moves cursor to first row,
					  ArrayList<Integer> alltu=new ArrayList<Integer>();
					 // int i =0;
					 do{ 
					    	//i++;
					    	alltu.add(Integer.parseInt((rs.getString(1))));
					
					    }  while (rs.next()); 
					    Request req301=new Request(alltu,QTypes.assignmentcombo);
					    try{ System.out.print("server301 send to client");
							  client.sendToClient(req301);
						  }catch(IOException ex){
							 //Do Somthing
							  serv.display("["+dtf.format(now)+"] Error Sending back assignmentcombo statment!");
						  }
					}
				  else 
				  {
					  Request req301=new Request(false,QTypes.assignmentcombo);
					  try{
						  client.sendToClient(req301);
					  }catch(IOException ex){
						 //Do Somthing
						  serv.display("["+dtf.format(now)+"] Error Sending back false statment!");
					  }
				  }
				  break;
			  case 303:
				  rs = stmt.executeQuery(((Message) msg).GetQuery());
				 
				  if(rs.next()) { // Checks for any results and moves cursor to first row,
					  ArrayList<Integer> alltu=new ArrayList<Integer>();
					 // int i =0;
					 do{ 
					    	//i++;
					    	alltu.add(Integer.parseInt((rs.getString(1))));
					
					    }  while (rs.next()); 
					    Request req301=new Request(alltu,QTypes.coursedownload);
					    try{ System.out.print("server301 send to client");
							  client.sendToClient(req301);
						  }catch(IOException ex){
							 //Do Somthing
							  serv.display("["+dtf.format(now)+"] Error Sending back assignmentcombo statment!");
						  }
					}
				  else 
				  {
					  Request req301=new Request(false,QTypes.coursedownload);
					  try{
						  client.sendToClient(req301);
					  }catch(IOException ex){
						 //Do Somthing
						  serv.display("["+dtf.format(now)+"] Error Sending back false statment!");
					  }
				  }break; 
				  
			  case 304:
				  rs = stmt.executeQuery(((Message) msg).GetQuery());
				 
				  if(rs.next()) { // Checks for any results and moves cursor to first row,
					  ArrayList<Integer> alltu=new ArrayList<Integer>();
					 // int i =0;
					 do{ 
					    	//i++;
					    	alltu.add(Integer.parseInt((rs.getString(1))));
					
					    }  while (rs.next()); 
					    Request req304=new Request(alltu,QTypes.assignmentcombodownload);
					    try{ System.out.print("server304 send to client");
							  client.sendToClient(req304);
						  }catch(IOException ex){
							 //Do Somthing
							  serv.display("["+dtf.format(now)+"] Error Sending back assignmentcombo statment!");
						  }
					}
				  else 
				  {
					  Request req301=new Request(false,QTypes.assignmentcombodownload);
					  try{
						  client.sendToClient(req301);
					  }catch(IOException ex){
						 //Do Somthing
						  serv.display("["+dtf.format(now)+"] Error Sending back false statment!");
					  }
				  }break;
				  
			  case 305:
				  rs = stmt.executeQuery(((Message) msg).GetQuery());
				 
				  if(rs.next()) { // Checks for any results and moves cursor to first row,
					  ArrayList<Integer> alltu=new ArrayList<Integer>();
					 // int i =0;
					 do{ 
					    	//i++;
					    	alltu.add(Integer.parseInt((rs.getString(1))));
					
					    }  while (rs.next()); 
					    Request req305=new Request(alltu,QTypes.coursecombomaterial);
					    try{ System.out.print("server305 send to client");
							  client.sendToClient(req305);
						  }catch(IOException ex){
							 //Do Somthing
							  serv.display("["+dtf.format(now)+"] Error Sending back coursecombo in view material statment!");
						  }
					}
				  else 
				  {
					  Request req305=new Request(false,QTypes.coursecombomaterial);
					  try{
						  client.sendToClient(req305);
					  }catch(IOException ex){
						 //Do Somthing
						  serv.display("["+dtf.format(now)+"] Error Sending back false statment!");
					  }
				  }break; 
				  
				  
				  
				  
			  case 300:
				  rs = stmt.executeQuery(((Message) msg).GetQuery());
				  if(rs.next()) // if it was successfully executed  
				  {
					  Request req300=new Request(true,QTypes.blockparent);
					    try{
							  client.sendToClient(req300);
						  }catch(IOException ex){
							  serv.display("["+dtf.format(now)+"] Error Sending true statemnet block parent");
						  }
					}
				  else 
				  {
					  Request req300=new Request(false,QTypes.blockparent);
					  try{
						  client.sendToClient(req300);
					  }catch(IOException ex){
					
						  serv.display("["+dtf.format(now)+"] Error Sending back false statment block parent!");
					  }
				  }
				  break;
				  
			 //SECRETARY CASES
			  case 101:
				  rs=stmt.executeQuery(((Message)msg).GetQuery());
				  
				  if (rs.next()) {
					  System.out.println("Semester: ID="+rs.getInt(1));
					  serv.display("["+dtf.format(now)+"] Checking Semester_ID="+rs.getInt(1)+" duration!");
					  Date dt=rs.getDate(3);
					  Date today=new Date();
					  if(dt.before(today)){
						  try {
							  Semester sm=new Semester(rs.getDate(2),dt,rs.getString(4),rs.getInt(1));
							client.sendToClient(new Request(sm,QTypes.checksemester));
							
						} catch (IOException e) {
							// TODO Auto-generated catch block
							serv.display("["+dtf.format(now)+"] Error Sending back to Client!");
						}
					  }else{
						  try {
							client.sendToClient(new Request(false,QTypes.checksemester));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							serv.display("["+dtf.format(now)+"] Error Sending back to Client!");
						}
					  }
				  }else{//didn't get any Semesters
					  try {
							client.sendToClient(new Request(true,QTypes.checksemester));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							serv.display("["+dtf.format(now)+"] Error Sending back to Client!");
						}
				  }
				  break;
			  }
			  
	      } catch (SQLException e2) 
		  		{
	    	   		serv.display("["+dtf.format(now)+"] Error with SQL Connection");
	      		}
	  	}
	 	    
	  /**
	   * This method overrides the one in the superclass.  Called
	   * when the server starts listening for connections.
	   */
	  protected void serverStarted()
	  {
		//Getting Current Date time
		  	LocalDateTime now = LocalDateTime.now();
		  System.out.println
		    ("["+dtf.format(now)+"] Server listening for connections on port " + getPort());
	  }
	  
	  /**
	   * This method overrides the one in the superclass.  Called
	   * when the server stops listening for connections.
	   */
	  protected void serverStopped()
	  {
		  System.out.println
	       ("Server has stopped listening for connections.");
	  }
	  
	  
}

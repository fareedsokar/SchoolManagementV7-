package server;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import ocsf.server.*;

import OurMessage.*;
import Entities.AccessProfiles;
import Entities.User;
public class Server extends AbstractServer {
	//Class variables ***************************************************
	  
	  /**
	   * The default port to listen on.
	   */
	  final public static int DEFAULT_PORT = 5555;
	  private Connection conn;
	  private ServerGUI serv;
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
		  
		  Statement stmt=null;//INSERT & SELECT Query statement;
		  PreparedStatement pstmt;//UPDATE prepared statement
		  ResultSet rs=null;
		  try 
		  {	 
			  stmt = conn.createStatement();
			  int op = ((Message)msg).GetQType();
			  switch(op){
			  case 5:
				  serv.display("Read User Details");
				  rs = stmt.executeQuery(((Message) msg).GetQuery());
				  if (rs.next()) {
					  int res=rs.getInt(5);//get status
					  if(res==1){
						  User us=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),res,new AccessProfiles(rs.getInt(6)));
						  Request req=new Request(us,Request.getuser);
						  serv.display("ID: "+us.getID()+", Name: "+us.getName());
						  try{
							  client.sendToClient(req);
							  //stmt.executeUpdate("UPDATE users SET Status = 0 WHERE ID="+ Integer.parseInt(rs.getString(1)));
							  //serv.display("Updated user Status to 0");
						  }catch(IOException ex){
							 //Do Somthing
							  System.out.println("Error Sending back User Details!");
						  }
					  }else{
						  Request req=new Request(false,Request.getuser);
						  try{
							  client.sendToClient(req);
						  }catch(IOException ex){
							 //Do Somthing
							  System.out.println("Error Sending back false statment!");
						  }
					  }
				  }
				  else
				  {
					  Request req=new Request(true,Request.getuser);
					  try{
						  client.sendToClient(req);
					  }catch(IOException ex){
						 //Do Somthing
						  System.out.println("Error Sending back false statment!");
					  }
				  }
				  break;
			  }
			  
	      } catch (SQLException e2) 
		  		{
	    	  //this.set("Faild!");
	      		}
	  	}
	  /*
			boolean check = false;
			Statement stmt=null;//INSERT & SELECT Query statement;
			PreparedStatement pstmt;//UPDATE prepared statement
			ResultSet rs=null;
		    String[] message = ((String) msg).split("/");
		    String[] message1 = message[0].split(" ");
			String type = message1[0];
			String sender = message1[message1.length - 1];
			String name = message1[1];
			String sql = message[1];
		  try 
		  {
			  stmt = conn.createStatement();
			  //int op = ((Message)msg).GetQType();
			  
				if (type.equals("connect")) {
					User us = null;
					rs = stmt.executeQuery(sql);
					if(rs == null)
					{
						
					}
					else
					{
						while ( rs.next() ) {
							us=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5),new AccessProfiles(rs.getInt(6)));
			            }
						serv.display("Connect succes " + ((User) us).getID()+ " " + ((User) us).getName());
						client.setInfo("name", name);
						try {
							client.sendToClient(us);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					//serv.display("Connect succes" + id+ " " + logname);
					
				} else if (type.equals("message")) {
					String data = "";
					for (int i = 2; i < message.length - 1; i++) {
						data += message[i] + " ";
					}
					System.out.println(Arrays.toString(message));
					for (Thread t : getClientConnections()) {
						ConnectionToClient c = (ConnectionToClient) t;
						System.out.println(c.getInfo("name"));
						if (c.getInfo("name").equals(name)) {
							try {
								check = true;
								c.sendToClient(client.getInfo("name") + " " + type + " " + data);
							} catch (IOException e) {
								try {
									client.sendToClient("Failed to send message");
								} catch (IOException e1) {
									// do nothing
								}
							}
						}
					}
					if (!check) {
						for (Thread thread : getClientConnections()) {
							ConnectionToClient cl = (ConnectionToClient) thread;
							if (cl.getInfo("name").equals(sender)) {
								try {
									cl.sendToClient(name + " offline is offline.");
								} catch (IOException e) {
									// do nothing
								}
							} else if (cl.getInfo("name").equals(name)) {
								thread.destroy();
							}
						}
					}
				} else if (type.equals("disconnect")) {
					try {
						client.close();
					} catch (IOException e) {
						// do nothing
					}
				}
			
		  } catch (SQLException e) 
		  {
			  this.sendToAllClients("Faild!");
		  }
		}
		
	 
	  /*public void handleMessageFromClient(Object msg, ConnectionToClient client)
	  {
		  
		  Statement stmt;//INSERT & SELECT Query statement;
		  PreparedStatement pstmt;//UPDATE prepared statement
		  ResultSet rs;
		  try 
		  {
			  //Creating The Statemnet to work with
			  stmt = conn.createStatement();
			  int op = ((Message)msg).GetQType();
			 
			  switch(op){
			  		case 1: // insert to the DB
			  				serv.display("WRITE request.");
			  				stmt.executeUpdate(((Message)msg).GetQuery());
			  				break;
				 
			  		case 2: // select from DB
			  				serv.display("Read Request");
			  				rs = stmt.executeQuery(((Message)msg).GetQuery());
			  				while(rs.next()){
			  					try {
			  						
			  						client.sendToClient(rs.getString(1) + " " + rs.getString(2)+" "+rs.getString(3));
			  					} catch (IOException e) {
			  						// TODO Auto-generated catch block
			  						e.printStackTrace();
			  					}//catch
			  				}// while
			  				break;
			  case 3: // display
				  serv.display(((Message)msg).GetQuery());
				  break;
			  case 4:
				  serv.display("UPDATE request.");
				  
				  String[] parts=((Message)msg).GetQuery().split("/");
				  pstmt= conn.prepareStatement(parts[0]);
				  for(int i=1;i<parts.length;i++)
				  {
					  pstmt.setString(i, parts[i]);
				  }
				  //pstmt= conn.prepareStatement(((Message)msg).GetQuery());
				  pstmt.executeUpdate();
				  break;
			  case 5:
				  serv.display("Checking user");
				  rs = stmt.executeQuery(((Message)msg).GetQuery());
				  if(rs==null)
				  {
	  					try {
							client.sendToClient(false);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}//not exist
				  }
				  else 
				  {
					  User us=new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getInt(5),new AccessProfiles(rs.getInt(6)));
					  try {
	  						client.sendToClient(us);
	  					} catch (IOException e) {
	  					// TODO Auto-generated catch block
	  					e.printStackTrace();
	  					}
				  }
				  break;
			  case 100:
				  	Response r=new Response(Response.integer);
				  	serv.display("Read Student ids Request.");
	  				rs = stmt.executeQuery(((Message)msg).GetQuery());
	  				while(rs.next()){
	  					r.getLs().add(rs.getInt(1));
	  				}
	  				try {
	  					client.sendToClient(r);
	  				} catch (IOException e) {
	  					// TODO Auto-generated catch block
	  					e.printStackTrace();
	  				}
				  break;
			  case 200:
				    Response TU=new Response(Response.string);
				  	serv.display("Read Teaching units (id & name)");
	  				rs = stmt.executeQuery(((Message)msg).GetQuery());
	  			    if(rs == null)
					{
		  					try {
								client.sendToClient(false);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}//not exist
					}
	  				else {
	  					while(rs.next()){
	  						TU.getLs().add(rs.getInt(1) + " - " + rs.getString(2));
	  					}
	  					try {
	  						client.sendToClient(TU);
	  					} catch (IOException e) {
	  						// TODO Auto-generated catch block
	  						e.printStackTrace();
	  					}
	  				}
				  break;
			  }
		  } catch (SQLException e) 
		  {
			  this.sendToAllClients("Faild!");
		  }
		  
	  }*/

	    
	  /**
	   * This method overrides the one in the superclass.  Called
	   * when the server starts listening for connections.
	   */
	  protected void serverStarted()
	  {
		  System.out.println
		    ("Server listening for connections on port " + getPort());
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

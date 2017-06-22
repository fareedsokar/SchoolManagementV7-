package User;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import OurMessage.Message;
import OurMessage.QTypes;
import Secretary.SecretaryHomeUI;
import chat.Client;
import sysAdmin.sysAdminHomeUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	public JTextField txtHost;
	public JTextField txtPort;
	private JPasswordField txtpassword;
	public JLabel lblPort = new JLabel("Port:");
	public JLabel lblHost = new JLabel("Host:");
	public JLabel lblNotConnected = new JLabel("Not Connected");
	public JButton btnConnect = new JButton("Connect");
	public JLabel lblerr = new JLabel("");
	public JLabel lblNewLabel;
	final public static int DEFAULT_PORT = 5555;
	static LoginUI login;
	/**
	 * Launch the application.
	 */
	public void startClient(String host, int port) {
        try {
            Client.client = new Client(host, port, this);
        } catch (IOException exception) {
            System.out.println("Error: Can't setup connection!"
                    + " Awaiting command");
            //System.exit(1);
        }
    }
	
	public static void main(String[] args) {
		login = new LoginUI();
		//login.setResizable(false);
		login.setVisible(true);
		
	}
	public String getUsername(){
		return this.txtUsername.getText();
	}
	public String getHost(){
		return this.txtHost.getText();
	}
	public String getPort(){
		return this.txtPort.getText();
	}
	public String getPassword(){
		return new String(this.txtpassword.getPassword());
	}
	
	public void setstatus(String S){
		lblerr.setText(S);
	}
	
	public void loginsuccess(int access){
		lblerr.setForeground(Color.green);
		setstatus("Your Account has Been successfully login\nRedirect in 1 sec...");
		ActionListener task = new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Client.clientGUI.dispose();
	        	//login.setVisible(false);
	            Client.clientGUI = new HomeUI();
	            ((HomeUI)Client.clientGUI).setResizable(true);
	        	switch(access){
				case 1://System.out.println("Welcome Back Student");
					
					break;
				case 2://System.out.println("Welcome Back Teacher");

					break;
				case 3://System.out.println("Welcome Back System Admin");
					((HomeUI)Client.clientGUI).innerpanel=new sysAdminHomeUI();
					((HomeUI)Client.clientGUI).contentPane.add(((HomeUI)Client.clientGUI).innerpanel);
					break;
				case 4://System.out.println("Welcome Back School Admin");
					
					break;
				case 5://System.out.println("Welcome Back Secretary");
					((HomeUI)Client.clientGUI).innerpanel=new SecretaryHomeUI();
					
					//((HomeUI)Client.clientGUI).innerpanel.setBounds(r);
		            ((HomeUI)Client.clientGUI).contentPane.add(((HomeUI)Client.clientGUI).innerpanel);
		           
					break;
				case 6://System.out.println("Welcome Back Parent");

					break;
				case 7://System.out.println("Welcome Back Guest");

					break;
				}
	        	
	        	 ((HomeUI)Client.clientGUI).setBounds(((HomeUI)Client.clientGUI).getX()
		            		,((HomeUI)Client.clientGUI).getY()
		            		,((HomeUI)Client.clientGUI).getWidth()
		            		,((HomeUI)Client.clientGUI).innerpanel.getHeight()
		            		+((HomeUI)Client.clientGUI).innerpanel.getY()+40);
		            ((HomeUI)Client.clientGUI).setResizable(false);
	            ((HomeUI)Client.clientGUI).setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	            Client.clientGUI.setVisible(true);
	        }
	        };
				
		Timer timer = new Timer(1500 , task);
	    timer.setRepeats(false);
	    timer.start();
	    
	    
		
	}
	/**
	 * Create the frame.
	 */
	public LoginUI() {
		initialize();
	}
	
	private void initialize() {
		setResizable(false);
		setTitle("School Mangement System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 367, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblUsername.setBounds(12, 125, 65, 14);
		contentPane.add(lblUsername);
		
		JLabel lblpassword = new JLabel("Password:");
		lblpassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblpassword.setHorizontalAlignment(SwingConstants.TRAILING);
		lblpassword.setBounds(2, 167, 65, 14);
		contentPane.add(lblpassword);
		
		JLabel lblServerStatus = new JLabel("Server Status:");
		lblServerStatus.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblServerStatus.setBounds(100, 201, 89, 14);
		contentPane.add(lblServerStatus);
		lblHost.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		lblHost.setBounds(33, 233, 34, 14);
		contentPane.add(lblHost);
		lblPort.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		lblPort.setBounds(33, 273, 34, 14);
		contentPane.add(lblPort);
		lblNotConnected.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		
		
		lblNotConnected.setForeground(Color.RED);
		lblNotConnected.setBounds(188, 201, 89, 14);
		contentPane.add(lblNotConnected);
		lblerr.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		lblerr.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblerr.setBounds(12, 85, 333, 20);
		contentPane.add(lblerr);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setToolTipText("");
		txtUsername.setBounds(111, 117, 180, 30);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtHost = new JTextField();
		txtHost.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtHost.setHorizontalAlignment(SwingConstants.CENTER);
		txtHost.setText("localhost");
		txtHost.setBounds(111, 225, 180, 30);
		contentPane.add(txtHost);
		txtHost.setColumns(10);
		
		txtPort = new JTextField();
		txtPort.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtPort.setHorizontalAlignment(SwingConstants.CENTER);
		txtPort.setText("5555");
		txtPort.setBounds(111, 265, 180, 30);
		contentPane.add(txtPort);
		txtPort.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtpassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtpassword.setBounds(111, 160, 180, 30);
		contentPane.add(txtpassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblerr.setText("");
				if(getUsername().isEmpty()|| getPassword().isEmpty()){
					lblerr.setForeground(Color.red);
					lblerr.setText("Username or password cannot be empty !");
				}else{
					if(!lblNotConnected.getText().equals("Connected"))
					{
						lblerr.setForeground(Color.red);
						lblerr.setText("There is No Connection");
					}
					else
					{
						Message msg = new Message("SELECT * FROM users WHERE id="+ getUsername()+" AND password="+getPassword()+";",QTypes.getuser);
						Client.client.handleMessageFromClientUI(msg);
					}
				}
			}
		});
		btnLogin.setBounds(84, 318, 89, 25);
		contentPane.add(btnLogin);
		
		
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(getHost().isEmpty() || getPort().isEmpty()){
					lblHost.setForeground(Color.RED);
					lblPort.setForeground(Color.RED);
				}else{
					startClient(getHost(), Integer.parseInt(getPort()));
					try {
						Client.client.openConnection();
						lblHost.setForeground(Color.GREEN);
						lblPort.setForeground(Color.GREEN);
						lblNotConnected.setText("Connected");
						lblNotConnected.setForeground(Color.GREEN);
						btnConnect.setEnabled(false);
						txtHost.setEnabled(false);
						txtPort.setEnabled(false);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						lblHost.setForeground(Color.RED);
						lblPort.setForeground(Color.RED);
					}
				}
			}
		});
		btnConnect.setBounds(200, 318, 88, 25);
		contentPane.add(btnConnect);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("img\\loginBGnew.jpg"));
		lblNewLabel.setBounds(0, 0, 362, 359);
		contentPane.add(lblNewLabel);
	}
}

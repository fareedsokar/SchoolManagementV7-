package User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class RegisterUI extends JFrame{
	
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	
	private RegisterUI rg;
	private RegisterController Crgs;
	private LoginUI loginUi;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	
	public RegisterUI()
	{
		setType(Type.UTILITY);
		setTitle("Register");
		
		JPanel panel = new JPanel();	
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(50, 78, 46, 14);
		panel.add(lblEmail);
		
		JLabel lblUserid = new JLabel("UserID : ");
		lblUserid.setBounds(50, 34, 46, 14);
		panel.add(lblUserid);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(50, 123, 89, 23);
		panel.add(lblName);
		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(50, 169, 73, 14);
		panel.add(lblPassword);
		
		JLabel lblRetryPassword = new JLabel("Retry Password:");
		lblRetryPassword.setBounds(50, 216, 97, 14);
		panel.add(lblRetryPassword);
		
		JButton btnRegister = new JButton("Sign Up");
		
		btnRegister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				//update DB 
				String Email=lblEmail.getText();
				String Id= lblUserid.getText();
				String Name = lblName.getText();
				String pass = lblPassword.getText();
				String Rpass =lblRetryPassword.getText();
				
				boolean flag=Crgs.checkpass(pass, Rpass);
				if(flag==false)
				{
					lblPassword.setText("You Password doesnt match");
					lblRetryPassword.setText("You Password doesnt match");
					
				}
				else
				{
				
				
				//	check the DB order	//String Query=new String("INSERT INTO users (ID,NAME,AGE,ADDRESS,SALARY)
				//	VALUES (Id,Name,Email,pass) ");
				
				
				//Message msg=new Message(Query,1);
				//	sendToServer(msg);

				}
							
				
			}
		});
		
		
		
		btnRegister.setBounds(230, 299, 89, 23);
		panel.add(btnRegister);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rg.dispose();
				loginUi.setVisible(true);
				
				
			}
		});
		btnCancle.setBounds(338, 299, 89, 23);
		panel.add(btnCancle);
		
		textField = new JTextField();
		textField.setBounds(145, 75, 89, 23);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 120, 89, 23);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(145, 31, 89, 23);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(145, 165, 89, 23);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(145, 212, 89, 23);
		panel.add(passwordField_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 268, -75, 2);
		panel.add(scrollPane);
		
		
		
		
	}
	
	
	
	
		}

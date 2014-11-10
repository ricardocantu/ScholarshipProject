
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.util.*;

public class LoginWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Window Properties
	
	private JLabel userNameLabel;
	private JTextField userNameTextField;
	private JLabel passwordLabel;
	private JPasswordField passwordTextField;
	
	private final int WINDOW_WIDTH = 350;
	private final int WINDOW_HEIGHT = 200;
	
	private JButton loginButton;
	private JButton clearButton;
	
	private JPanel panel;
	
	//Class data members to be used on program to access data
	private static String username;
	private static String password;
	private static boolean loginSuccess;
	private static boolean isAdmin;
	private static int idNumber;
	
	
	public LoginWindow(){
		
		
		loginSuccess = false;
		isAdmin = false;
		
		setTitle("Scholarship Award System: Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		userNameLabel = new JLabel("Enter your username:");
		userNameTextField = new JTextField(10);
		
		passwordLabel = new JLabel("Enter your password:");
		passwordTextField = new JPasswordField(10);
		
		loginButton = new JButton("Login");
		clearButton = new JButton("Clear");
		loginButton.addActionListener(new LoginButtonListener());
		
		panel = new JPanel();
		panel.add(userNameLabel);
		panel.add(userNameTextField);
		panel.add(passwordLabel);
		panel.add(passwordTextField);
		panel.add(loginButton);
		panel.add(clearButton);
		
		add(panel);
		
		setVisible(true);
		
		if(loginSuccess){
			setVisible(false);
		}
		
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public int getIDNumber(){
		return idNumber;
	}
	
	public boolean isAdmin(){
		return isAdmin;
	}
		
	private class LoginButtonListener implements ActionListener{

		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e){
			
			//Open file to check information
			File usersFile = new File("SchoolUsers.txt");
			String usernameInput = userNameTextField.getText();
			String passwordInput = passwordTextField.getText();
			
			try{
				@SuppressWarnings("resource")
				Scanner usersData = new Scanner(usersFile);
				boolean wrongPass = true;
				boolean noUsername = true;
				
				while(usersData.hasNext()){
					
					String label = usersData.next();
					
					//check if users data is on file
					if(label.matches("<username>")){
						username = usersData.next();
						if(usernameInput.matches(username)){
							label = usersData.next();
							noUsername = false;
							if(label.matches("<password>")){
								password = usersData.next();
								if(passwordInput.matches(password)){
									wrongPass = false;
									break;
								}
							}
						}
					}
				}
				if(noUsername){
					JOptionPane.showMessageDialog(null, "Username is not on file!");
					
				}
				else if(wrongPass){
					JOptionPane.showMessageDialog(null, "You enter the wrong password!");
				}
				
				//Checks if user is administrator
				if(!noUsername && !wrongPass){
					while(usersData.hasNext()){
						String label = usersData.next();
						
						if(label.matches("<isAdmin>")){
							if("true".matches(usersData.next())){
								isAdmin = true;
								
								label = usersData.next();
								
								if(label.matches("<idNum>")){
									idNumber = Integer.parseInt(usersData.next());
								}
								//Erase this at the end
								JOptionPane.showMessageDialog(null, "admin id num: "+ idNumber);
								
								loginSuccess = true;
								break;
							}
							else{
								isAdmin = false;
								
								label = usersData.next();
								
								if(label.matches("<idNum>")){
									idNumber = Integer.parseInt(usersData.next());
								}
								//Erase this at the end 
								JOptionPane.showMessageDialog(null, "not admin id num: "+idNumber);
								
								loginSuccess = true;
								break;
							}
						}	
					}
				}	
				if(loginSuccess && !isAdmin){
					dispose();
					new StudentWindow(idNumber);
				
				}
				else if(loginSuccess && isAdmin){
					dispose();
					new AdministratorWindow(idNumber);
				}
			}
			
			catch(FileNotFoundException e1){
				JOptionPane.showMessageDialog(null, "Error accesing user data!");
			}
		}
	}
	
	//Start program
	public static void main(String args[]){
		
		new LoginWindow();
		
	}
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


import javax.swing.*;

import java.awt.*;
import java.util.*;

public class LoginWindow extends JFrame {
	
	private final JLabel userNameLabel;
	private final JTextField userNameTextField;
	private final JLabel passwordLabel;
	private final JPasswordField passwordTextField;
	
	private final int WINDOW_WIDTH = 350;
	private final int WINDOW_HEIGHT = 200;
	
	private final JButton loginButton;
	private final  JButton clearButton;
	private final JButton forgotPasswordButton;
	
	
	private final JPanel panel;
	
	//Class data members to be used on program to access data
	private static String username;
	private static String password;
	private static boolean loginSuccess;
	private static boolean isAdmin;
	private static int idNumber;
        
        //Change Password Window
        
        private JFrame changePasswordFrame;
        
        private JLabel newPassDirectionLabel;
        private JLabel newPasswordLabel;
        private JLabel confirmPasswordLabel;
        private JPasswordField newPasswordTextField;
        private JPasswordField newConfirmPasswordTextField;
        private JButton newPasswordEnterButton;
        private JButton newPasswordCancelButton;                                                                              
        private JPanel changePasswordPanel;
	
	
	public LoginWindow(){
		
		
		loginSuccess = false;
		isAdmin = false;
		
		setTitle("Scholarship Award System: Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height
                        /2-this.getSize().height/2);
		
		
		
		userNameLabel = new JLabel("Enter your username:");
		userNameTextField = new JTextField(10);
		
		passwordLabel = new JLabel("Enter your password:");
		passwordTextField = new JPasswordField(10);
		
		loginButton = new JButton("Login");
		clearButton = new JButton("Clear");
		forgotPasswordButton = new JButton("Forgot password");
		loginButton.addActionListener(new LoginButtonListener());
		clearButton.addActionListener(new ClearButtonListener());
		forgotPasswordButton.addActionListener(new ForgotPasswordButtonListener());
		
		panel = new JPanel();
		
		panel.add(userNameLabel);
		panel.add(userNameTextField);
		panel.add(passwordLabel);
		panel.add(passwordTextField);
		panel.add(loginButton);
		panel.add(clearButton);
		panel.add(forgotPasswordButton);
		
		
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
		
	//Login button action when clicked
	private class LoginButtonListener implements ActionListener{

		
                @Override
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
                                        userNameTextField.setText("");
                                        passwordTextField.setText("");
					
				}
				else if(wrongPass){
					JOptionPane.showMessageDialog(null, "You enter the wrong password!");
                                        passwordTextField.setText("");
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
								loginSuccess = true;
								break;
							}
							else{
								isAdmin = false;
								
								label = usersData.next();
								
								if(label.matches("<idNum>")){
									idNumber = Integer.parseInt(usersData.next());
								}						
								loginSuccess = true;
								break;
							}
						}	
					}
				}	
				if(loginSuccess && !isAdmin){
					dispose();
                                    StudentWindow studentWindow = new StudentWindow(idNumber);
				
				}
				else if(loginSuccess && isAdmin){
					dispose();
                                    AdminMainWindow adminWindow = new AdminMainWindow(idNumber);
				}
				usersData.close();
			}
			
			catch(FileNotFoundException e1){
				JOptionPane.showMessageDialog(null, "Error accesing user data!");
			}
		}
	}
	
	//Clear button action when clicked
	private class ClearButtonListener implements ActionListener {
		
                @Override
		public void actionPerformed(ActionEvent e){
			
			userNameTextField.setText("");
			passwordTextField.setText("");
			
		}
	}
	
	//Forgot Password action when clicked
	private class ForgotPasswordButtonListener implements ActionListener{
		
                @Override
		public void actionPerformed(ActionEvent e){
                    
                        changePasswordFrame = new JFrame();
                    
                        newPassDirectionLabel = new JLabel("Please enter a 6 character long password:");
                        newPasswordLabel = new JLabel("New Password:");
                        confirmPasswordLabel = new JLabel("Confirm Password:");
                        newPasswordTextField = new JPasswordField(15);
                        newConfirmPasswordTextField = new JPasswordField(15);
                        newPasswordEnterButton = new JButton("Enter");
                        newPasswordCancelButton = new JButton("Cancel");                                                                              
                        changePasswordPanel = new JPanel();
			
			File usersFile = new File("SchoolUsers.txt");
			String usernameInput = userNameTextField.getText();
			String answerForQues = new String();
			
			try{
				@SuppressWarnings("resource")
				Scanner usersData = new Scanner(usersFile);
				boolean wrongAnswer = true;
				boolean noUsername = true;
				String correctAnswer;
				
				while(usersData.hasNext()){
					
					String label = usersData.next();
					
					if(label.matches("<username>")){
						username = usersData.next();
						if(usernameInput.matches(username)){
							do{
								noUsername = false;
								label = usersData.next();
							}while(!"<secQues>".matches(label));
							
							if(label.matches("<secQues>")){
								answerForQues = JOptionPane.showInputDialog(usersData.nextLine());//Prompt question
                                                                
                                                                //I Dont think this part is usefull but i dont know
                                                                if(answerForQues == null || answerForQues.length() == 0){
                                                                    
                                                                }
                                                                //The part on top
                                                                
							}
							usersData.next();
							correctAnswer = usersData.next();//Get answer from data file
							
							if(answerForQues.matches(correctAnswer)){
								JOptionPane.showMessageDialog(null, "Answer is correct!");
								wrongAnswer = false;
								break;
							}
							else
								JOptionPane.showMessageDialog(null, "Answer is wrong! Please try again");
								
						}
					}
				}
				
				if(noUsername){
					JOptionPane.showMessageDialog(null, "Username is not on file!");
				}
				if(!wrongAnswer){
					//aqui te quedaste guey si la respuesta esta correcta-->>>
					
                                        changePasswordFrame.setTitle("Scholarship Award System: Login");
                                        changePasswordFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        changePasswordFrame.setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
                                        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                                        changePasswordFrame.setLocation(dim.width/2-changePasswordFrame.getSize().width/2, dim.height
                                                                            /2-changePasswordFrame.getSize().height/2);
                                        
                                        newPasswordEnterButton.addActionListener(new NewPasswordEnterButtonListener());
                                        newPasswordCancelButton.addActionListener(new NewPasswordCancelButtonListener());
                                      
                                        changePasswordPanel.add(newPassDirectionLabel);
                                        changePasswordPanel.add(newPasswordLabel);
                                        changePasswordPanel.add(newPasswordTextField);
                                        changePasswordPanel.add(confirmPasswordLabel);
                                        changePasswordPanel.add(newConfirmPasswordTextField);
                                        changePasswordPanel.add(newPasswordEnterButton);
                                        changePasswordPanel.add(newPasswordCancelButton);
                                                               
                                        changePasswordFrame.add(changePasswordPanel);
                                        
                                        changePasswordFrame.setVisible(true);
				}
				
			}
			catch(FileNotFoundException e1){
				JOptionPane.showMessageDialog(null, "Error accesing User Data!");
			}
		}
	}
	private class NewPasswordEnterButtonListener implements ActionListener{
            
            @Override
            public void actionPerformed(ActionEvent e){                          
                          
                String newPasswordData = newPasswordTextField.getText();
                String confirmNewPassword = newConfirmPasswordTextField.getText();
                boolean passLengthCheck = false;
                
                if(newPasswordData.length()>=6) passLengthCheck = true;
                
                if(newPasswordData.matches(confirmNewPassword) && passLengthCheck){
                
                    JOptionPane.showMessageDialog(null, "Password has been change!");
                    
                    File usersFile = new File("SchoolUsers.txt");
                    
                    try{
                        Scanner originalFile = new Scanner(usersFile);
                        PrintWriter tempUserFile = new PrintWriter("SchoolUsersTemp.txt");
                        
                        String tempWord;
                        int counter = 0;
                        
                        while(originalFile.hasNext()){
                            tempWord = originalFile.next();
                            
                            if(tempWord.matches("<username>") && counter == 0){
                                counter++;
                                tempUserFile.print(tempWord);
                                tempWord = originalFile.next();
                                
                                if(tempWord.matches(username)){
                                    
                                    tempUserFile.print(" " + tempWord);
                                    tempWord = originalFile.next();
                                    tempUserFile.print("\n");
                                    tempUserFile.print(tempWord);
                                    tempUserFile.print(" " + newPasswordData);
                                    originalFile.next();
                                }
                                else{
                                    tempUserFile.print(" " + tempWord);  
                                }
                            }
                            else if(tempWord.matches("<username>") && counter != 0){
                                tempUserFile.print("\n");
                                tempUserFile.print(tempWord);
                                tempWord = originalFile.next();
                                
                                if(tempWord.matches(username)){
                                    tempUserFile.print(" " + tempWord);
                                    tempWord = originalFile.next();
                                    tempUserFile.print("\n");
                                    tempUserFile.print(tempWord);
                                    tempUserFile.print(" " + newPasswordData);
                                    originalFile.next();
                                    
                                }
                                else{
                                    tempUserFile.print(" " + tempWord);
                                }
                            }
                            else{
                                tempUserFile.print("\n");
                                tempUserFile.print(tempWord);
                                tempWord = originalFile.nextLine();
                                tempUserFile.print(tempWord);
                            }
                        }
                        
                        tempUserFile.close();
                        originalFile.close();
                            
                        File changeName = new File("SchoolUsersTemp.txt");
                        changeName.renameTo(usersFile);
                        
                    }
                    catch(FileNotFoundException e4){
                        JOptionPane.showMessageDialog(null, "Print Writer error!");
                    }
                    
                    changePasswordFrame.dispose();
                }
                else if(!passLengthCheck){
                    JOptionPane.showMessageDialog(null,"Password length incorrect.");
                }
                else{
                
                    JOptionPane.showMessageDialog(null,"Password confirmation incorrect. Please try again.");
                }               
            }        
        }
       
        private class NewPasswordCancelButtonListener implements ActionListener{
            
            @Override
            public void actionPerformed(ActionEvent e){                          
             
                changePasswordFrame.dispose();
                
            }
        }
        
        
	//
	//
	//
	//
	//Start program
	public static void main(String args[]){
		
            LoginWindow loginWindow = new LoginWindow();
		
	}
}
import javax.swing.*;

import java.awt.*;
import java.util.*;
import java.io.*;

public class AdministratorWindow extends JFrame {

	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel idNumberLabel;
	private JLabel usernameLabel;
	private JLabel schoolDepartmentLabel;
	private JLabel adminTitleLabel;
		
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 600;
	
	private JButton logoutButton;
	
	private JPanel panel;

	public AdministratorWindow(int idNumber) throws FileNotFoundException{
		
		File userFile = new File(idNumber+".txt");
		
		Scanner adminInfo = new Scanner(userFile);
		
		Administrator adminData = new Administrator();
		
		String label = adminInfo.next();
		
		//Get and set administrator information
		
		if(label.matches("<firstName>")){
			adminData.setFirstName(adminInfo.nextLine());
			adminInfo.next();
			adminData.setLastName(adminInfo.nextLine());
			adminInfo.next();
			adminData.setSchoolID(adminInfo.nextInt());
			adminInfo.next();
			adminData.setUserName(adminInfo.next());
			adminInfo.next();
			adminData.setAdminUser(true);
			adminInfo.next();
			adminInfo.next();
			adminData.setAdminTitle(adminInfo.nextLine());
			adminInfo.next();
			adminData.setSchoolDepartment(adminInfo.nextLine());
			
		}
		
		setTitle("Scholarship Award System: Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		firstNameLabel = new JLabel("First Name: " + adminData.getFirstName());
		lastNameLabel = new JLabel("Last Name: " + adminData.getLastName());
		idNumberLabel = new JLabel("ID Number: " + adminData.getSchoolID());
		usernameLabel = new JLabel("Username: " + adminData.getUserName());
		schoolDepartmentLabel = new JLabel("Department: " + adminData.getSchoolDepartment());
		adminTitleLabel = new JLabel("Title: " + adminData.getAdminTitle());
		
		panel = new JPanel();
		
		panel = new JPanel();
		panel.add(firstNameLabel);
		panel.add(lastNameLabel);
		panel.add(idNumberLabel);
		panel.add(usernameLabel);
		panel.add(schoolDepartmentLabel);
		panel.add(adminTitleLabel);
		
		add(panel);
		
		setVisible(true);
		
	}
	
	
	
}

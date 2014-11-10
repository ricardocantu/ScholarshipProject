import javax.swing.*;

import java.util.*;
import java.awt.*;
import java.io.*;

public class StudentWindow extends JFrame{

	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel idNumberLabel;
	private JLabel usernameLabel;
	private JLabel collegeLabel;
	private JLabel declaredMajorLabel;
	private JLabel majorLabel;
	private JLabel classificationLabel;
	private JLabel gpaLabel;
		
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 600;
	
	private JButton logoutButton;
	
	private JPanel panel;
	
	public StudentWindow(int idNumber) throws FileNotFoundException{
		
		File userFile = new File(idNumber+".txt");
		
		Scanner studInfo = new Scanner(userFile);
		
		Student studentData = new Student();
		
		String label = studInfo.next();
		
		//Get and set student information from file
		
		if(label.matches("<firstName>")){
			studentData.setFirstName(studInfo.nextLine());
			studInfo.next();
			studentData.setLastName(studInfo.nextLine());
			studInfo.next();
			studentData.setSchoolID(studInfo.nextInt());
			studInfo.next();
			studentData.setUserName(studInfo.next());
			studInfo.next();
			studentData.setAdminUser(false);
			studInfo.next();
			studentData.setCollege(studInfo.nextLine());
			studInfo.next();
			
			if("true".matches(studInfo.next()))
				studentData.setDeclaredMajor(true);
			else
				studentData.setDeclaredMajor(false);
			
			studInfo.next();
			studentData.setMajor(studInfo.nextLine());
			studInfo.next();
			studentData.setClassification(studInfo.next());
			studInfo.next();
			studentData.setGPA(studInfo.nextDouble());
			studInfo.next();
			studentData.setHoursTaken(studInfo.nextInt());
			studInfo.next();
			
			if("true".matches(studInfo.next()))
				studentData.setHasScholarship(true);
			else
				studentData.setHasScholarship(false);
			
		}
		
		setTitle("Scholarship Award System: Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		firstNameLabel = new JLabel("First Name: " + studentData.getFirstName());
		lastNameLabel = new JLabel("Last Name: " + studentData.getLastName());
		idNumberLabel = new JLabel("ID Number: " + studentData.getSchoolID());
		usernameLabel = new JLabel("Username: " + studentData.getUserName());
		collegeLabel = new JLabel("College: " + studentData.getCollege());
		if(studentData.hasDeclaredMajor())
			declaredMajorLabel = new JLabel("Declared Major: yes");
		else
			declaredMajorLabel = new JLabel("Declared Major: no");
		majorLabel = new JLabel("Major: " + studentData.getMajor());
		classificationLabel = new JLabel("Classification: " + studentData.getClassification());
		gpaLabel = new JLabel("GPA: " + studentData.getGPA());
		
		panel = new JPanel();
		panel.add(firstNameLabel);
		panel.add(lastNameLabel);
		panel.add(idNumberLabel);
		panel.add(usernameLabel);
		panel.add(collegeLabel);
		panel.add(declaredMajorLabel);
		panel.add(majorLabel);
		panel.add(classificationLabel);
		panel.add(gpaLabel);
		
		add(panel);
		

		setVisible(true);
		
	
	}
	
}
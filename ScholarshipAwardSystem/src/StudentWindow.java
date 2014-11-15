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
	
	private boolean foundFirstLabel = false;
	
	public StudentWindow(int idNumber){
		
		File userFile = new File(idNumber+".txt");
		
		try {
			Scanner studInfo = new Scanner(userFile);
			Student studentData = new Student();
			
			while(studInfo.hasNext() && !foundFirstLabel){
				
				String label = studInfo.next();
				
				//Get and set student information from file
				
				if(label.matches("<firstName>")){
					studentData.setAdminUser(false);
					studentData.setFirstName(studInfo.nextLine());
					studInfo.next();
					studentData.setLastName(studInfo.nextLine());
					studInfo.next();
					studentData.setSchoolID(studInfo.nextInt());
					studInfo.next();
					studentData.setUserName(studInfo.next());
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
					
					
					foundFirstLabel = true;
				}
				break;
			}
			studInfo.close();
			
			firstNameLabel = new JLabel("First Name:" + studentData.getFirstName());
			lastNameLabel = new JLabel("Last Name:" + studentData.getLastName());
			idNumberLabel = new JLabel("ID Number: " + studentData.getSchoolID());
			usernameLabel = new JLabel("Username: " + studentData.getUserName());
			if(studentData.hasDeclaredMajor())	
				declaredMajorLabel = new JLabel("Declared Major: yes");
			else
				declaredMajorLabel = new JLabel("Declared Major: no");
			
			classificationLabel = new JLabel("Classification: " + studentData.getClassification());
			gpaLabel = new JLabel("GPA: " + studentData.getGPA());
			
		
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Error loading data!");
		}
		
		
                
                
		
	}
	
}
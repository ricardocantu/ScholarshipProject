import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentWindow extends JPanel {

    private static int userIDNumber;       
 
    // Variables declaration - do not modify
    private JButton jViewCurrentAwardButton;
    private JButton jLogOutButton;
    private JButton jButtonApply;
    private JButton jButtonNext;
    private JButton jButtonPrev;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaContent;
    private JLabel usernameLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel idNumberLabel;
    private JLabel collegeLabel;
    private JLabel declaredMajorLabel;
    private JLabel majorLabel;
    private JLabel classificationLabel;
    private JLabel gpaLabel;
    private JLabel hoursTakenLabel;
    
    private static JFrame frame = new JFrame("Scholarship Award System: Student");   
    
    private Student studentData = new Student();
    private Scholarship scholarData = new Scholarship();
    private boolean meetsRequirements = false;
        
    private boolean foundFirstLabel = false;
    private static int counter = 0;
    
    public StudentWindow(int idNumber) {
       userIDNumber = idNumber;
               
       File userFile = new File(idNumber+".txt");	
		
       try {
	   Scanner studInfo = new Scanner(userFile);	           	
	
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
			
       }catch (FileNotFoundException e) {
           JOptionPane.showMessageDialog(null,"Error loading data!");		
       }
       
       //Get first scholarship Information
       File awardsFile = new File("Scholarships.txt");
        
        try{
            
            Scanner awardInfo = new Scanner(awardsFile);
            String label;
            String scholarFileName = "";
            int currentNumStudents;
            int maxNumStudents;
            
            while(awardInfo.hasNext()){
                
                label = awardInfo.next();
                
                if(label.matches("<name>")){
                    scholarFileName = awardInfo.next();
                    awardInfo.next();
                    maxNumStudents = awardInfo.nextInt();
                    awardInfo.next();
                    currentNumStudents = awardInfo.nextInt();
                    
                    if(currentNumStudents<maxNumStudents)
                        break;
                }           
            }
            awardInfo.close();
                        
            File scholarFile = new File(scholarFileName+".txt");
            Scanner scholarInfo = new Scanner(scholarFile);
            
            while(scholarInfo.hasNext()){
                label = scholarInfo.next();
                
                if(label.matches("<name>")){
                    scholarData.setName(scholarInfo.nextLine());
                    scholarInfo.next();
                    scholarData.setMajor(scholarInfo.nextLine());
                    scholarInfo.next();
                    if("true".matches(scholarInfo.next()))
                        scholarData.setDeclaredMajor(true);
                    else
                        scholarData.setDeclaredMajor(false);
                    scholarInfo.next();
                    scholarData.setMinGPA(scholarInfo.nextDouble());
                    scholarInfo.next();
                    scholarData.setMinHrs(scholarInfo.nextInt());
                    scholarInfo.next();
                    scholarData.setClassification(scholarInfo.next());
                    scholarInfo.next();
                    scholarData.setAmount(scholarInfo.nextInt());
                    scholarInfo.next();
                    scholarData.setMaxNumAwards(scholarInfo.nextInt());
                    scholarInfo.next();
                    scholarData.setCurrentNumStudents(scholarInfo.nextInt());
                    scholarInfo.next();
                    scholarData.setFileName(scholarInfo.next());
                }
                break;
            }
            
            scholarInfo.close();                                   
        }
        catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error accesing Scholarships file!");
        }        
        
        //Panel do not remove or modify
        initComponents();
        run();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jButtonNext = new JButton();
        jButtonPrev = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextAreaContent = new JTextArea();
        jButtonApply = new JButton();
        jPanel2 = new JPanel();
        jViewCurrentAwardButton = new JButton();
        usernameLabel = new JLabel();
        firstNameLabel = new JLabel();
        lastNameLabel = new JLabel();
        idNumberLabel = new JLabel();
        collegeLabel = new JLabel();
        declaredMajorLabel = new JLabel();
        majorLabel = new JLabel();
        classificationLabel = new JLabel();
        gpaLabel = new JLabel();
        hoursTakenLabel = new JLabel();
        jLogOutButton = new JButton();

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

       

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jScrollPane1.setViewportView(jTextAreaContent);

        
        

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonPrev)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonNext)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jButtonApply)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonPrev))
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonApply)
                .addContainerGap())
        );

        jButtonApply.setText("Apply");        
        jButtonNext.setText(">");
        jButtonPrev.setText("<");        
        jViewCurrentAwardButton.setText("View Current Award");
        usernameLabel.setText("Username: " + studentData.getUserName());
        firstNameLabel.setText("First Name:" + studentData.getFirstName());
        lastNameLabel.setText("Last Name:" + studentData.getLastName());
        idNumberLabel.setText("ID #: " + studentData.getSchoolID());
        collegeLabel.setText("College:" + studentData.getCollege());
        if(studentData.hasDeclaredMajor())               
            declaredMajorLabel = new JLabel("Declared Major: yes");
        else              
            declaredMajorLabel = new JLabel("Declared Major: no");
        majorLabel.setText("Major:" + studentData.getMajor());
        classificationLabel.setText("Classification: " + studentData.getClassification());
        gpaLabel.setText("GPA: " + studentData.getGPA());        
        hoursTakenLabel.setText("Hours taken: " + studentData.getHoursTaken());
        jLogOutButton.setText("Log Out");
        
        
        //Add all the action listeners below for all the buttons
        jLogOutButton.addActionListener(new jLogOutButtonListener());
        jButtonApply.addActionListener(new jButtonApplyListener());
        
        
        //Add the scholarships to the Text Area Content Edit the scholarship later!!!!!
        jTextAreaContent.setText("The" + scholarData.getName() + "\n\n"
                                + "Eligibility:\n" + 
                                "\n* Declared Major: " + (scholarData.hasDeclaredMajor()?"yes":"no") +
                                "\n* Major required:" + scholarData.getMajor()+
                                "\n* Minimum GPA required: " + scholarData.getMinGPA()+
                                "\n* Minimum Hours taken: " + scholarData.getMinHrs()+
                                "\n* Student classification: " + scholarData.getClassification()+
                                "\n* Award amount: $" + scholarData.getAmount()+
                                "\n* Awards available: " + (scholarData.getMaxNumAwards()-scholarData.getCurrentNumStudents()));
       
        jTextAreaContent.setEditable(false);
            
        //Layout setup do not modify!!
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(collegeLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(declaredMajorLabel, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(firstNameLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idNumberLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(majorLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(classificationLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hoursTakenLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(gpaLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jViewCurrentAwardButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLogOutButton)
                .addGap(74, 74, 74))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(firstNameLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastNameLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idNumberLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(collegeLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(declaredMajorLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(majorLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(classificationLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)                
                .addComponent(hoursTakenLabel) 
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gpaLabel)                   
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jViewCurrentAwardButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLogOutButton)
                .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }//End of initComponent()
        
    
    //Create class for the Action Listeners for the Buttons
    
    private class jViewCurrentAwardButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e1){
            
            ViewAwardWindow viewAwards = new ViewAwardWindow(userIDNumber);
            frame.dispose();
            
        }
    }
    
    private class jLogOutButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e2){
                                          
            frame.dispose();
            studentData = new Student();
            scholarData = new Scholarship();
            frame = new JFrame();
            counter = 0;   
            LoginWindow loginWindow = new LoginWindow();
        }
    }
    
    //Apply button action
    private class jButtonApplyListener implements ActionListener{
        boolean awardFull = false;
        boolean alreadyHasAward = false;
        
        @Override
        public void actionPerformed(ActionEvent e3){
            //TODO Action performed
            if(studentData.getMajor().matches(scholarData.getMajor()) || " any".matches(scholarData.getMajor())){
                if(scholarData.hasDeclaredMajor()&&studentData.hasDeclaredMajor() || !scholarData.hasDeclaredMajor()){
                    if(studentData.getGPA()>scholarData.getMinGPA()){
                        if(studentData.getHoursTaken()>scholarData.getMinHrs()){
                            if(studentData.getClassification().matches(scholarData.getClassification()) || "any".matches(scholarData.getClassification())){
                                if(scholarData.getCurrentNumStudents()<scholarData.getMaxNumAwards()){
                                    if(!studentData.hasScholarship()){
                                        meetsRequirements = true;
                                    }
                                    else{
                                        alreadyHasAward = true;
                                    }
                                }
                                else{
                                    awardFull = true;
                                }
                            }
                        }
                    }
                }
            } 
            
            if(meetsRequirements){   
                File studFile = new File(userIDNumber+".txt");
                File awardsFile = new File("Scholarships.txt");
                File scholarFile = new File(scholarData.getFileName()+".txt");



                try{
                    Scanner studInfo = new Scanner(studFile);
                    PrintWriter tempFile = new PrintWriter("tempFile.txt");

                    String tempWord;

                    while(studInfo.hasNext()){
                        tempWord = studInfo.next();

                        if(!tempWord.matches("<scholarship>")){
                            tempFile.print(tempWord);
                            tempFile.print(studInfo.nextLine());
                            tempFile.print("\n");
                        }
                        else{
                            tempFile.print(tempWord);
                            tempFile.print(" true");
                            tempFile.print("\n");
                            studInfo.next();
                            tempFile.print(studInfo.next());
                            tempFile.print(scholarData.getName());
                            break;
                        }
                    }
                    tempFile.close();
                    studInfo.close();

                    File changeName = new File("tempFile.txt");
                    changeName.renameTo(studFile);

                }
                catch(FileNotFoundException exe){
                    JOptionPane.showMessageDialog(null, "Error accesing files!");
                }


            }
            else{
                if(!awardFull && !alreadyHasAward)
                    JOptionPane.showMessageDialog(null, "You don't meet all the requirements.");
                else if(awardFull)
                    JOptionPane.showMessageDialog(null, "There are no more awards available. Please try another one.");
                else if(alreadyHasAward)
                    JOptionPane.showMessageDialog(null, "You already have an award. You can only have one at a time."+
                                                    "\nPlease delete the one you have in order to add a new one.");
            }
        }
    }
    
    private class jButtonNextListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e4){
            //TODO action performed
            
        }
    }
    
    private class jButtonPrevListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e5){
            //TODO action performed
        }
    }
      
    private static void createAndShowGUI() {
        //Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new StudentWindow(userIDNumber));

        //Display the window.
        frame.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();        
        frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.setVisible(true);
        counter++;
    }
    
    private static void run(){
        SwingUtilities.invokeLater(() -> {
            //Turn off metal's use of bold fonts
            if(counter==0){
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

}



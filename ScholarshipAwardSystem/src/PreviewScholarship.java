import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PreviewScholarship extends JFrame{
    
    private final int WINDOW_WIDTH = 320;
	
    private final int WINDOW_HEIGHT = 340;
	
	
    private final JButton addButton;	
    private final JButton cancelButton;
    private final JLabel askUserLabel;
    private final JPanel panel;
 
    private final JTextArea jTextAreaContent;
    private final JScrollPane jScrollPane1;
    
    private JFrame changePasswordFrame;
    
    private static int idNumber;
    private Scholarship newScholarData;
    
    
    public PreviewScholarship(Scholarship newScholar, int userIDNumber){
        idNumber = userIDNumber;
      
        newScholarData = newScholar;
        
        setTitle("Preview Scholarship");
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height
                /2-this.getSize().height/2);
        panel = new JPanel();      
        addButton = new JButton();
        cancelButton = new JButton();
       
        askUserLabel = new JLabel("Are you sure you want to add the scholarship?");
        
        jScrollPane1 = new JScrollPane();
        jTextAreaContent = new JTextArea();
        
        jScrollPane1.setViewportView(jTextAreaContent);
               
        jTextAreaContent.setColumns(22);
        jTextAreaContent.setRows(15);
        jTextAreaContent.setText("The " + newScholar.getName() + "\n\n"
                                + "Eligibility:\n" + 
                                "\n* Declared Major: " + (newScholar.hasDeclaredMajor()?"yes":"no") +
                                "\n* Major required: " + newScholar.getMajor()+
                                "\n* Minimum GPA required: " + newScholar.getMinGPA()+
                                "\n* Minimum Hours taken: " + newScholar.getMinHrs()+
                                "\n* Student classification: " + newScholar.getClassification()+
                                "\n* Award amount: $" + newScholar.getAmount()+
                                "\n* Awards available: " + (newScholar.getMaxNumAwards()-newScholar.getCurrentNumStudents()));
        jTextAreaContent.setEditable(false);
        
        addButton.setText("Add");
        cancelButton.setText("Cancel");
        
        cancelButton.addActionListener(new cancelButtonListener());
        addButton.addActionListener(new addButtonListener());
                
        panel.add(askUserLabel);
        panel.add(jScrollPane1);
        panel.add(addButton);
        panel.add(cancelButton);
        add(panel);
        
        
        setVisible(true);
                
    }
    
    private class addButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            File scholarFile = new File("Scholarships.txt");
            
            try{
                Scanner scholarInfo = new Scanner(scholarFile);
                PrintWriter newScholarText = new PrintWriter("tempFile.txt");
                
                String label;
                
                while(scholarInfo.hasNext()){
                    label = scholarInfo.next();
                    if(label.matches("<numOfScholarships>")){
                        newScholarText.print((label+" "));
                        newScholarText.print((scholarInfo.nextInt()+1)+"\n");
                    }
                    else if(!label.matches("<")){
                        newScholarText.print(label);
                        newScholarText.print(scholarInfo.nextLine());
                        newScholarText.print("\n");
                    }
                    else{
                        newScholarText.print(label+"\n");
                    }
                }
                newScholarText.print("<"+"\n");
                label = newScholarData.getName();
                label = label.replaceAll(" ", "");
                newScholarText.print("<name> "+label);
                
                scholarInfo.close();
                newScholarText.close();
                
                File changeName = new File("tempFile.txt");
                changeName.renameTo(scholarFile);
                
                //Created new file to store the information for the Scholarship
                PrintWriter awardInfoTxt = new PrintWriter(label+".txt");
                                
                awardInfoTxt.print("<name> "+ newScholarData.getName() + "\n");
                awardInfoTxt.print("<major> "+ newScholarData.getMajor() + "\n");
                awardInfoTxt.print("<declared> "+ newScholarData.hasDeclaredMajor() + "\n");
                awardInfoTxt.print("<minGPA> "+ newScholarData.getMinGPA() + "\n");
                awardInfoTxt.print("<minHrs> "+ newScholarData.getMinHrs() + "\n");
                awardInfoTxt.print("<classification> "+ newScholarData.getClassification() + "\n");
                awardInfoTxt.print("<amount> "+ newScholarData.getAmount() + "\n");
                awardInfoTxt.print("<maxNum> "+ newScholarData.getMaxNumAwards() + "\n");
                awardInfoTxt.print("<currentNum> 0\n");
                awardInfoTxt.print("<fileName> "+ label + "\n");
                awardInfoTxt.print("<students> ");
                
                awardInfoTxt.close();
                
               
            }
            catch(FileNotFoundException e3){
                JOptionPane.showMessageDialog(null, "Error accesing the Data!");
            }
            dispose();
            AddScholarshipWindow addScholarshipWindow = new AddScholarshipWindow(idNumber);
        }
    }
    
    private class cancelButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e2){
            
            dispose();
            AddScholarshipWindow addScholarshipWindow = new AddScholarshipWindow(idNumber);
        
        }
    }
    
}

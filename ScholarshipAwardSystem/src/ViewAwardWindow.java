import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;

public class ViewAwardWindow extends JPanel {

    private static int userIDNumber;
    
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel idNumberLabel;
    private JLabel usernameLabel;
    private JLabel collegeLabel;
    private JLabel declaredMajorLabel;
    private JLabel majorLabel;
    private JLabel classificationLabel;
    private JLabel gpaLabel;
    
    
    private boolean foundFirstLabel = false;
    private static int counter = 0;
    
    public ViewAwardWindow(int idNumber) {
        userIDNumber = idNumber;
        //ADD the user info code
        
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
           JOptionPane.showMessageDialog(null,"Error loading data!");		
       }
        
        
        //Panel do not remove or modify
        initComponents();
        run();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaContent = new javax.swing.JTextArea();
        jButtonRemoveAward = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonBackto = new javax.swing.JButton();
        mockLabel = new javax.swing.JLabel();
        mockLabel1 = new javax.swing.JLabel();
        mockLabel2 = new javax.swing.JLabel();
        mockLabel3 = new javax.swing.JLabel();
        mockLabel4 = new javax.swing.JLabel();
        mockLabel5 = new javax.swing.JLabel();
        mockLabel6 = new javax.swing.JLabel();
        mockLabel7 = new javax.swing.JLabel();
        mockLabel8 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jScrollPane1.setViewportView(jTextAreaContent);

        jButtonRemoveAward.setText("Remove Award");
        jButtonRemoveAward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveAwardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jButtonRemoveAward)
                .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonRemoveAward)
                .addContainerGap())
        );

        jButtonBackto.setText("Back to Scholarships");
        jButtonBackto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBacktoActionPerformed(evt);
            }
        });

        mockLabel.setText("Username:");

        mockLabel1.setText("First Name:");

        mockLabel2.setText("Last Name:");

        mockLabel3.setText("ID #:");

        mockLabel4.setText("College:");

        mockLabel5.setText("Declared Major:");

        mockLabel6.setText("Major:");

        mockLabel7.setText("Classification:");

        mockLabel8.setText("GPA: ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonBackto, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mockLabel3)
                                    .addComponent(mockLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mockLabel8)
                                    .addComponent(mockLabel4)
                                    .addComponent(mockLabel5))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mockLabel1)
                            .addComponent(mockLabel2)
                            .addComponent(mockLabel6)
                            .addComponent(mockLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mockLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mockLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mockLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mockLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mockLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mockLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mockLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mockLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mockLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(jButtonBackto)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
        
    
    
    private void jButtonRemoveAwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveAwardActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButtonRemoveAwardActionPerformed

    private void jButtonBacktoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBacktoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBacktoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBackto;
    private javax.swing.JButton jButtonRemoveAward;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaContent;
    private javax.swing.JLabel mockLabel;
    private javax.swing.JLabel mockLabel1;
    private javax.swing.JLabel mockLabel2;
    private javax.swing.JLabel mockLabel3;
    private javax.swing.JLabel mockLabel4;
    private javax.swing.JLabel mockLabel5;
    private javax.swing.JLabel mockLabel6;
    private javax.swing.JLabel mockLabel7;
    private javax.swing.JLabel mockLabel8;
    // End of variables declaration//GEN-END:variables
    
      private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("FileChooserDemo");
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



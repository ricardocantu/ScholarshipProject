import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class AddScholarshipWindow extends JPanel {

    private JButton jButtonBack;
    private JButton jButtonAdd;
    private JButton jButtonClear;
    private JLabel jLabel1;
    private JLabel collegeLabel;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanelContainer;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JTextField jTextField1;
    
    private JTextField jTextField3;
    private JTextField jTextField4;
    
    private JTextField jTextField6;
    private JTextField jTextField7;

    private JComboBox classifComboBox;
    private JComboBox collegeComboBox;
    private JComboBox majorComboBox;

    private int majorComboIndex;

    private static JFrame frame = new JFrame();

    private static int userIDNumber;
    private int numOfScholarships;
    private Administrator adminData = new Administrator();
    private Scholarship scholarData = new Scholarship();
    private boolean meetsRequirements = false;

    private boolean foundFirstLabel = false;
    private static int counter = 0;

    private int counterNext = 1;
    private int counterPrev;

    private String[] classifs = {"Any", "Freshman", "Sophmore", "Junior", "Senior"};

    private String[] colleges = {"Any", "University College", "College of Business", "College of Humanities and Social Sciences",
        "College of Public Services", "College of Sciences and Technology"};

    private String[] anyMajor = {"Any"};

    private String[] univCollMajors = {"Any", "B.A.A.S. in Applied Administration", "B.S. in Interdisciplinary Studies"};

    private String[] businMajors = {"Any", "B.B.A. in Accounting", "B.B.A. in Enterprise Information System", "B.B.A. in Finance",
        "B.B.A. in General Business,", "B.B.A. in Insurance & Risk Management", "B.B.A. in International Business",
        "B.B.A. in Management", "B.A.A. in Marketing", "B.B.A. in Supply Chain Management"};

    private String[] humAndSSMajors = {"Any", "B.A. in Communication Studies", "B.A. in English", "B.A. in Fine Arts", "B.A. in History",
        "B.A. in Humanities", "B.A. in Philosophy", "B.A. in Social Sciences", "B.A. in Spanish",
        "B.S. in Political Science", "B.S. in Professional Writing", "B.S. in Psychology", "B.S in Social Sciences", "B.S. in Sociology"};

    private String[] publicSerMajors = {"Any", "B.A. in Interdisciplinary Studies", "B.A.A.S. in Criminal Justice", "B.S. in Criminal Justice",
        "B.S.W. in Social Work"};

    private String[] sciAndTechMajors = {"Any", "B.A. in Mathematics", "B.A. in Mathematics and Secondary Mathematics Teacher Certification",
        "B.S. in Applied Statistics", "B.S. in Applied Statistics and Concentration in Biostatics", "B.S. in Biological and Physical Sciences",
        "B.S. in Biological and Physical Sciences with Teacher Certification",
        "B.S. in Biology", "B.S. in Biology with Environmental Bioscienses Concentration",
        "B.S. in Biology with Microbiology Concentration",
        "B.S. in Biology with Molecular and Cellular Bioscience Concentration",
        "B.S. in Biotechnology", "B.S. in Chemistry", "B.S. in Chemistry with Biochemistry Concentration",
        "B.S. in Chemistry with an Environmental Chemisty Concentration",
        "B.S. in Chemistry with Forensic Sciences Concentration",
        "B.S. whith Industrial Chemistry Concentration", "B.S. in Computer Science",
        "B.S. in Geoscience with Geochemistry Concentration",
        "B.S. in Geoscience with Environmental Geology Concentration",
        "B.S. in Geoscience with Petroleum Geotechnology Concentration", "B.S. in Mathematics",
        "B.S.E.T. in Control and Instrumentation Engineering Technology",
        "B.S.E.T. in Structural and Design Option in Engineering Technology", "B.A.A.S. in Safety Management"};

    public AddScholarshipWindow(int idNumber) {

        frame.setTitle("Scholarship Award System: Administrator - Add Scholarship");

        userIDNumber = idNumber;

        File userFile = new File(idNumber + ".txt");

        try {
            Scanner adminInfo = new Scanner(userFile);

            while (adminInfo.hasNext() && !foundFirstLabel) {

                String label = adminInfo.next();

                //Get and set student information from file
                if (label.matches("<firstName>")) {

                    adminData.setFirstName(adminInfo.nextLine());
                    adminInfo.next();
                    adminData.setLastName(adminInfo.nextLine());
                    adminInfo.next();
                    adminData.setSchoolID(adminInfo.nextInt());
                    adminInfo.next();
                    adminData.setUserName(adminInfo.next());
                    adminInfo.next();
                    if ("true".matches(adminInfo.next())) {
                        adminData.setAdminUser(true);
                    } else {
                        adminData.setAdminUser(false);
                    }
                    adminInfo.next();
                    adminData.setAdminTitle(adminInfo.nextLine());
                    adminInfo.next();
                    adminData.setSchoolDepartment(adminInfo.nextLine());

                    foundFirstLabel = true;
                }
                break;
            }

            adminInfo.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading data!");
        }

        //DO NOT REMOVE OR MODIFY THIS
        initComponents();
        run();
    }

    private void initComponents() {

        jPanelContainer = new JPanel();
        jButtonAdd = new JButton();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        collegeLabel = new JLabel();
        jLabel2 = new JLabel();
        
        jLabel3 = new JLabel();
        jRadioButton1 = new JRadioButton();
        jRadioButton2 = new JRadioButton();
        jLabel4 = new JLabel();
        jTextField3 = new JTextField();
        jLabel5 = new JLabel();
        jTextField4 = new JTextField();
        jLabel6 = new JLabel();
        
        jLabel7 = new JLabel();
        jTextField6 = new JTextField();
        jLabel8 = new JLabel();
        jTextField7 = new JTextField();
        jButtonClear = new JButton();
        jPanel1 = new JPanel();
        jButtonBack = new JButton();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();

        collegeComboBox = new JComboBox(colleges);
        collegeComboBox.addActionListener(new collegeComboBoxListener());

        majorComboBox = new JComboBox(sciAndTechMajors);
        majorComboBox.removeAllItems();
        majorComboBox.addItem(anyMajor[0]);

        classifComboBox = new JComboBox(classifs);

        jPanelContainer.setBorder(BorderFactory.createEtchedBorder());

        jLabel1.setText("Scholarship Name:");
        collegeLabel.setText("College:");
        jLabel2.setText("Major:");
        jLabel3.setText("Required to have declared major?:");
        jRadioButton1.setText("Yes");
        jRadioButton2.setText("No");
        jLabel4.setText("Minimum GPA:");
        jLabel5.setText("Minimum hours taken:");
        jLabel6.setText("Classification:");
        jLabel7.setText("Award amount: $");
        jLabel8.setText("Maximum number of awards:");

        GroupLayout jPanelContainerLayout = new GroupLayout(jPanelContainer);
        jPanelContainer.setLayout(jPanelContainerLayout);
        jPanelContainerLayout.setHorizontalGroup(
                jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelContainerLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(collegeLabel)
                                                .addComponent(jLabel2))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(majorComboBox)
                                                .addComponent(collegeComboBox)
                                                .addComponent(jTextField1)))
                                .addGroup(jPanelContainerLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButton2))
                                .addGroup(jPanelContainerLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField3))
                                .addGroup(jPanelContainerLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField4))
                                .addGroup(GroupLayout.Alignment.TRAILING, jPanelContainerLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(classifComboBox))
                                .addGroup(jPanelContainerLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField6))
                                .addGroup(GroupLayout.Alignment.TRAILING, jPanelContainerLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField7)))
                        .addContainerGap())
                .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButtonAdd)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonClear)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelContainerLayout.setVerticalGroup(
                jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jRadioButton1)
                                .addComponent(jRadioButton2))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(collegeLabel)
                                .addComponent(collegeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(majorComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jTextField3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jTextField4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(classifComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jTextField6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(jTextField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonAdd)
                                .addComponent(jButtonClear))
                        .addContainerGap())
        );

        //Buttons go here
        jButtonBack.setText("Back to Scholarships");
        jButtonAdd.setText("Add");
        jButtonClear.setText("Clear");

        //Button action listeners go here
        jButtonBack.addActionListener(new jButtonBackListener());
        jButtonClear.addActionListener(new jButtonClearListener());
        jButtonAdd.addActionListener(new jButtonAddListener());

        //Radio Button Listener
        jRadioButton1.addActionListener(new jRadioButton1Listener());
        jRadioButton2.addActionListener(new jRadioButton2Listener());

        //Information panel text
        jLabel9.setText("Username: " + adminData.getUserName());

        jLabel10.setText("First Name:" + adminData.getFirstName());

        jLabel11.setText("Last Name:" + adminData.getLastName());

        jLabel12.setText("ID #: " + adminData.getSchoolID());

        jLabel13.setText("Department:" + adminData.getSchoolDepartment());

        jLabel14.setText("Title:" + adminData.getAdminTitle());

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jButtonBack))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel9))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel10))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel11))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel12))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel13))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel14)))
                        .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBack)
                        .addContainerGap())
        );

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelContainer, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanelContainer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
    }

    private class collegeComboBoxListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int index;
            index = collegeComboBox.getSelectedIndex();

            if (index == 0) {
                majorComboBox.removeAllItems();
                majorComboBox.addItem(anyMajor[0]);

            } else if (index == 1) {
                majorComboBox.removeAllItems();
                for (int i = 0; i < univCollMajors.length; i++) {
                    majorComboBox.addItem(univCollMajors[i]);
                }
            } else if (index == 2) {
                majorComboBox.removeAllItems();
                for (int i = 0; i < businMajors.length; i++) {
                    majorComboBox.addItem(businMajors[i]);
                }
            } else if (index == 3) {
                majorComboBox.removeAllItems();
                for (int i = 0; i < humAndSSMajors.length; i++) {
                    majorComboBox.addItem(humAndSSMajors[i]);
                }
            } else if (index == 4) {
                majorComboBox.removeAllItems();
                for (int i = 0; i < publicSerMajors.length; i++) {
                    majorComboBox.addItem(publicSerMajors[i]);
                }
            } else if (index == 5) {
                majorComboBox.removeAllItems();
                for (int i = 0; i < sciAndTechMajors.length; i++) {
                    majorComboBox.addItem(sciAndTechMajors[i]);
                }
            }
        }

    }

    private class jButtonAddListener implements ActionListener {

        public void actionPerformed(ActionEvent e3) {

            boolean radioUnselected = false;

            scholarData.setName(jTextField1.getText());
            scholarData.setMajor((String) majorComboBox.getSelectedItem());
            if (jRadioButton1.isSelected()) {
                scholarData.setDeclaredMajor(true);
            } else if (jRadioButton2.isSelected()) {
                scholarData.setDeclaredMajor(false);
            } else {
                radioUnselected = true;
            }
            scholarData.setClassification((String) classifComboBox.getSelectedItem());

            try {
                scholarData.setMinGPA(Double.parseDouble(jTextField3.getText()));
                scholarData.setMinHrs(Integer.parseInt(jTextField4.getText()));

                scholarData.setAmount(Integer.parseInt(jTextField6.getText()));
                scholarData.setMaxNumAwards(Integer.parseInt(jTextField7.getText()));
            } catch (Exception e) {

            }

            if (!scholarData.isEmpty()) {
                PreviewScholarship preview = new PreviewScholarship(scholarData, userIDNumber);

                jTextField1.setText("");
                
                jTextField3.setText("");
                jTextField4.setText("");
                
                jTextField6.setText("");
                jTextField7.setText("");
                jRadioButton1.setSelected(false);
                jRadioButton2.setSelected(false);

                majorComboBox.removeAllItems();
                majorComboBox.addItem(anyMajor[0]);
                classifComboBox.setSelectedIndex(0);
                collegeComboBox.setSelectedIndex(0);

                scholarData = new Scholarship();
            } else {
                JOptionPane.showMessageDialog(null, "The data is incomplete or entered wrong.\nPlease try again and check everything is filled in.");
            }
        }
    }

    private class jButtonClearListener implements ActionListener {

        public void actionPerformed(ActionEvent e1) {

            jTextField1.setText("");
            
            jTextField3.setText("");
            jTextField4.setText("");
            
            jTextField6.setText("");
            jTextField7.setText("");
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);

            majorComboBox.removeAllItems();
            majorComboBox.addItem(anyMajor[0]);
            classifComboBox.setSelectedIndex(0);
            collegeComboBox.setSelectedIndex(0);

            scholarData = new Scholarship();
        }
    }

    private class jButtonBackListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            adminData = new Administrator();
            scholarData = new Scholarship();
            frame = new JFrame();
            counter = 0;
            AdminMainWindow adminWindow = new AdminMainWindow(userIDNumber);
        }

    }

    private class jRadioButton1Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            jRadioButton2.setSelected(false);

            if (jRadioButton1.isSelected()) {
                scholarData.setDeclaredMajor(true);
                collegeComboBox.removeAllItems();

                for (int i = 0; i < colleges.length; i++) {
                    collegeComboBox.addItem(colleges[i]);
                }

                majorComboBox.removeAllItems();
                majorComboBox.addItem(anyMajor[0]);

            } else {
                scholarData.setDeclaredMajor(false);
                jRadioButton2.setSelected(true);

                collegeComboBox.removeAllItems();
                collegeComboBox.addItem(colleges[0]);
                majorComboBox.removeAllItems();
                majorComboBox.addItem(anyMajor[0]);
            }

        }

    }

    private class jRadioButton2Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            jRadioButton1.setSelected(false);

            if (jRadioButton2.isSelected()) {
                scholarData.setDeclaredMajor(false);

                collegeComboBox.removeAllItems();
                collegeComboBox.addItem(colleges[0]);
                majorComboBox.removeAllItems();
                majorComboBox.addItem(anyMajor[0]);

            } else {
                scholarData.setDeclaredMajor(true);
                jRadioButton1.setSelected(true);

                collegeComboBox.removeAllItems();

                for (int i = 0; i < colleges.length; i++) {
                    collegeComboBox.addItem(colleges[i]);
                }

                majorComboBox.removeAllItems();
                majorComboBox.addItem(anyMajor[0]);
            }

        }

    }

    //DO NOT MODIFY ANYTHING BELOW THIS
    private static void createAndShowGUI() {
        //Create and set up the window.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new AddScholarshipWindow(userIDNumber));

        //Display the window.
        frame.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
        counter++;
    }

    private static void run() {
        SwingUtilities.invokeLater(() -> {
            //Turn off metal's use of bold fonts
            if (counter == 0) {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                createAndShowGUI();
            }
        });
    }

}

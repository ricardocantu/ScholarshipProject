import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class AdminMainWindow extends JPanel {

    private JButton jLogOutButton;
    private JButton jButtonAdd;
    private JButton jButtonNext;
    private JButton jButtonPrev;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel14;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanelContainer;
    private JPanel jPanelContent;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaContent;

    private static JFrame frame = new JFrame();

    private static int userIDNumber;
    private int numOfScholarships;
    private String[] scholarshipFilenames;
    private Administrator adminData = new Administrator();
    private Scholarship scholarData = new Scholarship();
    private boolean meetsRequirements = false;

    private boolean foundFirstLabel = false;
    private static int counter = 0;

    private int counterNext = 1;
    private int counterPrev;

    public AdminMainWindow(int idNumber) {

        frame.setTitle("Scholarship Award System: Administrator");

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

        //Get first scholarship Information
        File awardsFile = new File("Scholarships.txt");

        try {

            Scanner awardInfo = new Scanner(awardsFile);
            String label;
            String scholarFileName = "";

            int counterScholar = 0;

            while (awardInfo.hasNext()) {

                label = awardInfo.next();

                if (label.matches("<numOfScholarships>")) {
                    numOfScholarships = awardInfo.nextInt();
                    counterPrev = numOfScholarships - 1;
                    scholarshipFilenames = new String[numOfScholarships];
                } else if (label.matches("<name>")) {
                    scholarFileName = awardInfo.next();
                    scholarshipFilenames[counterScholar] = scholarFileName;
                    counterScholar++;
                }

            }
            awardInfo.close();

            File scholarFile = new File(scholarshipFilenames[0] + ".txt");
            Scanner scholarInfo = new Scanner(scholarFile);

            while (scholarInfo.hasNext()) {
                label = scholarInfo.next();

                if (label.matches("<name>")) {
                    scholarData.setName(scholarInfo.nextLine());
                    scholarInfo.next();
                    scholarData.setMajor(scholarInfo.nextLine());
                    scholarInfo.next();
                    if ("true".matches(scholarInfo.next())) {
                        scholarData.setDeclaredMajor(true);
                    } else {
                        scholarData.setDeclaredMajor(false);
                    }
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
                    scholarInfo.next();
                    scholarData.setStudInAward(scholarInfo.nextLine());
                }
                break;
            }

            scholarInfo.close();

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error accesing Scholarships file!");
        }

        //DO NOT REMOVE OR MODIFY THIS
        initComponents();
        run();

    }

    private void initComponents() {

        jPanelContainer = new JPanel();
        jButtonNext = new JButton();
        jButtonPrev = new JButton();
        jPanelContent = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextAreaContent = new JTextArea();
        jButtonAdd = new JButton();
        jPanel1 = new JPanel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();
        jLogOutButton = new JButton();

        jPanelContainer.setBorder(BorderFactory.createEtchedBorder());

        jButtonNext.setText(">");

        jButtonPrev.setText("<");

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jScrollPane1.setViewportView(jTextAreaContent);

        GroupLayout jPanelContentLayout = new GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
                jPanelContentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
        );
        jPanelContentLayout.setVerticalGroup(
                jPanelContentLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1)
        );

        jButtonAdd.setText("Add Scholarships");

        GroupLayout jPanelContainerLayout = new GroupLayout(jPanelContainer);
        jPanelContainer.setLayout(jPanelContainerLayout);
        jPanelContainerLayout.setHorizontalGroup(
                jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, jPanelContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonPrev)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelContent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNext)
                        .addContainerGap())
                .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(jButtonAdd)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelContainerLayout.setVerticalGroup(
                jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addGroup(jPanelContainerLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonNext)
                                .addComponent(jButtonPrev))
                        .addContainerGap(234, Short.MAX_VALUE))
                .addGroup(jPanelContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanelContent, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdd)
                        .addContainerGap())
        );

        jLabel9.setText("Username: " + adminData.getUserName());

        jLabel10.setText("First Name:" + adminData.getFirstName());

        jLabel11.setText("Last Name:" + adminData.getLastName());

        jLabel12.setText("ID #: " + adminData.getSchoolID());

        jLabel13.setText("Department:" + adminData.getSchoolDepartment());

        jLabel14.setText("Title:" + adminData.getAdminTitle());

        jLogOutButton.setText("Log Out");

        //Add all action listeners below for all the buttons
        jLogOutButton.addActionListener(new jLogOutButtonListener());
        jButtonNext.addActionListener(new jButtonNextListener());
        jButtonPrev.addActionListener(new jButtonPrevListener());
        jButtonAdd.addActionListener(new jButtonAddListener());

        //Add the scholarships to the Text Area Content Edit the scholarship later!!!!!
        jTextAreaContent.setText("The" + scholarData.getName() + "\n\n"
                + "Eligibility:\n"
                + "\n* Declared Major: " + (scholarData.hasDeclaredMajor() ? "yes" : "no")
                + "\n* Major required:" + scholarData.getMajor()
                + "\n* Minimum GPA required: " + scholarData.getMinGPA()
                + "\n* Minimum Hours taken: " + scholarData.getMinHrs()
                + "\n* Student classification: " + scholarData.getClassification()
                + "\n* Award amount: $" + scholarData.getAmount()
                + "\n* Awards available: " + (scholarData.getMaxNumAwards() - scholarData.getCurrentNumStudents())
                + "\n* Students that have the award:"
                + "\n" + scholarData.getStudInAward());

                                //ADD the current Students that have the scholarship
        jTextAreaContent.setEditable(false);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel11)
                                                .addComponent(jLabel12)
                                                .addComponent(jLabel13)
                                                .addComponent(jLabel14)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(jLogOutButton)))
                        .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(jLogOutButton)
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

    private class jLogOutButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e2) {

            frame.dispose();
            adminData = new Administrator();
            scholarData = new Scholarship();
            frame = new JFrame();
            counter = 0;
            LoginWindow loginWindow = new LoginWindow();
        }
    }

    private class jButtonNextListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e4) {

            try {
                String label;

                File scholarFile = new File(scholarshipFilenames[counterNext] + ".txt");
                Scanner scholarInfo = new Scanner(scholarFile);
                scholarData = new Scholarship();

                while (scholarInfo.hasNext()) {
                    label = scholarInfo.next();

                    if (label.matches("<name>")) {
                        scholarData.setName(scholarInfo.nextLine());
                        scholarInfo.next();
                        scholarData.setMajor(scholarInfo.nextLine());
                        scholarInfo.next();
                        if ("true".matches(scholarInfo.next())) {
                            scholarData.setDeclaredMajor(true);
                        } else {
                            scholarData.setDeclaredMajor(false);
                        }
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
                        scholarInfo.next();
                        scholarData.setStudInAward(scholarInfo.nextLine());
                        
                    }
                    break;
                }

                scholarInfo.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error accesing Scholarships file!");
            }

            jTextAreaContent.setText("The" + scholarData.getName() + "\n\n"
                    + "Eligibility:\n"
                    + "\n* Declared Major: " + (scholarData.hasDeclaredMajor() ? "yes" : "no")
                    + "\n* Major required:" + scholarData.getMajor()
                    + "\n* Minimum GPA required: " + scholarData.getMinGPA()
                    + "\n* Minimum Hours taken: " + scholarData.getMinHrs()
                    + "\n* Student classification: " + scholarData.getClassification()
                    + "\n* Award amount: $" + scholarData.getAmount()
                    + "\n* Awards available: " + (scholarData.getMaxNumAwards() - scholarData.getCurrentNumStudents())
                    + "\n* Students that have the award:"
                    + "\n" + scholarData.getStudInAward());

            jTextAreaContent.setEditable(false);

            if (counterNext < numOfScholarships - 1) {
                counterNext++;
            } else {
                counterNext = 0;
            }

        }
    }

    private class jButtonPrevListener implements ActionListener {

        public void actionPerformed(ActionEvent e5) {

            try {
                String label;

                File scholarFile = new File(scholarshipFilenames[counterPrev] + ".txt");
                Scanner scholarInfo = new Scanner(scholarFile);
                scholarData = new Scholarship();

                while (scholarInfo.hasNext()) {
                    label = scholarInfo.next();

                    if (label.matches("<name>")) {
                        scholarData.setName(scholarInfo.nextLine());
                        scholarInfo.next();
                        scholarData.setMajor(scholarInfo.nextLine());
                        scholarInfo.next();
                        if ("true".matches(scholarInfo.next())) {
                            scholarData.setDeclaredMajor(true);
                        } else {
                            scholarData.setDeclaredMajor(false);
                        }
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
                        scholarInfo.next();
                        scholarData.setStudInAward(scholarInfo.nextLine());
                        
                    }
                    break;
                }

                scholarInfo.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error accesing Scholarships file!");
            }

            jTextAreaContent.setText("The" + scholarData.getName() + "\n\n"
                    + "Eligibility:\n"
                    + "\n* Declared Major: " + (scholarData.hasDeclaredMajor() ? "yes" : "no")
                    + "\n* Major required:" + scholarData.getMajor()
                    + "\n* Minimum GPA required: " + scholarData.getMinGPA()
                    + "\n* Minimum Hours taken: " + scholarData.getMinHrs()
                    + "\n* Student classification: " + scholarData.getClassification()
                    + "\n* Award amount: $" + scholarData.getAmount()
                    + "\n* Awards available: " + (scholarData.getMaxNumAwards() - scholarData.getCurrentNumStudents())
                    + "\n* Students that have the award:"
                    + "\n" + scholarData.getStudInAward());

            jTextAreaContent.setEditable(false);

            if (counterPrev > 0) {
                counterPrev--;
            } else {
                counterPrev = numOfScholarships - 1;
            }

        }
    }

    private class jButtonAddListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            frame.dispose();
            adminData = new Administrator();
            scholarData = new Scholarship();
            frame = new JFrame();
            counter = 0;

            AddScholarshipWindow addScholarshipWindow = new AddScholarshipWindow(userIDNumber);
        }

    }

    private static void createAndShowGUI() {
        //Create and set up the window.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new AdminMainWindow(userIDNumber));

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

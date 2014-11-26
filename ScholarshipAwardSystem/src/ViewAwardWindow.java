import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JLabel hoursTakenLabel;

    private JButton jButtonBackto;
    private JButton jButtonRemoveAward;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextArea jTextAreaContent;

    private static JFrame frame = new JFrame();

    private Student studentData = new Student();
    private Scholarship scholarData = new Scholarship();

    private String awardFileName;

    private boolean foundFirstLabel = false;
    private static int counter = 0;
    private boolean alreadyRemove;

    public ViewAwardWindow(int idNumber) {
        userIDNumber = idNumber;

        frame.setTitle("Scholarship Award System: Student - View Current Award");

        File userFile = new File(idNumber + ".txt");

        try {
            Scanner studInfo = new Scanner(userFile);

            while (studInfo.hasNext() && !foundFirstLabel) {

                String label = studInfo.next();

                //Get and set student information from file
                if (label.matches("<firstName>")) {
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
                    if ("true".matches(studInfo.next())) {
                        studentData.setDeclaredMajor(true);
                    } else {
                        studentData.setDeclaredMajor(false);
                    }
                    studInfo.next();
                    studentData.setMajor(studInfo.nextLine());
                    studInfo.next();
                    studentData.setClassification(studInfo.next());
                    studInfo.next();
                    studentData.setGPA(studInfo.nextDouble());
                    studInfo.next();
                    studentData.setHoursTaken(studInfo.nextInt());
                    studInfo.next();
                    if ("true".matches(studInfo.next())) {
                        studentData.setHasAward(true);
                        studInfo.next();
                        studentData.setCurrentAward(studInfo.nextLine());
                    } else {
                        studentData.setHasAward(false);
                        studInfo.next();
                        studentData.setCurrentAward("None");
                    }
                    foundFirstLabel = true;
                }
                break;
            }

            studInfo.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error loading data!");
        }

        if (studentData.hasScholarship()) {

            String tempStr = studentData.getCurrentAward();
            awardFileName = tempStr.replaceAll("\\s+", "");

            File scholarFile = new File(awardFileName + ".txt");

            try {
                Scanner scholarInfo = new Scanner(scholarFile);
                String label;

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
                    }
                    break;
                }

                scholarInfo.close();

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error loading data!");
            }

        }

        //Panel do not remove or modify
        initComponents();
        run();
    }

    private void initComponents() {
        alreadyRemove = false;
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jTextAreaContent = new JTextArea();
        jButtonRemoveAward = new JButton();
        jPanel2 = new JPanel();
        jButtonBackto = new JButton();

        firstNameLabel = new JLabel("First Name:" + studentData.getFirstName());
        lastNameLabel = new JLabel("Last Name:" + studentData.getLastName());
        idNumberLabel = new JLabel("ID Number: " + studentData.getSchoolID());
        usernameLabel = new JLabel("Username: " + studentData.getUserName());
        collegeLabel = new JLabel("College:" + studentData.getCollege());
        if (studentData.hasDeclaredMajor()) {
            declaredMajorLabel = new JLabel("Declared Major: yes");
        } else {
            declaredMajorLabel = new JLabel("Declared Major: no");
        }
        majorLabel = new JLabel("Major:" + studentData.getMajor());
        classificationLabel = new JLabel("Classification: " + studentData.getClassification());
        hoursTakenLabel = new JLabel("Hours taken: " + studentData.getHoursTaken());
        gpaLabel = new JLabel("GPA: " + studentData.getGPA());

        jPanel1.setBorder(BorderFactory.createEtchedBorder());

        jTextAreaContent.setColumns(20);
        jTextAreaContent.setRows(5);
        jScrollPane1.setViewportView(jTextAreaContent);

        //Add the scholarships to the Text Area Content Edit the scholarship later!!!!!
        if (studentData.hasScholarship()) {
            jTextAreaContent.setText("The" + scholarData.getName() + "\n\n"
                    + "Eligibility:\n"
                    + "\n* Declared Major: " + (scholarData.hasDeclaredMajor() ? "yes" : "no")
                    + "\n* Major required:" + scholarData.getMajor()
                    + "\n* Minimum GPA required: " + scholarData.getMinGPA()
                    + "\n* Minimum Hours taken: " + scholarData.getMinHrs()
                    + "\n* Student classification: " + scholarData.getClassification()
                    + "\n* Award amount: $" + scholarData.getAmount()
                    + "\n* Awards available: " + (scholarData.getMaxNumAwards() - scholarData.getCurrentNumStudents()));
        } else {
            jTextAreaContent.setText("You don't have an award.");
        }
        jTextAreaContent.setEditable(false);

        jButtonRemoveAward.setText("Remove Award");
        jButtonRemoveAward.addActionListener(new jButtonRemoveAwardListener());

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(133, Short.MAX_VALUE)
                        .addComponent(jButtonRemoveAward)
                        .addGap(130, 130, 130))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonRemoveAward)
                        .addContainerGap())
        );

        jButtonBackto.setText("Back to Scholarships");
        jButtonBackto.addActionListener(new jButtonBacktoListener());

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jButtonBackto, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addComponent(idNumberLabel)
                                                                .addComponent(usernameLabel)
                                                                .addComponent(hoursTakenLabel)
                                                                .addComponent(collegeLabel)
                                                                .addComponent(declaredMajorLabel))
                                                        .addGap(0, 0, Short.MAX_VALUE)))
                                        .addContainerGap())
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(firstNameLabel)
                                                .addComponent(lastNameLabel)
                                                .addComponent(majorLabel)
                                                .addComponent(classificationLabel)
                                                .addComponent(gpaLabel))
                                        .addGap(0, 0, Short.MAX_VALUE))))
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
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                        .addComponent(jButtonBackto)
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
    }

    //Button action listeners
    private class jButtonBacktoListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            frame.dispose();
            studentData = new Student();
            scholarData = new Scholarship();
            frame = new JFrame();
            counter = 0;
            StudentWindow studentWindow = new StudentWindow(userIDNumber);
        }
    }

    private class jButtonRemoveAwardListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (studentData.hasScholarship() && !alreadyRemove) {

                File studFile = new File(userIDNumber + ".txt");
                File scholarFile = new File(scholarData.getFileName() + ".txt");

                try {
                    Scanner studInfo = new Scanner(studFile);
                    PrintWriter tempFile = new PrintWriter("tempFile.txt");

                    String tempWord;

                    while (studInfo.hasNext()) {
                        tempWord = studInfo.next();

                        if (!tempWord.matches("<scholarship>")) {
                            tempFile.print(tempWord);
                            tempFile.print(studInfo.nextLine());
                            tempFile.print("\n");
                        } else {
                            tempFile.print(tempWord);
                            tempFile.print(" false");
                            tempFile.print("\n");
                            studInfo.next();
                            tempFile.print(studInfo.next());
                            tempFile.print(" None");
                            break;
                        }
                    }
                    tempFile.close();
                    studInfo.close();

                    File changeName = new File("tempFile.txt");
                    changeName.renameTo(studFile);

                    //Now edit the shcolarship file to add to the current number of students and reduce the num awards available
                    Scanner scholarInfo = new Scanner(scholarFile);
                    PrintWriter tempScholar = new PrintWriter("tempScholar.txt");
                    String tempLine;

                    while (scholarInfo.hasNext()) {
                        tempWord = scholarInfo.next();

                        if (!tempWord.matches("<currentNum>")) {
                            if (tempWord.matches("<students>")) {
                                tempScholar.print(tempWord);
                                if (scholarInfo.hasNextLine()) {
                                    tempLine = scholarInfo.nextLine();
                                    tempLine = tempLine.replaceAll(" " + studentData.getUserName() + ":", "");
                                    tempLine = tempLine.replaceAll(studentData.getFirstName(), "");
                                    tempLine = tempLine.replaceAll(studentData.getLastName() + ",", "");
                                    tempScholar.print(tempLine);
                                    tempScholar.print("\n");
                                } else {
                                    tempScholar.print(" ");
                                }
                            } else {
                                tempScholar.print(tempWord);
                                tempScholar.print(scholarInfo.nextLine());
                                tempScholar.print("\n");
                            }
                        } else {
                            tempScholar.print(tempWord);
                            int tempNum = scholarInfo.nextInt();
                            tempNum -= 1;
                            tempScholar.print(" " + tempNum);
                            tempScholar.print("\n");
                        }
                    }

                    tempScholar.close();
                    scholarInfo.close();

                    File reName = new File("tempScholar.txt");
                    reName.renameTo(scholarFile);

                    alreadyRemove = true;
                    studentData.setHasAward(false);

                    JOptionPane.showMessageDialog(null, "The award has been remove");

                    jTextAreaContent.setText("You don't have an award.");

                } catch (FileNotFoundException exe) {
                    JOptionPane.showMessageDialog(null, "Error accesing files!");
                }

            } else {
                JOptionPane.showMessageDialog(null, "You don't have an award!");
            }

        }

    }

    private static void createAndShowGUI() {
        //Create and set up the window.

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add content to the window.
        frame.add(new ViewAwardWindow(userIDNumber));

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

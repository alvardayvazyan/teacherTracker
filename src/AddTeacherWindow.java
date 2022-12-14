import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTeacherWindow extends JFrame implements ActionListener{

    JTextField teacherName = new JTextField();
    JTextField teacherSurname = new JTextField();

    //String[] subjectList = {"Mathematics", "English", "French", "History", "Literature", "Art", "PE", "Science"};
    //JCheckBox subject = new JCheckBox(String.valueOf(subjectList));

    JTextField subject = new JTextField();
    JTextField teacherUsername = new JTextField();
    JPasswordField teacherPassword = new JPasswordField();
    JButton submitBtn = new JButton("Add");
    JButton goBack = new JButton("Back");

    public AddTeacherWindow(){

        //FRAME
        setSize(1000, 1000);
        setLayout(null);

        //HEADER
        Font f = new Font("Poppins", Font.BOLD, 30);
        JPanel header = new JPanel();
        header.setBackground(new Color(51, 153, 102));
        header.setBounds(0, 0, 1000, 100);
        JLabel name = new JLabel("Add Teacher!", SwingConstants.CENTER);
        name.setForeground(Color.WHITE);
        name.setBounds(200, 50, 400, 50);
        name.setFont(f);


        Border border = BorderFactory.createLineBorder(new Color(51, 153, 102));

        //PANEL BUTTONS
        JPanel buttons = new JPanel();
        buttons.setLayout(null);
        buttons.setBorder(border);
        buttons.setBounds(250, 200, 500, 500);

        //PANEL HEADER
        JLabel fillIn = new JLabel("Fill in the required fields");
        fillIn.setBounds(180, 5, 200, 50);
        fillIn.setForeground(new Color(51, 153, 102));

        //PANEL TEXT FIELDS
        teacherName.setBounds(50, 80, 400, 30);
        JLabel teacherNameLabel = new JLabel("Teacher's name");
        teacherNameLabel.setBounds(50, 55, 400, 30);

        teacherSurname.setBounds(50, 150, 400, 30);
        JLabel teacherSurnameLabel = new JLabel("Teacher's surname");
        teacherSurnameLabel.setBounds(50, 125, 400, 30);


        subject.setBounds(50, 220, 400, 30 );
        JLabel subjectLabel = new JLabel("Subject taught by the teacher");
        subjectLabel.setBounds(50, 195, 400, 30);

        teacherUsername.setBounds(50, 290, 400, 30);
        JLabel teacherUsernameLabel = new JLabel("Teacher's username");
        teacherUsernameLabel.setBounds(50, 265, 400, 30);

        teacherPassword.setBounds(50, 360, 400, 30);
        JLabel teacherPassLabel = new JLabel("Teacher's Password");
        teacherPassLabel.setBounds(50, 335, 400, 30);

        submitBtn.setBounds(350, 430, 100, 30);
        submitBtn.setBackground(new Color(51, 153, 102));
        submitBtn.setForeground(Color.WHITE);

        //BACK BUTTON
        goBack.setBounds(0, 103, 100, 30);
        goBack.setBackground(new Color(51, 153, 102));
        goBack.setForeground(Color.white);


        //ADDERS
        add(header);
        header.add(name);
        add(buttons);
        buttons.add(fillIn);
        buttons.add(teacherName);
        buttons.add(teacherNameLabel);
        buttons.add(teacherSurname);
        buttons.add(teacherSurnameLabel);
        buttons.add(subject);
        buttons.add(subjectLabel);
//        subject.addActionListener(this);
        buttons.add(teacherUsername);
        buttons.add(teacherUsernameLabel);
        buttons.add(teacherPassword);
        buttons.add(teacherPassLabel);
        buttons.add(submitBtn);
        submitBtn.addActionListener(this);
        add(goBack);
        goBack.addActionListener(this);


        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        JComboBox cb = (JComboBox)e.getSource();
//        String subjectList = (String)cb.getSelectedItem();

        if(e.getSource() == submitBtn){
            AdminDAO.insertTeacherRow(new   Teacher(teacherName.getText(),
                                            teacherSurname.getText(),
                                            subject.getText(),
                                            teacherUsername.getText(),
                                            teacherPassword.getPassword()));
        }
        else if (e.getSource() == goBack) {
            new AdminHomePage();
            setVisible(false);
        }

    }
}

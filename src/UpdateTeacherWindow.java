import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTeacherWindow extends JFrame implements ActionListener {


    JTextField teacherID = new JTextField();
    JTextField teacherName = new JTextField();
    JTextField teacherSurname = new JTextField();

    //String[] subjectList = {"Mathematics", "English", "French", "History", "Literature", "Art", "PE", "Science"};
    //JCheckBox subject = new JCheckBox(String.valueOf(subjectList));

    JTextField subject = new JTextField();
    JTextField teacherUsername = new JTextField();
    JPasswordField teacherPassword = new JPasswordField();
    JButton updateBtn = new JButton("Update");
    JButton goBack = new JButton("Back");

    public UpdateTeacherWindow() {

        //FRAME
        setSize(1000, 1000);
        setLayout(null);

        //HEADER
        Font f = new Font("Poppins", Font.BOLD, 30);
        JPanel header = new JPanel();
        header.setBackground(new Color(51, 153, 102));
        header.setBounds(0, 0, 1000, 100);
        JLabel name = new JLabel("Update Teacher!", SwingConstants.CENTER);
        name.setForeground(Color.WHITE);
        name.setBounds(200, 50, 400, 50);
        name.setFont(f);


        Border border = BorderFactory.createLineBorder(new Color(51, 153, 102));

        //PANEL BUTTONS
        JPanel buttons = new JPanel();
        buttons.setLayout(null);
        buttons.setBorder(border);
        buttons.setBounds(250, 200, 500, 550);

        //PANEL HEADER
        JLabel fillIn = new JLabel("Fill in the required fields");
        fillIn.setBounds(180, 5, 200, 50);
        fillIn.setForeground(new Color(51, 153, 102));

        //PANEL TEXT FIELDS

        teacherID.setBounds(50, 80, 400, 30);
        JLabel teacherIDLabel = new JLabel("ID of the teacher you want to update");
        teacherIDLabel.setBounds(50, 55, 400, 30);

        teacherName.setBounds(50, 150, 400, 30);
        JLabel teacherNameLabel = new JLabel("Teacher's name");
        teacherNameLabel.setBounds(50, 125, 400, 30);

        teacherSurname.setBounds(50, 220, 400, 30);
        JLabel teacherSurnameLabel = new JLabel("Teacher's surname");
        teacherSurnameLabel.setBounds(50, 195, 400, 30);


        subject.setBounds(50, 290, 400, 30);
        JLabel subjectLabel = new JLabel("Subject taught by the teacher");
        subjectLabel.setBounds(50, 265, 400, 30);

        teacherUsername.setBounds(50, 360, 400, 30);
        JLabel teacherUsernameLabel = new JLabel("Teacher's username");
        teacherUsernameLabel.setBounds(50, 335, 400, 30);

        teacherPassword.setBounds(50, 430, 400, 30);
        JLabel teacherPassLabel = new JLabel("Teacher's Password");
        teacherPassLabel.setBounds(50, 405, 400, 30);

        updateBtn.setBounds(350, 480, 100, 30);
        updateBtn.setBackground(new Color(51, 153, 102));
        updateBtn.setForeground(Color.WHITE);

        //BACK BUTTON
        goBack.setBounds(0, 103, 100, 30);
        goBack.setBackground(new Color(51, 153, 102));
        goBack.setForeground(Color.white);


        //ADDERS
        add(header);
        header.add(name);
        add(buttons);
        buttons.add(fillIn);
        buttons.add(teacherID);
        buttons.add(teacherIDLabel);
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
        buttons.add(updateBtn);
        updateBtn.addActionListener(this);
        add(goBack);
        goBack.addActionListener(this);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            new AdminHomePage();
            setVisible(false);
        }
        else if(e.getSource() == updateBtn){
            AdminDAO.updateTeacher(new Teacher(Integer.parseInt(teacherID.getText()),
                    teacherName.getText(),
                    teacherSurname.getText(),
                    subject.getText(),
                    teacherUsername.getText(),
                    teacherPassword.getPassword()));
        }


    }
}

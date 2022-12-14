import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPage extends JFrame implements ActionListener {

    JButton teacherLoginButton = new JButton("Log in as Teacher");
    JButton adminLoginButton = new JButton("Log in as Admin");
//    JButton adminRegister = new JButton("Register as Admin");
    public StartPage() {

        setSize(1000, 1000);
        setLayout(null);

        //HEADER
        Font f = new Font("Poppins", Font.BOLD, 30);
        JPanel header = new JPanel();
        header.setBackground(new Color(51, 153, 102));
        header.setBounds(0, 0, 1000, 100);
        JLabel name = new JLabel("Welcome to Teacher Tracker!", SwingConstants.CENTER);
        name.setForeground(Color.WHITE);
        name.setBounds(200, 50, 400, 50);
        name.setFont(f);


//        Font textFont = new Font("Poppins", Font.BOLD, 20);
//        JLabel loginText = new JLabel("Log In to Your Account!");
//        loginText.setBounds(250, 220, 400, 30);
//        loginText.setForeground(new Color(51, 153, 102));
//        loginText.setFont(textFont);


        //LOGIN PANEL
        JPanel login = new JPanel();
        login.setLayout(null);
        Border border = BorderFactory.createLineBorder(new Color(51, 153, 102));
        login.setSize(400, 350);
        login.setBorder(border);
        login.setBounds(250, 260, 400, 350);

//        JLabel user = new JLabel("Username");
//        user.setBounds(50, 15, 300, 50);
//        JTextField username = new JTextField();
//        username.setBounds(50, 50, 300, 50);
//        username.setBorder(border);
//
        Font role = new Font("Poppins", Font.BOLD, 20);
        JLabel roleLabel = new JLabel("Choose your role");
        roleLabel.setBounds(120, 10, 300, 70);
        roleLabel.setForeground(new Color(51, 153, 102));
        roleLabel.setFont(role);

        Font f1 = new Font("Poppins", Font.BOLD, 16);

        teacherLoginButton.setBounds(50, 100, 300, 50);
        teacherLoginButton.setBackground(new Color(51, 153, 102));
        teacherLoginButton.setForeground(Color.white);
        teacherLoginButton.setFont(f1);

        adminLoginButton.setBounds(50, 200, 300, 50);
        adminLoginButton.setBackground(new Color(51, 153, 102));
        adminLoginButton.setForeground(Color.white);
        adminLoginButton.setFont(f1);

//        adminRegister.setBounds(50, 250, 300, 50);
//        adminRegister.setBackground(new Color(51, 153, 102));
//        adminRegister.setForeground(Color.white);
//        adminRegister.setFont(f1);



        //ADDERS
        header.add(name);
        add(header);
//        add(loginText);
        add(login);
        login.add(roleLabel);
        login.add(teacherLoginButton);
        teacherLoginButton.addActionListener(this);
        login.add(adminLoginButton);
        adminLoginButton.addActionListener(this);
//        login.add(adminRegister);
//        login.add(user);
//        login.add(username);
//        login.add(pass);
//        login.add(password);
//        login.add(loginButton);

        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminLoginButton) {
            setVisible(false);
            new AdminLoginWindow();
        }
        else if (e.getSource() == teacherLoginButton) {
            setVisible(false);
            new TeacherLoginWindow();
        }

    }
}

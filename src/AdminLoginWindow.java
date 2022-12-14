import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginWindow extends JFrame implements ActionListener{

    JButton goBack = new JButton("Back");

    JButton loginButton = new JButton("Login");
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();



    public AdminLoginWindow(){

        //FRAME
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


        Font textFont = new Font("Poppins", Font.BOLD, 20);
        JLabel loginText = new JLabel("Log In as Admin!");
        loginText.setBounds(250, 220, 400, 30);
        loginText.setForeground(new Color(51, 153, 102));
        loginText.setFont(textFont);

        //BACK BUTTON
        goBack.setBounds(0, 103, 100, 30);
        goBack.setBackground(new Color(51, 153, 102));
        goBack.setForeground(Color.white);



        //LOGIN PANEL
        JPanel login = new JPanel();
        login.setLayout(null);
        Border border = BorderFactory.createLineBorder(new Color(51, 153, 102));
        login.setSize(400, 350);
        login.setBorder(border);
        login.setBounds(250, 260, 400, 350);

        JLabel user = new JLabel("Username");
        user.setBounds(50, 15, 300, 50);
        username.setBounds(50, 50, 300, 50);
        username.setBorder(border);

        JLabel pass = new JLabel("Password");
        pass.setBounds(50, 115, 300, 50);
        password.setBounds(50, 150, 300, 50);
        password.setBorder(border);

        Font f1 = new Font("Poppins", Font.BOLD, 16);

        loginButton.setBounds(150, 250, 100, 50);
        loginButton.setBackground(new Color(51, 153, 102));
        loginButton.setForeground(Color.white);
        loginButton.setFont(f1);
        loginButton.addActionListener(this);

        //ADDERS
        header.add(name);
        add(header);
        add(goBack);
        goBack.addActionListener(this);
        add(loginText);
        add(login);
        login.add(user);
        login.add(username);
        login.add(pass);
        login.add(password);
        login.add(loginButton);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            new StartPage();
            setVisible(false);
        }
        else if(e.getSource() == loginButton){
            if(AdminDAO.adminLogin(username.getText(), String.valueOf(password.getPassword()))){
                setVisible(false);
                new AdminHomePage();

            }
        }
    }
}

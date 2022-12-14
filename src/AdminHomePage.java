import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminHomePage extends JFrame implements ActionListener {

    JButton addTeacher = new JButton("Add Teacher");
    JButton viewTeachers = new JButton("View Teachers");
    JButton deleteTeacher = new JButton("Delete Teacher");
    JButton updateTeacher = new JButton("Update Teacher");
    JButton addSchedule = new JButton("Add Schedule");
    JButton updateSchedule = new JButton("Update Schedule");


    public AdminHomePage()
    {
        setSize(1000, 1000);
        setLayout(null);

        Border border = BorderFactory.createLineBorder(new Color(51, 153, 102));


        //PANEL PROFILE
//        JPanel profileInfo = new JPanel();
//        profileInfo.setLayout(null);
//        profileInfo.setSize(1000, 150);
//        profileInfo.setBounds(0, 150, 1000, 150);
//        profileInfo.setBorder(border);
//        JLabel profPic = new JLabel();
//        profPic.setIcon(new ImageIcon("C:\\Users\\Alvard\\OneDrive\\Desktop\\TeacherTracker\\pp.jpg"));
//        profPic.setBounds(10, 150, 100, 150);


        //HEADER
        Font f = new Font("Poppins", Font.BOLD, 30);
        JPanel header = new JPanel();
        header.setBackground(new Color(51, 153, 102));
        header.setBounds(0, 0, 1000, 100);
        JLabel name = new JLabel("Welcome " + AdminDAO.loggedInAdmin.getAdminUsername() + "!", SwingConstants.CENTER);
        name.setForeground(Color.WHITE);
        name.setBounds(200, 50, 400, 50);
        name.setFont(f);


        //PANEL BUTTONS
        JPanel buttons = new JPanel();
        buttons.setLayout(null);
        //buttons.setSize(900, 400);
        buttons.setBorder(border);
        buttons.setBounds(300, 200, 400, 500);


        //BUTTONS
        Font buttonFont = new Font("Poppins", Font.BOLD, 13);

        viewTeachers.setBounds(50, 50, 300, 50);
        viewTeachers.setBackground(new Color(51, 153, 102));
        viewTeachers.setForeground(Color.white);
        viewTeachers.setFont(buttonFont);


        addTeacher.setBounds(50, 120, 300, 50);
        addTeacher.setBackground(new Color(51, 153, 102));
        addTeacher.setForeground(Color.white);
        addTeacher.setFont(buttonFont);
        addTeacher.addActionListener(this);

        deleteTeacher.setBounds(50, 190, 300, 50);
        deleteTeacher.setBackground(new Color(51, 153, 102));
        deleteTeacher.setForeground(Color.white);
        deleteTeacher.setFont(buttonFont);
        deleteTeacher.addActionListener(this);


        updateTeacher.setBounds(50, 260, 300, 50);
        updateTeacher.setBackground(new Color(51, 153, 102));
        updateTeacher.setForeground(Color.white);
        updateTeacher.setFont(buttonFont);
        updateTeacher.addActionListener(this);


        addSchedule.setBounds( 50, 330, 300, 50);
        addSchedule.setBackground(new Color(51, 153, 102));
        addSchedule.setForeground(Color.white);
        addSchedule.setFont(buttonFont);
        addSchedule.addActionListener(this);

        updateSchedule.setBounds(50, 400, 300, 50);
        updateSchedule.setBackground(new Color(51, 153, 102));
        updateSchedule.setForeground(Color.white);
        updateSchedule.setFont(buttonFont);


        //ADDERS
        add(header);
        header.add(name);
//        add(profileInfo);
//        profileInfo.add(profPic);
        add(buttons);
        buttons.add(viewTeachers);
        buttons.add(addTeacher);
        buttons.add(deleteTeacher);
        buttons.add(updateTeacher);
        buttons.add(addSchedule);
        buttons.add(updateSchedule);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addTeacher){
            new AddTeacherWindow();
            setVisible(false);
        }
        else if(e.getSource() == updateTeacher){
            new UpdateTeacherWindow();
            setVisible(false);
        }
        else if(e.getSource() == deleteTeacher){
            new DeleteTeacherWindow();
            setVisible(false);
        }
        else if(e.getSource() == addSchedule){
            new AddScheduleWindow();
            setVisible(false);
        }
    }
}

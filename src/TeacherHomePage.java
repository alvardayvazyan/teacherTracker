import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class TeacherHomePage extends JFrame implements ActionListener {

    JPanel buttons = new JPanel();
    JButton monday = new JButton("Monday");
    JButton tuesday = new JButton("Tuesday");
    JButton wednesday = new JButton("Wednesday");
    JButton thursday = new JButton("Thursday");
    JButton friday = new JButton("Friday");
    JPanel timeTable = new JPanel();
    JButton backToButtons = new JButton("Back");
    JLabel firstLesson = new JLabel();
    JLabel secondLesson = new JLabel();
    JLabel thirdLesson = new JLabel();

    public TeacherHomePage(){

        setSize(1000, 1000);
        setLayout(null);

        Border border = BorderFactory.createLineBorder(new Color(51, 153, 102));


        Font f = new Font("Poppins", Font.BOLD, 30);
        JPanel header = new JPanel();
        header.setBackground(new Color(51, 153, 102));
        header.setBounds(0, 0, 1000, 100);
        JLabel name = new JLabel("Welcome " + TeacherDAO.loggedInTeacher.getTeacherUsername()
                                         + "!", SwingConstants.CENTER);
        name.setForeground(Color.WHITE);
        name.setBounds(200, 50, 400, 50);
        name.setFont(f);

        //PANEL BUTTONS
        //JPanel buttons = new JPanel();
        buttons.setLayout(null);
        buttons.setBorder(border);
        buttons.setBounds(300, 200, 400, 430);

        //PANEL TIME TABLE
        //timeTable.setLayout(new FlowLayout());
        timeTable.setLayout(null);
        timeTable.setBorder(border);
        timeTable.setBounds(300, 200, 400, 430);


        firstLesson.setBounds(50, 50, 300, 50);
        secondLesson.setBounds(50, 120, 300, 50);
        thirdLesson.setBounds(50, 190, 300, 50);


        //BUTTONS
        Font buttonFont = new Font("Poppins", Font.BOLD, 13);

        monday.setBounds(50, 50, 300, 50);
        monday.setBackground(new Color(51, 153, 102));
        monday.setForeground(Color.white);
        monday.setFont(buttonFont);
        monday.addActionListener(this);


        tuesday.setBounds(50, 120, 300, 50);
        tuesday.setBackground(new Color(51, 153, 102));
        tuesday.setForeground(Color.white);
        tuesday.setFont(buttonFont);
        tuesday.addActionListener(this);

        wednesday.setBounds(50, 190, 300, 50);
        wednesday.setBackground(new Color(51, 153, 102));
        wednesday.setForeground(Color.white);
        wednesday.setFont(buttonFont);
        wednesday.addActionListener(this);

        thursday.setBounds(50, 260, 300, 50);
        thursday.setBackground(new Color(51, 153, 102));
        thursday.setForeground(Color.white);
        thursday.setFont(buttonFont);
        thursday.addActionListener(this);

        friday.setBounds( 50, 330, 300, 50);
        friday.setBackground(new Color(51, 153, 102));
        friday.setForeground(Color.white);
        friday.setFont(buttonFont);
        friday.addActionListener(this);

        backToButtons.setBounds(10, 10, 100, 30);
        backToButtons.setBackground(new Color(51, 153, 102));
        backToButtons.setForeground(Color.white);
        backToButtons.addActionListener(this);



        //ADDERS
        add(header);
        header.add(name);
        add(buttons);
        timeTable.setVisible(false);
        timeTable.add(firstLesson);
        timeTable.add(secondLesson);
        timeTable.add(thirdLesson);
        add(timeTable);
        timeTable.add(backToButtons);
        buttons.add(monday);
        buttons.add(tuesday);
        buttons.add(wednesday);
        buttons.add(thursday);
        buttons.add(friday);

        setVisible(true);
    }

    private void updateTimeTable(String day){
        buttons.setVisible(false);
        timeTable.setVisible(true);
        firstLesson.setText("");
        secondLesson.setText("");
        thirdLesson.setText("");
        Vector<String> lessons = TeacherDAO.getTeacherSpecificDayLessons(TeacherDAO.loggedInTeacher.getTeacherID(), day);
        System.out.println(lessons.size());
        if (lessons.size() > 0) {
            firstLesson.setText(lessons.get(0));
            if (lessons.size() > 1) {
                secondLesson.setText(lessons.get(1));
                if (lessons.size() > 2) {
                    thirdLesson.setText(lessons.get(2));
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == monday){
            updateTimeTable("Monday");
        }
        else if (e.getSource() == tuesday)
        {
            updateTimeTable("Tuesday");
        }
        else if(e.getSource() == wednesday){
            updateTimeTable("Wednesday");
        }
        else if(e.getSource() == thursday){
            updateTimeTable("Thursday");
        }
        else if(e.getSource() == friday){
            updateTimeTable("Friday");
        }
        else if(e.getSource() == backToButtons){
            timeTable.setVisible(false);
            buttons.setVisible(true);
        }

    }
}

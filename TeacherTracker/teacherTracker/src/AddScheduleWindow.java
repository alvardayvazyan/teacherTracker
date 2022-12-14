import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddScheduleWindow extends JFrame implements ActionListener {


        JTextField teacherID = new JTextField();
        JTextField day = new JTextField();

        //String[] subjectList = {"Mathematics", "English", "French", "History", "Literature", "Art", "PE", "Science"};
        //JCheckBox subject = new JCheckBox(String.valueOf(subjectList));

        JTextField fromHour = new JTextField();
        JTextField toHour = new JTextField();
        JTextField classNumber = new JTextField();
        JButton submitBtn = new JButton("Add");
        JButton goBack = new JButton("Back");

    public AddScheduleWindow(){

            //FRAME
            setSize(1000, 1000);
            setLayout(null);

            //HEADER
            Font f = new Font("Poppins", Font.BOLD, 30);
            JPanel header = new JPanel();
            header.setBackground(new Color(51, 153, 102));
            header.setBounds(0, 0, 1000, 100);
            JLabel name = new JLabel("Add Schedule!", SwingConstants.CENTER);
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
            teacherID.setBounds(50, 80, 400, 30);
            JLabel teacherNameLabel = new JLabel("Teacher's ID");
            teacherNameLabel.setBounds(50, 55, 400, 30);

            day.setBounds(50, 150, 400, 30);
            JLabel teacherSurnameLabel = new JLabel("Day of the week");
            teacherSurnameLabel.setBounds(50, 125, 400, 30);


            fromHour.setBounds(50, 220, 400, 30 );
            JLabel subjectLabel = new JLabel("Start of the class");
            subjectLabel.setBounds(50, 195, 400, 30);

            toHour.setBounds(50, 290, 400, 30);
            JLabel teacherUsernameLabel = new JLabel("End of the class");
            teacherUsernameLabel.setBounds(50, 265, 400, 30);

            classNumber.setBounds(50, 360, 400, 30);
            JLabel teacherPassLabel = new JLabel("Number of the classroom");
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
            buttons.add(teacherID);
            buttons.add(teacherNameLabel);
            buttons.add(day);
            buttons.add(teacherSurnameLabel);
            buttons.add(fromHour);
            buttons.add(subjectLabel);
//        subject.addActionListener(this);
            buttons.add(toHour);
            buttons.add(teacherUsernameLabel);
            buttons.add(classNumber);
            buttons.add(teacherPassLabel);
            buttons.add(submitBtn);
            submitBtn.addActionListener(this);
            add(goBack);
            goBack.addActionListener(this);


            setVisible(true);

        }

    @Override
    public void actionPerformed(ActionEvent e) {
            if(e.getSource() == submitBtn){
                    AdminDAO.addSchedule(new   Schedule(Integer.parseInt(teacherID.getText()),
                            day.getText(),
                            fromHour.getText(),
                            toHour.getText(),
                            classNumber.getText()));
            }
            else if (e.getSource() == goBack) {
                    new AdminHomePage();
                    setVisible(false);
            }


    }
}

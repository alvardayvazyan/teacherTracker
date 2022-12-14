import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTeacherWindow extends JFrame implements ActionListener {

    JButton deleteBtn = new JButton("Delete");
    JButton goBack = new JButton("Back");
    JTextField teacherID = new JTextField();


    public DeleteTeacherWindow(){

        //FRAME
        setSize(1000, 1000);
        setLayout(null);

        //HEADER
        Font f = new Font("Poppins", Font.BOLD, 30);
        JPanel header = new JPanel();
        header.setBackground(new Color(51, 153, 102));
        header.setBounds(0, 0, 1000, 100);
        JLabel name = new JLabel("Delete Teacher!", SwingConstants.CENTER);
        name.setForeground(Color.WHITE);
        name.setBounds(200, 50, 400, 50);
        name.setFont(f);

        Border border = BorderFactory.createLineBorder(new Color(51, 153, 102));

        //PANEL BUTTONS
        JPanel buttons = new JPanel();
        buttons.setLayout(null);
        buttons.setBorder(border);
        buttons.setBounds(250, 300, 500, 300);

        //PANEL HEADER
        JLabel fillIn = new JLabel("Fill in the required fields");
        fillIn.setBounds(180, 5, 200, 50);
        fillIn.setForeground(new Color(51, 153, 102));

        //PANEL TEXT FIELDS
        teacherID.setBounds(50, 100, 400, 30);
        JLabel teacherIDLabel = new JLabel("ID of the teacher you want to delete");
        teacherIDLabel.setBounds(50, 70, 400, 30);

        deleteBtn.setBounds(350, 180, 100, 30);
        deleteBtn.setBackground(new Color(51, 153, 102));
        deleteBtn.setForeground(Color.WHITE);

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
        buttons.add(deleteBtn);
        deleteBtn.addActionListener(this);
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
        else if(e.getSource() == deleteBtn){
            AdminDAO.deleteTeacher(new Teacher(Integer.parseInt(teacherID.getText())));
        }


    }
}

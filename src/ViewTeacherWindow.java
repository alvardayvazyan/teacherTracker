//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class ViewTeacherWindow extends JFrame implements ActionListener {
//
//        private final JTable table;
//        private JTextArea textArea = new JTextArea(10,10);
//        private AdminDAO adminDAO = new AdminDAO();
//
//        public ViewTeacherWindow(){
//            setLayout(new FlowLayout());
//            add(textArea);
//            AdminDAO.getAllTeachers();
//            textArea.setText(AdminDAO.getAllTeachers());
//
//
//            final String[][] data = AdminDAO.getAllTeachers();
//            final String[] column ={"AUTH_NAME","AUTH_SURNAME","BOOK_TITLE"};
//            table = new JTable(data, column);
//            table.setBounds(30, 40, 200, 300);
//
//            final JScrollPane scrollPane = new JScrollPane(table);
//            add(scrollPane);
//
//            setSize(1000, 500);
//            setVisible(true);
//        }
//
//
//
//
//        @Override
//    public void actionPerformed(ActionEvent e) {
//
//    }
//}

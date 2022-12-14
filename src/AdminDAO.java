import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
        private List<Teacher> teachers = new ArrayList<>();
        private static Statement statement = null;
        private ResultSet resultSet = null;
        private int columnCount;

        public static Admin loggedInAdmin = null;

        public List<Teacher> getTeachers() {
            return teachers;
        }

        public void setTeachers(List<Teacher> teachers) {
            this.teachers = teachers;
        }

    private static String toQuotedString(String s) {
        return '"' + s + '"';
    }


    public static boolean adminLogin( String username, String password){
        try{
            Statement statement = null;
            ResultSet resultSet = null;

            statement = teacherTrackerDB.connect().createStatement();
            String row = "select * from admin_info where adminUsername ="
                    + toQuotedString(username)
                    + " and adminPassword = "
                    + toQuotedString(password);

            resultSet = statement.executeQuery(row);

            if (resultSet.next()){

                loggedInAdmin = new Admin(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3));
                return true;
            }
            else System.out.println("Nothing found.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }


    //static boolean adminLogout


    public static boolean insertTeacherRow(Teacher teacher) {
        try {
             Statement statement = null;
             ResultSet resultSet = null;

            //CHECK IF USERNAME ALREADY EXISTS
            String check = "select * from teacher_info where teacherUsername = " + toQuotedString(teacher.getTeacherUsername());
            statement = teacherTrackerDB.connect().createStatement();
            resultSet = statement.executeQuery(check);
            if(resultSet.next()){
                return false;
            }

            //ADD NEW TEACHER
            statement = teacherTrackerDB.connect().createStatement();
            String row = "insert into teacher_info(teacherName, teacherSurname, subjectTaught, teacherUsername, teacherPassword) "
                            +"values ("
                            + toQuotedString(teacher.getTeacherName()) + ','
                            + toQuotedString(teacher.getTeacherSurname()) + ","
                            + toQuotedString(teacher.getSubjectTaught()) + ","
                            + toQuotedString(teacher.getTeacherUsername()) + ","
                            + toQuotedString(teacher.getTeacherPassword())
                            + ")";

            //System.out.println("AuthorDAO insertRow: " +row);

            statement.executeUpdate(row);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void updateTeacher(Teacher teacher) {
        //System.out.println(teacher);
        try {
            statement = teacherTrackerDB.connect().createStatement();
            String row = "update teacher_info set teacherName ="+ toQuotedString(teacher.getTeacherName())
                    + ',' + "teacherSurname =" + toQuotedString(teacher.getTeacherSurname())
                    + ',' + "subjectTaught=" + toQuotedString(teacher.getSubjectTaught())
                    + ',' + "teacherUsername=" + toQuotedString(teacher.getTeacherUsername())
                    + ',' + "teacherPassword=" + toQuotedString(teacher.getTeacherPassword())
                    + " where teacherID=" + teacher.getTeacherID();

            //System.out.println("AdminDAO updateRow: " +row);

            statement.executeUpdate(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteTeacher(Teacher teacher) {
        try {
            statement = teacherTrackerDB.connect().createStatement();
            String delete = "delete from teacher_info where teacherID =" + teacher.getTeacherID();

            statement.executeUpdate(delete);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static boolean addSchedule(Schedule schedule) {
        try {
            Statement statement = null;
            ResultSet resultSet = null;

            statement = teacherTrackerDB.connect().createStatement();
            String row = "insert into schedule(teacherID, day, fromHour, toHour, classNumber) "
                    +"values ("
                    + schedule.getTeacherID() + ','
                    + toQuotedString(schedule.getDay()) + ","
                    + toQuotedString(schedule.getFromHour()) + ","
                    + toQuotedString(schedule.getToHour()) + ","
                    + toQuotedString(schedule.getClassNumber())
                    + ")";


            statement.executeUpdate(row);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

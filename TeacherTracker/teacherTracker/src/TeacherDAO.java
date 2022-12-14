import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class TeacherDAO {

    private Statement statement = null;
    private ResultSet resultSet = null;
    public static Teacher loggedInTeacher = null;

    private static String toQuotedString(String s) {
        return '"' + s + '"';
    }


    public static boolean teacherLogin( String username, String password){
        try{
            Statement statement = null;
            ResultSet resultSet = null;

            statement = teacherTrackerDB.connect().createStatement();
            String row = "select * from teacher_info where teacherUsername ="
                    + toQuotedString(username)
                    + " and teacherPassword = "
                    + toQuotedString(password);

            resultSet = statement.executeQuery(row);

            if (resultSet.next()){

                loggedInTeacher = new Teacher(resultSet.getInt(1)
                );
                return true;
            }
            else System.out.println("Nothing found.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public static Vector<String> getTeacherSpecificDayLessons(int teacherID, String day){
        Vector<String> result = new Vector<String>();

        try{
            Statement statement = null;
            ResultSet resultSet = null;

            statement = teacherTrackerDB.connect().createStatement();
            String selectDay = "select fromHour, toHour, classNumber from schedule where teacherID = " +
                    teacherID + " and day=" + toQuotedString(day);
            resultSet = statement.executeQuery(selectDay);

            while(resultSet.next()){
                String wholeInfo = "";
                wholeInfo += resultSet.getString(1)
                            + " " +resultSet.getString(2)
                            + " " + resultSet.getString(3);

                result.add(wholeInfo);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }



}

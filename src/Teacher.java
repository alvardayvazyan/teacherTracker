public class Teacher {

    private int teacherID;
    private String teacherName;
    private String teacherSurname;
    private String subjectTaught;
    private String teacherUsername;
    private String teacherPassword;
    //private int schoolID;

    public Teacher(String teacherID, String text, String surnameText,
                   String subjectText, String teacherUsername, char[] teacherPassword) {
    }

    public Teacher(String teacherName, String teacherSurname, String subjectTaught, String teacherUsername, char[] teacherPassword) {
        this.teacherID = -1;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.subjectTaught = subjectTaught;
        this.teacherUsername = teacherUsername;
        this.teacherPassword = String.valueOf(teacherPassword);
    }

    public Teacher(int teacherID) {
        this.teacherID = teacherID;
        this.teacherUsername = teacherUsername;
        this.teacherPassword = teacherPassword;
    }

    public Teacher(int teacherID, String teacherName, String teacherSurname, String subjectTaught, String teacherUsername, char[] teacherPassword) {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.subjectTaught = subjectTaught;
        this.teacherUsername = teacherUsername;
        this.teacherPassword = String.valueOf(teacherPassword);
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSurname() {
        return teacherSurname;
    }

    public void setTeacherSurname(String teacherSurname) {
        this.teacherSurname = teacherSurname;
    }

    public String getSubjectTaught() {
        return subjectTaught;
    }

    public void setSubjectTaught(String subjectTaught) {
        this.subjectTaught = subjectTaught;
    }

    public String getTeacherUsername() {
        return teacherUsername;
    }

    public void setTeacherUsername(String teacherUsername) {
        this.teacherUsername = teacherUsername;
    }

    public String getTeacherPassword() {
        return teacherPassword;
    }

    public void setTeacherPassword(String teacherPassword) {
        this.teacherPassword = teacherPassword;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherID=" + teacherID +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSurname='" + teacherSurname + '\'' +
                ", subjectTaught='" + subjectTaught + '\'' +
                ", teacherUsername='" + teacherUsername + '\'' +
                ", teacherPassword='" + teacherPassword + '\'' +
                '}';
    }
}

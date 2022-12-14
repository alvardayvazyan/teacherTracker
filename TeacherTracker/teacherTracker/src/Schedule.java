public class Schedule {

    private int scheduleID;
    private int teacherID;
    private String day;
    private String fromHour;
    private String toHour;
    private String classNumber;

    public Schedule(String text, String dayText, String fromHourText, String toHourText, String classNumberText) {
    }

    public Schedule(int scheduleID, int teacherID, String day, String fromHour, String toHour, String classNumber) {
        this.scheduleID = scheduleID;
        this.teacherID = teacherID;
        this.day = day;
        this.fromHour = fromHour;
        this.toHour = toHour;
        this.classNumber = classNumber;
    }

    public Schedule(int teacherID, String day, String fromHour, String toHour, String classNumber) {
        this.scheduleID = -1;
        this.teacherID = teacherID;
        this.day = day;
        this.fromHour = fromHour;
        this.toHour = toHour;
        this.classNumber = classNumber;
    }

    public int getScheduleID() {
        return scheduleID;
    }

    public void setScheduleID(int scheduleID) {
        this.scheduleID = scheduleID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleID=" + scheduleID +
                ", teacherID=" + teacherID +
                ", day='" + day + '\'' +
                ", fromHour='" + fromHour + '\'' +
                ", toHour='" + toHour + '\'' +
                ", classNumber='" + classNumber + '\'' +
                '}';
    }
}

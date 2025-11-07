public class DateTime {

    private String year, month, day, hour, minute;

    public DateTime(String year, String month, String day, String hour, String minute){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public DateTime(String year, String month, String day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public DateTime(String year, String month){
        this.year = year;
        this.month = month;
    }

    public void setTime(String hour, String minute){
        this.hour = hour;
        this.minute = minute;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getYear() {
        return year;
    }

    public String getHour() {
        return hour;
    }

    public String getMinute() {
        return minute;
    }

    
}

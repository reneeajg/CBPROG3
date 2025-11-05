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

    public void getDate(){
        System.out.println(this.month + "-" + this.day + "-" + this.year);
    }
    
    public void getTime(){
        System.out.println(this.hour + ":" + this.minute);
    }
}

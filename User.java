import java.util.ArrayList;


public class User {

    private String userID, userEmail, firstName, midName, Surname, password;
    private ArrayList<Bank> userBanks;

    public User(String email, String fName, String mName, String sName){
        this.userEmail = email;
        this.firstName = fName;
        this.midName = mName;
        this.Surname = sName;
    }

    public void setUserID(){
        //will figure out how to make unique id l8r
        this.userID = "202511111";
    }

    public String getUserEmail(){
        return userEmail;
    }

    public void setUserEmail(String email){
        this.userEmail = email;
    }

    public String getUserPassword(){
        return password;
    }

    public void setUserPassword(String pw){ //made it return void muna
        this.password = pw;
    }

    public void addBank(String bankName, String bankAccNum){
        userBanks.add(new Bank(bankName, bankAccNum));
    }



}

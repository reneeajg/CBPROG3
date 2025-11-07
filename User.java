import java.util.ArrayList;

public class User {

    private String userID, userEmail, firstName, midName, Surname, password, defaultCurrency;
    private ArrayList<Bank> userBanks = new ArrayList<>();

    public User(String email, String fName, String mName, String sName){
        this.userEmail = email;
        this.firstName = fName;
        this.midName = mName;
        this.Surname = sName;
        this.userID = setUserID();
    }

    private String setUserID(){
        long id = System.currentTimeMillis();
        return Long.toString(id);
    }

    public String getUserID(){
        return userID;
    }

    public String getUserFirstName(){
        return firstName;
    }

    public String getUserMidName(){
        return midName;
    }

    public String getUserSurname(){
        return Surname;
    }

    public String getUserEmail(){
        return userEmail;
    }

    public boolean setUserEmail(String email){
        if(userEmail == null){
            this.userEmail = email;
            return true;
        }
        else{

            if(userEmail.equals(email)){
                System.out.println("Error: New email is same as old email!");
                return false;
            }
            else {
                this.userEmail = email;
                return true;
            }

        } 
    }

    public String getUserPassword(){
        return password;
    }

    public boolean setUserPassword(String pw){ 
        if(password == null){
            this.password = pw;
            return true;
        }
        else{

            if(password.equals(pw)){
                System.out.println("Error: New password is same as old password!");
                return false;
            }
            else {
                this.password = pw;
                return true;
            }

        } 
    }

    public void addBank(String bankName, String bankAccNum){
        userBanks.add(new Bank(bankName, bankAccNum));
    }

    public ArrayList<Bank> getBanks(){
        return userBanks;
    }

    public void setDefaultCurrency(String c){
        this.defaultCurrency = c;
    }

    public String getDefaultCurrency(){
        return defaultCurrency;
    }

}

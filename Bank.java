public class Bank {
    private String bankName, bankAccNum;
    
    public Bank(String name, String accNum){
        this.bankName = name;
        this.bankAccNum = accNum;
    }
    
    public String getBankName(){
        return this.bankName;
    }
    
    public String getBankAccNum(){
        return this.bankAccNum;
    }
}

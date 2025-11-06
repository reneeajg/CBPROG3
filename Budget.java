import java.time.LocalDateTime;

public class Expense {

    // attributes
    private float expenseAmount;
    private String expenseCurrency, expenseRefNum, expenseReceiverAccNo;
    private DateTime expenseDateTime;
    private Category expenseCategory;
    private Bank expenseBank;

    public Expense (String bankName, String bankAccNum, float amount, String currency, String refNum, String receiverAccNo, DateTime dateTime, Category category){
        this.expenseBank = new Bank(bankName, bankAccNum);
        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseReceiverAccNo = receiverAccNo;
        this.expenseDateTime = dateTime;
        this.expenseCategory = category;
    }

    public Expense (String bankName, String bankAccNum, float amount, String currency, String refNum, String receiverAccNo, DateTime dateTime){
        this.expenseBank = new Bank(bankName, bankAccNum);
        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseReceiverAccNo = receiverAccNo;
        this.expenseDateTime = dateTime;
    }

    public Expense (float amount, String currency, DateTime dateTime, Category category){

        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseDateTime = dateTime;
        this.expenseCategory = category;
    }

    public Expense (float amount, String currency, DateTime dateTime){

        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseDateTime = dateTime;
    }

    public float getExpenseAmount() {
        return expenseAmount;
    }

    public String getExpenseCurrency() {
        return expenseCurrency;
    }

    public String getExpenseRefNum() {
        return expenseRefNum;
    }

    public Category getExpenseCategory() {
        return expenseCategory;
    }

    public DateTime getExpenseDateTime() {
        return expenseDateTime;
    }

    public String getExpenseReceiverAccNo() {
        return expenseReceiverAccNo;
    }
}

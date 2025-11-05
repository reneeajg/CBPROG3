public class Expense {

    // attributes
    private float expenseAmount;
    private String expenseCurrency, expenseRefNum, expenseReceiverAccNo;
    private DateTime expenseDateTime;
    private Category expenseCategory;

    public Expense (float amount, String currency, String refNum, String receiverAccNo, DateTime dateTime, Category category){
        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseReceiverAccNo = receiverAccNo;
        this.expenseDateTime = dateTime;
        this.expenseCategory = category;
    }

}

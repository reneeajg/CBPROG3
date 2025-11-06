
public class Expense {

    // attributes
    private static final String EXPENSE_CODE = "EXP";
    private static int expCounter = 0;
    private String expenseID;
    private float expenseAmount;
    private String expenseCurrency, expenseRefNum, expenseReceiverAccNo;
    private DateTime expenseDateTime;
    private Category expenseCategory;
    private Bank expenseBank;

    private void createExpID(){
        expCounter++;
        this.expenseID = EXPENSE_CODE + String.format("%03d", expCounter);
    }

    public Expense (String bankName, String bankAccNum, float amount, String currency, String refNum, String receiverAccNo,
                    DateTime dateTime, Category category){
        createExpID();
        this.expenseBank = new Bank(bankName, bankAccNum);
        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseReceiverAccNo = receiverAccNo;
        this.expenseDateTime = dateTime;
        this.expenseCategory = category;
    }

    public Expense (String bankName, String bankAccNum, float amount, String currency, String refNum, String receiverAccNo,
                    DateTime dateTime){
        createExpID();
        this.expenseBank = new Bank(bankName, bankAccNum);
        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseReceiverAccNo = receiverAccNo;
        this.expenseDateTime = dateTime;
    }

    public Expense (float amount, String currency, DateTime dateTime, Category category){

        createExpID();
        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseDateTime = dateTime;
        this.expenseCategory = category;
    }

    public Expense (float amount, String currency, DateTime dateTime){

        createExpID();
        this.expenseAmount = amount;
        this.expenseCurrency = currency;
        this.expenseDateTime = dateTime;
    }

    public DateTime getDate(){
        return expenseDateTime;
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
    
    // this is how we can avoid printing null values
    public String getExpenseSummary() {
        StringBuilder sb = new StringBuilder();

        sb.append("Amount: ").append(expenseAmount).append(" ").append(expenseCurrency).append(" | Date: ")
                .append(expenseDateTime.getDay())
                .append("-").append(expenseDateTime.getMonth())
                .append("-").append(expenseDateTime.getYear());

        if (expenseCategory != null)
            sb.append(" | Category: ").append(expenseCategory.getCategoryName());

        if (expenseBank != null) {
            sb.append(" | Bank: ").append(expenseBank.getBankName());
            sb.append(" | Account: ").append(expenseBank.getBankAccNum());
        }

        if (expenseRefNum != null)
            sb.append(" | Ref#: ").append(expenseRefNum);

        if (expenseReceiverAccNo != null)
            sb.append(" | Receiver: ").append(expenseReceiverAccNo);

        return sb.toString();
    }



}

public class Budget {

    //attributes
    private static final String budgetID = "B";
    private float budgetAmt;
    private DateTime budgetStart, budgetEnd;
    private Category category;

    public Budget(float amount, DateTime start, DateTime end, Category category){
        this.budgetAmt = amount;
        this.budgetStart = start;
        this.budgetEnd = end;
        this.category = category;
    }

    public Budget(float amount, DateTime start, DateTime end){
        this.budgetAmt = amount;
        this.budgetStart = start;
        this.budgetEnd = end;
    }

    public void setBudgetAmt(float budgetAmt) {
        this.budgetAmt = budgetAmt;
    }

    public static String getBudgetID() {
        return budgetID;
    }

    public float getBudgetAmt() {
        return budgetAmt;
    }

    public DateTime getBudgetStart() {
        return budgetStart;
    }

    public DateTime getBudgetEnd() {
        return budgetEnd;
    }

    public Category getCategory() {
        return category;
    }
}

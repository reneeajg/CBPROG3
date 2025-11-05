public class Budget {

    //attributes
    private float budgetAmt;
    private DateTime budgetStart, budgetEnd;
    private Category category;

    public Budget(float amount, DateTime start, DateTime end, Category category){
        this.budgetAmt = amount;
        this.budgetStart = start;
        this.budgetEnd = end;
        this.category = category;
    }
}

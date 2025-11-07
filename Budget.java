

public class Budget {

    //attributes
    private static final String BUDGET_CODE = "B";
    private static int bCounter = 0;
    private String budgetID;
    private float budgetAmt;
    private DateTime budgetStart, budgetEnd;
    private String category;

    private void createBudID(){
        bCounter++;
        this.budgetID = BUDGET_CODE + String.format("%03d", bCounter);
    }

    public String getBudID(){
        return budgetID;
    }

    public Budget(float amount, DateTime start, DateTime end, String category){
        createBudID();
        this.budgetAmt = amount;
        this.budgetStart = start;
        this.budgetEnd = end;
        this.category = category;
    }

    public Budget(float amount, DateTime start, DateTime end){
        createBudID();
        this.budgetAmt = amount;
        this.budgetStart = start;
        this.budgetEnd = end;
    }

    public void setBudgetAmt(float budgetAmt) {
        this.budgetAmt = budgetAmt;
    }



    public float getBudgetAmt() {
        return budgetAmt;
    }

    public float getBudgetAmt(String category) {
        
        if(getCategory().equalsIgnoreCase(category)) return budgetAmt;
        return 0;
    }

    public DateTime getBudgetStart() {
        return budgetStart;
    }

    public DateTime getBudgetEnd() {
        return budgetEnd;
    }

    public String getCategory() {
        return category;
    }

    public String getBudgetSummary(){
        StringBuilder sb = new StringBuilder();

        sb.append("BudgetID: ").append(" ").append(budgetID);

        sb.append(" | Budget Amount: ").append(budgetAmt);

        sb.append(" | Start Date (DD-MM-YYYY): ").append(budgetStart.getDay()).append("-").append(budgetStart.getMonth())
                .append("-").append(budgetStart.getYear());

        sb.append(" | End Date: ").append(budgetEnd.getDay()).append("-").append(budgetEnd.getMonth())
                .append("-").append(budgetEnd.getYear());

        if(category != null){
            sb.append(" | Category: ").append(category);
        }
        return sb.toString();
    }
}

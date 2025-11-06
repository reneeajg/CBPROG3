import java.util.ArrayList;

public class ExpenseTracker {
    ArrayList<Budget> budgetTracker;
    ArrayList<Expense> expenseTracker;
    User user;
    ArrayList<Category> categories;

    public ExpenseTracker(User user) {
        this.user = user;
        this.budgetTracker = new ArrayList<>();
        this.expenseTracker = new ArrayList<>();
        this.categories = new ArrayList<>();
    }


    public Boolean login(String email, String password){
        return email.equals(user.getUserEmail()) && password.equals(user.getUserPassword());
    }

    public void addBudget(float amount, DateTime start, DateTime end, Category category){
        budgetTracker.add(new Budget(amount, start, end, category));
    }

    public void addBudget(float amount, DateTime start, DateTime end){
        budgetTracker.add(new Budget(amount, start, end));
    }


    public void recordExpense(String bankName, String bankAccNum, float amount, String currency, String refNum, String receiverAccNo,
                              DateTime dateTime, Category category){
        expenseTracker.add(new Expense(bankName, bankAccNum, amount, currency, refNum, receiverAccNo, dateTime,category));

        for(Budget b: budgetTracker){
            if(b.getCategory() == category){
                float budget = b.getBudgetAmt();
                budget = budget - amount;
                b.setBudgetAmt(budget);
            }
        }
    }

    public void recordExpense(String bankName, String bankAccNum, float amount, String currency, String refNum, String receiverAccNo,
                              DateTime dateTime){
        expenseTracker.add(new Expense(bankName, bankAccNum, amount, currency, refNum, receiverAccNo, dateTime));
    }

    public void recordExpense(float amount, String currency, DateTime dateTime, Category category){
        expenseTracker.add(new Expense(amount, currency, dateTime,category));
        for(Budget b: budgetTracker){
            if(b.getCategory() == category){
                float budget = b.getBudgetAmt();
                budget = budget - amount;
                b.setBudgetAmt(budget);
            }
        }
    }

    public void recordExpense(float amount, String currency, DateTime dateTime){
        expenseTracker.add(new Expense(amount, currency, dateTime));
    }



    public float getDailyTotalExp(DateTime date){
        float totalExpense = 0;
        int expenseCount = 0;

        for(Expense exp: expenseTracker){
            DateTime expDate = exp.getExpenseDateTime();

            if(date.getYear().equals(expDate.getYear()) && date.getMonth().equals(expDate.getMonth())
                    && date.getDay().equals(expDate.getDay())){
                totalExpense = totalExpense + exp.getExpenseAmount();
                expenseCount++;
            }
        }
        return totalExpense;
    }

    public float computeDailyAve(DateTime date){
        float totalExpense = 0;
        int expenseCount = 0;

        for(Expense exp: expenseTracker){
            DateTime expDate = exp.getExpenseDateTime();

            if(date.getYear().equals(expDate.getYear()) && date.getMonth().equals(expDate.getMonth())
                    && date.getDay().equals(expDate.getDay())){
                totalExpense = totalExpense + exp.getExpenseAmount();
                expenseCount++;
            }
        }

        if(expenseCount == 0){
            return 0;
        }

        return totalExpense / expenseCount;
    }

    public float getMonthlyTotalExp(String month, String year){
        float totalExpense = 0;

        for(Expense exp: expenseTracker){
            DateTime expDate = exp.getExpenseDateTime();

            if(expDate.getMonth().equals(month) && expDate.getYear().equals(year)){
                totalExpense = totalExpense + exp.getExpenseAmount();
            }
        }

        return totalExpense;
    }

    public float getMonthlyAve(String month, String year){
        float totalExpense = getMonthlyTotalExp(month,year);
        int expenseCount = 0;

        for(Expense exp: expenseTracker){
            DateTime expDate = exp.getExpenseDateTime();

            if(expDate.getMonth().equals(month) && expDate.getYear().equals(year)){
                expenseCount++;
            }
        }

        if(expenseCount == 0){
            return 0;
        }

        return totalExpense / expenseCount;
    }











}

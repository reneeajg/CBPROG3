import java.util.ArrayList;

public class ExpenseTracker {
    ArrayList<Budget> budgetTracker;
    ArrayList<Expense> expenseTracker;
    User user;
    ArrayList<Category> categories;

    public Boolean login(String email, String password){
        return email.equals(user.getUserEmail()) && password.equals(user.getUserPassword());
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

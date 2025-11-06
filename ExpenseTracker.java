import java.util.ArrayList;

public class ExpenseTracker {
    ArrayList<Budget> budgetTracker;
    ArrayList<Expense> expenseTracker;
    User user;
    ArrayList<Category> categories;


    public Boolean login(String email, String password){
        return email.equals(user.getUserEmail()) && password.equals(user.getUserPassword());
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








}

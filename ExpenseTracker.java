import java.util.ArrayList;

public class ExpenseTracker {
    ArrayList<Budget> budgets;
    ArrayList<Expense> expenses;
    User user;
    ArrayList<String> categories;
    
    
    public Boolean login(String email, String password){
        return email.equals(user.getUserEmail()) && password.equals(user.getUserPassword());
    }

    public void addBudget(float amount, DateTime start, DateTime end, String category){
        budgets.add(new Budget(amount, start, end, category));
    }

    public void addBudget(float amount, DateTime start, DateTime end){
        budgets.add(new Budget(amount, start, end));
    }


    public void recordExpense(String bankName, String bankAccNum, float amount, String currency, String refNum, String receiverAccNo,
                              DateTime dateTime, String category){
        expenses.add(new Expense(bankName, bankAccNum, amount, currency, refNum, receiverAccNo, dateTime,category));

        for(Budget b: budgets){
            //decrease the budget in that category
            if(b.getCategory() != null && b.getCategory().equals(category)){
                float budget = b.getBudgetAmt();
                budget = budget - amount;
                b.setBudgetAmt(budget);
            }
        }
    }

    public void recordExpense(String bankName, String bankAccNum, float amount, String currency, String refNum, String receiverAccNo,
                              DateTime dateTime){
        expenses.add(new Expense(bankName, bankAccNum, amount, currency, refNum, receiverAccNo, dateTime));
    }

    public void recordExpense(float amount, String currency, DateTime dateTime, String category){
        expenses.add(new Expense(amount, currency, dateTime,category));
        //decrease the budget in that category
        for(Budget b: budgets){
            if(b.getCategory() != null && b.getCategory().equals(category)){
                float budget = b.getBudgetAmt();
                budget = budget - amount;
                b.setBudgetAmt(budget);
            }
        }
    }

    public void recordExpense(float amount, String currency, DateTime dateTime){
        expenses.add(new Expense(amount, currency, dateTime));
    }

    public void viewExpensesbyCat(String category){
        int counter = 1;
        System.out.println(("EXPENSE ID | AMOUNT | DATE"));
        for(Expense e: expenses){
            if(e.getExpenseCategory().equals(category)){
                System.out.println(e.getExpenseID() + counter + " | " + e.getExpenseAmount() + " | " +
                        " | " + e.getDate()); // this is not complete idk how to do it paaaa
            }
        }
    }



    public float getDailyTotalExp(DateTime date){
        float totalExpense = 0;
        int expenseCount = 0;

        for(Expense exp: expenses){
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

        for(Expense exp: expenses){
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

        for(Expense exp: expenses){
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

        for(Expense exp: expenses){
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

    public float getTotalCatExp(String category){
        float total = 0;

        for(Expense e: expenses){
            if(e.getExpenseCategory().equals(category)){
                total = total + e.getExpenseAmount();
            }
        }

        return total;
    }

    public float getTotalExpense(){
        float total = 0;

        for(Expense e: expenses){
            total = total + e.getExpenseAmount();
        }

        return total;
    }

    public float getCatPercentage(String category){
        return getTotalCatExp(category)/getTotalExpense();

    }

    /* MAIN FUNCTION HERE */

    
    public static void main(String[] args) {

        User user1 = new User("mariabclara@dlsu.edu.ph",  "Maria", "Borja",  "Clara");
        user1.setUserPassword("passwrod");

        System.out.println(user1.getUserID());
        System.out.println(user1.getUserEmail());
        System.out.println(user1.getUserFirstName());
        System.out.println(user1.getUserMidName());
        System.out.println(user1.getUserSurname());
        System.out.println(user1.getUserPassword());

        user1.addBank("GCash", "09171234567");
        user1.addBank("BDO", "001234567891");


        ArrayList<Bank> banks = user1.getBanks();
        for(Bank b: banks){
            System.out.print(b.getBankName());
            System.out.print(" ");
            System.out.print(b.getBankAccNum());
            System.out.println();
        }

        user1.setUserPassword("passwrod");

        System.out.println();
        System.out.println();

        
    }


}

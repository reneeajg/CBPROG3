import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    ArrayList<Budget> budgets = new ArrayList<>();
    ArrayList<Expense> expenses = new ArrayList<>();
    User user;
    ArrayList<String> categories = new ArrayList<>();
    
    
    public Boolean login(String email, String password){
        return email.equals(user.getUserEmail()) && password.equals(user.getUserPassword());
    }

   
    public void addCategory(String c){
        categories.add(c);
    }

    public void displayCategories(){
        System.out.println();
        for(int i = 0; i < categories.size(); i++){
            System.out.print((i+1)  + ". ");
            System.out.println(categories.get(i));
        }
    }

    public String getCategoryIndex(int i){
        return categories.get(i-1);
    }

    public boolean isCategoryUnique(String c){
        for(String curr : categories){
            if(curr.equalsIgnoreCase(c))
                return false;
        }
        return true;
    }

   /* public void addBudget(float amount, DateTime start, DateTime end, String category){
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
    
    */ 

    public void addBudget(){
        System.out.println();
        Scanner sca = new Scanner(System.in);
        float amount;
        String startMonth = "0", startDay = "0", startYear  = "0", endMonth  = "0", endDay  = "0", endYear  = "0";

        DateTime start;
        DateTime end;

        String category = "NONE";

        boolean validNum = false;

        System.out.print("Enter Budget Amount: ");
        amount = sca.nextFloat();
        sca.nextLine();

        /* BUDGET START DATE */

        while(!validNum){
            System.out.print("Enter Budget Start Month: ");
            startMonth = sca.nextLine();
            int sMonth = Integer.parseInt(startMonth);
            if(sMonth > 0 && sMonth < 13){
                validNum = true;
            }
            else{
                System.out.println("Error: Please input a month between 1-12");
            }
        }

        validNum = false;
        
        while(!validNum){
            System.out.print("Enter Budget Start Day: ");
            startDay = sca.nextLine();
            int sDay = Integer.parseInt(startDay);
            if(sDay > 0 && sDay < 32){
                validNum = true;
            }
            else{
                System.out.println("Error: Please input a day between 1-31");
            }
        }

        validNum = false;

        while(!validNum){
            System.out.print("Enter Budget Start Year: ");
            startYear = sca.nextLine();
            if(startYear.length() == 4){
                validNum = true;
            }
            else{
                System.out.println("Error: Please input a day 4-digit year");
            }
        }
        validNum = false;

        /* BUDGET END DATE */

         while(!validNum){
            System.out.print("Enter Budget End Month: ");
            endMonth = sca.nextLine();
            int eMonth = Integer.parseInt(endMonth);
            if(eMonth > 0 && eMonth < 13){
                validNum = true;
            }
            else{
                System.out.println("Error: Please input a month between 1-12");
            }
        }
        validNum = false;
        
        while(!validNum){
            System.out.print("Enter Budget End Day: ");
            endDay = sca.nextLine();
            int eDay = Integer.parseInt(endDay);
            if(eDay > 0 && eDay < 32){
                validNum = true;
            }
            else{
                System.out.println("Error: Please input a day between 1-31");
            }
        }

        validNum = false;

        while(!validNum){
            System.out.print("Enter Budget End Year: ");
            startYear = sca.nextLine();
            if(startYear.length() == 4){
                validNum = true;
            }
            else{
                System.out.println("Error: Please input a day 4-digit year");
            }
        }

        System.out.print("Enter a category (Input 'NONE' to not apply a category): ");
        category = sca.nextLine();
        if(category.equalsIgnoreCase("NONE")){
            start = new DateTime(startYear, startMonth, startDay);
            end = new DateTime(endYear, endMonth, endDay);
            budgets.add(new Budget(amount, start, end));
        }
        else {
            start = new DateTime(startYear, startMonth, startDay);
            end = new DateTime(endYear, endMonth, endDay);
            if(isCategoryUnique(category)){
                addCategory(category);
                budgets.add(new Budget(amount, start, end, category));
            }
            else    
                budgets.add(new Budget(amount, start, end, category));
        }

        sca.close();

        System.out.println();
        System.out.println("New Budget added!");
    }

    
    public void recordExpense(User user){
        Scanner sca = new Scanner(System.in);
        boolean validNum = false;
        int type=0; //for expense type
        int bankChoice=0; 

        String bankName = "NONE";
        String bankAccNum = "NONE";
        float amount = 0; 
        String currency = user.getDefaultCurrency();
        String refNum = "NONE";
        String receiverAccNo  = "NONE";
        String expMonth = "0";
        String expDay = "0";
        String expYear = "0";
        DateTime datetime;
        String category = "NONE";

        System.out.println();
        System.out.println("[1] Digital Expense\n[2] Physical Expense");
        ;
        
        
        while(!validNum){
            System.out.print("Enter number of choice: ");
            type = sca.nextInt();

            if(type == 1 || type == 2)
                validNum = true;
            else{
                System.out.println("Error: Please input 1 or 2 only");
            }
        }
        validNum = false;

        if(type == 1){
            System.out.println("Select Bank: ");
            for(int i = 0; i < user.getBanks().size(); i++){
                System.out.print("[" + (i+1) + "] ");
                System.out.println(user.getBanks().get(i).getBankName());
            }
            

            while(!validNum){
                System.out.print("Enter number of choice: ");
                bankChoice = sca.nextInt();

                if(bankChoice > 0 && bankChoice < user.getBanks().size()){
                    bankName = user.getBanks().get(bankChoice).getBankName();
                    bankAccNum = user.getBanks().get(bankChoice).getBankAccNum();
                    validNum = true;
                }
            }
            validNum = false;
            
            System.out.print("Enter Expense amount: ");
            amount = sca.nextFloat();

            sca.nextLine();

            while(!validNum){
                System.out.print("Enter Month of Expense: ");
                expMonth = sca.nextLine();
                int eMonth = Integer.parseInt(expMonth);
                if(eMonth > 0 && eMonth < 13){
                    validNum = true;
                }
                else{
                    System.out.print("Error: Please input a month between 1-12");
                    System.out.println();
                }
            }
            validNum = false;

            while(!validNum){
                System.out.print("Enter Day of Expense: ");
                expDay = sca.nextLine();
                int eDay = Integer.parseInt(expDay);
                if(eDay > 0 && eDay < 32){
                    validNum = true;
                }
                else{
                    System.out.print("Error: Please input a day between 1-31");
                    System.out.println();
                }
            }

            validNum = false;

            while(!validNum){
                System.out.print("Enter Year of Expense: ");
                expYear = sca.nextLine();
                if(expYear.length() == 4){
                    validNum = true;
                }
                else{
                    System.out.println("Error: Please input a day 4-digit year");
                }
            }

            System.out.print("Enter Reference Number of Digital Expense: ");
            refNum = sca.nextLine();
            System.out.print("Enter Receiver's Account Number: ");
            receiverAccNo = sca.nextLine();


        }

        if(type == 2){
            validNum = false;

            System.out.println("Enter Expense amount: ");
            amount = sca.nextFloat();
            sca.nextLine();

            while(!validNum){
            System.out.print("Enter Month of Expense: ");
            expMonth = sca.nextLine();
            int eMonth = Integer.parseInt(expMonth);
            if(eMonth > 0 && eMonth < 13){
                validNum = true;
            }
            else{
                System.out.print("Error: Please input a month between 1-12");
                System.out.println();
            }
        }
            validNum = false;
            
            while(!validNum){
                System.out.print("Enter Day of Expense: ");
                expDay = sca.nextLine();
                int eDay = Integer.parseInt(expDay);
                if(eDay > 0 && eDay < 32){
                    validNum = true;
                }
                else{
                    System.out.print("Error: Please input a day between 1-31");
                    System.out.println();
                }
            }

            validNum = false;

            while(!validNum){
                System.out.print("Enter Year of Expense: ");
                expYear = sca.nextLine();
                if(expYear.length() == 4){
                    validNum = true;
                }
                else{
                    System.out.print("Error: Please input a day 4-digit year");
                    System.out.println();
                }
            }
                
            }

            System.out.print("Enter a category (Input 'NONE' to not apply a category): ");
            category = sca.nextLine();
            if(category.equalsIgnoreCase("NONE")){
                datetime = new DateTime(expYear, expMonth, expDay);

                if(type == 1)
                    expenses.add(new Expense(bankName, bankAccNum, amount, currency, refNum, receiverAccNo, datetime));
                if(type == 2)
                    expenses.add(new Expense(amount, currency, datetime));
            }
            else {
                datetime = new DateTime(expYear, expMonth, expDay);

                if(isCategoryUnique(category)){
                    addCategory(category);
                    if(type == 1){
                        expenses.add(new Expense(bankName, bankAccNum, amount, currency, refNum, receiverAccNo, datetime, category));
                    }
                    if(type == 2){
                        expenses.add(new Expense(amount, currency, datetime, category));
                    }
                    
                }
                else{
                    if(type == 1){
                        expenses.add(new Expense(bankName, bankAccNum, amount, currency, refNum, receiverAccNo, datetime, category));
                    }
                    if(type == 2){
                        expenses.add(new Expense(amount, currency, datetime, category));
                    }
                }
                    
            }

        sca.close();

        System.out.println();
        System.out.println("New Expense added!");

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

        Scanner sc = new Scanner(System.in);
        ExpenseTracker app = new ExpenseTracker();

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

        //app.addBudget();
        app.recordExpense(user1);

       

        sc.close();
    }


}

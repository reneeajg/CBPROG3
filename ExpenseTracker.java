import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {
    ArrayList<Budget> budgets = new ArrayList<>();
    ArrayList<Expense> expenses = new ArrayList<>();
    User user;
    ArrayList<String> categories = new ArrayList<>();


    public boolean login(String email, String password, User user){
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



    public void viewExpenses(){

        System.out.println("EXPENSE SUMMARY");

        for(Expense e: expenses){
            System.out.println(e.getExpenseSummary());
        }
        System.out.println("Total Expenses: " + getTotalExpense());
    }

    public void viewExpensesbyCat(String category){

        System.out.println("SHOWING EXPENSES FOR " + category + "CATEGORY");

        for(Expense e: expenses){
            String expCat = e.getExpenseCategory();

            if (expCat.equalsIgnoreCase(category)) {
                System.out.println(e.getExpenseSummary());
            }
        }

        System.out.println("Total: " + getTotalCatExp(category));

        for(Budget b: budgets){
            if(b.getCategory().equalsIgnoreCase(category)){
                System.out.println("Remaining budget: " + b.getBudgetAmt(category));
            }
        }
    }

    public void viewBudget(){
        for(Budget b: budgets){
            System.out.println(b.getBudgetSummary());
        }
    }

    public float calculateBudgetMinusExpenses(Budget b, ArrayList<Expense> expenses){

        DateTime bdtS = b.getBudgetStart();
        DateTime bdtE = b.getBudgetEnd();
        int budgetStartMonth = Integer.parseInt(bdtS.getMonth());
        int budgetStartDay = Integer.parseInt(bdtS.getDay());
        int budgetStartYear = Integer.parseInt(bdtS.getYear());
        int budgetEndMonth = Integer.parseInt(bdtE.getMonth());
        int budgetEndDay = Integer.parseInt(bdtE.getDay());
        int budgetEndYear = Integer.parseInt(bdtE.getYear());

        float remainingBudget = b.getBudgetAmt();

        for(Expense curr : expenses){

            DateTime dt = curr.getExpenseDateTime();

            //check if expense is less than or equal to budget end date
            if((Integer.parseInt(dt.getMonth()) <= budgetEndMonth) && (Integer.parseInt(dt.getDay()) <= budgetEndDay) && (Integer.parseInt(dt.getYear()) <= budgetEndYear)){

                //check if expense is greater than or equal to budget start date
                if((Integer.parseInt(dt.getMonth()) >= budgetStartMonth) && (Integer.parseInt(dt.getDay()) >= budgetStartDay) && (Integer.parseInt(dt.getYear()) >= budgetStartYear)){

                    remainingBudget = (remainingBudget - curr.getExpenseAmount());

                }

            }

        }

        return remainingBudget;

    }


    public float calculateBudgetMinusExpenses(Budget b, ArrayList<Expense> expenses, boolean underCategory){

        DateTime bdtS = b.getBudgetStart();
        DateTime bdtE = b.getBudgetEnd();

        String budCat = b.getCategory();

        int budgetStartMonth = Integer.parseInt(bdtS.getMonth());
        int budgetStartDay = Integer.parseInt(bdtS.getDay());
        int budgetStartYear = Integer.parseInt(bdtS.getYear());
        int budgetEndMonth = Integer.parseInt(bdtE.getMonth());
        int budgetEndDay = Integer.parseInt(bdtE.getDay());
        int budgetEndYear = Integer.parseInt(bdtE.getYear());

        float remainingBudget = b.getBudgetAmt();

        for(Expense curr : expenses){

            DateTime dt = curr.getExpenseDateTime();
            String currCat = curr.getExpenseCategory();

            //check if expense is less than or equal to budget end date
            if((Integer.parseInt(dt.getMonth()) <= budgetEndMonth) && (Integer.parseInt(dt.getDay()) <= budgetEndDay) && (Integer.parseInt(dt.getYear()) <= budgetEndYear)){

                //check if expense is greater than or equal to budget start date
                if((Integer.parseInt(dt.getMonth()) >= budgetStartMonth) && (Integer.parseInt(dt.getDay()) >= budgetStartDay) && (Integer.parseInt(dt.getYear()) >= budgetStartYear)){

                    //check if budget
                    if(currCat.equalsIgnoreCase(budCat)){
                        remainingBudget = (remainingBudget - curr.getExpenseAmount());
                    }

                }

            }

        }

        return remainingBudget;

    }

    public void viewDailyExpense(DateTime date){
        System.out.println("Expenses for:" + date.getDay() + '-' + date.getMonth() + "-" + date.getYear());
        for(Expense exp: expenses){
            DateTime expDate = exp.getExpenseDateTime();

            if(date.getYear().equals(expDate.getYear()) && date.getMonth().equals(expDate.getMonth())
                    && date.getDay().equals(expDate.getDay())){
                System.out.println(exp.getExpenseSummary());
            }
        }
    }

    public float getDailyTotalExp(DateTime date){
        viewDailyExpense(date);
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

    public float getDailyAve(String month, String year){
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

    public void viewMonthlyExpense(String month, String year){
        System.out.println("Showing expenses for: " + month + " " + year);

        for(Expense exp: expenses){
            DateTime expDate = exp.getExpenseDateTime();

            if(expDate.getMonth().equals(month) && expDate.getYear().equals(year)){
                System.out.println(exp.getExpenseSummary());
            }
        }
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

        /*=============EXPENSES=================*/


        // Fixed bank account numbers per bank
        String gcashAcc = "BA10001";
        String bpiAcc = "BA20001";
        String mayaAcc = "BA30001";
        String currency = "PHP";

        app.expenses.add(new Expense("GCASH", gcashAcc, 1200, currency, "REF1001", "ACC5001",
                new DateTime("2025", "10", "1"), "GROCERY"));
        app.expenses.add(new Expense("GCASH", gcashAcc, 3500, currency, "REF1001", "ACC5001",
                new DateTime("2025", "10", "1"), "SHOPPING"));
        app.expenses.add(new Expense("GCASH", gcashAcc, 2000, currency, "REF1001", "ACC5001",
                new DateTime("2025", "10", "8"), "SHOPPING"));
        app.expenses.add(new Expense("GCASH", gcashAcc, 850, currency, "REF1002", "ACC5002",
                new DateTime("2025", "10", "8"), "GROCERY"));
        app.expenses.add(new Expense("GCASH", gcashAcc, 950, currency, "REF1003", "ACC5003",
                new DateTime("2025", "10", "15"), "GROCERY"));
        app.expenses.add(new Expense("GCASH", gcashAcc, 1100, currency, "REF1004", "ACC5004",
                new DateTime("2025", "10", "22"), "GROCERY"));
        app.expenses.add(new Expense("BPI", bpiAcc, 2300, currency, "REF2001", "ACC6001",
                new DateTime("2025", "10", "5"), "UTILITY"));
        app.expenses.add(new Expense("BPI", bpiAcc, 1850, currency, "REF2002", "ACC6002",
                new DateTime("2025", "10", "20"), "UTILITY"));
        app.expenses.add(new Expense("PAYMAYA", mayaAcc, 499, currency, "REF3001", "ACC7001",
                new DateTime("2025", "10", "3"), "SHOPPING"));
        app.expenses.add(new Expense("PAYMAYA", mayaAcc, 249, currency, "REF3002", "ACC7002",
                new DateTime("2025", "10", "15"), "SUBSCRIPTION"));
        app.expenses.add(new Expense("PAYMAYA", mayaAcc, 149, currency, "REF3003", "ACC7003",
                new DateTime("2025", "10", "31"), "SUBSCRIPTION"));
        app.expenses.add(new Expense("GCASH", gcashAcc, 300, currency, "REF4001", "ACC8001",
                new DateTime("2025", "10", "2"), "TRANSPORTATION"));
        app.expenses.add(new Expense("BPI", bpiAcc, 450, currency, "REF4002", "ACC8002",
                new DateTime("2025", "10", "15"), "SHOPPING"));
        app.expenses.add(new Expense("PAYMAYA", mayaAcc, 275, currency, "REF4003", "ACC8003",
                new DateTime("2025", "10", "15"), "TRANSPORTATION"));
        app.expenses.add(new Expense("GCASH", gcashAcc, 390, currency, "REF4004", "ACC8004",
                new DateTime("2025", "10", "25"), "TRANSPORTATION"));
        //overloads
        app.expenses.add(new Expense(249, currency, new DateTime("2025","10","15")));
        app.expenses.add(new Expense(150, currency, new DateTime("2025","10","10")));
        app.expenses.add(new Expense(100, currency, new DateTime("2025","10","3")));
        app.expenses.add(new Expense(30, currency, new DateTime("2025","10","29")));
        app.expenses.add(new Expense(600, currency, new DateTime("2025", "10", "12"), "GROCERY"));
        app.expenses.add(new Expense(199, currency, new DateTime("2025", "10", "28"), "SUBSCRIPTION"));

        DateTime start = new DateTime("2025", "10", "1");
        DateTime end = new DateTime("2025", "10", "31");
        /*=============BUDGET=================*/
        app.budgets.add(new Budget(20000, start, end, "GROCERY"));
        app.budgets.add(new Budget(5000, start, end, "TRANSPORTATION"));
        app.budgets.add(new Budget(3000, start, end, "SUBSCRIPTION"));
        app.budgets.add(new Budget(10000, start, end, "SHOPPING"));
        app.budgets.add(new Budget(30000, start, end));

        boolean quit = false; //for program
        boolean success = false; //for login

        System.out.println("PERSONAL EXPENSES TRACKER");
        System.out.println();

        while(!success){
            System.out.print("Enter your email: ");
            String em = sc.nextLine();
            System.out.print("Enter your password: ");
            String pw = sc.nextLine();

            success = app.login(em, pw, user1);

            if(!success){
                System.out.println("Error: email and password do not match or are incorrect!");
            }

        }

        if(success){
            System.out.println("Login Successful!");
            System.out.println("Welcome, " + user1.getUserFirstName() + " " + user1.getUserMidName().charAt(0) + ". " + user1.getUserSurname());
            System.out.println();
        }


        if(!quit){

            int choice = 0;
            boolean validChoice = false;

            System.out.println("[1] Add Digital Bank\n[2] Add New Expense\n[3] Add New Budget\n[4] Add Category\n[5] View Expenses/Budgets\n[6] View Insights\n[7] Quit");

            while (!validChoice){

                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                if(choice < 0 || choice > 7){
                    System.out.println("Error: Please input 1-7 only");
                }
                else
                    validChoice = true;

            }


            if(choice == 7){
                quit = true;
            }

            if(choice == 1){
                Scanner sone = new Scanner(System.in);
                ArrayList<Bank> banks = user1.getBanks();


                System.out.println();
                System.out.print("Enter Bank Name: ");
                String bN = sone.nextLine();
                System.out.print("Enter Bank Account Number: ");
                String bAN = sone.nextLine();
                user1.addBank(bN, bAN);

                System.out.println();
                System.out.println();

                System.out.println("New Bank Added: "); //just to show bank has been added to User's banks

                for(Bank curr : banks){

                    if(curr.getBankName().equals(bN) && curr.getBankAccNum().equals(bAN)){
                        System.out.println(curr.getBankName());
                        System.out.println(curr.getBankAccNum());
                    }

                }

                sone.close();

                quit = true;
            }

            if(choice == 2){

                quit = true;
            }

            if(choice == 3){

                quit = true;

            }

            if(choice == 4){

                quit = true;

            }

            if(choice == 5){

                int view = 0;

                while(view < 1 || view > 4){

                    System.out.println("[1] View Daily Expense");
                    System.out.println("[2] View Monthly Expense");
                    System.out.println("[3] View by Category");
                    System.out.println("[4} View All");
                    System.out.println("Select how you wish to view your recorded expenses: ");
                    view = sc.nextInt();
                }

                if(view == 1){
                    app.viewDailyExpense(new DateTime("2025","10", "1"));
                }

                else if (view == 2){
                    app.viewMonthlyExpense("10", "2025");
                }

                else if (view == 3){
                    app.viewExpensesbyCat("GROCERY");
                }
                else {
                    app.viewExpenses();
                }

                quit = true;

            }

            if(choice == 6){

                int view6 = 0;

                while(view6 < 1 || view6 > 2){

                    System.out.println("[1] View Daily Average Expense");
                    System.out.println("[2] View Expense Percentage of a Category: ");
                    System.out.println("Select your choice: ");
                    view6 = sc.nextInt();
                }

                if (view6 == 1){
                    app.viewMonthlyExpense("10", "2025");
                    System.out.println("Daily Average: " + app.getDailyAve("10", "2025"));
                }
                else{
                    System.out.println("You spent " + (app.getCatPercentage("GROCERY") * 100) + "% in the GROCERY category");
                    System.out.println("You spent " + (app.getCatPercentage("TRANSPORTATION") * 100) + "% in the TRANSPORTATION category");
                    System.out.println("You spent " + (app.getCatPercentage("SUBSCRIPTION") * 100) + "% in the SUBSCRIPTION category");
                    System.out.println("You spent " + (app.getCatPercentage("SHOPPING") * 100) + "% in the SHOPPING category");

                }

                quit = true;

            }


        }

        if(quit){
            System.out.println();
            System.out.println("Logged Out");
        }


        sc.close();
    }


}

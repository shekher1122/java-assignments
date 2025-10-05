import java.util.Scanner;

public class BankingApp {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface(50);
        ui.mainMenu();
    }

    // Account class (nested)
    static class Account {
        private int accountNumber;
        private String accountHolderName;
        private double balance;
        private String email;
        private String phoneNumber;

        public Account(int accountNumber, String accountHolderName, double balance, String email, String phoneNumber) {
            this.accountNumber = accountNumber;
            this.accountHolderName = accountHolderName;
            this.balance = balance;
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("₹" + amount + " deposited successfully.");
            } else {
                System.out.println("Invalid deposit amount!");
            }
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Invalid withdrawal amount!");
            } else if (amount > balance) {
                System.out.println("Insufficient balance!");
            } else {
                balance -= amount;
                System.out.println("₹" + amount + " withdrawn successfully.");
            }
        }

        public void displayAccountDetails() {
            System.out.println("\n--- Account Details ---");
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Balance: ₹" + balance);
            System.out.println("Email: " + email);
            System.out.println("Phone: " + phoneNumber);
        }

        public void updateContactDetails(String email, String phoneNumber) {
            this.email = email;
            this.phoneNumber = phoneNumber;
            System.out.println("Contact details updated successfully!");
        }

        public int getAccountNumber() {
            return accountNumber;
        }
    }

    // UserInterface class (nested)
    static class UserInterface {
        private Account[] accounts;
        private int count;
        private Scanner sc;

        public UserInterface(int size) {
            accounts = new Account[size];
            count = 0;
            sc = new Scanner(System.in);
        }

        public void createAccount() {
            if (count >= accounts.length) {
                System.out.println("Cannot create more accounts. Limit reached!");
                return;
            }

            System.out.print("Enter account holder name: ");
            String name = sc.nextLine();

            System.out.print("Enter initial deposit amount: ");
            double amount;
            try {
                amount = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Account not created.");
                return;
            }

            System.out.print("Enter email address: ");
            String email = sc.nextLine();

            System.out.print("Enter phone number: ");
            String phone = sc.nextLine();

            int accNum = 1000 + count + 1;
            accounts[count] = new Account(accNum, name, amount, email, phone);
            System.out.println("Account created successfully with Account Number: " + accNum);
            count++;
        }

        public void performDeposit() {
            System.out.print("Enter account number: ");
            int accNum = readInt();
            if (accNum == Integer.MIN_VALUE) return;

            System.out.print("Enter amount to deposit: ");
            double amount = readDouble();
            if (Double.isNaN(amount)) return;

            Account acc = findAccount(accNum);
            if (acc != null) acc.deposit(amount);
            else System.out.println("Account not found!");
        }

        public void performWithdrawal() {
            System.out.print("Enter account number: ");
            int accNum = readInt();
            if (accNum == Integer.MIN_VALUE) return;

            System.out.print("Enter amount to withdraw: ");
            double amount = readDouble();
            if (Double.isNaN(amount)) return;

            Account acc = findAccount(accNum);
            if (acc != null) acc.withdraw(amount);
            else System.out.println("Account not found!");
        }

        public void showAccountDetails() {
            System.out.print("Enter account number: ");
            int accNum = readInt();
            if (accNum == Integer.MIN_VALUE) return;

            Account acc = findAccount(accNum);
            if (acc != null) acc.displayAccountDetails();
            else System.out.println("Account not found!");
        }

        public void updateContact() {
            System.out.print("Enter account number: ");
            int accNum = readInt();
            if (accNum == Integer.MIN_VALUE) return;

            Account acc = findAccount(accNum);
            if (acc != null) {
                System.out.print("Enter new email: ");
                String email = sc.nextLine();
                System.out.print("Enter new phone number: ");
                String phone = sc.nextLine();
                acc.updateContactDetails(email, phone);
            } else {
                System.out.println("Account not found!");
            }
        }

        private Account findAccount(int accNum) {
            for (int i = 0; i < count; i++) {
                if (accounts[i].getAccountNumber() == accNum)
                    return accounts[i];
            }
            return null;
        }

        private int readInt() {
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid integer input.");
                return Integer.MIN_VALUE;
            }
        }

        private double readDouble() {
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid number input.");
                return Double.NaN;
            }
        }
        
        public void mainMenu() {
            int choice = 0;
            do {
                System.out.println("\n===== Welcome to the Banking Application =====");
                System.out.println("1. Create a new account");
                System.out.println("2. Deposit money");
                System.out.println("3. Withdraw money");
                System.out.println("4. View account details");
                System.out.println("5. Update contact details");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid choice! Please enter a number.");
                    continue;
                }

                switch (choice) {
                    case 1: createAccount(); break;
                    case 2: performDeposit(); break;
                    case 3: performWithdrawal(); break;
                    case 4: showAccountDetails(); break;
                    case 5: updateContact(); break;
                    case 6: System.out.println("Thank you for using the Banking Application!"); break;
                    default: System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 6);
        }
    }
}

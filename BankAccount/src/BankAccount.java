
import java.util.*;

public class BankAccount {
	
	private String accountNumber;
	private String firstName;
	private String lastName;
	private double checkingBalance = 0;
    private double savingsBalance = 0;
    private HashMap accounts = new HashMap();
    static double totalAccounts = 0;
    static double totalBalance = 0;

    private String generateAccountNumber(){
        boolean tester = true;
        double number;
        String rounded = "null";
        while(tester) {
            number = Math.random() * 9000000000L + 1000000000;
            rounded = String.format("%.0f", number);
            if (!accounts.containsKey(number)) {
                tester = false;
            }
        }
        return rounded;
    }

    public BankAccount(String firstName, String lastName){
        accountNumber = this.generateAccountNumber();
        this.firstName = firstName;
        this.lastName = lastName;
        accounts.put(accountNumber, this.lastName + ", " + this.firstName);
        totalAccounts++;
    }
    
    public double getCheckingBalance() {
		return checkingBalance;
	}

	private void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
    
	void depositChecking(double amountDeposited) {
		checkingBalance += amountDeposited;
	}
	
	void depositSavings(double amountDeposited) {
		savingsBalance += amountDeposited;
	}
	
	double withdrawSavings(double amountWithdrawn) {
		if(amountWithdrawn > savingsBalance) {
			System.out.println("Insufficent Funds");
			return 0.0;
		}else {
			savingsBalance -= amountWithdrawn;
			return amountWithdrawn;
		}
	}
	
	double withdrawChecking(double amountWithdrawn) {
		if(amountWithdrawn > checkingBalance) {
			System.out.println("Insufficent Funds");
			return 0.0;
		}else {
			checkingBalance -= amountWithdrawn;
			return amountWithdrawn;
		}
	}
	
	double accountBalance() {
		return checkingBalance + savingsBalance;
	}
	
    

}

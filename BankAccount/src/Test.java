
public class Test {
	public static void main(String[] args) {
        BankAccount me = new BankAccount("Joseph", "Smith");
        me.depositChecking(100.00);
        me.depositSavings(40.00);
        System.out.println(me.getCheckingBalance());
        System.out.println(me.getSavingsBalance());
        me.withdrawChecking(10.00);
        me.withdrawSavings(25.2);
        System.out.println(me.accountBalance());
    }
}

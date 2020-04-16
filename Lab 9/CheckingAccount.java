public class CheckingAccount extends BankAccount{
	static final double FEE = .15;
	
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		super.setAccountNumber(super.getAccountNumber() + "-10");
	}
	
	@Override
	public boolean withdraw(double amount) {
		return super.withdraw(amount + CheckingAccount.FEE);
		
	}
}

package testing;

public class TestBank {

	public static void main(String args[])
	{
		HDFC hdfc=new HDFC();
		
		hdfc.credit();
		hdfc.debit();
		hdfc.loan();
		
		Bank bank=new HDFC();
		
		bank.credit();
		bank.credit_limit();
		
		
	}
}

package bankinterest;

public class BankInterest {

	public static void main(String[] args) {
		double startMoney = 4000;
		double interest = 0.02;
		double amount = 0;
		String action = "";
		
		System.out.println("Day      Type          Amount          Balance");
		for (int i=1; i<31; i++) {
			double random = Math.random();
			if (random < 0.5) {
				action = "Deposit ";
				amount = 200.5;
				startMoney += amount;
			}
			else {
				action = "Withdraw";
				amount = 100;
				startMoney -= amount;
			}
			amount = (double) Math.round(amount * 100) / 100;
			System.out.println(i+"       "+action+"       $"+amount+"0        "+"$"+startMoney+"0");
		}
		System.out.println();
		System.out.println("Interest earned: "+startMoney*interest);
		System.out.println("Money after one month's interest: "+ startMoney*(1+interest)); 
	}
}

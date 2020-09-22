public class application_money {
	public static double creatormoney = 0;
	public static double deliverychargestaken = 0;

	public static void moneyadd(double amount) {
		creatormoney += amount;
	}

	public static void moneyadddelivery(double delivery) {
		deliverychargestaken += delivery;
	}

	public static double getcreatormoney() {
		return creatormoney;
	}

	public static double getdeliverymoney() {
		return deliverychargestaken;
	}
}
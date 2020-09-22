import java.util.HashMap;

public interface customer_methods {
	public double amountforauthentic(HashMap<String, Integer> cart, double amount);

	public int deduction(double amount);

	public void alloptions();

	public double total_order_value(HashMap<String, Integer> cart);

	public int deliverycharge();

	public void enternotcheckedunits(HashMap<String, Integer> cart);

	public void rewardpointsadder(HashMap<String, Integer> cart, double amount);

	public void displayer();
}
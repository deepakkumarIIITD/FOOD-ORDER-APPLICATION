import java.util.HashMap;

public class customer_types {
	public int special(double amount) {
		return specialp(amount);
	}

	private int specialp(double amount) {
		if (amount > 200) {
			return 25;
		}
		return 0;
	}

	public int elite(double amount) {
		return elitep(amount);
	}

	private int elitep(double amount) {
		if (amount > 200) {
			return 50;
		}
		return 0;
	}

	public int normal(double amount) {
		return normalp(amount);
	}

	private int normalp(double amount) {
		return 0;
	}

	public int ffpoints(double amount) {
		return ffpointsp(amount);
	}

	private int ffpointsp(double amount) {
		int points = 0;
		while (amount >= 150) {
			amount -= 150;
			points += 10;
		}
		return points;
	}

	public int authenticpoints(double amount) {
		return authenticpointsp(amount);
	}

	private int authenticpointsp(double amount) {
		int points = 0;
		while (amount >= 200) {
			amount -= 200;
			points += 25;
		}
		return points;
	}

	public int restpoints(double amount) {
		return restpointsp(amount);
	}

	private int restpointsp(double amount) {
		int points = 0;
		while (amount >= 100) {
			amount -= 100;
			points += 5;
		}
		return points;
	}
}
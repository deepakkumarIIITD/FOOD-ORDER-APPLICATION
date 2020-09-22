import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class seller implements seller_interface {
	private String restoname;
	private String restotype = "NORMAL";
	private double rewardpoints = 0;
	private double discount = 0;
	private int totalorderstaken = 0;
	private String restoaddress;
	public HashMap<String, food> fooddata = new HashMap<>();
	Scanner scn = new Scanner(System.in);

	public int gettotalorders() {
		return totalorderstaken;
	}

	seller(String RESTONAME, String RESTOTYPE, String RESTOADDRESS) {
		this.restoname = RESTONAME;
		this.restotype = RESTOTYPE;
		this.restoaddress = RESTOADDRESS;
	}

	public void addingorders() {
		totalorderstaken += 1;
	}

	@Override
	public void displayresto() {
		System.out.println("RESTRAUNTS NAME : " + restoname);
		System.out.println("RESTRAUNTS ADDRESS : " + restoaddress);
		System.out.println("RESTRAUNTS TYPE : " + restotype);
		System.out.println("RESTRAUNTS NUMBER OF ORDERS TAKEN : " + totalorderstaken);
		System.out.println("RESTRAUNTS REWARD POINTS : " + rewardpoints);
		System.out.println("RESTRAUNTS DISCOUNT : " + discount);
	}

	@Override
	public void methods() {
		while (true) {
			System.out.println(" 1 ADD ITEM");
			System.out.println(" 2 EDIT ITEM");
			System.out.println(" 3 PRINT REWARDS");
			System.out.println(" 4 DISCOUNT ON BILL VALUES");
			System.out.println(" 5 EXIT");
			System.out.println("ENTRE OPTION NUMBER : ");
			int task = scn.nextInt();
			if (task == 1) {
				food a = new food();
				fooddata.put(a.getItemcode(), a);
			} else if (task == 2) {
				System.out.println(restoname);
				System.out.println("CHOOSE CODE OF RESPECTIVE ITEM : ");
				for (String key : fooddata.keySet()) {
					food a = fooddata.get(key);
					a.display();
					System.out.println("\n");
				}
				System.out.println("ENTER THE FOOD CODE WHICH NEEDS TO BE EDITED");
				String foodid = scn.next();
				System.out.println("CHOOSE WHAT NEEDS TO BE EDITED IN " + foodid);
				System.out.println(" 1 NAME");
				System.out.println(" 2 PRICE");
				System.out.println(" 3 QUANTITY");
				System.out.println(" 4 CATEGORY");
				System.out.println(" 5 OFFER");
				int editnum = scn.nextInt();
				fooddata.get(foodid).edititem(editnum);
			} else if (task == 3) {
				System.out.println("THE REWARD POINTS CLAIMED TILL NOW ARE : " + rewardpoints + " POINTS");
			} else if (task == 4) {
				if (restotype.equals("authentic") || restotype.equals("fastfood")) {
					System.out.println("ENTER THE OVERALL DISCOUNT PERCENTAGE : ");
					this.discount = scn.nextDouble();
				} else {
					System.out.println(restotype + " TYPE RESTRAUNTS ARE NOT ELIGIBLE FOR ANY OVERALL DISCOUNTS");
				}
			} else if (task == 5) {
				break;
			}
		}
	}

	public void displayallitems() {
		System.out.println("CHOOSE CODE OF RESPECTIVE ITEM : ");
		for (String key : fooddata.keySet()) {
			food a = fooddata.get(key);
			a.display();
			System.out.println("\n");
		}
	}

	public String getrestoname() {
		return (restoname);
	}

	public double getdiscount() {
		return discount;
	}

	public String getrestotype() {
		return restotype;
	}

	public void addrewardpoints(int p) {
		rewardpoints += p;
	}
}
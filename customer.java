import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class customer extends customer_types implements customer_methods {
	private String name;
	private double wallet = 1000;
	private double pointsgainedtillnow = 0;
	private double points;
	private String customertype = "NORMAL";
	private String address;
	public ArrayList<HashMap<String, Integer>> allorders = new ArrayList<>();
	Scanner scn = new Scanner(System.in);

	customer(String name, String customertype, String address) {
		this.name = name;
		this.customertype = customertype;
		this.address = address;
	}

	@Override
	public void displayer() {
		System.out.println("CUSTOMER NAME : " + name);
		System.out.println("CUSTOMER ADDRESS : " + address);
		System.out.println("CUSTOMER TYPE : " + customertype);
		System.out.println("CUSTOMER WALLET AMOUNT : " + wallet);
		System.out.println("CUSTOMER WALLET POINTS : " + points);
	}

	@Override
	public int deliverycharge() {
		if (customertype.equals("ELITE")) {
			return 0;
		} else if (customertype.equals("SPECIAL")) {
			return 20;
		} else {
			return 40;
		}
	}

	@Override
	public void rewardpointsadder(HashMap<String, Integer> cart, double amount) {
		boolean breakall = false;
		for (String key : cart.keySet()) {
			for (String key1 : test.allsellers.keySet()) {
				boolean condition = true;
				seller j = test.allsellers.get(key1);
				if (condition) {
					for (String key2 : j.fooddata.keySet()) {
						if (key.equals(key2)) {
							j.addingorders();
							breakall = true;
							break;
						}
					}
				}
				if (breakall) {
					break;
				}
			}
			if (breakall) {
				break;
			}
		}
		for (String key : cart.keySet()) {
			System.out.println("QUANTITY OF ITEM : " + cart.get(key));
			for (String key1 : test.allsellers.keySet()) {
				boolean condition = true;
				seller j = test.allsellers.get(key1);
				if (condition) {
					for (String key2 : j.fooddata.keySet()) {
						if (key.equals(key2)) {
							condition = false;
							String sellertype = "";
							sellertype = test.allsellers.get(key1).getrestotype();
							if (sellertype.equals("FASTFOOD")) {
								int ffpoints = ffpoints(amount);
								j.addrewardpoints(ffpoints);
								points += ffpoints;
								pointsgainedtillnow += ffpoints;
							} else if (sellertype.equals("AUTHENTIC")) {
								int authenticpoints = authenticpoints(amount);
								j.addrewardpoints(authenticpoints);
								points += authenticpoints;
								pointsgainedtillnow += authenticpoints;
							} else {
								int restpoints = restpoints(amount);
								j.addrewardpoints(restpoints);
								points += restpoints;
								pointsgainedtillnow += restpoints;
							}
//							
							return;
						}
					}
				} else {
					break;
				}
			}
		}

	}

	@Override
	public double total_order_value(HashMap<String, Integer> mycart) {
		double totalamount = 0;
		for (String key : mycart.keySet()) {
			for (String key1 : test.allsellers.keySet()) {
				boolean condition = true;
				seller j = test.allsellers.get(key1);
				if (condition) {
					for (String key2 : j.fooddata.keySet()) {
						if (key.equals(key2)) {
							condition = false;
							double unitamount = j.fooddata.get(key2).getPrice();
							double discountamount = j.fooddata.get(key2).getOffer();
							totalamount += ((mycart.get(key)) * (unitamount * (100 - discountamount))) / 100;
							break;
						}
					}
				} else {
					break;
				}
				double restrauntdiscount = j.getdiscount();
				totalamount = (totalamount * (100 - restrauntdiscount)) / 100;
				if (customertype.equals("ELITE")) {
					totalamount -= elite(totalamount);
				} else if (customertype.equals("SPECIAL")) {
					totalamount -= special(totalamount);
				} else {
					totalamount -= normal(totalamount);
				}
			}
		}
		return totalamount;
	}

	@Override
	public void enternotcheckedunits(HashMap<String, Integer> cart) {
		for (String key : cart.keySet()) {
			System.out.println("QUANTITY OF ITEM : " + cart.get(key));
			for (String key1 : test.allsellers.keySet()) {
				boolean condition = true;
				seller j = test.allsellers.get(key1);
				if (condition) {
					for (String key2 : j.fooddata.keySet()) {
						if (key.equals(key2)) {
							condition = false;
							test.allsellers.get(key1).fooddata.get(key).setQuantity(
									test.allsellers.get(key1).fooddata.get(key).getQuantity() + cart.get(key));
							break;
						}
					}
				} else {
					break;
				}
			}
		}
	}

	@Override
	public double amountforauthentic(HashMap<String, Integer> cart, double amount) {
		for (String key : cart.keySet()) {
			System.out.println("QUANTITY OF ITEM : " + cart.get(key));
			for (String key1 : test.allsellers.keySet()) {
				boolean condition = true;
				seller j = test.allsellers.get(key1);
				if (condition) {
					for (String key2 : j.fooddata.keySet()) {
						if (key.equals(key2)) {
							condition = false;
							String sellertype = "";
							sellertype = test.allsellers.get(key1).getrestotype();
							if (sellertype.equals("AUTHENTIC")) {
								if (amount > 100) {
									return (amount / 2);
								}
							}
							return amount;
						}
					}
				} else {
					break;
				}
			}
		}
		return amount;
	}

	@Override
	public void alloptions() {
		HashMap<String, Integer> cart = new HashMap<>();
		while (true) {
			System.out.println(" 1 TO SELECT RESTRAUNT");
			System.out.println(" 2 TO CHECK OUT CART");
			System.out.println(" 3 REWARDS WON");
			System.out.println(" 4 TO PRINT RECENT ORDERS");
			System.out.println(" 5 TO EXIT");
			System.out.println(" ENTER OPTION : ");
			int num = scn.nextInt();
			if (num == 1) {
//				SELECT RESTRAUNT
				int index = 1;
				for (String key : test.allsellers.keySet()) {
					System.out.println(" " + index + " RESTRAUNT NAME : " + key + " RESTRAUNT TYPE : "
							+ test.allsellers.get(key).getrestotype());
				}
				System.out.println("ENTER RESTAURANTS NAME : ");
				String restonametoorder = scn.next();
				test.allsellers.get(restonametoorder).displayallitems();
				System.out.println("ENTER ITEM CODE : ");
				String codeforfood = scn.next();
				System.out.println("ENTER QUANTITY : ");
				int foodquantity = scn.nextInt();
				int quantitydealed = test.allsellers.get(restonametoorder).fooddata.get(codeforfood)
						.reductingquantity(foodquantity);
				if (quantitydealed > 0) {
					cart.put(codeforfood, quantitydealed);
				}
			} else if (num == 2) {
//				CHECKOUT CART
				if (cart.size() > 0) {
					for (String key : cart.keySet()) {
						System.out.println("\nQUANTITY OF ITEM : " + cart.get(key));
						for (String key1 : test.allsellers.keySet()) {
							boolean condition = true;
							seller j = test.allsellers.get(key1);
							if (condition) {
								for (String key2 : j.fooddata.keySet()) {
									if (key.equals(key2)) {
										condition = false;
										System.out.println();
										j.fooddata.get(key2).displayforcustomer();
										break;
									}
								}
							} else {
								break;
							}
						}
					}
					double cdelivery = deliverycharge();
					double foodamount = amountforauthentic(cart, total_order_value(cart));
					System.out.println("\nDELIVERY CHARGE : " + cdelivery);
					System.out.println("TOTAL FOOD VALUE : INR " + foodamount);
					System.out.println("\nENTER 1 TO CHECKOUT 2 TO NOT");
					int checkoutnum = scn.nextInt();
					if (checkoutnum == 1) {
						int deductedornot = deduction(foodamount + cdelivery);
						if (deductedornot == 0) {
							enternotcheckedunits(cart);
						} else if (deductedornot == 1) {
							application_money.moneyadddelivery(cdelivery);
							rewardpointsadder(cart, foodamount);
							System.out.println("ITEMS ARE SUCESSFULLY BOUGHT");
							ZOTATO_LOGO.random();
							allorders.add(cart);
							application_money.moneyadd((foodamount * 0.01));
							cart = new HashMap<>();
						}
					}
				}
			} else if (num == 3) {
//				REWARD WON
				System.out.println("THE REWARD POINTS GAINED TILL NOW : " + pointsgainedtillnow);
				System.out.println("THE REWARD POINTS PRESENT FOR USAGE : " + points);
			} else if (num == 4) {
//				PRINT RECENT ORDERS
				for (int i = 0; i < allorders.size(); i++) {
					HashMap<String, Integer> intermediate = allorders.get(i);
					System.out.println("ORDER NO : " + (i + 1));
					for (String key : intermediate.keySet()) {
						System.out.println("    ITEM ID : " + key + "  QUANTITY : " + intermediate.get(key));
					}
				}
			} else if (num == 5) {
//				EXIT
				break;
			}
		}

	}

//
	@Override
	public int deduction(double amount) {
		return moneydeduction(amount);
	}

	private int moneydeduction(double amount) {
		while (amount != 0) {
			if (points > 0) {
				if (points - amount <= 0) {
					double intermediate = points;
					this.points = 0;
					amount -= intermediate;
				} else {
					double intermediate = amount;
					amount = 0;
					this.points -= intermediate;
				}
			} else {
				if (wallet - amount < 0) {
					System.out.println("NOT ENOUGH MONEY PRESENT");
					return 0;
				} else {
					this.wallet -= amount;
					amount = 0;
				}
			}
		}
		return 1;
	}

	public String getname() {
		return name;
	}

	public String getaddress() {
		return address;
	}

	public String getcustomertype() {
		return customertype;
	}

	public double getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}
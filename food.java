import java.util.*;

class food implements food_interface {
	private String foodname;
	private double price;
	private int quantity;
	private String category;
	private double offer;
	private String itemcode;
	Scanner scn = new Scanner(System.in);

	food() {
		enterfood();
		codemaker();
	}

	@Override
	public void displayforcustomer() {
		System.out.println("ITEM CODE : " + itemcode);
		System.out.println("ITEM NAME: " + foodname);
		System.out.println("ITEM CATEGORY : " + category);
		System.out.println("ITEM PRICE : " + price);
		System.out.println("ITEM OFFER : " + offer + "%");
	}

	@Override
	public int reductingquantity(int requiredquantity) {
		if (quantity > 0) {
			if (requiredquantity > quantity) {
				System.out.println("REQUIRED QUANTITY IS NOT PRSENT , ONLY " + quantity
						+ " UNITS ARE PRESENT\n \nENTER 1 TO ORDER THE PRESENT UNITS AND 2 IF NOT");
				int option = scn.nextInt();
				if (option == 1) {
					int intermediate = quantity;
					System.out.println(intermediate + " " + foodname + " HAS BEEN ADDED TO YOUR CART");
					quantity = 0;
					return intermediate;
				} else {
					return 0;
				}
			} else {
				quantity -= requiredquantity;
				System.out.println(requiredquantity + " " + foodname + " HAS BEEN ADDED TO YOUR CART");
				return requiredquantity;
			}
		} else {
			System.out.println("ALL UNITS ARE SOLD OUT");
			return 0;
		}
	}

	@Override
	public void enterfood() {
		System.out.println("ENTER FOOD DETAILS ");
		System.out.println("ENTER FOOD NAME : ");
		this.foodname = scn.next();
		System.out.println("ENTER FOOD PRICE : ");
		this.price = scn.nextDouble();
		System.out.println("ENTER FOOD QUANTITY : ");
		this.quantity = scn.nextInt();
		System.out.println("ENTER FOOD CATEGORY : ");
		this.category = scn.next();
		System.out.println("ENTER FOOD OFFER : ");
		this.offer = scn.nextDouble();
	}

	@Override
	public void edititem(int num) {
		if (num == 1) {
//			NAME
			System.out.println("ENTER NEW NAME : ");
			String newname = scn.next();
			setFoodname(newname);
		} else if (num == 2) {
//			PRICE
			System.out.println("ENTER NEW PRICE : ");
			double newprice = scn.nextDouble();
			setPrice(newprice);
		} else if (num == 3) {
//			QUANTITY
			System.out.println("ENTER NEW QUANTITY : ");
			int newquantity = scn.nextInt();
			setQuantity(newquantity);
		} else if (num == 4) {
//			CATEGORY
			System.out.println("ENTER NEW CATEGORY : ");
			String newcategory = scn.next();
			setCategory(newcategory);
		} else if (num == 5) {
//			OFFER
			System.out.println("ENTER NEW OFFER : ");
			double newoffer = scn.nextDouble();
			setOffer(newoffer);
		}
		display();
	}

	@Override
	public void display() {
		System.out.println("ITEM CODE : " + itemcode);
		System.out.println("ITEM NAME: " + foodname);
		System.out.println("ITEM CATEGORY : " + category);
		System.out.println("ITEM PRICE : " + price);
		System.out.println("ITEM QUANTITY : " + quantity);
		System.out.println("ITEM OFFER : " + offer + "%");
	}

	@Override
	public void codemaker() {
		idmaker();
	}

	private void idmaker() {
		String foodid = foodname + Integer.toString((int) price) + Integer.toString(quantity) + category
				+ Integer.toString((int) offer) + Integer.toString(counter.count);
		this.itemcode = foodid;
		counter.count++;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public void setPrice(double newprice) {
		this.price = newprice;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setOffer(double newoffer) {
		this.offer = newoffer;
	}

	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}

	public String getFoodname() {
		return foodname;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getCategory() {
		return category;
	}

	public double getOffer() {
		return offer;
	}

	public String getItemcode() {
		return itemcode;
	}
}
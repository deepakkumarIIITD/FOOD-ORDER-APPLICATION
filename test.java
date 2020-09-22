import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class test extends ZOTATO_LOGO {
	public static HashMap<String, seller> allsellers = new HashMap<>();

	public static HashMap<String, customer> allcustomers = new HashMap<>();

	public static void sellernamesdisplay() {
		int indexing = 1;
		for (String key : allsellers.keySet()) {
			System.out.println(" " + indexing + " " + allsellers.get(key).getrestoname() + " ("
					+ allsellers.get(key).getrestotype() + ")");
			indexing++;
		}

	}

	public static void customernamesdisplay() {
		int indexing = 1;
		for (String key : allcustomers.keySet()) {
			System.out.println(" " + indexing + " " + allcustomers.get(key).getname());
			indexing++;
		}
	}

	public static void main(String[] args) {
		dataadding();
		logo();
		Scanner scn = new Scanner(System.in);
		while (true) {
			System.out.println("\nWELCOME TO ZOTATO");
			System.out.println("\n 1 ENTER AS RESTAURANT OWNER");
			System.out.println(" 2 ENTER AS CUSTOMER");
			System.out.println(" 3 CHECK USER DETAILS");
			System.out.println(" 4 COMPANY ACCOUNT DETAILS");
			System.out.println(" 5 EXIT");
			System.out.println("ENTER OPTION");
			int num = scn.nextInt();
			if (num == 1) {
				sellernamesdisplay();
				System.out.println("\nENTER RESTRAUNTS NAME : ");
				String restonam = scn.next();
				allsellers.get(restonam).methods();
			} else if (num == 2) {
				customernamesdisplay();
				System.out.println("\nENTER CUSTOMER NAME : ");
				String custnam = scn.next();
				allcustomers.get(custnam).alloptions();
			} else if (num == 3) {
				System.out.println("\nENTER 1 TO SEE CUSTOMERS DATA");
				System.out.println("ENTER 2 TO SEE THE RESTRAUNTS DATA");
				System.out.println("ENTER OPTION");
				int optionnum = scn.nextInt();
				if (optionnum == 1) {
					customernamesdisplay();
					System.out.println("\nENTER CUSTOMER NAME : ");
					String custnam = scn.next();
					allcustomers.get(custnam).displayer();
				} else if (optionnum == 2) {
					sellernamesdisplay();
					System.out.println("\nENTER RESTRAUNTS NAME : ");
					String restonam = scn.next();
					allsellers.get(restonam).displayresto();
				}
			} else if (num == 4) {
				System.out.println("ZOTATO EARNINGS - ");
				System.out.println("EARNINGS FROM THE RESTRAUNTS : " + application_money.getcreatormoney());
				System.out.println("EARNINGS FROM THE DELIVERY : " + application_money.getdeliverymoney());
			} else if (num == 5) {
				logo();
				break;
			}
		}
	}

	public static void dataadding() {
		seller s1 = new seller("HALDIRAM", "NORMAL", "DELHI");
		seller s2 = new seller("ITC", "AUTHENTIC", "PUNE");
		seller s3 = new seller("BITTOTIKKIVALA", "FASTFOOD", "DELHI");
		seller s4 = new seller("GULAB", "NORMAL", "UP");
		seller s5 = new seller("KARIM", "AUTHENTIC", "LUCKNOW");
		allsellers.put(s1.getrestoname(), s1);
		allsellers.put(s2.getrestoname(), s2);
		allsellers.put(s3.getrestoname(), s3);
		allsellers.put(s4.getrestoname(), s4);
		allsellers.put(s5.getrestoname(), s5);
		customer c1 = new customer("CARRYMINATI", "NORMAL", "NOIDA");
		customer c2 = new customer("JETHALAL", "SPECIAL", "MUMBAI");
		customer c3 = new customer("TRUMP", "ELITE", "USA");
		customer c4 = new customer("MODI", "SPECIAL", "DELHI");
		customer c5 = new customer("JINGPING", "NORMAL", "CHINA");
		allcustomers.put(c1.getname(), c1);
		allcustomers.put(c2.getname(), c2);
		allcustomers.put(c3.getname(), c3);
		allcustomers.put(c4.getname(), c4);
		allcustomers.put(c5.getname(), c5);
	}
}
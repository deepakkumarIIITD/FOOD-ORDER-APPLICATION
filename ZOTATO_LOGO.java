import java.util.*;

public class ZOTATO_LOGO {
	public static void logo() {
		System.out.println(" /$$$$$$$$  /$$$$$$  /$$$$$$$$ /$$$$$$  /$$$$$$$$ /$$$$$$ ");
		System.out.println("|_____ $$  /$$__  $$|__  $$__//$$__  $$|__  $$__//$$__  $$");
		System.out.println("     /$$/ | $$  \\ $$   | $$  | $$  \\ $$   | $$  | $$  \\ $$");
		System.out.println("    /$$/  | $$  | $$   | $$  | $$$$$$$$   | $$  | $$  | $$");
		System.out.println("   /$$/   | $$  | $$   | $$  | $$__  $$   | $$  | $$  | $$");
		System.out.println("  /$$/    | $$  | $$   | $$  | $$  | $$   | $$  | $$  | $$");
		System.out.println(" /$$$$$$$$|  $$$$$$/   | $$  | $$  | $$   | $$  |  $$$$$$/");
		System.out.println("|________/ \\______/    |__/  |__/  |__/   |__/   \\______/ ");
	}

	public static void pie() {
		System.out.println();
		System.out.println("         (           ");
		System.out.println("          )          ");
		System.out.println("     __..---..__     ");
		System.out.println(" ,-='  /  |  \\  `=-.");
		System.out.println(":--..___________..--:");
		System.out.println(" \\.,_____________,./");
		System.out.println(" PEOPLE WHO LOVE TO EAT ARE ALWAYS THE BEST PEOPLE \n");
	}

	public static void pizza() {
		System.out.println();
		System.out.println("        _....._        ");
		System.out.println("    _.:`.--|--.`:._    ");
		System.out.println("  .: .'\\o  | o /'. '.  ");
		System.out.println(" // '.  \\ o|  //  o '.\\ ");
		System.out.println("//'._o'. \\ |o/ o_.-'o\\");
		System.out.println("|| o '-.'.\\|/.-' o   ||");
		System.out.println("||--o--o-->|           ");
		System.out.println(" YOU DONT NEED A SILVER FORK TO EAT GOOD FOOD \n");
	}

	public static void chocolate() {
		System.out.println();
		System.out.println(" _____________,-.___     _   ");
		System.out.println("|____        { {]_]_]   [_]  ");
		System.out.println("|___ `-----.__\\ \\_]_]_    .`");
		System.out.println("|   `-----.____} }]_]_]_   , ");
		System.out.println("|_____________/ {_]_]_]_] , `");
		System.out.println("              `-'            ");
		System.out.println(" LAUGHTER IS BRIGHTEST WHERE THE FOOD IS BEST \n");
	}

	public static void random() {
		Random r = new Random();
		int result = r.nextInt(3) + 1;
		if (result == 1) {
			pie();
		} else if (result == 2) {
			pizza();
		} else if (result == 3) {
			chocolate();
		}
	}
}
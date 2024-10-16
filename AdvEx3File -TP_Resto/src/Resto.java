
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Resto {

	public static void main(String[] args) {

		String[] arrEntree = { "[1 - SALADE]", "[2 - SOUPE]", "[3 - QUICHE]", "[4 - AUCUNE]" };
		String[] arrPlats = { "[1 - POULET]", "[2 - BOEUF]", "[3 - POISSON]", "[4 - VEGETARIEN]", "[5 - VEGAN]",
				"[6 - AUCUN]" };
		String[] arrAccompagnements = { "[1 - RIZ]", "[2 - PATES]", "[3 - FRITES]", "[4 - LEGUMES]", "[5 - AUCUN]" };
		String[] arrBoissons = { "[1 - EAU PLATE]", "[2 - EAU GAZEUZE]", "[3 - SODA]", "[4 - VIN]", "[5 - AUCUNE]" };
		String[] arrDesserts = { "[1 - TARTE MAISON]", "[2 - MOUSSE AU CHOCOLAT]", "[3 - TIRAMISU]", "[4 - AUCUN]" };

		String[] categories = { "entree", "plats", "accompagnements", "boissons", "desserts" };

		ArrayList<String[]> menu = new ArrayList<>();
		menu.add(arrEntree);
		menu.add(arrPlats);
		menu.add(arrAccompagnements);
		menu.add(arrBoissons);
		menu.add(arrDesserts);

		System.out.println("Bonjour, combien de menus souhaitez vous ?");
		Scanner sc = new Scanner(System.in);
		int nbMenusChosen = sc.nextInt();

		HashMap<Integer, ArrayList<String>> orderedMenus = new HashMap<>();

		for (int i = 1; i <= nbMenusChosen; i++) {
			ArrayList<String> selectedDishes = new ArrayList<>();

			System.out.println("Commande numéro " + i);

			for (int j = 0; j < categories.length; j++) {
				String choice = displayUserInterface(sc, categories[j], menu.get(j), menu, j);

				if (!choice.equals("aucun") && !choice.equals("aucune")) {
					selectedDishes.add(choice);
				}
			}

			orderedMenus.put(i, selectedDishes);

			System.out.println("Résumé de la commande " + i + "\n" + selectedDishes + "\n");

		}
		addOrderToFile(orderedMenus);
	}

	public static void addOrderToFile(HashMap<Integer, ArrayList<String>> orderedMenus) {

		File orderFile = new File("order.txt");

		try {
			if (!orderFile.exists()) {
				orderFile.createNewFile();
			}

			try {
				FileWriter writer = new FileWriter(orderFile);
				BufferedWriter bw = new BufferedWriter(writer);

				orderedMenus.forEach((key, value) -> {
					try {
						bw.write("\n*************************** Résumé de la commande " + key
								+ " ***************************\n");
						bw.write(String.join("\n", value));
					} catch (Exception e) {
						e.printStackTrace();
					}

				});
				bw.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String userChoicePlat(int choice, ArrayList<String[]> menu, int index) {

		String userChoiceName = "";
		int length = menu.get(index).length;

		for (int i = 0; i < length; i++) {
			if (choice - 1 == i) {
				userChoiceName = menu.get(index)[i].replaceAll("[\\[\\]\\d-]", "").trim().toLowerCase();
			}
		}
		return userChoiceName;
	}

	public static String displayPlats(String[] array) {

		String arrString = "";

		for (int i = 0; i < array.length; i++) {
			arrString += array[i];
		}
		return arrString;
	}

	public static String displayUserInterface(Scanner sc, String menuName, String[] arrMenuType,
			ArrayList<String[]> menu, int menuIndex) {
		int userInputchoice = 0;

		System.out.println("choix d'" + menuName + " :\n" + displayPlats(arrMenuType) + "\nque souhaitez vous comme "
				+ menuName + " ? [saisir le chiffre correspondant]");
		userInputchoice = sc.nextInt();

		return userChoicePlat(userInputchoice, menu, menuIndex);
	}
}
package GameManagementProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Game {
	int gameId;
	String gameName;
	String gamePlatform;
	String gameGenre;
	int gamePrice;

	public static void toInsertAGame() {
		System.out.println("Inserting a New Game");
		Game gameData = new Game();
		Scanner input = new Scanner(System.in);

		System.out.println("Game Name: ");
		gameData.gameName = input.next();

		System.out.println("Game Platform: ");
		gameData.gamePlatform = input.next();

		System.out.println("Game Genre: ");
		gameData.gameGenre = input.next();

		System.out.println("Game Price: ");
		gameData.gamePrice = input.nextInt();

		DbOperationGame.toAddGames(gameData);
	}

	public static void toRemoveAGame() {
		System.out.println("Removing a Game");
		Scanner input = new Scanner(System.in);

		System.out.print("Enter an ID to be removed: ");
		int id = input.nextInt();

		if (DbOperationGame.gameExists(id)) {
			DbOperationGame.toRemoveGame(id);
			System.out.println("Game With " + id + " is removed successfully!!!");
		} else {
			System.err.println("Game With " + id + " Does Not Exit!!!");
		}
	}

	public static void toUpdateAGame() {
		System.out.println("Updating a Game");
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an ID to be Updated: ");
		int id = input.nextInt();

		if (DbOperationGame.gameExists(id)) {
			System.out.println("1. Update Name");
			System.out.println("2. Update Game Platform");
			System.out.println("3. Update Genre");
			System.out.println("4. Update Price");
			System.out.print("Enter a Choice: ");

			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter updated name: ");
				DbOperationGame.toUpdateName(id, input.next());
				break;
			case 2:
				System.out.println("Enter updated Platform: ");
				DbOperationGame.toUpdatePlatform(id, input.next());
				break;
			case 3:
				System.out.println("Enter updated Genre: ");
				DbOperationGame.toUpdateGenre(id, input.next());
				break;
			case 4:
				System.out.println("Enter updated Price: ");
				DbOperationGame.toUpdatePrice(id, input.nextInt());
				break;

			default:
				System.err.println("Enter a Valid choice!!!");
				break;
			}
		} else {
			System.err.println("Game with id " + id + " does not exist!!!");
		}
	}

	public static void toDisplayAGameDatabase() {
		HashMap<Integer, Game> gamesdb =DbOperationGame.toGetAllGameData();
		System.out.println("Displaying All Games data");
		System.out.println("*************************************************");
		System.out.println("ID \t Name \t Platform \t Genre \t Price");
		System.out.println("*************************************************");
		for (Map.Entry<Integer, Game> gameEntry :gamesdb.entrySet()) {
			System.out.print(gameEntry.getKey() + "\t");
			System.out.print(gameEntry.getValue().gameName + "\t");
			System.out.print(gameEntry.getValue().gamePlatform + "\t");
			System.out.print(gameEntry.getValue().gameGenre + "\t");
			System.out.println(gameEntry.getValue().gamePrice + "\t");
			System.out.println("**********************************************");
		}
	}

	public static void toSearchAGame() {
		System.out.println("Searching a Game");
		Scanner input = new Scanner(System.in);

		System.out.print("Enter an ID to be Searched: ");
		int id = input.nextInt();

		if (DbOperationGame.gameExists(id)) {
			Game GameObj = DbOperationGame.toSearchGame(id);
			System.out.println("Game ID            : " + GameObj.gameId);
			System.out.println("Game Name          : " + GameObj.gameName);
			System.out.println("Game Platform      : " + GameObj.gamePlatform);
			System.out.println("Game Genre         : " + GameObj.gameGenre);
			System.out.println("Game Price         : " + GameObj.gamePrice);
			System.out.println("Game data printed Successfully!!!\n");
		} else {
			System.err.println("Game With id " + id + " does not Exist!!!");
		}
	}
}
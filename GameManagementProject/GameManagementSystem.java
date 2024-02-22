package GameManagementProject;

import java.util.Scanner;


public class GameManagementSystem {
				
		private static void printMenu() {

			System.out.println("1.Games Creation");
			System.out.println("2.Remove a Games ");
			System.out.println("3.Update a Games ");
			System.out.println("4.Display all Games Data ");
			System.out.println("5.Search a Games ");
			System.out.println("6.Exit Application ");
			System.out.print("Enter Your Choice: ");
		}

		public static void main(String[] args) {

			System.out.println("\t\t Games Management System ");
			System.out.println("\t\t---------------------------");

			Scanner input = new Scanner(System.in);
			while (true) {
				printMenu();

				int choice = input.nextInt();
				switch (choice) {
				case 1:
					Game.toInsertAGame();
					break;
				case 2:
					Game.toRemoveAGame();
					break;
				case 3:
					Game.toUpdateAGame();
					break;
				case 4:
					Game.toDisplayAGameDatabase();
					break;
				case 5:
					Game.toSearchAGame();
					break;
				case 6:
					System.out.println("Application Exited !!!");
					input.close();
					return;
				default:
					System.err.println(" !!!*** Enter a Valid Choice ***!!! ");

				}

			}
		}

	}

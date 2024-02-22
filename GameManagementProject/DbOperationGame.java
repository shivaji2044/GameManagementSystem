package GameManagementProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DbOperationGame {
	private static final String host = "jdbc:mysql://localhost:3306/gamesdb";
	private static final String username = "root";
	private static final String password = "2044";

	// Connection method
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(host, username, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void toAddGames(Game gameData) {
		try {
			Connection con = getConnection();
			String query = "Insert into game(gameName,gamePlatform,gameGenre,gamePrice) values(?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, gameData.gameName);
			stmt.setString(2, gameData.gamePlatform);
			stmt.setString(3, gameData.gameGenre);
			stmt.setInt(4, gameData.gamePrice);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Game Creation Successfully !!!\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static HashMap<Integer, Game> toGetAllGameData() {
		try {
			Connection con = getConnection();
			String query = "Select * from game";
			PreparedStatement stmt = con.prepareStatement(query);
			ResultSet result = stmt.executeQuery(query);
			HashMap<Integer, Game> gameDatabase = new HashMap<>();
			while (result.next()) {
				Game obj = new Game();
				obj.gameId = result.getInt(1);
				obj.gameName = result.getString(2);
				obj.gamePlatform = result.getString(3);
				obj.gameGenre = result.getString(4);
				obj.gamePrice = result.getInt(5);
				gameDatabase.put(obj.gameId, obj);
			}
			stmt.close();
			con.close();
			return gameDatabase;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean gameExists(int id) {
		try {
			Connection con = getConnection();
			String query = "select*from game where gameid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			boolean flag = result.next();
			con.close();
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void toRemoveGame(int id) {
		try {
			Connection con = getConnection();
			String query = "Delete from game where gameid = ?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Game With " + id + " is removed successfully!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static Game toSearchGame(int id) {

		try {
			Connection con = getConnection();
			String query = "Select * from game where gameid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			Game gameData = new Game();
			result.next();
			gameData.gameId = result.getInt(1);
			gameData.gameName = result.getString(2);
			gameData.gamePlatform = result.getString(3);
			gameData.gameGenre = result.getString(4);
			gameData.gamePrice = result.getInt(5);
			stmt.close();
			con.close();
			return gameData;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void toUpdateName(int id, String name) {
		try {
			Connection con = getConnection();
			String query = "Update game set gameName=? where gameid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Game name is updated Successfully!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void toUpdatePlatform(int id, String platform) {
		try {
			Connection con = getConnection();
			String query = "Update game set gamePlatform=? where gameid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, platform);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Game Platform is updated Successfully!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void toUpdateGenre(int id, String Genre) {
		try {
			Connection con = getConnection();
			String query = "Update game set gameGenre=? where gameid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, Genre);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Game Genre is updated Successfully!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void toUpdatePrice(int id, int number) {
		try {
			Connection con = getConnection();
			String query = "Update game set gamePrice=? where gameid=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, number);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Game Price is updated Successfully!!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
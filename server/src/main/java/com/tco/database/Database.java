package com.tco.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import com.tco.gamemanagement.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Database {

    private Connection conn = null;
    private PreparedStatement nameStatement = null;
    private PreparedStatement countStatement = null;
    private Statement test = null;

    private final static String TABLE = "users";
	private final static String COLUMNS = "uuid,users";

    private static Logger log = LoggerFactory.getLogger(Database.class);

    public Database() {
        try {
            conn = DriverManager.getConnection(Credential.url(), Credential.USER, Credential.PASSWORD);
            test = conn.createStatement();
        } catch (SQLException se) {
            log.error("SQL Exception: " + se.getMessage());
        }
	}

	  public static User getUserById(UUID userID){
		String sql = "SELECT * From " + TABLE + " WHERE uuid = ?";
		String url      = Credential.url();
		String user     = Credential.USER;
		String password = Credential.PASSWORD;
		String jsonUser = "";
		
		try (
			// connect to the database and query
			Connection conn    = DriverManager.getConnection(url, user, password);
			PreparedStatement  query   = conn.prepareStatement(sql);
			
		) {
			query.setString(1, userID.toString());
			ResultSet results = query.executeQuery();
			if(results.next()){
				jsonUser = results.getString("users");
			}
			return new Gson().fromJson(jsonUser, User.class);
		} catch (SQLException e) {
		log.warn("SQL FAILED", e);
		} catch (Exception e) {
			log.warn("FAILED", e);
		throw e;
	}
		return null;
	  }

      public static List<User> users(String match, Integer limit) throws Exception {
			String sql      = Select.match(match, limit);
			String url      = Credential.url();
			String user     = Credential.USER;
			String password = Credential.PASSWORD;
			try (
				// connect to the database and query
				Connection conn    = DriverManager.getConnection(url, user, password);
				Statement  query   = conn.createStatement();
				ResultSet  results = query.executeQuery(sql)
			) {
				return convertResultUser(results, COLUMNS);
			} catch (Exception e) {
				throw e;
			}
		}

		public static List<User> getAllUsers() throws Exception {
			String sql      = "SELECT * FROM users";
			String url      = Credential.url();
			String user     = Credential.USER;
			String password = Credential.PASSWORD;
			try (
				// connect to the database and query
				Connection conn    = DriverManager.getConnection(url, user, password);
				Statement  query   = conn.createStatement();
				ResultSet  results = query.executeQuery(sql)
			) {
				return convertResultUser(results, COLUMNS);
			} catch (Exception e) {
				throw e;
			}
		}

		public static void addUserDB(User addUser){

			Gson gson = new Gson();
			String url      = Credential.url();
			String user     = Credential.USER;
			String password = Credential.PASSWORD;

			//Serialize the user object into a string for storage
			//Most effienct way to get something quick
			String jsonUser = gson.toJson(addUser);
			UUID userId = addUser.getProfile().getUserId();
			
			String sql = "INSERT INTO " + TABLE + " (uuid, users) VALUES (?, ?)";
			try{
				Connection conn    = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, userId.toString());
				statement.setString(2, jsonUser);
				statement.executeUpdate();
				conn.commit();
			}
			catch( Exception e){
				log.error("Failed to insert new user {} ", userId, e);
			}
		}

		public static void updateUserDB(User userUpdate){

			Gson gson = new Gson();
			String url      = Credential.url();
			String user     = Credential.USER;
			String password = Credential.PASSWORD;
			UUID userId = userUpdate.getProfile().getUserId();
			String jsonUser = gson.toJson(userUpdate);
			
			
			String sql = "UPDATE " + TABLE + " SET users = ? WHERE uuid = ?";
			
			try{
				Connection conn    = DriverManager.getConnection(url, user, password);
				PreparedStatement statement = conn.prepareStatement(sql);

				statement.setString(1, jsonUser);
				statement.setString(2, userId.toString());
				statement.executeUpdate();
			}
			catch( Exception e){
				log.error("Failed to update user {} ", userId, e);
			}
		}

        //TODO: Need better setters for user
        private static List<User> convertResultUser(ResultSet results, String columns) throws Exception {
			int count = 0;
			String[] cols = columns.split(",");
			ArrayList<User> userList = new ArrayList<>();
			Gson gson = new Gson();

			while (results.next()) {
				User user = null;
				for (String col: cols) {
                    switch (col) {
                        case "uuid":
							//do nothing for now
                            // user.setUsername(results.getString(col));
                            break;
                        case "users":
                            user = gson.fromJson(results.getString(col), User.class);
							userList.add(user);
                            break;
                        default:
                            //nothing
                    }
					
				}
			}
			return userList;
		}

        private static Integer count(ResultSet results) throws Exception {
			if (results.next()) {
				return results.getInt("count");
			}
			throw new Exception("No count results in found query.");
		}

		static class Select {
			static String match(String match, int limit) {
				return statement(match, "DISTINCT " + COLUMNS, "LIMIT " + limit);
			}
	
			static String found(String match) {
				return statement(match, "COUNT(*) AS count ", "");
			}
	
			static String statement(String match, String data, String limit) {
				return "SELECT "
					+ data
					+ " FROM " + TABLE
					+ " WHERE name LIKE \"%" + match + "%\" "
					+ limit
					+ " ;";
			}
		}

        static Integer found(String match) throws Exception {
			String sql = Select.found(match);
			try (
				// connect to the database and query
				Connection conn = DriverManager.getConnection(Credential.url(), Credential.USER, Credential.PASSWORD);
				Statement query = conn.createStatement();
				ResultSet results = query.executeQuery(sql)
			) {
				return count(results);
			} catch (Exception e) {
				throw e;
			}
		}

    }   
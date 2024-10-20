package com.tco.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import com.tco.gamemanagement.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private Connection conn = null;
    private PreparedStatement nameStatement = null;
    private PreparedStatement countStatement = null;
    private Statement test = null;
    private final static String TABLE = "users";
    private static Logger log = LoggerFactory.getLogger(Database.class);

    public Database() {
        try {
            conn = DriverManager.getConnection(Credential.url(), Credential.USER, Credential.PASSWORD);
            test = conn.createStatement();
        } catch (SQLException se) {
            log.error("SQL Exception: " + se.getMessage());
        }

        static List<User> users(String match, Integer limit) throws Exception {
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

        //TODO: Need better setters for user
        private static List<User> convertResultUser(ResultSet results, String columns) throws Exception {
			int count = 0;
			String[] cols = columns.split(",");
			ArrayList<User> userList = new ArrayList<>();

			while (results.next()) {
				User user = new User();
				for (String col: cols) {
                    switch (col) {
                        case "username":
                            user.setUsername(results.getString(col));
                            break;
                        case "email":
                            //user.setEmail(results.getString(col));
                            break;
                        default:
                            //nothing
                    }
					userList.add(user);
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

}
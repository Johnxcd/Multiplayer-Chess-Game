package com.tco.database;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tco.gamemanagement.User;

public class TestDataBase {

    private Database database;

    @BeforeEach
    public void createConfigurationForTestCases() {
        database = new Database();
    }

    @Test
    @DisplayName("sam25: testAddDB")
    public void testSimpleAdd() {
        User user = new User("Test1");
        //set the uuid so we dont over flood the DB
        UUID uuid = UUID.fromString("51220858-9033-47a1-8bf7-76533fe7926a");
        user.getProfile().setUserId(uuid);
        Database.addUserDB(user);
        
        User retrievedUser = database.getUserById(uuid);
        assertEquals(uuid, retrievedUser.getProfile().getUserId());
        assertNotNull(retrievedUser.getUserName());
    }

    @Test
    @DisplayName("sam25: testUpdate DB")
    public void testSimpleUpdate() {
        User user = new User("Test1 UPDATE");
        //set the uuid so we dont over flood the DB
        UUID uuid = UUID.fromString("66720858-9033-48b2-8bf7-76533fe7926a");
        user.getProfile().setUserId(uuid);
        Database.addUserDB(user);
        
        String newUserName = "newUser";
        user.getProfile().setUserName(newUserName);

        Database.updateUserDB(user);

        User retrievedUser = database.getUserById(uuid);
        assertEquals(uuid, retrievedUser.getProfile().getUserId());
        assertEquals("newUser", retrievedUser.getUserName());
    }

    @Test
    @DisplayName("sam25: testGetAllUsers DB")
    public void testGetAllUsers() throws Exception{
        User user1 = new User("Test1 UPDATE");
        UUID uuid1 = UUID.fromString("66720858-9033-48b2-8bf7-76533fe7926a");
        user1.getProfile().setUserId(uuid1);

        User user2 = new User("Test2 UPDATE");
        UUID uuid2 = UUID.fromString("14620858-8033-48b2-8bf7-76533fe7926a");
        user2.getProfile().setUserId(uuid2);

        User user3 = new User("Test3 UPDATE");
        UUID uuid3 = UUID.fromString("12777788-9033-48b2-8bf7-76533fe7926a");
        user3.getProfile().setUserId(uuid3);
        
        Database.addUserDB(user1);
        Database.addUserDB(user2);
        Database.addUserDB(user3);

        List<User> users = Database.getAllUsers();

        Boolean firstFound = false;
        Boolean secondFound = false;
        Boolean thirdFound = false;
        
        for (User user : users){
            if(user.getProfile().getUserId() == user1.getProfile().getUserId()){
                firstFound = true;
            }
            if(user.getProfile().getUserId() == user2.getProfile().getUserId()){
                secondFound = true;
            }
            if(user.getProfile().getUserId() == user3.getProfile().getUserId()){
                thirdFound = true;
            }
        }
        assertTrue(firstFound);
        assertTrue(secondFound);
        assertTrue(thirdFound);
    }

    @Test
    @DisplayName("sam25: getUserById DB")
    public void testGetUserById() throws Exception{
        User user = new User("Test1");
        //set the uuid so we dont over flood the DB
        UUID uuid = UUID.fromString("51220858-9033-47a1-8bf7-76533fe7926a");
        user.getProfile().setUserId(uuid);
        Database.addUserDB(user);

        User foundUser = Database.getUserById(uuid);

        assertNotNull(foundUser);
        assertEquals(uuid, foundUser.getProfile().getUserId());
    }

    @Test
    @DisplayName("sam25: testBadUserId DB")
    public void testGetUserByIdFail() throws Exception{
       
        UUID uuid = UUID.fromString("11111111-1111-0000-0000-76533fe7926a");

        User foundUser = Database.getUserById(uuid);

        assertNull(foundUser);
    }

    @Test
    @DisplayName("sam25: testAddSameId DB")
    public void testAddSameId() throws Exception{
        User user1 = new User("Test1 UPDATE");
        UUID uuid = UUID.fromString("66720858-9033-48b2-8bf7-76533fe7926a");
        user1.getProfile().setUserId(uuid);

        User user2 = new User("Test1 UPDATE");
        //Use same Id
        user2.getProfile().setUserId(uuid);

        Database.addUserDB(user1);
        Database.addUserDB(user2);

        List<User> users = Database.getAllUsers();

        List<User> userFound = new ArrayList<>();

        for(User user : users){
            if(user.getProfile().getUserId() == uuid){
                userFound.add(user);
            }
        }

        assertNotNull(userFound);
        assertTrue(userFound.size() == 1);
        assertEquals(uuid, userFound.get(0).getProfile().getUserId());
    }

    @Test
    @DisplayName("sam25: testFound DB")
    public void testFound() throws Exception{
        
        //Adding user for safety
        User user1 = new User("Test1 UPDATE");
        UUID uuid = UUID.fromString("66720858-9033-48b2-8bf7-76533fe7926a");
        user1.getProfile().setUserId(uuid);

        Database.addUserDB(user1);

        int foundNumber = Database.found("*");
        
        assertTrue(foundNumber > 0);

    }

    @Test
    @DisplayName("sam25: testUsersMatch DB")
    public void testUsersMatch() throws Exception{
        
        //Adding user for safety
        User user1 = new User("Test1 UPDATE");
        UUID uuid = UUID.fromString("66720858-9033-48b2-8bf7-76533fe7926a");
        user1.getProfile().setUserId(uuid);

        Database.addUserDB(user1);

        //Does not mean we get the user we added, we just get the first user found
        List<User> users = Database.users("*", 1);
        
        assertTrue(users.size() == 1);

    }

}
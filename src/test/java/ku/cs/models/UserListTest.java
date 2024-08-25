package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {

    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        User user1 = new User("Aomsin", "aomsin123");
        User user2 = new User("Khaotung", "khaotung123");
        User user3 = new User("First", "first123");

        UserList userlist = new UserList();
        userlist.addUser("Aomsin", "aomsin123");
        userlist.addUser("Khaotung", "khaotung123");
        userlist.addUser("First", "first123");

        // TODO: find one of them
        User findUser = userlist.findUserByUsername("Aomsin");


        // TODO: assert that UserList found User
        // String expected = "<one of username>";
        // String actual = user.getUsername();
        // assertEquals(expected, actual);
        String expected = "Aomsin";
        String actual = findUser.getUsername();
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        UserList userlist = new UserList();
        userlist.addUser("Aomsin", "aomsin123");
        userlist.addUser("Khaotung", "khaotung123");
        userlist.addUser("First", "first123");

        // TODO: change password of one user
        boolean result = userlist.changePassword("Aomsin", "aomsin123", "luvkhaofirst");
        assertTrue(result);

        // TODO: assert that user can change password
        boolean isPasswordValid = userlist.verifyPassword("Aomsin", "luvkhaofirst");
        assertTrue(isPasswordValid);

        boolean isOldPasswordValid = userlist.verifyPassword("Aomsin", "aomsin123");
        assertFalse(isOldPasswordValid);
    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        UserList userlist = new UserList();
        userlist.addUser("Aomsin", "aomsin123");
        userlist.addUser("Khaotung", "khaotung123");
        userlist.addUser("First", "first123");

        // TODO: call login() with correct username and password
        User user = userlist.login("Aomsin", "aomsin123");

        // TODO: assert that User object is found
        // assertEquals(expected, actual);
        assertEquals(userlist.login("Aomsin", "aomsin123"), user);
        //user จะทำการเช็ค username แล้วตรง userlist.login ค่อยมาเช็ค password
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        UserList userlist = new UserList();
        userlist.addUser("Aomsin", "aomsin123");
        userlist.addUser("Khaotung", "khaotung123");
        userlist.addUser("First", "first123");

        // TODO: call login() with incorrect username or incorrect password
        User user = userlist.login("Aomsin", "aomsin1234");
        // TODO: assert that the method return null
        // assertNull(actual);
        assertNull(user);
    }

}
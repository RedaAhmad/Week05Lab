package models;

/**
 *
 * @author reda_
 *
 */
public class User {

    private String username;

    private String password;



    public User(String username, String password) {

        this.username = username;

        this.password = password;

        }

    public static User login(String username, String password) {

        if (password.equals("password") && username.equals("abe") || username.equals("barb")) {

            User person = new User(username, password);

            return person;

        } else {

            return null;

        }

    }

}

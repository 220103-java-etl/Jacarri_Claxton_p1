package DB;

import Models.Role;
import Models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * This MockDB Class is to represent a persistent store for our application's data.
 * It has static arrays that hold info on each of the entities/models that our
 * application needs.
 */
public class MockDB {

    public static int userIndex = 0;
    public static List<User> users = new ArrayList<>();

    public static int authorIndex = 0;
    public static List<Role> roles = new ArrayList<>();

    // static code blocks will execute when the class is loaded
    static {
        // creating mock users
        users.add(new User(1, "Jacarri1999", "Passpass22", "Employee", "password"));
        users.add(new User(2, "Jay69", "YourBarber23", "Employee", "password"));
        users.add(new User(3, "MyMom85", "MuscleMan74", "Employee", "password"));
        users.add(new User(4, "DanTheMan", "Dan26", "Finance Manager","password"));

    }
}


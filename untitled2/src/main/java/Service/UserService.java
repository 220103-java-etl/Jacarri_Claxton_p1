package Service;

import Models.User;
import Repository.UserDAO;

import java.util.List;
import java.util.Optional;


    /**
     * The UserService should handle the processing and retrieval of Users for the ERS application.
     *
     * {@code getByUsername} is the only method required;
     * however, additional methods can be added.
     *
     * Examples:
     * <ul>
     *     <li>Create User</li>
     *     <li>Update User Information</li>
     *     <li>Get Users by ID</li>
     *     <li>Get Users by Email</li>
     *     <li>Get All Users</li>
     * </ul>
     */
    public class UserService {

        private UserDAO userDAO = new UserDAO();

        //method to login
        public boolean login(String username, String password) {
            User u = userDAO.getByUsername(username).get();
            //First we need the help of our UserDAO to retrieve user information by their username.

            // Check if user exists
            if (u != null) {
                // check to make sure credentials match
                if (username.equals(u.getUsername()) && password.equals(u.getPassword())) {
                    return true;
                }
            }
            System.out.println("Credentials do not match"); // this would be a great place to use a custom
            return false;
        }
        public List<User> getAll() {
            return userDAO.getAll();

        }
        public Optional<User> getByUsername(String username) {
            return userDAO.getByUsername(username);
        }

    }


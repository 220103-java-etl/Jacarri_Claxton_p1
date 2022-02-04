package App;

import DB.MockDB;
import Models.User;
import Repository.UserDAO;
import Service.UserService;

import java.util.List;
import java.util.Scanner;

public class AppDriver {

            private static Scanner scanner = new Scanner(System.in);
            private static UserService userService = new UserService();
            private static UserDAO userDAO = new UserDAO();


            public static void main(String[] args) {

                // Manual Tests to see that our DAO methods are working...(you will need to look and query your database to be sure!)
                // Same work flow for Users.
                List<User>  users = userDAO.getAll();

                User l = new User(1, " "," ",  " ", " ");
                System.out.println("Adding User: " + l);
                l = UserDAO.add(); // the way we've written the add method - it will return an Author object with its newly assigned id from the serial sequence that postgres is in charge of.
                System.out.println("The User should now have an id");
                System.out.println(l);

                System.out.println("Getting an employee by id");
                User a2 =(userDAO.getById(l.getId()));
                System.out.println("This should be our newly added User: " + a2);

                System.out.println("Updating User");
                l.setFirstName("George R.R.");
                userDAO.update(l);
                System.out.println("We should see the user's name has been updated");
                System.out.println(userDAO.getById(l.getId()));

                System.out.println("Let's delete an User");
                userDAO.delete(l.getId());
                System.out.println("Query all users to see that it's disappeared!");
                System.out.println(userDAO.getAll());

//        // Using our DAO to READ from the database
        List<User> user1 = userDAO.getAll();
        System.out.println(users);

        User u = userDAO.getById(3);
        System.out.println(u);

        System.out.println("**************************************************************************************");

        // Using our DAO to CREATE a new user
        User newUser = new User( 1, "lastName", "addedUsername", "pass" );
        userDAO.add(newUser);
        System.out.println(MockDB.users);

        System.out.println("**************************************************************************************");

        // Using our DAO to UPDATE a user (retrieving the existing user from the database first
        User u2 = userDAO.getById(1);
        u2.setUsername("newUsername");
        userDAO.update(u2);
        System.out.println(MockDB.users);

        System.out.println("**************************************************************************************");

        // Using our DAO to DELETE a user
        userDAO.delete(6);

        System.out.println(MockDB.users);

            /*
            Want my LibraryApp Users to be able to do the following:
            - login
                - stretch goal -> disable account if too many login attempts fail
            - view available books to check out
                - stretch goal -> to search books by author/ISBN/title
            - checkout a book (maybe we limit to 5 books)
            - save a book to a wishlist/readinglist (and remove it)
            - view their checked-out books
            - see due dates when books are due to be returned
            - return a book
                - rate a book (stretch)
            - admin abilities:
                - delete users
                - add books and authors to library
                - delete books and authors from library
            Book Class - qty
             */
//        System.out.println("Welcome to the Library App!");
//        System.out.println("Please choose an option to continue.");
//        System.out.println("1.Login\n" +
//                            "2. Register\n" +
//                            "3. View Available Books\n" +
//                            "4. Logout\n" +
//                            "5. Quit");
//
//        int input = scanner.nextInt();
//
//        switch (input) {
//            case 1:
//                scanner.nextLine(); // clear our input stream (any characters or key presses left in the console)
//                System.out.println("You chose LOGIN");
//                // collect the username and password
//                System.out.println("Please enter your username: ");
//                String username = scanner.nextLine();
//
//                System.out.println("Please enter your password: ");
//                String password = scanner.nextLine();
//
//                System.out.println("Username entered = " + username);
//                System.out.println("Password entered = " + password);
//                // check it against existing credentials - This is where our Service layer comes in.
//                // let's create a login method in a UserService class
//                boolean successfulLogin = userService.login(username, password);
//                System.out.println(successfulLogin);
//                // if user doesn't exist -> give them the option to register
//                break;
//            case 2:
//                System.out.println("You chose QUIT. Goodbye.");
//                break;
//            default:
//                System.out.println("I didn't recognize that option. Please only enter integers.");
//        }



            }
        }



package Models;

/** Create additional fields to showcase a First name
 * Lase name , Email, Phone number, Address and gender.
 *
 * Example Fields
 * <ul>
 *     <li>First Name</li>
 *     <li>Last Name</li>
 *     <li>Email</li>
 *     <li>Phone Number</li>
 *     <li>Address</li>
 *     <li>Gender</li>
 * </ul>
 *
 */

public class User {

    private int id;
    private String fName;
    private String lName;
    private String email;
    private String contact;
    private String username;
    private String password;
    private String role;

    public User(int id, String fName, String lName, String email, String contact, String username, String password, String gender, String role) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.contact = contact;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User(int id, String genericEmployee1, String genericPassword, String employee) {
    }

    public User() {

    }

    public User(int i, String s, String s1, String s2, String s3) {
    }

    public User(int id, String first_name, String last_name, String email, String username, String password, String role) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public void setFirstName(String s) {
    }


}

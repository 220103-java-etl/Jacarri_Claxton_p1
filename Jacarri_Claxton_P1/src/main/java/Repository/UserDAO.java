package Repository;

import Models.User;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO implements GenericDAO<User> {


    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public User add(User user) {
        String sql = "insert into users values (default, ?, ?, ?, ?, ?, ?, ?) returning *";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getfName());
            ps.setString(2, user.getlName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getRole().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("role"
                        ));
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    ;


    @Override
    public User getById(Integer id) {
        String sql = "select * from users where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("pass"),
                        rs.getString("role"
                        ));

                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getByUsername(String username) {
        String sql = "select * from users where username = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "username");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User u = new User(
                        rs.getInt("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role")
                );
                return u;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        @Override
        public void update (User user){
            String sql = "update users set first_name = ?, last_name = ?, username = ?, pass = ?, email = ?, where id = ?";
            try (Connection conn = cu.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, User.getfName());
                ps.setString(2, User.getlName());
                ps.setString(3, User.getUsername());
                ps.setString(4, User.getPassword());
                ps.setString(5, User.getEmail());
                ps.setInt(7, User.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



    @Override
    public List<User> getAll() {
        {
            String sql = "select * from users";
            List<User> users = new ArrayList<>();
            try (Connection conn = cu.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    User a = new User(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("username"),
                            rs.getString("password"),
                            rs.getString("role")
                    );
                    users.add(a);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return users;
        }
    }





    @Override
    public void delete(Integer id) {
        String sql = "delete from users where id = ?";
            try(Connection conn = cu.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,id);
                ps.executeUpdate();
            } catch(SQLException e) {
                e.printStackTrace();
            }

    }

    @Override
    public void create(User employee_to_register) {

    }


    public static User add() {
        return null;
    }


}
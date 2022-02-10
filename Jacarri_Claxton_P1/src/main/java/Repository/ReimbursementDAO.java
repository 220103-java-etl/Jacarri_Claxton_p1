package Repository;

import Models.Reimbursement;
import Models.Status;
import Models.User;
import Util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReimbursementDAO implements GenericDAO<User> {

    ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    @Override
    public Reimbursement add(Reimbursement reimbursement) {
        String sql = "insert into reimbursement values(default, ? , ?, ? , ?) returning *";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,reimbursement.getUsername());
            ps.setString(2,Status.getStatus());
            ps.setDouble(3,reimbursement.getAmount());
            ps.setString(4,User.getResolver);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reimbursement u =new Reimbursement(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("status"),
                        rs.getDouble("amount"),
                        rs.getString("resolver")
                ));
            return u;
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursement;
    }


    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     * @return
     */
    @Override
    public User getById(Integer id) {
        String sql = "select * from reimbursement where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Reimbursement u = new Reimbursement(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("status"),
                        rs.getDouble("amount"),
                        rs.getString("resolver")
                ));
            return Reimbursement;
        }

        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    }

    public void update(User user) {
        String sql = "update reimbursements set username = ?, status = ?, amount = ?, resolver = ?, where id = ?";
        try (Connection conn = cu.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, Reimbursement.getId);
                    ps.setString(2,Reimbursement.getUsername);
                    ps.setStatus(3, Reimbursement.getStatus);
                    ps.setDouble(4,Reimbursement.getAmount);
              ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */

    public  User add(User user) {
        return user;
    }




    @Override
    public List<Reimbursement> getAll() {
        {
            String sql = "select * from reimbursement";
            List<Reimbursement> reimbursements = new ArrayList<>();
            try (Connection conn = cu.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Reimbursement u = new Reimbursement(
                            rs.getInt("id"),
                            rs.getString("username"),
                            rs.getString("status"),
                            rs.getDouble("amount")
                            rs.getString("resolver")
                    );
                    Reimbursement.add(u);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return reimbursements;


            // public abstract ObservableBooleanValue update(User user);

            public void delete (Integer id){
            String sql = "delete from reimbursement where id = ?";
            try (Connection conn = cu.getConnection()) {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

            // @Override
            // public void create(User employee_to_register) {

            //  }

            //   public User getByUsername(String username) {return null;}
//
//    public Reimbursement update(Reimbursement unprocessedReimbursement) {
            //       return null;
            //   }
//}

        }
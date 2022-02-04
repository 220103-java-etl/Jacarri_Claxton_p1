package Repository;

import Models.Reimbursement;
import Models.Status;
import Models.User;
import javafx.beans.value.ObservableBooleanValue;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {


    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     * @return
     */
    public Optional<User> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    }

    public void update(User user) {}

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

   // public abstract ObservableBooleanValue update(User user);

    public void delete(Integer id) {}

    public User getByUsername(String username) {return null;}

    public Reimbursement update(Reimbursement unprocessedReimbursement) {
        return null;
    }
}


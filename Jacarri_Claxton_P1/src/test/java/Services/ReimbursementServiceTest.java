package Services;

import Models.Reimbursement;
import Models.Role;
import Models.Status;
import Models.User;
import Repository.ReimbursementDAO;
import Service.ReimbursementService;
import javafx.beans.value.ObservableBooleanValue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

import static javafx.beans.binding.Bindings.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReimbursementServiceTest {

    private static ReimbursementService reimbursementService;
    private static ReimbursementDAO reimbursementDAO;

    private User REIMBURSEMENT_TO_PROCESS;
    private Reimbursement GENERIC_REIMBURSEMENT_1;
    private Reimbursement GENERIC_REIMBURSEMENT_2;
    private List<Reimbursement> GENERIC_ALL_PENDING_REIMBURSEMENTS;
    private User GENERIC_EMPLOYEE_1;
    private User GENERIC_FINANCE_MANAGER_1;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        reimbursementService = new ReimbursementService();
        reimbursementDAO = mock(ReimbursementDAO.class);
    }

    @Before
    public void setUp() throws Exception {
        GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", "EMPLOYEE");
        GENERIC_FINANCE_MANAGER_1 = new User(1, "genericManager1", "genericPassword", "FINANCE_MANAGER");

      //  REIMBURSEMENT_TO_PROCESS = new Reimbursement(2, Status.PENDING, GENERIC_EMPLOYEE_1, null, 150.00);

        GENERIC_REIMBURSEMENT_1 = new Reimbursement(1, Status.PENDING, GENERIC_EMPLOYEE_1, null, 100.00);
        GENERIC_REIMBURSEMENT_2 = new Reimbursement(2, Status.APPROVED, GENERIC_EMPLOYEE_1, GENERIC_FINANCE_MANAGER_1, 150.00);

        GENERIC_ALL_PENDING_REIMBURSEMENTS = new List<Reimbursement>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Reimbursement> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Reimbursement reimbursement) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Reimbursement> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Reimbursement> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Reimbursement get(int index) {
                return null;
            }

            @Override
            public Reimbursement set(int index, Reimbursement element) {
                return null;
            }

            @Override
            public void add(int index, Reimbursement element) {

            }

            @Override
            public Reimbursement remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Reimbursement> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Reimbursement> listIterator(int index) {
                return null;
            }

            @Override
            public List<Reimbursement> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        GENERIC_ALL_PENDING_REIMBURSEMENTS.add(GENERIC_REIMBURSEMENT_1);
    }

   // @Test
   // public void testProcessPassesWhenUserIsFinanceManagerAndReimbursementExistsAndUpdateSuccessful() {
        //when(reimbursementDAO.getById(anyInt())).thenReturn(Optional.of(GENERIC_REIMBURSEMENT_1));
      //  when(reimbursementDAO.update(any()).thenReturn(GENERIC_REIMBURSEMENT_2);

        //assertEquals(GENERIC_REIMBURSEMENT_2, reimbursementService.process(REIMBURSEMENT_TO_PROCESS, Status.APPROVED, GENERIC_FINANCE_MANAGER_1));

       // verify(reimbursementDAO).getById(REIMBURSEMENT_TO_PROCESS.getId());
        //verify(reimbursementDAO).update(REIMBURSEMENT_TO_PROCESS);
    //}

   // @Test
   // public void testGetReimbursementByStatusPassesWhenReimbursementsAreSuccessfullyReturned() {
   //     when((ObservableBooleanValue) reimbursementDAO.getByStatus(any())).thenReturn(GENERIC_ALL_PENDING_REIMBURSEMENTS);

     //   assertEquals(GENERIC_ALL_PENDING_REIMBURSEMENTS, reimbursementService.getReimbursementsByStatus(Status.PENDING));

       // verify(reimbursementDAO).getByStatus(Status.PENDING);
    }


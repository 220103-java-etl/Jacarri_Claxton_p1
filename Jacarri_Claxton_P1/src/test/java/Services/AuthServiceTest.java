package Services;

import Exceptions.NewUserHasNonZeroIdException;
import Exceptions.RegistrationUnsuccessfulException;
import Exceptions.UsernameNotUniqueException;
import Models.Role;
import Models.User;
import Repository.UserDAO;
import Service.AuthService;
import Service.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import java.util.Optional;

public class AuthServiceTest {

    private static AuthService authService;
    private static UserService userService;
    private static UserDAO userDAO;

    private User EMPLOYEE_TO_REGISTER;
    private User GENERIC_EMPLOYEE_1;
    private User GENERIC_FINANCE_MANAGER_1;}

 //   @BeforeClass
 //   public static void setUpBeforeClass() throws Exception {
 //       authService = new AuthService();
  //      userService = mock(UserService.class);
 //       userDAO = mock(UserDAO.class);
 //   }

  //  @Before
  //  public void setUp() throws Exception {
 //      EMPLOYEE_TO_REGISTER = new User(0, "genericEmployee1", "genericPassword", "EMPLOYEE");
  //      GENERIC_EMPLOYEE_1 = new User(1, "genericEmployee1", "genericPassword", "EMPLOYEE");
 //       GENERIC_FINANCE_MANAGER_1 = new User(1, "genericManager1", "genericPassword", "FINANCE_MANAGER");
 //   }

   // @Test
   // public void testRegisterFailsWhenUsernameIsTaken() {
   //     when(userService.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));

     //   assertThrows(UsernameNotUniqueException.class,
       //         () -> authService.register(EMPLOYEE_TO_REGISTER)
        //);

       // verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
       // verify(userDAO, never()).create(EMPLOYEE_TO_REGISTER);
    //}

   // @Test
  //  public void testRegisterPassesWhenUsernameIsNotTaken() {
   //     when(userService.getByUsername(anyString())).thenReturn(Optional.empty());
   //     when(userDAO.add(anyObject())).thenReturn(GENERIC_EMPLOYEE_1);

       // assertEquals(GENERIC_EMPLOYEE_1, authService.register(EMPLOYEE_TO_REGISTER));

    //    verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
    //    verify(userDAO).create(EMPLOYEE_TO_REGISTER);
   // }

   // @Test
   // public void testRegisterFailsWhenRegistrationIsUnsuccessful() {
    //    when(userDAO.add(anyObject())).thenThrow(new RegistrationUnsuccessfulException());

    //    assertThrows(RegistrationUnsuccessfulException.class,
     //           () -> authService.register(EMPLOYEE_TO_REGISTER)
      //  );
    //}

 //   @Test
  //  public void testRegisterFailsWhenIdIsNonZero() {
  //      EMPLOYEE_TO_REGISTER.setId(1000);

   //     assertThrows(NewUserHasNonZeroIdException.class,
   //            // () -> authService.register(EMPLOYEE_TO_REGISTER)
   //     );
  //  }

  //  @Test
 //   public void testLoginPassesWhenUsernameDoesExistAndPasswordMatches() {
  //      when(userService.getByUsername(anyString())).thenReturn(Optional.of(GENERIC_EMPLOYEE_1));
//
       // assertEquals(GENERIC_EMPLOYEE_1, authService.login(GENERIC_EMPLOYEE_1.getUsername(), GENERIC_EMPLOYEE_1.getPassword()));

 //       verify(userService).getByUsername(EMPLOYEE_TO_REGISTER.getUsername());
//    }
//}


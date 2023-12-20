import java.util.Date;
public interface AccountManagement {
    User createAccount(String firstName, String lastName, String username, String password,
                           String confirmPassword, String email, Date birthdate, String profilePictureUrl);

        boolean login(String username, String password);

}

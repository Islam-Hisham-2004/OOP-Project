import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface AccountManagement {
    User createAccount(String firstName, String lastName, String username, String password,
                       String confirmPassword, String email, Date birthdate, String profilePictureUrl);

    boolean login(String username, String password);
}

public class User implements AccountManagement {
    private UUID userID;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;
    private String profilePictureUrl = " "; // Default value
    private Date birthdate;
    private List<User> listOfFriends;
    private Gender gender;
    private String Confirmpassword;

    public User(String firstName, String lastName, String email, String username,
                String password, String confirmPassword, Gender gender) {
        this.userID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.gender = gender;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<User> getListOfFriends() {
        return listOfFriends;
    }

    public void setListOfFriends(List<User> listOfFriends) {
        this.listOfFriends = listOfFriends;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getConfirmpassword() {
        return Confirmpassword;
    }

    public void setConfirmpassword(String confirmpassword) {
        Confirmpassword = confirmpassword;
    }

    public User(UUID userID, String username, String firstName, String lastName,
                String password, String confirmPassword, String email, Date birthdate,
                String profilePictureUrl, Gender gender) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
        this.birthdate = birthdate;
        this.profilePictureUrl = profilePictureUrl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    // Implementing methods from AccountManagement interface

    @Override
    public User createAccount(String Firstname, String Lastname, String username, String password, String confirmpassword, String email, Date birthdate, String profilePictureUrl){
        if (isValidUsername(username) && isValidPassword(password, confirmpassword) &&
                isValidEmail(email) && isValidBirthdate(birthdate) && isValidProfilePictureUrl(profilePictureUrl)) {
            this.username = username;
            this.password = password;
            this.Confirmpassword = confirmpassword;

            this.email = email;
            this.birthdate = birthdate;
            this.profilePictureUrl = profilePictureUrl;
            this.userID = UUID.randomUUID(); // Generate a random and unique UUID
        } else {
            throw new IllegalArgumentException("Invalid account details");
        }

        if (isValidEmail(email)) {
            this.email = email;
        } else throw new IllegalArgumentException("Invalid email format");

        //return user1;
        return null;
    }

    private boolean isValidUsername(String username) {
        /* check for a minimum length requirement */
        return username != null && username.length() >= 4;
    }

    private boolean isValidPassword(String password, String confirmPassword) {
        /* check for length, complexity, matching confirmation */
        return password != null && password.length() >= 6 && password.equals(confirmPassword);
    }

    private boolean isValidBirthdate(Date birthdate) {
        if (birthdate == null) {
            return false;
        }
        // Get the current date
        Calendar currentDate = Calendar.getInstance();

        // Check if the birthdate is in the future
        if (birthdate.after(currentDate.getTime())) {
            return false;
        }

        // Check if the birthdate is within a reasonable range (e.g., not too far in the past)
        Calendar reasonableRange = Calendar.getInstance();
        reasonableRange.add(Calendar.YEAR, -150); //ay range zy m na 3aiza

        return birthdate.after(reasonableRange.getTime());
    }

    private boolean isValidProfilePictureUrl(String profilePictureUrl) {
        // For example, check if it's a valid URL
        return profilePictureUrl != null && profilePictureUrl.startsWith("http");
    }



    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        /*ensures that the email:
        Starts with one or more alphanumeric characters, underscores, plus signs, ampersands, asterisks, or hyphens.
        Contains an '@' symbol.
        Followed by one or more groups of characters separated by dots, where each group starts with alphanumeric characters, underscores, plus signs, ampersands, asterisks, or hyphens.
        Ends with a dot and two to seven alphabetic characters.*/

        Pattern pattern = Pattern.compile(emailRegex);
        // creates a Pattern object and compiles the regular expression emailRegex into the Pattern object.

        Matcher matcher = pattern.matcher(email);
        //creates a Matcher object (matcher) for the specified email address (email).


        // Return true if the email matches the pattern
        return matcher.matches();
    }

   /* private static List<User> readUsersFromFile(String filePath) {
        String defaultEmail = "unknown@example.com";
        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String savedUsername = parts[0];
                    String savedPassword = parts[1];

                    // Default or placeholder values for optional attributes
                    String defaultFirstName = "Unknown";
                    String defaultLastName = "Unknown";
                    Date defaultBirthdate = new Date(); // Provide a default date
                    String defaultProfilePictureUrl = "default.jpg";
                    UUID defaultUserID = UUID.randomUUID(); // Generate a default UUID

                    User user = new User(savedUsername, savedPassword,
                            defaultFirstName, defaultLastName, defaultEmail,
                            defaultBirthdate, defaultProfilePictureUrl, defaultUserID);

                    users.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return users;
    }*/




    @Override
    public boolean login(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        return this.username.equals(username) && this.password.equals(password);
    }

    
}

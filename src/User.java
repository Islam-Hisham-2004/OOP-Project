import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.io.Serializable;


public class User implements AccountManagement {
    private int userID = 0;
    private static int nextUserID = 1;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String confirmPassword;
    private String profilePictureUrl = " "; // Default value
    private Date birthdate;
    public ArrayList<User> listOfFriends;
    public ArrayList<Conversation> conversations=new ArrayList<>();
    public ArrayList<Page> pages=new ArrayList<>();
    public ArrayList<Post> posts=new ArrayList<>();
    public ArrayList<Page> followedpages=new ArrayList<>();
    private String gender;
    private String Confirmpassword;
   /* public  Gender parseGenderIgnoreCase(String input) {
        // Convert the input to uppercase before using Gender.valueOf()
        try {
            return Gender.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Handle the case where the input doesn't match any enum constant
            throw new IllegalArgumentException("Invalid gender input. Please enter 'MALE' or 'FEMALE'.");
        }
    }*/
    public User(){}
    public User(User obj){
        this.userID=obj.userID;
        this.firstName = obj.firstName;
        this.lastName = obj.lastName;
        this.email = obj.email;
        this.username = obj.username;
        this.password = obj.password;
        this.confirmPassword = obj.confirmPassword;
        this.gender = obj.gender;
    }
    public User(String username){
        this.username=username;
    }
    public User(String firstName, String lastName, String email, String username,
                String password, String confirmPassword, String gender,Date birthdate) {
        this.userID = nextUserID;
        nextUserID++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.gender = gender;
        this.birthdate=birthdate;
    }
    Scanner input = new Scanner(System.in);




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

   public static void register(ArrayList<User> users){
       Scanner input = new Scanner(System.in);
       User user1=new User();
       System.out.println("Please enter your first name");
       String firstname = input.nextLine();
       user1.setFirstName(firstname);
       System.out.println("Please enter your last name");

       String lastname = input.nextLine();
       user1.setLastName(lastname);
       System.out.println("Please enter your username");
       String username = input.nextLine();
       user1.setUsername(username);
       while(true){
           System.out.println("Please enter your email following email constraints");
           String email = input.nextLine();
           String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
           Pattern pattern = Pattern.compile(emailRegex);
           Matcher matcher = pattern.matcher(email);
           if(matcher.matches()){
               user1.setEmail(email);
               break;
           }else{
               System.out.println("invalid mail");

           }}

       System.out.println("Enter your birthdate (in the format yyyy-MM-dd): ");
       String dateString = input.nextLine();

       Date birthdate = null;
       try {
           // Parse the entered date string
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           birthdate = dateFormat.parse(dateString);

           System.out.println("Parsed Date: " + birthdate);


       } catch (ParseException e) {
           System.err.println("Error: Invalid date format. Please use the format yyyy-MM-dd.");
           // Handle the exception or prompt the user to enter the date again
       }
       user1.birthdate=birthdate;

       while(true){
           System.out.println("Enter the pass");
           String password = input.nextLine();
           System.out.println("Renter the pass");
           String confpass = input.nextLine();
           if(password.length() >= 6 && password.equalsIgnoreCase(confpass)){
               user1.setPassword(password);
               break;
           }else{
               System.out.println("invalid password");
           }}
       while (true){
           System.out.println("Select your gender");
           String gender =input.nextLine();
           if (gender.equalsIgnoreCase("male")||gender.equalsIgnoreCase("female")) {
               user1.setGender(gender);
               break;
           }
           else{
               System.out.println("invalid gender");
           }
       }

       users.add(user1);

   }

    public static User login( ArrayList<User>users) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Enter Username:");
            String username = input.nextLine();
            System.out.println("Enter Password:");
            String password = input.nextLine();
            for (int i = 0; i < users.size(); i++) {
                // Add a null check before calling equals
                if (users.get(i).getUsername() != null && users.get(i).getUsername().equals(username)
                        && users.get(i).getPassword() != null && users.get(i).getPassword().equals(password)) {
                    System.out.println("Login successful!");
                    return users.get(i);
                }
            }
            System.out.println("Wrong Credentials!");
            continue;
        }
    }


    public int getUserID() {
        return userID;
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

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public void addConversation(Conversation conversation) {
        conversations.add(conversation);
    }

    public ArrayList<Conversation> getConversations() {
        return conversations;
    }



}
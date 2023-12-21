import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
    ArrayList<User> users=new ArrayList<>();
    Scanner input = new Scanner(System.in);
    User loggeduser =new User();
        while (true) {
            System.out.println("Choose an option");
            System.out.println("1. Create Account");
            System.out.println("2. Login to an existing account");
            System.out.println("3.exit");

            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    User.register(users);
                 break;
                case 2:
                    loggeduser= new User(User.login(users));
                    loop: while(true){
                    UserInteractions.display();
                        int option = input.nextInt();
                        switch (option) {
                            case 1:
                                UserInteractions.createPost(loggeduser,loggeduser.listOfFriends,loggeduser.posts);


                                break;
                            case 2:
                                break;
                            case 3:

                                break;
                            case 4:
                                UserInteractions.createPage(loggeduser.pages);
                                break;
                            case 5:
                                UserInteractions.createConversation(loggeduser.conversations);
                                break;
                            case 6:
                                UserInteractions.sendMessage(loggeduser.conversations);
                                break;
                            case 7:

                                break;
                            case 8:
                                UserInteractions.followPage(loggeduser.followedpages,loggeduser);
                                break;
                            case 9:

                                break;
                            case 10:
                                break loop;
                        }
                    }
                    break;
                case 3:
                    System.out.println("exiting program ");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }




   /*         private void loadSystemDetails () {
                try (ObjectInputStream usersStream = new ObjectInputStream(new FileInputStream(USERS_FILE));
                     ObjectInputStream postsStream = new ObjectInputStream(new FileInputStream(POSTS_FILE));
                     ObjectInputStream conversationsStream = new ObjectInputStream(new FileInputStream(CONVERSATIONS_FILE))) {
                    users = (List<User>) usersStream.readObject();
                    posts = (List<Post>) postsStream.readObject();
                    conversations = (List<Conversation>) conversationsStream.readObject();
                } catch (FileNotFoundException e) {
                    System.out.println("Files not found. Creating new system.");
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            private void saveSystemDetails () {
                try (ObjectOutputStream usersStream = new ObjectOutputStream(new FileOutputStream(USERS_FILE));
                     ObjectOutputStream postsStream = new ObjectOutputStream(new FileOutputStream(POSTS_FILE));
                     ObjectOutputStream conversationsStream = new ObjectOutputStream(new FileOutputStream(CONVERSATIONS_FILE))) {
                    usersStream.writeObject(users);
                    postsStream.writeObject(posts);
                    conversationsStream.writeObject(conversations);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/
}

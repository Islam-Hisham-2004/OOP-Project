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
                    Feed feed=new Feed(loggeduser);
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
                                UserInteractions.createConversation(loggeduser.conversations,loggeduser.listOfFriends,loggeduser);
                                break;
                            case 6:
                                UserInteractions.sendMessage(loggeduser.conversations,loggeduser);
                                break;
                            case 7: feed.viewConversations();
                                feed.viewSelectedConversation();
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


    public static String convtostr(ArrayList<User> users) {
        StringBuffer data = new StringBuffer();
        for (int i=0;i< users.size();i++){
            data.append users.get(i).getEmail()+","+users.get(i).getUsername()+","+users.get(i).getFirstName()+","+users.get(i).getLastName()+","+
                    users.get(i).getPassword()+","+users.get(i).getGender()+","+users.get(i).getUserID()+"\n";}
        return data;
    }
public static void write_data(String data,String path){

}

}














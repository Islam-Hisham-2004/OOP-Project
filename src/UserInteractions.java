import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class UserInteractions implements Displayable {
    Scanner input=new Scanner(System.in);


     public static void display(){

         System.out.println("Welcome to facebook! what action do u want to perform,please choose a number");
         System.out.println("1.Write post");
         System.out.println("2. Search for a friend");
         System.out.println("3. See friend’s posts");
         System.out.println("4. Create page");
         System.out.println("5.create new conversation");
         System.out.println("6.Send message in existing conversation");
         System.out.println("7.see pages u follow");
         System.out.println("8.follow page");
         System.out.println("9.add friend");
         System.out.println("10.exit or logout");

     }


    public static void createConversation(ArrayList<Conversation> conversations) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter the name of the new conversation:");
        String convName = input.nextLine();

        System.out.println("Enter the participants' names, each name separated by a comma:");
        String participantsInput = input.nextLine();
        String[] partNames = participantsInput.split(",");

        ArrayList<User> participants = new ArrayList<>();
        for (String participantName : partNames) {
            participants.add(new User(participantName));
        }

        Conversation newConversation = new Conversation(convName, participants);
        conversations.add(newConversation);

        System.out.println("New conversation created: " + newConversation.getConvname());
    }

    public static void sendMessage(ArrayList<Conversation> conversations) {
        Scanner input=new Scanner(System.in);
        if (conversations.isEmpty()) {
            System.out.println("No conversations available. Please create a new conversation first.");
            return;
        }

        System.out.println("Choose a conversation to write your message in:");
        for (int i = 0; i < conversations.size(); i++) {
            System.out.println((i + 1) + ". " + conversations.get(i).getConvname());
        }

        int selectedConvIndex = Integer.parseInt(input.nextLine()) - 1;

        if (selectedConvIndex >= 0 && selectedConvIndex < conversations.size()) {
            Conversation selectedConv = conversations.get(selectedConvIndex);

            System.out.println("Enter the name of the sender:");
            String name = input.nextLine();
            User sender = new User(name);

            System.out.println("Enter your message:");
            String msgContent = input.nextLine();

            selectedConv.sendMessage(sender, msgContent);
        } else {
            System.out.println("Invalid conversation index.");
        }
    }


    public static void createPage (ArrayList<Page> pages) {
        try {
            Page newPage = new Page();
            newPage.setPageName();
            newPage.setAbout();
            if (newPage.getAbout() == null || newPage.getAbout().isEmpty()) {
                throw new Exception("About cannot be null or empty.");
            }
            if (newPage.getPageName() == null || newPage.getPageName().isEmpty()) {
                throw new Exception("About cannot be null or empty.");
            }
            System.out.println("Page created successfully!");
            System.out.println("Page Name : " + newPage.getPageName());
            pages.add(newPage);


        } catch (Exception e) {
            System.err.println("Error creating page: " + e.getMessage());
        }
    }



}

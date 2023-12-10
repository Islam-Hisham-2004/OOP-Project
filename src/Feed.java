import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Feed {
    private List<Conversation> conversations;
    private List<Page> pages;
    private List<Post> posts;



    public Feed() {
       conversations = new ArrayList<>();
        pages=new ArrayList<>();
        posts=new ArrayList<>();
    }

    public  void createPage() {
        try {
            Page newPage = new Page();
            newPage.setPageName();
            newPage.setAbout();
            if ( newPage.getAbout() == null || newPage.getAbout().isEmpty()){
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

    /*public void startUserInteraction() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create a new conversation");
            System.out.println("2. Write a message in an existing conversation");
            System.out.println("3. EXIT");

            int choice = Integer.parseInt(input.nextLine());

            switch (choice) {
                case 1:
                    createConversation(input);
                    break;
                case 2:
                    sendMessage(input);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
                    break;
            }
        }
    }*/

    public void createConversation(Scanner input) {
        System.out.println("Enter the name of the new conversation:");
        String convName = input.nextLine();

        System.out.println("Enter the participants' names, each name separated by a comma:");
        String participantsInput = input.nextLine();
        String[] partNames = participantsInput.split(",");

        List<User> participants = new ArrayList<>();
        for (String participantName : partNames) {
            participants.add(new User(participantName));
        }

        Conversation newConversation = new Conversation(convName, participants);
        conversations.add(newConversation);

        System.out.println("New conversation created: " + newConversation.getConvname());
    }

    public void sendMessage(Scanner input) {
        if (conversations.isEmpty()) {
            System.out.println("No conversations available. Please create a new conversation first.");
            return;
        }

        System.out.println("Choose a conversation to write your message in:");
        for (int i = 0; i < conversations.size(); i++) {
            System.out.println((i + 1) + ". " + conversations.get(i).getConvName());
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
}

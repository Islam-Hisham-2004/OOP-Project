import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class UserInteractions implements Displayable {
    Scanner input = new Scanner(System.in);


    public static void display() {

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


    public static void createConversation(ArrayList<Conversation> conversations, ArrayList<User> users, User user) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name of the new conversation:");
        String convName = input.nextLine();
        ArrayList<User> participants = new ArrayList<>();
        while (true) {
            while (true) {
                // Display list of users not in the current conversation
                System.out.println("Available users not in the conversation:");
                for (User availableUser : users) {
                    if (!participants.contains(availableUser)) {
                        System.out.println(availableUser.getUsername());
                    }

                }
                String participantName = input.nextLine().trim();

                if (participantName.equalsIgnoreCase("done")) {
                    break;
                }

                User selectedUser = null;
                for (User availableUser : users) {
                    if (availableUser.getUsername().equalsIgnoreCase(participantName) && !participants.contains(availableUser)) {
                        selectedUser = availableUser;
                        break;
                    }
                }

                if (selectedUser != null) {
                    participants.add(selectedUser);
                    System.out.println(selectedUser.getUsername() + " added to participants.");
                } else {
                    System.out.println("Invalid user name or user already added. Please enter a valid name.");
                }

                System.out.println("Do you want to add another participant? (yes/no):");
                String addAnother = input.nextLine().trim().toLowerCase();
                if (!addAnother.equals("yes")) {
                    break;
                }
            }
            Conversation newConversation = new Conversation(convName, participants);
            for (User participant : participants) {
                participant.addConversation(newConversation);
            }

            // Add the new conversation to the list of conversations for the user
            user.addConversation(newConversation);

            System.out.println("New conversation created: " + newConversation.getConvname());
        }
    }
        public static void sendMessage (ArrayList < Conversation > conversations, User user) {
            Scanner input = new Scanner(System.in);
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

                System.out.println(" name of the sender:" + user.getUsername());

                System.out.println("Enter your message:");
                String msgContent = input.nextLine();

                selectedConv.sendMessage(user, msgContent);
            } else {
                System.out.println("Invalid conversation index.");
            }
        }


        public static void createPage (ArrayList < Page > pages) {
            try {
                Page newPage = new Page();
                newPage.setPageName();
                newPage.setAbout();
                newPage.managePageSettings();
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

        public static void followPage (ArrayList < Page > pages, User user){
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < pages.size(); i++) {
                System.out.println(i + 1 + "-" + pages.get(i).getPageName());
            }
            System.out.println("Enter the number that match your choice : ");
            int choice = input.nextInt();

            for (int i = 0; i < pages.size(); i++) {

                if (choice == pages.get(i).getPageID()) {
                    pages.get(i).addFollower(user);
                } else {
                    System.out.println("Invalid choice");
                    followPage(pages, user);
                }
            }
        }

        public static void createPost (User creator, ArrayList < User > friends, ArrayList < Post > posts){

            Post newPost = new Post();

            newPost.setContent();
            newPost.setPrivacyChoice();

            Scanner input = new Scanner(System.in);


            System.out.println("Tag users press y/n");
            String c = input.nextLine();

            while (Objects.equals(c.toLowerCase(), "y")) {
                newPost.setTaggedUsers(friends);
                System.out.println("Tag another user press y/n");
                c = input.nextLine();
            }
            posts.add(newPost);

        }


    }



import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Feed {
    private List<Conversation> conversations;
    private List<Page> pages;
    private List<User> users;
    private List<Post> posts;


    public Feed(User user) {

        conversations = user.conversations;
        pages = user.pages;
        posts = user.posts;

    }

    public void viewConversations() {
        System.out.println("Your Conversations:");
        for (int i = 0; i < conversations.size(); i++) {
            System.out.println((i + 1) + ". " + conversations.get(i).getConvname());
        }
    }

    public void viewSelectedConversation() {
        Scanner scanner = new Scanner(System.in);

        viewConversations();

        System.out.println("Enter the number of the conversation you want to view:");
        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= conversations.size()) {
            Conversation selectedConversation = conversations.get(choice - 1);
            selectedConversation.Conv_display();
            selectedConversation.displayMessages();
        } else {
            System.out.println("Invalid choice.");
        }
    }











    }
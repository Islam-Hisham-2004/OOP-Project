import java.io.Serializable;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Scanner;
public class Message implements Displayable , Serializable {
    private UUID id;
    private User sender;
    private String content;
    private LocalDateTime msgtime;

    ///////////////message constructor//////////////////////
    public Message(User sender, String content) {
        id = UUID.randomUUID();
        this.sender = sender;
        this.content = content;
        this.msgtime = LocalDateTime.now();
    }


    public UUID getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getMsgtime() {
        return msgtime;
    }


    public void Message_display() {
        System.out.println(id + " - " + sender.getUsername() + ": " + content + " - Sent at: " + msgtime);
    }

    public static void Sendmessage(Scanner input, List<Conversation> conversations) {
        if (conversations.isEmpty()) {
            System.out.println("No conversations available,Please Create a new conversation first.");
            return;
        }
        System.out.println("Choose conv to write ur msg in");
        for (int i = 0; i < conversations.size(); i++) {
            System.out.println((i + 1) + ". " + conversations.get(i).getConvname());
        }
        int selectedConvIndex = Integer.parseInt(input.nextLine()) - 1;
        if (selectedConvIndex >= 0 && selectedConvIndex < conversations.size()) {
            Conversation selectedConv = conversations.get(selectedConvIndex);
            System.out.println("Enter the name of sender");
            String name = input.next();
            User sender = new User(name);
            System.out.println("Enter ur msg");
            String Msg_Cont = input.nextLine();
            selectedConv.sendMessage(sender, Msg_Cont);
        } else {
            System.out.println("Invalid conversation index.");
        }
    }
}

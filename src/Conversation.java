import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conversation implements Displayable, Serializable {
    private String convname;
    private static int id=0;
    private List<Message> messages;
    private ArrayList<User> participants=new ArrayList<>();
    private LocalDateTime creationTime;



    public Conversation(String convname, List<User> participants) {
        this.convname = convname;
        this.participants = new ArrayList<>();
        this.participants.addAll(participants) ;
        this.creationTime = LocalDateTime.now();
        this.messages=new ArrayList<>();
        id++;
    }

    public String getConvname() {
        return convname;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void addParticipants(List<User> selectedParticipants) {
        participants.addAll(selectedParticipants);
    }
    public List<User> getParticipants() {
        return participants;
    }
    public void sendMessage(User sender, String message) {
        Message newMessage = new Message(sender, message);
        this.messages.add(newMessage);
    }

    public void Conv_display() {
        System.out.println("Conversation{" +
                "name='" + convname + '\''+"paricipants: ");
        for (User user : participants) {
            System.out.println(user.getUsername());
        }

        displayMessages();

    }

    public void displayMessages() {
        System.out.println("Messages in " + convname + ":");
        for (Message message : messages) {
            message.Message_display();
        }
    }
}






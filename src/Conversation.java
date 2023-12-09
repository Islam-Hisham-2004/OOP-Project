import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Conversation {
    private String convname;
    private List<Message> messages;
    private List<User> participants;
    private LocalDateTime creationTime;



    public Conversation(String convname, List<User> participants) {
        this.convname = convname;
        this.participants = new ArrayList<>();
        this.participants.addAll(participants) ;
        this.creationTime = LocalDateTime.now();
        this.messages=new ArrayList<>();
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
    public String toString() {
        return "Conversation{" +
                "name='" + convname + '\'' +
                ", participants=" + participants +
                ", messages=" + messages +
                '}';
    }
}






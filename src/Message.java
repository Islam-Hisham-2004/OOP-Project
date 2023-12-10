import java.util.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Scanner;
public class Message {
    private UUID id;
    private User sender;
    private String content;
    private LocalDateTime msgtime;

    ///////////////message constructor//////////////////////
    public Message(User sender, String content) {
        id = UUID.randomUUID();
        this.sender = sender;
        this.content = content;
        this.msgtime=LocalDateTime.now();
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
    @Override
    public String toString() {
        return id + " - " + sender.getName() + ": " + content + " - Sent at: " + msgtime;
    }
}


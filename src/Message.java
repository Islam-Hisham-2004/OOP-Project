import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class Message implements Displayable , Serializable {
   private static int id=0;
    private User sender;
    private String content;
    private LocalDateTime msgtime;

    ///////////////message constructor//////////////////////
    public Message(User sender, String content) {
       id++;
        this.sender = sender;
        this.content = content;
        msgtime = LocalDateTime.now();
    }


    public int getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public String getContent() {
        return content;
    }

    public String getMsgtime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return msgtime.format(formatter);
    }



    public void Message_display() {
        String formateddate=getMsgtime();
        System.out.println( sender.getUsername() + ": " + content + " - Sent at: " + formateddate);
    }


}

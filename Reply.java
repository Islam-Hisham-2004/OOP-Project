package javaapplication7;

import java.time.LocalDateTime;

public class Reply {

    private int replyId;
    private String userName;
    private String content;
    private LocalDateTime time;

    public Reply(int replyId, String userName, String content) {
        this.replyId = replyId;
        this.userName = userName;
        this.content = content;
        this.time = LocalDateTime.now();
    }

    public int getReplyId() {
        return replyId;
    }

    public String getUserName() {
        return userName;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTime() {
        return time;
    }

    
    

}

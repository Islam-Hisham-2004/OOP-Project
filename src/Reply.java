

import java.time.LocalDateTime;

public class Reply {

    private int replyId;
    private User user;
    private String content;
    private LocalDateTime time;

    public Reply(int replyId, User user, String content, LocalDateTime time) {
        this.replyId = replyId;
        this.user = user;
        this.content = content;
        this.time = time;
    }

    public int getReplyId() {
        return replyId;
    }

    public User getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTime() {
        return time;
    }





}
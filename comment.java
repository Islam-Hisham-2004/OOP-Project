package javaapplication7;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class comment {

    private int commentId;
    private String userName;
    private String content;
    private LocalDateTime time;
    private List<Reply> replies;

    public comment(int commentId, String userName, String content) {
        this.commentId = commentId;
        this.userName = userName;
        this.content = content;
        this.time = LocalDateTime.now();
        this.replies = new ArrayList<>();
    }

    public int getCommentId() {
        return commentId;
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

    public List<Reply> getReplies() {
        return replies;
    }

    public void addReply(Reply reply) {
        replies.add(reply);
    }

    
     
    
    

}

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comment {
    private int commentId;
    private User user;
    private String content;
    private LocalDateTime time;
    private List<Reply> replies;

    public Comment(int commentId, User user, String content) {
        this.commentId = commentId;
        this.user = user;
        this.content = content;
        this.time = LocalDateTime.now();
        this.replies = new ArrayList<>();
    }

    public int getCommentId() {
        return commentId;
    }

    public User getUserName() {
        return user;
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

    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", user=" + user + ", content=" + content + ", time=" + time + ", replies=" + replies + '}';
    }





}
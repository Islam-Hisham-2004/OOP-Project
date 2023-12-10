import java.time.LocalDateTime;

public class Reply extends Comment {
    private LocalDateTime time;

    public Reply(int replyId, User user, String content) {
        super(replyId, user, content);
        this.time = LocalDateTime.now();
    }



    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Reply{" + "time=" + time + '}';
    }


}
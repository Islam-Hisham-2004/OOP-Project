import java.time.LocalDateTime;
import java.util.*;


public class Reply extends Comment {

    private LocalDateTime time;
    private Comment comment;
    private List<User> likers;


    @Override
    public List<User> getLikers() {
        return likers;
    }

    @Override
    public void setLikers(List<User> likers) {
        this.likers = likers;
    }

    // Constructor for creating a new reply
    public Reply(String content,User user,  Comment comment) {
        super(content, user);
        this.time = LocalDateTime.now();
        this.comment = comment;
        this.likers = new ArrayList<>();

    }

    public static Reply createReply(User loggedInUser, List<Comment> comments) {
        Scanner input = new Scanner(System.in);

        // Display available comments for the user to choose
        System.out.println("Choose the comment for your reply:");
        for (int i = 0; i < comments.size(); i++) {
            System.out.println((i + 1) + ". " + comments.get(i).getContent());
        }

        // Prompt the user to choose a comment
        int commentChoice = input.nextInt();
        input.nextLine(); // Consume newline

        // Validate the comment choice
        while (commentChoice <= 0 || commentChoice > comments.size()) {
            System.out.println("Invalid comment choice. Please choose again:");
            commentChoice = input.nextInt();
            input.nextLine();
        }

        Comment chosenComment = comments.get(commentChoice - 1);

        // Prompt the user to enter reply content
        System.out.println("Enter your reply:");
        String content = input.nextLine();


        Reply reply = new Reply(content,loggedInUser,chosenComment);
        reply.comment = chosenComment;
        chosenComment.getReplies().add(reply);
        // Create a new reply with the provided content, user, and parentComment
        return  reply;
    }
    public void likeReply(User loggedInUseruser ,Reply chosenReply) {


        chosenReply.likers.add(loggedInUseruser);
    }



    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Reply{" + "time=" + time +'}';
}



}
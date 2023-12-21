import java.time.LocalDateTime;
import java.util.*;


public class Comment {
    static Scanner input = new Scanner(System.in);
    private static int nextID = 1;
    private int commentId;
    private User user;
    private String content;
    private Post post;
    private LocalDateTime time;
    private List<Reply> replies;
    private List<User> likers;









    public Comment(String content,User user) {
        this.commentId = nextID++;
        this.user = user;
        this.content = content;
        this.time = LocalDateTime.now();
        this.replies = new ArrayList<>();
        this.likers = new ArrayList<>();
    }


    public List<User> getLikers() {
        return likers;
    }
    public void setLikers(List<User> likers) {
        this.likers = likers;
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

    public Post getPost() {
        return post;
    }


    public List<Reply> getReplies() {
        return replies;
    }

    public void addReply(Reply reply) {
        replies.add(reply);
    }


    public static Comment createComment(User loggedInUser, List<Post> posts) {


        // Display available posts for the user to choose
        System.out.println("Choose the post for your comment:");
        for (int i = 0; i < posts.size(); i++) {
            System.out.println((i + 1) + ". " + posts.get(i).getContent());
        }

        // Prompt the user to choose a post
        int postChoice = input.nextInt();
        input.nextLine(); // Consume newline



        // Validate the post choice
        while (postChoice <= 0  || postChoice > posts.size()) {
            System.out.println("Invalid post choice. Please choose again:");
            postChoice = input.nextInt();
            input.nextLine();
        }

        Post chosenPost = posts.get(postChoice - 1);

        System.out.println("Enter your comment:");
        String content = input.nextLine();


        Comment comment = new Comment(content, loggedInUser);
        comment.post = chosenPost;
        chosenPost.getComments().add(comment);
        return comment;
    }

    public void likeComment(User loggedInUseruser ,Comment chosenComment) {


        chosenComment.likers.add(loggedInUseruser);
    }
    @Override
    public String toString() {
        return "Comment{" + "commentId=" + commentId + ", user=" + user + ", content=" + content + ", time=" + time + ", replies=" + replies +'}';
}



}
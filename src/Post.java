import java.util.*;

public class Post {
    private static int nextID = 1;
    Scanner input = new Scanner(System.in);
    private int postID;
    private String content;
    private String privacyOption;
    private List<Comment> comments;
    private List<String> taggedUsers;
    private List<String> likers;


    public Post(String content, String privacyOption) {
        initializeNextID();
        initializePost(content, privacyOption);
    }
    public void writeContent() {
        System.out.print("Enter the content for your post: ");
        content = input.nextLine();
    }

    // Function to allow the user to write privacy option for a new post
    public void writePrivacyOption() {
        System.out.print("Enter the privacy option for your post (Public or Friends only): ");
        privacyOption = input.nextLine();
        // You might want to add validation for the entered privacy option
    }
    // Constructor for creating posts without specifying content and privacy option
    public Post() {
        initializeNextID();
        this.comments = new ArrayList<>();
        this.taggedUsers = new ArrayList<>();
        this.likers = new ArrayList<>();
    }

    private void initializeNextID() {
        this.postID = nextID++;
    }

    private void initializePost(String content, String privacyOption) {
        if (content == null || content.isEmpty() || privacyOption == null || privacyOption.isEmpty()) {
            throw new IllegalArgumentException("Content and privacy option cannot be null or empty");
        }
        this.content = content;
        this.privacyOption = privacyOption;
    }

    public int getPostID() {
        return postID;
    }

    public String getContent() {
        return content;
    }

    public String getPrivacyOption() {
        return privacyOption;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<String> getTaggedUsers() {
        return taggedUsers;
    }

    public List<String> getLikers() {
        return likers;
    }

    public void displayComments() {
        for (Comment current_comment : comments) {
            System.out.println(current_comment.getContent());
        }
    }

    public void tagUser(String user) {
        if (user == null || user.isEmpty()) {
            throw new IllegalArgumentException("User to tag cannot be null or empty");
        }
        taggedUsers.add(user);
    }

    public void likePost(String user) {
        if (user == null || user.isEmpty()) {
            throw new IllegalArgumentException("User liking the post cannot be null or empty");
        }
        likers.add(user);
    }

    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", content='" + content + '\'' +
                ", privacyOption='" + privacyOption + '\'' +
                ", comments=" + comments +
                ", taggedUsers=" + taggedUsers +
                ", likers=" + likers +
                '}';
    }
}
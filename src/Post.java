import java.util.*;
public class Post {
    private static int nextID = 1;
    Scanner input = new Scanner(System.in);
    private int postID;
    private User creator;

    public void setContent() {
        System.out.print("Enter the content for your post: ");
        this.content = input.nextLine();
    }

    private String content;
    private List<String> privacyOption;


    public void setPrivacyChoice() {
        System.out.println("Enter 1 to set your post public or 2 to set it friends only");
        this.privacyChoice = input.nextInt();

    }

    private int privacyChoice;
    private List<Comment> comments;

    public void setTaggedUsers(ArrayList<User> friends) {

        this.taggedUsers = addTaggedUser(chooseUser(friends));
    }

    private List<User> taggedUsers;
    private List<User> likers;


    public Post() {
        postID = nextID++;
        content = content;
        creator = creator;
        privacyOption = new ArrayList<>(Arrays.asList("Public", "Friends only"));
        privacyChoice = privacyChoice;
        comments = new ArrayList<>();
        taggedUsers = taggedUsers;
        likers = new ArrayList<>();

    }
    public int getPostID() {
        return postID;
    }
    public int getPrivacyChoice() {
        return privacyChoice;
    }
    public String getContent() {
        return content;
    }
    public User getCreator() {
        return creator;
    }

    public List<String> getPrivacyOption() {
        return privacyOption;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public List<User> getTaggedUsers() {
        return taggedUsers;
    }
    public List<User> getLikers() {
        return likers;
    }

    public void displayComments() {
        for (Comment current_comment : comments) {
            System.out.println(current_comment.toString());
        }
    }

    public List<User> addTaggedUser(User friend) {
        taggedUsers.add(friend);
        return taggedUsers;
    }

    public User chooseUser( ArrayList<User> friends){
        for (int i = 0 ; i < friends.size() ; i++){
            System.out.println(i+1 + "-" + friends.get(i).getUsername());
        }
        System.out.println("Enter the number that match your choice: ");
        int choice = input.nextInt();

        while(choice>friends.size() || choice<0){
            System.out.println("Invalid choice!");
            System.out.println("Enter the number that match your choice: ");
            choice = input.nextInt();
        }

        return friends.get(choice);

    }

    public void likePost(User loggedInUseruser , Post chosenPost) {


        chosenPost.likers.add(loggedInUseruser);
    }

    public String toString() {

        return "Post{\ncontent: "
                + content +
                "\ncomments: "
                + comments +
                "\ntagged users: "
                + taggedUsers +
                "\nliked by: "
                + likers +
                "\n}";

}
}
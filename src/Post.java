import java.util.*;
public class Post {
    private static int nextID = 1;
    Scanner input = new Scanner(System.in);
    private int postID;
    private User creator;
    private String content;
    private List<String> privacyOption;
    private int privacyChoice;
    private List<Comment> comments;
    private List<User> taggedUsers;
    private List<User> likers;


    public Post(User creator, String content,int privacyChoice,List<User> taggedUsers) {
        this.postID = nextID++;
        this.content = content;
        this.creator = creator;
        this.privacyOption = new ArrayList<>(Arrays.asList("Public", "Friends only"));
        this.privacyChoice = privacyChoice;
        this.comments = new ArrayList<>();
        this.taggedUsers = taggedUsers;
        this.likers = new ArrayList<>();

    }

    public Post(Scanner input) {

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
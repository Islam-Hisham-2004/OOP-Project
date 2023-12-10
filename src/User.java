import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public  class User {
    private static int userID = 0;
    private String Firstname;
    private String Lastname;
    private String email;
    private String username;
    private String password;
    private String Confirmpassword;
    private static String profilePictureUrl=" "; //4aklaha m4 ht4t8all nnn
    private Date birthdate;
    // private ArrayList<String> ListOfFriends = new ArrayList<String>();
    List<User> ListOfFriends;
    private ArrayList followedPages= new ArrayList<>();
    private User[] friends;


    public User(int userID, String Firstname,String Lastname, String email, String username, String password, String Confirmpassword )
    {
        userID ++;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.Confirmpassword = Confirmpassword;
        this.profilePictureUrl = profilePictureUrl;
        this.birthdate = birthdate;
        ArrayList<String> listOfPosts = new ArrayList<>();
        this.ListOfFriends = new ArrayList<>();
        ArrayList<String> listOfConversations = new ArrayList<>();
        this.followedPages = new ArrayList<>();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmpassword() {
        return Confirmpassword;
    }

    public void setConfirmpassword(String Confirmpassword) {
        this.Confirmpassword = Confirmpassword;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    /*public ArrayList<String> getListOfFriends() {
        return ListOfFriends;
    }*/

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /*public void setListOfFriends(ArrayList<String> listOfFriends) {
        ListOfFriends = listOfFriends;
    }*/
    /*public void addFriend(User friend) {
        friends.add(friend);
    }

    public void removeFriend(User friend) {
        friends.remove(friend);
    }*/
    public void deletePost(Post post) {
        posts.remove(post);
    }

    public static User createAccount(String Firstname, String Lastname, String username, String password, String email, Date birthdate){
        if (username == null || password == null || Firstname == null || email == null || profilePictureUrl == null) {
            throw new IllegalArgumentException("All parameters are required");
        }
        User user = new User(userID, username, password, Firstname, Lastname, email, profilePictureUrl);
        User user1 = user;
        return user1;


    }
    public boolean login(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        return this.username.equals(username) && this.password.equals(password);
    }
    public Post writePost(String title, String content) {

        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content cannot be null or empty");
        }

        Post newPost = new Post(title, content, this); //this represents the user who is creating the post
        this.posts.add(newPost);
        return newPost;
    }
    public void writeComments(Post post, String commentText) {
        Comment comment = new Comment(this, commentText);  //this represents the user who is commenting on the post
        post.addComment(comment);
    }
    public void likeComment(Comment comment) {
        comment.addLike(this); //add user to the list of likes (this represents the user)
    }
    /*public void likePost(Post post) {
        post.addLike(this);
    }*/
    public void seeFriendsPosts() {
        // User[] friendList;
        if (ListOfFriends.isEmpty()) {
            System.out.println("You have no friends to see posts from.");
            return;
        }

        System.out.println("Posts from friends:");

        for (User friend : ListOfFriends) {
            96            System.out.println("Posts from " + friend.getUsername() + ":");
            List<Post> friendPosts = friend.getPosts();

            if (friendPosts.isEmpty()) {
                System.out.println(" - No posts from " + friend.getUsername());
            } else {
                for (Post friendPost : friendPosts) {
                    System.out.println(" - " + friendPost.getMessage());
                }
            }

            System.out.println(); // Separate friend posts
        }
    }

    //public Page createPage();

    public void searchAddFriends(User friend) {
        if (ListOfFriends.contains(friend) || friend.equals(this)) {
            System.out.println("User not found or already a friend.");
        } else {
            ListOfFriends.add(friend);
            friend.ListOfFriends.add(this); // Add reciprocal friendship
            System.out.println("Friend added: " + friend.getUsername());
        }
    }
    public void followPage(Page page) {
        if (!this.followedPages.contains(page)) {
            this.followedPages.add(page);
        }
    }

    public List<Page> getFollowedPages() {
        return this.followedPages;
    }




    public List<User> getMutualFriends(User otherUser) {
        List<User> mutualFriends = new ArrayList<>();

        for (User friend : this.friends) {
            if (otherUser.getFriends().contains(friend)) {
                mutualFriends.add(friend);
            }
        }

        return mutualFriends;
    }

}
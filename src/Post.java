

import java.util. *;

public class Post {
    private static int nextID = 1;

    private int postID;
    private String content;
    private String privacyOption;
    private List<Comment> comments;
    private List<String> taggedUsers;
    private List<String> likers;


    public Post(String content, String privacyOption) {
        if (content == null || content.isEmpty() || privacyOption == null || privacyOption.isEmpty()) {
            throw new IllegalArgumentException("Content and privacy option cannot be null or empty");
        }
        this.postID = nextID++;
        this.content = content;
        this.privacyOption = privacyOption;
        this.comments = new ArrayList<>();
        this.taggedUsers = new ArrayList<>();
        this.likers = new ArrayList<>();
    }

    public int getPostID(){
        return postID;
    }
    public String getContent(){
        return content;
    }
    public String getPrivacyOption(){
        return privacyOption;
    }

    public List<Comment> getComments(){
        return comments;
    }

    public List<String> getTaggedUsers() {
        return taggedUsers;
    }

    public List<String> getlikers() {
        return likers;
    }

    public void addComment(Comment comment){

        if (comment == null) {
            throw new IllegalArgumentException("Comment cannot be null");
        }comments.add(comment);
    }
    public void tagUser(String user){
        if (user == null || user.isEmpty()) {
            throw new IllegalArgumentException("User to tag cannot be null or empty");
        }
        taggedUsers.add(user);
    }
    public void likePost(String user){
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



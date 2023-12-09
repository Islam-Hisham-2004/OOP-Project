public class PageSettings {
    private boolean allowComments;
    private boolean allowTags;
    private boolean allowPublicPosts;

    // Constructor
    public PageSettings(){
        this.allowComments = true;
        this.allowTags = true;
        this.allowPublicPosts = true;
    }
    // Getter and setter methods

    public boolean isAllowComments() {
        return allowComments;
    }

    public void setAllowComments(boolean allowComments) {
        this.allowComments = allowComments;
    }

    public boolean isAllowTags() {
        return allowTags;
    }

    public void setAllowTags(boolean allowTags) {
        this.allowTags = allowTags;
    }

    public boolean isAllowPublicPosts() {
        return allowPublicPosts;
    }

    public void setAllowPublicPosts(boolean allowPublicPosts) {
        this.allowPublicPosts = allowPublicPosts;
    }
}

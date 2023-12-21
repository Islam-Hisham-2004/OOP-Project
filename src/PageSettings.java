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

    public void setAllowComments(int choice) {
        boolean allowComments = true;
        if (choice == 1){
            allowComments = true;
        } else if (choice == 0) {
            allowComments = false;
        }
        this.allowComments = allowComments;
    }

    public boolean isAllowTags() {
        return allowTags;
    }

    public void setAllowTags(int choice)
    {
        boolean allowTags = true;
        if (choice == 1){
            allowTags = true;
        } else if (choice == 0) {
            allowTags = false;
        }
        this.allowTags = allowTags;
    }

    public boolean isAllowPublicPosts() {
        return allowPublicPosts;
    }

    public void setAllowPublicPosts(int choice) {
        boolean allowPublicPosts = true;
        if (choice == 1){
            allowPublicPosts = true;
        } else if (choice == 0) {
            allowPublicPosts = false;
        }
        this.allowPublicPosts = allowPublicPosts;
}
}

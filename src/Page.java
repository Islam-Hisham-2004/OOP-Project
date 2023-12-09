import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Page {

    private String pageName;
    private int pageID = 0;
    private List<User> followers;
    private List<Post> posts;
    public String about;
    private PageSettings pageSettings;

    Scanner input = new Scanner(System.in);

    /**
     * Constructor initialize the pageID initialize
     */
    public Page() {
        pageID++;
        pageName = "";
        followers = new ArrayList<>();
        posts = new ArrayList<>();
        about = "";
        pageSettings = new PageSettings();
    }

    /**
     * add follower a page
     *
     * @param user
     */
    public void addFollower(User user) {
        try {
            if (user == null) {
                throw new Exception("User cannot be null.");
            }
            followers.add(user);
            System.out.println(user.getFisrtname() + user.getLastname() + " is now following Page ID: " + pageID);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * show followers and their number
     */
    public void showFollowers() {
        System.out.println("Followers total number: " + followers.size());
        System.out.println("Followers:");
        for (User follower : followers) {
            System.out.println(follower.getName());
        }
    }

    /**
     * post on a page
     *
     * @param post
     */
    public void postOnPage(Post post) {
        try {
            if (post == null) {
                throw new Exception("Post cannot be null.");
            }
            posts.add(post);
            System.out.println("Post added to Page ID: " + pageID);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }


//
//    public void displayPosts() {
//        for (Post current_post : posts) {
//            System.out.println(current_post.getContent());
//        }
//    }

    /**
     * manage page settings
     *
     * @param allowComments
     * @param allowTags
     * @param allowPublicPosts
     */
    public void managePageSettings(boolean allowComments, boolean allowTags, boolean allowPublicPosts) {
        pageSettings.setAllowComments(allowComments);
        pageSettings.setAllowTags(allowTags);
        pageSettings.setAllowPublicPosts(allowPublicPosts);
        System.out.println("Page settings updated for Page ID: " + pageID);
    }

    /**
     * Display Page Settings
     */
    public void displayPageSettings() {
        System.out.println("Allow Comments -> " + pageSettings.isAllowComments());
        System.out.println("Allow Public Posts -> " + pageSettings.isAllowPublicPosts());
        System.out.println("Allow Tags -> " + pageSettings.isAllowTags());
    }

    // Getter and setter methods
    public int getPageID() {
        return pageID;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout() {
        System.out.print("Write the Page's about: ");
        this.about = input.nextLine();
    }

    public void setPageName() {
        System.out.print("Write the Page's Name: ");
        this.pageName = input.nextLine();
    }

    public PageSettings getPageSettings() {
        return pageSettings;
    }

    public void setPageSettings(PageSettings pageSettings) {
        this.pageSettings = pageSettings;
    }
}

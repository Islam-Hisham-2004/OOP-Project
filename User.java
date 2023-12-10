import java.util.ArrayList;
import java.util.List;

// Class representing a User in a social networking application
public class User {
    private String username;
    private List<User> friends;

    public User(String username) {
        this.username = username;
        this.friends = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void sendFriendRequest(User otherUser, FriendRequestManager friendRequestManager) {
        // Check if the users are the same
        if (this == otherUser) {
            System.out.println("You cannot send a friend request to yourself.");
            return;
        }
        // Check if a friend request has already been sent
        if (!friendRequestManager.hasSentFriendRequest(this, otherUser)) {
            friendRequestManager.sendFriendRequest(this, otherUser);
            System.out.println(username + " sent a friend request to " + otherUser.getUsername());
        } else {
            System.out.println("A friend request has already been sent to " + otherUser.getUsername());
        }
    }

    public void acceptFriendRequest(User requester, FriendRequestManager friendRequestManager) {
        friendRequestManager.acceptFriendRequest(requester, this);
    }
}



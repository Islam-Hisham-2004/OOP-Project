import java.util.ArrayList;
import java.util.List;

// Class managing FriendRequests in a social networking application
class FriendRequestManager {
    private List<FriendRequest> friendRequests;

    public FriendRequestManager() {
        this.friendRequests = new ArrayList<>();
    }

    public void sendFriendRequest(User sender, User receiver) {
        FriendRequest request = new FriendRequest(sender, receiver);
        friendRequests.add(request);
//        System.out.println(sender.getUsername() + " sent a friend request to " + receiver.getUsername());
    }

    public void acceptFriendRequest(User requester, User accepter) {
        FriendRequest request = findFriendRequest(requester, accepter);
        if (request != null) {
            requester.getFriends().add(accepter);
            accepter.getFriends().add(requester);
            friendRequests.remove(request);
            System.out.println(accepter.getUsername() + " accepted the friend request from " + requester.getUsername());
        } else {
            System.out.println("Friend request not found or already accepted/declined.");
        }
    }

    public boolean hasSentFriendRequest(User sender, User receiver) {
        for (FriendRequest request : friendRequests) {
            if (request.getSender() == sender && request.getReceiver() == receiver) {
                return true; // Friend request already sent
            }
        }
        return false; // Friend request not sent
    }

    private FriendRequest findFriendRequest(User sender, User receiver) {
        for (FriendRequest request : friendRequests) {
            if (request.getSender() == sender && request.getReceiver() == receiver) {
                return request; // Return the found friend request
            }
        }
        return null; // Friend request not found
    }
}

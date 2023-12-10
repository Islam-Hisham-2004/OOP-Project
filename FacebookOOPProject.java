public class FacebookOOPProject {
    public static void main(String[] args) {
        User user1 = new User("Alice");
        User user2 = new User("Bob");
        User user3 = new User("hatem");
        User user4 = new User("hisham");

        FriendRequestManager friendRequestManager = new FriendRequestManager();

        // Alice sends a friend request to Bob
        user1.sendFriendRequest(user2, friendRequestManager);
        user4.sendFriendRequest(user3, friendRequestManager);
        user4.sendFriendRequest(user3, friendRequestManager);
        user4.sendFriendRequest(user4, friendRequestManager);

//        // Bob tries to send another friend request to Alice
//        user4.sendFriendRequest(user4, friendRequestManager);
//        user2.sendFriendRequest(user1, friendRequestManager);
//
//        // Bob accepts the friend request from Alice
        user2.acceptFriendRequest(user1, friendRequestManager);


        // Display friends of each user
        System.out.println("Friends of " + user1.getUsername() + ": " + user1.getFriends());
        System.out.println("Friends of " + user2.getUsername() + ": " + user2.getFriends());
    }
}
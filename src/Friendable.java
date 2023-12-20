import java.util.List;
import java.util.function.Consumer;
public interface Friendable {
    void receiveFriendRequest(FriendRequest friendRequest, Consumer<FriendRequest> onAccept, Consumer<FriendRequest> onReject);
    void addFriend(User friend);
    List<User> getListOfFriends();
}

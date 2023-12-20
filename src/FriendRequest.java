import java.util.Date;

public class FriendRequest {
    private User sender;
    private User receiver;
    private Date requestDate;
    private boolean accepted;
    private String message;
    private RequestStatus status;

    public enum RequestStatus {
        PENDING,
        ACCEPTED,
        REJECTED
    }

    public FriendRequest(User sender, User receiver, String message) {
        this.sender = sender;
        this.receiver = receiver;
        this.requestDate = new Date();
        this.accepted = false;
        this.message = message;
        this.status = RequestStatus.PENDING;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public String getMessage() {
        return message;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void sendRequest() {
        receiver.receiveFriendRequest(this);
        System.out.println("Friend request sent from " + sender.getUsername() + " to " + receiver.getUsername());
    }

    public void acceptRequest() {
        this.accepted = true;
        this.status = RequestStatus.ACCEPTED;
        //sendNotification("Friend request accepted!");
    }

    public void rejectRequest() {
        this.status = RequestStatus.REJECTED;
        //sendNotification("Friend request rejected.");
    }

    /*private void sendNotification(String notificationMessage) {
        // Simulating sending a notification (you can replace this with actual notification logic)
        System.out.println("Notification sent to " + receiver.getUsername() + ": " + notificationMessage);
    }*/

    @Override
    public String toString() {
        return "FriendRequest{" +
                "sender=" + sender.getUsername() +
                ", receiver=" + receiver.getUsername() +
                ", requestDate=" + requestDate +
                ", accepted=" + accepted +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}

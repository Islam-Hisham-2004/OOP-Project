import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Feed {
    private List<Conversation> conversations;
    private List<Page> pages;
    private List<User> users;
    private List<Post> posts;
   // private static final String DATA_FILE = "data.ser";
    //private static boolean dataLoaded = false;


    public Feed() {
        users = new ArrayList<>();
        conversations = new ArrayList<>();
        pages = new ArrayList<>();
        posts = new ArrayList<>();
    }

  /*  public void loadData() {
        if (!dataLoaded) {
            try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
                Feed loadedFeed = (Feed) inputStream.readObject();
                users = loadedFeed.users;
                posts = loadedFeed.posts;
                conversations = loadedFeed.conversations;
                System.out.println("Data loaded successfully!");
                dataLoaded = true;
            } catch (FileNotFoundException e) {
                System.out.println("No previous data found. Creating a new system.");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public void saveData() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outputStream.writeObject(this);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    }
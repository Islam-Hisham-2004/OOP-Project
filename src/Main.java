import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[]args){
            List<Conversation> Conversations= new ArrayList<>();
            Scanner input=new Scanner(System.in);

            while(true){
                System.out.println("choose an option");
                System.out.println("1.Create a new conversation");
                System.out.println("2.Write message in existing conversation");
                System.out.println("3.EXIT");

                int choice = Integer.parseInt(input.nextLine());

                switch (choice){
                    case 1: createconversation(input,Conversations);
                        break;
                    case 2: Sendmessage(input,Conversations);
                        break;
                    case 3:System.out.println("Exiting the program.");
                        System.exit(0);

                        break;
                    default:
                        System.out.println("Invalid choice. Please choose again.");
                        break;
                }


        }

    }
    public static void createconversation(Scanner input, List<Conversation>Conversations){
        System.out.println("Enter the name of the new conversation:");
        String Conv_Name = input.nextLine();

        System.out.println("Enter the participants name each name separated by comma");
        String participantsInput=input.nextLine();
        String[]part_Names=participantsInput.split(",");

        List<User>Participants=new ArrayList<>();
        for (String participantName : part_Names) {
            Participants.add(new User(participantName));
        }
        Conversation newConversation = new Conversation(Conv_Name,Participants);
        Conversations.add(newConversation);

        System.out.println("New conversation created: " + newConversation.getConvname());
    }
  public static void Sendmessage(Scanner input , List<Conversation>conversations){
      if (conversations.isEmpty()) {
          System.out.println("No conversations available,Please Create a new conversation first.");
          return;
      }
      System.out.println("Choose conv to write ur msg in");
      for (int i=0;i<conversations.size();i++){
          System.out.println((i+1)+". "+conversations.get(i).getConvname());
      }
      int selectedConvIndex = Integer.parseInt(input.nextLine()) - 1;
  if (selectedConvIndex>=0&&selectedConvIndex<conversations.size()){
      Conversation selectedConv = conversations.get(selectedConvIndex);
      System.out.println("Enter the name of sender");
      String name= input.next();
      User sender=new User(name);
      System.out.println("Enter ur msg");
      String Msg_Cont=input.nextLine();
      selectedConv.sendMessage(sender, Msg_Cont);
  } else {
      System.out.println("Invalid conversation index.");
  }


  }
  }

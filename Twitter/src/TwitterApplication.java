import java.util.*;

public class TwitterApplication {

    public static void main(String[] args) {
        System.out.println("Welcome to Darko Nikoloski's Twitter Application!");
        System.out.println("When asked for an action, type: \n1. tweet - to tweet a message;" +
                "\n2. list - to list all messages in a chronological order with the latest messages displayed first;" +
                "\n3. exit - to exit the application.");
        Scanner input = new Scanner(System.in);
        List<TwitterMessage> twitterMessages = new ArrayList<TwitterMessage>();
        boolean flag = true;

        while (flag) {
            System.out.println("Choose your action: ");
            String functionality = input.nextLine();
            switch (functionality) {
                case "tweet":
                    System.out.println("Your message: ");
                    twitterMessages.add(new TwitterMessage(input.nextLine(), new Date()));
                    sort(twitterMessages);
                    break;
                case "list":
                    int index = 1;
                    for (TwitterMessage twitterMessage : twitterMessages) {
                        System.out.println(index++ + ". " + twitterMessage.getMessage() + "\n" + twitterMessage.getDate());
                    }
                    break;
                case "exit":
                    flag = false;
                    System.out.println("Exiting the application..");
                    break;
                    default:
                        System.out.println("Indalid command, try again!");
                        break;
            }
        }

    }

    public static void sort(List<TwitterMessage> twitterMessages) {
        Collections.sort(twitterMessages, new Comparator<TwitterMessage>() {
            @Override
            public int compare(TwitterMessage o1, TwitterMessage o2) {
                return (o1.getDate().compareTo(o2.getDate()) * (-1));
            }
        });
    }
}

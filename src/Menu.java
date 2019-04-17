import java.util.Scanner;

public class Menu {
    public static void menu()
    {
        System.out.println("1. New game\n2. Hall of Fame\n3. Credits\n4. Exit");

        Scanner userInput = new Scanner(System.in);
        String inputRegex = "[a-zA-Z0-05-9.,]+";
        while(userInput.hasNext(inputRegex))
        {
            System.out.println("! Choose option 1-4 !");
            userInput.next();
        }

        Board board = new Board();
        Shipyard sy = new Shipyard(board);

        switch(userInput.nextInt())
        {
            case 1:
                board.printBoard();
                break;
            case 2:
                System.out.println("Hall of fame");
                break;
            case 3:
                System.out.println("\n\t\tThe Battle of Leyte Gulf\n\nmade by: ... \n\nSurprise! \nHubert and Michał");
            case 4:
                System.exit(0);
        }
    }
}
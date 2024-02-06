import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GAP extends Character{
    Scanner in = new Scanner(System.in);
    Quest quest = new Quest(this);  
    User user;

    public void menu(){
        System.out.println("\nMain Menu:");
        System.out.println("\t(1) Profile \n\t(2) Play\n\t(3)Log out");
        System.out.print("Enter -> ");
        int mm = in.nextInt();
        switch (mm){
            case 1:
                checkStats();
                menu();
                break;
            case 2:
                Quest questLogin = new Quest(this); // Pass the player instance to the Quest constructor
                questLogin.chooseQuest();
                break;
            case 3:
                System.out.println("Thank you for playing!");
                user.updateUserDataInFile();
                
                if (user.isLoggedIn()) {
                    user.updateStats();
                    user.updateUserDataInFile();
                    user.setLoggedIn(false);
                    break;
                } else{
                    user.saveAccount();
                    break;
                } 
            default:
                System.out.println("Invalid choice");
                menu();
                break;
        }
    }

    public void logo() {
        System.out.println(
            "            ░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓███████▓▒░        ░▒▓██████▓▒░ ░▒▓██████▓▒░░▒▓██████████████▓▒░░▒▓████████▓▒░ \n" +
            "           ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░        \n" +
            "           ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░        \n" +
            "           ░▒▓█▓▒▒▓███▓▒░▒▓████████▓▒░▒▓███████▓▒░       ░▒▓█▓▒▒▓███▓▒░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓██████▓▒░   \n" +
            "           ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░        \n" +
            "           ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░             ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░        \n" +
            "            ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░              ░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░ \n" +
            "            -- Gillian ---  Andrew --- Patricia --                          F I N A L - P R O J E C T            \n"
        );
    }
    
    

   // ...

public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    
    Character player = new Character();
    User user = new User(player);
    GAP main = new GAP();
    main.user = user;
    main.logo();

    System.out.println("Welcome to GAP game!");

    int num;
    boolean validChoice = false;

    do {
        System.out.println("1. Sign up \n2. Login \n3. Quit");
        System.out.print("\nEnter -> ");
        num = in.nextInt();

        switch (num) {
            case 1:
                user.signUp();
                player.setUp();
                main.menu();
                validChoice = true;
                break;
            case 2:
                user.login();
                main.menu();
                validChoice = true;
                break;
            case 3:
                validChoice = true;
                break;
            default:
                System.out.println("Invalid input. Please choose a number from 1-3");
        }
    } while (!validChoice);

    in.close();
}
// ...


}

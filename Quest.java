import java.util.Scanner;

public class Quest {
    Scanner scanner = new Scanner(System.in);
    protected int action;
    
    protected GAP main;
    protected Character character;
    protected Battle battle;

    public Quest(GAP main) {
        this.main = main;
        character = new Character(); // Initialize the Character instance
    }
    
    public void chooseQuest() {
        System.out.println("\nWelcome, " + character.getPlayerName() + "!");
        System.out.println("Choose a quest you would like to do");
    
        String[] questNames = {
            "Slay The Slime (required level 0)",
            "Slay The Goblin (required level 1)",
            "Slay The Thieves (required level 2)",
            "Slay The Zombie (required level 3)",
            "Slay The Robot (required level 4)",
            "Slay The Alien (required level 5)",
            "Slay The Phoenix (required level 6)",
            "Slay The Dragon (required level 7)",
            "Slay The Demon (required level 8)",
            "Slay The God (required level 9)"
        };
    
        boolean validQuestChoice = false;
    
        while (!validQuestChoice) {
            for (int i = 0; i < questNames.length; i++) {
                System.out.println("\t(" + (i + 1) + ") " + questNames[i]);
            }
    
            System.out.println("(0) BACK");
            System.out.print("Enter -> ");
    
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                setAction(choice);
    
                if (choice == 0) {
                    main.menu();
                    break;
                } else if (choice >= 1 && choice <= questNames.length) {
                    startQuest(choice, questNames[choice - 1]);
                    validQuestChoice = true;
                    break;
                } else {
                    System.out.println("Invalid Choice. Try again.");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Consume the invalid input
            }
        }
    }
    
    private void startQuest(int questNumber, String questName) {
        Enemy enemy = createEnemy(questNumber);
        Battle battle = new Battle(character, enemy);
    
        System.out.println("\nYou picked " + questName);
    
        rewards();

        System.out.print("\nDo you want to play this quest? [Yes/NO] ");
        String play = scanner.nextLine().toLowerCase();
        
        if (play.equals("yes")) {
            checkQuestApproval();
            battle.startBattle();
            playQuestAgain();
        } else if (play.equals("no")) {
            main.menu();
        } else {
            System.out.println("Invalid input. Please choose Yes or No.");
            startQuest(questNumber, questName); // Allow the player to choose again
        }
    }


    public void playQuestAgain(){
        boolean playing = true;
        while (playing) {
            System.out.print("Do you want to play another quest? [Yes/No] ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (playAgain.equals("yes")) {
                chooseQuest();
                checkQuestApproval();
                battle.startBattle();
            } else {
                playing = false;
                main.menu();
            }
        }
    }


    private Enemy createEnemy(int questNumber) {
        switch (questNumber) {
            case 1: return new Slime();
            case 2: return new Goblin();
            case 3: return new Thieves();
            case 4: return new Zombie();
            case 5: return new Robot();
            case 6: return new Alien();
            case 7: return new Phoenix();
            case 8: return new Dragon();
            case 9: return new Demon();
            case 10: return new God();
            default: return null;
        }
        
    }

    public void checkQuestApproval() {
        if (action >= 1 && action <= 10) {
            if (character.playerLevel >= action - 1) {
                System.out.println("\n----Your desired quest has been approved! You may now proceed ----");
            } else {
                System.out.println("\nYour desired quest cannot be accepted due to your low level! Get Stronger :>");
                main.menu(); // Go back to the Main Menu
            }
        } else {
            System.out.println("\nInvalid quest selection. Please choose a valid quest.");
            main.menu(); // Go back to the Main Menu
        }
    }
    
    

    protected void setAction(int choice) {
        this.action = choice;
    }

    public void rewards(){
        System.out.println("Rewards: ");
        System.out.println("\tMagic: +5");
        System.out.println("\tAttack: +5");
        System.out.println("\tSpeed: +5");
        System.out.println("\tHealth: +5");

    }

    

}

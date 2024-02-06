// polymorphism
import java.util.Scanner;

 class Character {
    public static String playerName;
    public static int playerLevel;
    protected static int magic = 3;
    protected static int attack = 3;
    protected static int speed = 3;
    protected static int health = 10;
    String role = " ";

    protected User user;  // reference
    protected GAP main;
    
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getMagic() {
        return magic;
    }

    interface Skill{
        void chooseSkill();
    }

    public void setUp() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("\nLet's set up your character!");
        System.out.print("Enter player name: ");
        playerName = scanner.nextLine();
        setPlayerName(capitalizeFirstLetter(playerName));
    
        int classChoice;
        boolean validChoice = false;
    
        do {
            System.out.println("\nChoose your class:");
            System.out.println("1. Mage\n2. Fighter\n3. Assassin\n4. Tank");
            System.out.print("\nEnter -> ");
            classChoice = scanner.nextInt();
    
            switch (classChoice) {
                case 1:
                    role = "mage";
                    magic += 5;
                    System.out.println("You have chosen the Mage class. Your magic increased by 5.");
                    validChoice = true;
                    break;
                case 2:
                    role = "fighter";
                    attack += 5;
                    System.out.println("You have chosen the Fighter class. Your attack increased by 5.");
                    validChoice = true;
                    break;
                case 3:
                    role = "assassin";
                    speed += 5;
                    System.out.println("You have chosen the Assassin class. Your speed increased by 5.");
                    validChoice = true;
                    break;
                case 4:
                    role = "tank";
                    System.out.println("You have chosen the Tank class. Your health increased by 5");
                    health += 5;
                    validChoice = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid class.");
                    break;
            }
        } while (!validChoice);
    
        playerLevel = 0;
    
        System.out.println("Your level is currently " + playerLevel);
    }
    

    private String capitalizeFirstLetter(String name) {
        if (name != null && name.length() > 0) {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        } else {
            return name;
        }
    }

    public void checkStats() {
        // user.updateStats();
        System.out.println("\nPlayer Stats:");
        System.out.println("Name: " + playerName);
        System.out.println("Level: " + playerLevel);
        System.out.println("Magic: " + magic);
        System.out.println("Attack: " + attack);
        System.out.println("Speed: " + speed);
        System.out.println("Health: " + health);
        System.out.println();
    }

    public void levelDown() {
        if (playerLevel > 1) {
            playerLevel--;
            magic = Math.max(0, magic - 5);
            attack = Math.max(0, attack - 5);
            speed = Math.max(0, speed - 5);
            health = Math.max(1, health - 5); // Ensure health is at least 1

            // main.updateStats();

            System.out.println("You lost a level! All stats decreased by 5.");
        } else {
            System.out.println("You are already at the lowest level.");
        }
    }

    public void levelUp() {
        playerLevel++;
        magic += 5;
        attack += 5;
        speed += 5;
        health += 5;

        checkStats();

        System.out.println("You leveled up! All stats increased by 5.");

        if (playerLevel == 10) {
            System.out.println("You have Reached Level 10! You have Finished The Game!");
            System.exit(0); // End the game
        }
    }

}

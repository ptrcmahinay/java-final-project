import java.util.*;

public class Battle implements Skill {
    private Character player;
    private Enemy enemy;
    protected User user;
    Scanner scanner = new Scanner(System.in);

    public Battle(Character player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

   

    public void startBattle() {
        System.out.println("A " + enemy.getEnemyName() + " appears!");
        enemy.displayStats();

        int initialHealth = player.getHealth();

        while (enemy.getEnemyHealth() > 0 && player.getHealth() > 0) {
            System.out.println("\nChoose your action:");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Check Stats");
            System.out.print("Enter -> ");
            int actionChoice = scanner.nextInt();

            switch (actionChoice) {
                case 1:
                    playerAttack();
                    break;

                case 2:
                    defend();
                    break;

                case 3:
                // if (user != null) {
                //     user.updateCharacterStats();
                // } else {
                //     checkStats();
                // }
                    
                    player.checkStats();
                    enemy.displayStats();
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        if (enemy.getEnemyHealth() <= 0 && player.getHealth() > 0) {
            System.out.println("Congratulations! You defeated the " + enemy.getEnemyName() + "!");
            player.levelUp();
        } else if (player.getHealth() <= 0) {
            System.out.println(" The " + enemy.getEnemyName() + " defeated you.");
            player.levelDown();
            player.checkStats();
            player.setHealth(initialHealth);
        }
    }

    public void skill(){
        
    }

    private void playerAttack() {
        System.out.println("\nChoose your attack type:");
        System.out.println("1. Normal Attack");
        System.out.println("2. Ability");
        System.out.println("3. Super Skill");

        System.out.print("Enter -> ");
        int attackTypeChoice = scanner.nextInt();

        int playerDamageDealt = calculatePlayerDamage(attackTypeChoice);
        enemy.setEnemyHealth(Math.max(0, enemy.getEnemyHealth() - playerDamageDealt));
        System.out.println("---------------------------------------------------");
        System.out.println("\nYou dealt " + playerDamageDealt + " damage to the " + enemy.getEnemyName() + "!");

        Character c = new Character();
        if (enemy.getEnemyHealth() <= 0) {
            System.out.println("The " + enemy.getEnemyName() + " has been defeated!");
            System.out.println("---------------------------------------------------");
            switch (Character.playerLevel) {
                case 0:Character.health = 10; break;
                case 1:Character.health = 15; break;
                case 2:Character.health = 20; break;
                case 3:Character.health = 25; break;
                case 4:Character.health = 30; break;
                case 5:Character.health = 35; break;
                case 6:Character.health = 40; break;
                case 7:Character.health = 45; break;
                case 8:Character.health = 50; break;
                case 9:Character.health = 55; break;
                default:
                    break;
            }
        } else {
            int enemyDamage = enemy.getEnemyAttack(); // Default enemy damage
            player.setHealth(player.getHealth() - enemyDamage);
            System.out.println("The " + enemy.getEnemyName() + " attacked you and dealt " + enemyDamage + " damage!");
            System.out.println("---------------------------------------------------");
        }
    }

    private int calculatePlayerDamage(int attackTypeChoice) {
        int playerDamageDealt = 0;

        switch (attackTypeChoice) {
            case 1:
                playerDamageDealt = Math.max(0, player.getAttack() - enemy.getEnemySpeed());
                break;
            case 2:
                playerDamageDealt = Math.max(0, player.getMagic() - enemy.getEnemySpeed());
                break;
            case 3:
                playerDamageDealt = Math.max(0, player.getAttack() + player.getMagic() - enemy.getEnemySpeed());
                break;
            default:
                System.out.println("Invalid attack type. Try again.");
                playerAttack(); // Allow the player to choose attack type again
                break;
        }

        return playerDamageDealt;
    }

    private void defend() {
        int defendDamage = enemy.getEnemyAttack();
        player.setHealth(player.getHealth() - defendDamage);
        System.out.println("---------------------------------------------------");
        System.out.println("\nYou chose to defend. The " + enemy.getEnemyName() + " attacked you and dealt "
                + defendDamage + " damage!");
        System.out.println("---------------------------------------------------");
    }

    // private static void clearConsole() {
    //     System.out.print("\033[H\033[2J");
    //     System.out.flush();
    // }
}
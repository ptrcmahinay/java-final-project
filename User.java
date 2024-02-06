import java.util.*;
import java.io.*;

public class User extends GAP{
    private String username;
    private String password;
    private boolean loggedIn = false;
    public List<Map<String, String>> playerData;
    private static final String FILE_PATH = "user_data.txt";
    private Character player;

    public User(Character player) {
        this.playerData = new ArrayList<>();
        this.player = player;
        loadUserDataFromFile(); // Load existing user data from the file
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void loadUserDataFromFile() {
        try (Scanner fileScanner = new Scanner(new File(FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] playerInfo = line.split(", ");
                if (playerInfo.length == 9) {
                    Map<String, String> data = new HashMap<>();
                    data.put("Username", playerInfo[0].split(": ")[1]);
                    data.put("Password", playerInfo[1].split(": ")[1]);
                    data.put("Player_name", playerInfo[2].split(": ")[1]);
                    data.put("Role", playerInfo[3].split(": ")[1]);
                    data.put("Level", playerInfo[4].split(": ")[1]);
                    data.put("Magic", playerInfo[5].split(": ")[1]);
                    data.put("Attack", playerInfo[6].split(": ")[1]);
                    data.put("Speed", playerInfo[7].split(": ")[1]);
                    data.put("Health", playerInfo[8].split(": ")[1]);
                    playerData.add(data);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    

    public void saveUserDataToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Map<String, String> player : playerData) {
                writer.printf("Username: %s, Password: %s, Player_name: %s, Role: %s, Level: %s, Magic: %s, Attack: %s, Speed: %s, Health: %s%n",
                        player.get("Username"),
                        player.get("Password"),
                        player.get("Player_name"),
                        player.get("Role"),
                        player.get("Level"),
                        player.get("Magic"),
                        player.get("Attack"),
                        player.get("Speed"),
                        player.get("Health"));
            }
        } catch (IOException e) {
            // Handle exceptions, e.g., unable to write to the file
            e.printStackTrace();
        }
    }

    public void signUp() {
        Scanner in = new Scanner(System.in);
        // while (true) {
            System.out.println("\nCreate a new account");
            System.out.print("Username: ");
            username = in.nextLine();
            System.out.print("Password: ");
            password = in.nextLine();

            System.out.println("\nAccount created successfully!");
    }
    
    Map<String, String> loggedInUser = new HashMap<>();
    public void login() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nLog in to your account");
        System.out.print("Username: ");
        String username = in.nextLine();

        System.out.print("Password: ");
        String password = in.nextLine();

        boolean loginSuccessful = false;

        for (Map<String, String> user : playerData) {
            if (user.get("Username").equals(username) && user.get("Password").equals(password)) {
                loginSuccessful = true;
                loggedInUser = user;
                setLoggedIn(true);
                // setLoggedInUser(loggedInUser);
                updateStats();
                break;
            }
        }

        if (loginSuccessful) {
            System.out.println("\nLogin successful!");
            setLoggedIn(true);
            // profile();
        } else {
            System.out.println("Invalid username or password. Login failed.");
            login();
        }
    }
    
    public void profile() {
        // Display character information from the user map
        System.out.println("\nPlayer stats:");
        System.out.println("Name: " + loggedInUser.get("Player_name"));
        System.out.println("Level: " + loggedInUser.get("Level"));
        System.out.println("Magic: " + loggedInUser.get("Magic"));
        System.out.println("Attack: " + loggedInUser.get("Attack"));
        System.out.println("Speed: " + loggedInUser.get("Speed"));
        System.out.println("Health: " + loggedInUser.get("Health"));
    }

    public void updateStats() {
        // Update character stats based on the logged-in user data
        player.playerName = loggedInUser.get("Player_name");
        player.playerLevel = Integer.parseInt(loggedInUser.get("Level"));
        player.health = Integer.parseInt(loggedInUser.get("Health"));
        player.attack = Integer.parseInt(loggedInUser.get("Attack"));
        player.magic = Integer.parseInt(loggedInUser.get("Magic"));
        player.speed = Integer.parseInt(loggedInUser.get("Speed"));
    }

    public void updateUserDataInFile() {
        // Load existing user data from the file
        List<String> lines = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Search for the user in lines list
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.contains("Username: " + getUsername())) {
                // Update existing user data
                lines.set(i, String.format("Username: %s, Password: %s, Player_name: %s, Role: %s, Level: %s, Magic: %s, Attack: %s, Speed: %s, Health: %s",
                        getUsername(), getPassword(), playerName, role, playerLevel, magic, attack, speed, health));
                break;
            }
        }

        // Save the updated data to file
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (String updatedLine : lines) {
                writer.println(updatedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAccount(){
        Map<String, String> data = new HashMap<>();
        data.put("Username", getUsername());
        data.put("Password", getPassword());
        data.put("Role", role);
        data.put("Player_name", playerName);
        data.put("Level", Integer.toString(playerLevel));
        data.put("Magic", Integer.toString(magic));
        data.put("Attack", Integer.toString(attack));
        data.put("Speed", Integer.toString(speed));
        data.put("Health", Integer.toString(health));
        playerData.add(data);
        saveUserDataToFile();
    }

    
}


